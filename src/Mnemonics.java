import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import java.util.Random;

public class Mnemonics extends JFrame{
    private JButton startButton;
    private JButton nextButton;
    private JButton stopButton;
    private JLabel uText;
    private JLabel uMarks;
    private JTextField rField;
    Integer score=0;
    Integer total=0;
    Score sc=new Score();     
    String uResponse,uQuest;
    Thread th,t;
    LogWriter log=new LogWriter();
    public Mnemonics(){
        startButton=new JButton("Start");
        stopButton=new JButton("Stop");
        nextButton=new JButton("Next");
        uText=new JLabel("");
        uMarks=new JLabel("0/0");
        rField=new JTextField("Enter the displayed pattern");
        rField.setEnabled(false);
        stopButton.setEnabled(false);
        nextButton.setEnabled(false);
        uText.setForeground(Color.green);
        uText.setFont(new Font("Serif", Font.ROMAN_BASELINE,40));
        uMarks.setFont(new Font("Serif", Font.CENTER_BASELINE,30));
        uText.setBorder(BorderFactory.createTitledBorder(""));
        uMarks.setBorder(BorderFactory.createTitledBorder("Score:"));
        final JPanel uPanel=new JPanel(new FlowLayout());
        uPanel.add(startButton);
        JPanel rPanel=new JPanel(new GridLayout(2,1));
        rPanel.add(uText);
        rPanel.add(rField);
        JPanel fPanel=new JPanel(new GridLayout(3,1));
        fPanel.add(rPanel);
        fPanel.add(uPanel);
        fPanel.add(uMarks);
        add(fPanel);
       
        //final gameLogic G=new gameLogic();
        
        
    
    
    
        startButton.addActionListener(new ActionListener()
{
            @Override
   public void actionPerformed(ActionEvent e){
                uText.setForeground(Color.blue);
                stopButton.setEnabled(true);
                nextButton.setEnabled(true);
                final String h=gameLogics();
                qDisplay(h);
                uMarks.setText("0/0");     
                log.writeLog("Game started");
                rField.setEnabled(true);
                rField.setText("");
                startButton.setEnabled(false);
                uPanel.add(nextButton);
                uPanel.add(stopButton);
                uPanel.remove(startButton);
                uPanel.revalidate();
                uPanel.repaint();
            
            }
            });
    
    
    nextButton.addActionListener(new ActionListener()
    {
            @Override
        public void actionPerformed(ActionEvent e){
                uResponse=rField.getText();
                log.writeLog("Response recieved is "+uResponse);
                rField.setText("");
                
                
                String h= gameLogics1();
                String k=uQuest;
           qDisplay(h); 
           log.writeLog("Next question displayed");
           Score(uResponse,k);
            }
    });
    
    stopButton.addActionListener(new ActionListener()
    {
            @Override
        public void actionPerformed(ActionEvent e){
            startButton.setEnabled(true);
            uText.setForeground(Color.red);
            uText.setText("GAME OVER");
            uText.setBorder(BorderFactory.createTitledBorder(""));
            th.stop();
            t.stop();
            sc.writeScore(Collection.pName(), "Mnemonics", score);
            rField.setText("Enter the displayed pattern");
            rField.setEnabled(false);
            total=0;
            score=0;
            log.writeLog("Game stopped");
            uPanel.add(startButton);
            uPanel.remove(stopButton);
            uPanel.remove(nextButton);
            uPanel.revalidate();
            uPanel.repaint();
            }
    });
    
    
    
    
    }
    
        String uAsk;
        String bChar;
        String aBase="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random nGen=new Random();
        Random aGen=new Random();
        Random a=new Random();
        Integer aNum,nChar;
        int b;
        int c=0;
        
        String gameLogics(){
            int k=aGen.nextInt(26);
            uAsk=aBase.substring(k,k+1);
            c=0;
            while(c!=4){
            aNum=nGen.nextInt(10);
            nChar=aGen.nextInt(26);
            bChar=aBase.substring(nChar,nChar+1); 
            
            b=a.nextInt(2)+1;
            if(b==1)
                uAsk=uAsk+bChar;
            else
                uAsk=uAsk+aNum;
            c=uAsk.length();
            }
            log.writeLog("Random string generated is "+uAsk);
            return uAsk;
        }
            String gameLogics1(){
                
                aNum=nGen.nextInt(10);
                nChar=aGen.nextInt(26);
                bChar=aBase.substring(nChar,nChar+1); 
                b=a.nextInt(2)+1;
                if(b==1)
                    uAsk=uAsk+bChar;
                else
                    uAsk=uAsk+aNum;
                log.writeLog("Random string generated is "+uAsk);
                return uAsk;
        }
   
     
     void Score(String h,String k){
         total++;
         if(h.equals(k))
             score++;
         log.writeLog("total is "+total);
         log.writeLog("Score is "+score); 
         uMarks.setText(score+"/"+total);
         if(total-score>=5){
             th.stop();
             t.stop();
             startButton.setEnabled(true);
            nextButton.setEnabled(false);
            uText.setForeground(Color.red);
           uText.setText("GAME OVER");
           uText.setBorder(BorderFactory.createTitledBorder(""));
           stopButton.setEnabled(false);
           log.writeLog("Score stored");
           sc.writeScore(Collection.pName(), "Mnemonics", score);
           total=0;
           score=0;
           log.writeLog("Game Over");
     }
     }
    
     void qDisplay(final String h){
         uQuest=h;
          
      t=new Thread(){
                    
                    @Override
                    public void run(){
                     
                        for(int i=0;i<1;i++){
                             uText.setText(h);
                             rField.setEnabled(false);
                         
                         try {
                                
                                sleep(3000);
                            } catch (InterruptedException ex) {
                                
                            }uText.setText("");
                            rField.setEnabled(true);
                     }          
                    }
                };
                
                t.start();
                
         th=new Thread(){
             
            @Override
             public void run(){
                 for(int j=3;j>=0;j--){
                     uText.setBorder(BorderFactory.createTitledBorder(j+""));
                      try {
                                
                                sleep(1000);
                            } catch (InterruptedException ex) {
                                
                            }
                 }
             }
         };   th.start();    
     }
            
     
    
     public static void main(String[] args)
{

JFrame frame = new Mnemonics();
frame.setTitle("Mnemonics");
frame.setSize(350,350);
frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
frame.setLocationRelativeTo(null);
frame.setVisible(true);

}
}