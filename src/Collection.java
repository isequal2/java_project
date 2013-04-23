import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Collection extends JFrame {
    static String plName;
    private JButton gOne=new JButton("Game 1");
    private JButton gTwo=new JButton("Memory");
    private JButton gThree=new JButton("Police Run");
    private JButton gFour=new JButton("Hangman");
    private JButton gFive=new JButton("TicTacToe");
    private JButton gSix=new JButton("Surprise");
    private JButton okButton=new JButton("OK");
    private JButton highScore=new JButton("High Scores");
    ImageIcon i1=new ImageIcon("D:\\new\\game1.png");
    ImageIcon i2=new ImageIcon("D:\\new\\game2.png");
    ImageIcon i3=new ImageIcon("D:\\new\\game3.png");
    ImageIcon i4=new ImageIcon("D:\\new\\game4.png");
    ImageIcon i5=new ImageIcon("D:\\new\\game5.jpg");
    ImageIcon i6=new ImageIcon("D:\\new\\Game6.png");
    private JLabel gO=new JLabel(i1);
    private JLabel gT=new JLabel(i2);
    private JLabel gTh=new JLabel(i3);
    private JLabel gF=new JLabel(i4);
    private JLabel gFi=new JLabel(i5);
    private JLabel gS=new JLabel(i6);
    private JLabel pLabel=new JLabel("");
   
    private JTextField pName=new JTextField("",12);
    //Image backGround;
    Score score=new Score();
    LogWriter log=new LogWriter();           
    JList list=new JList();
    JScrollPane mScroll=new JScrollPane();


    
    public Collection() {
       java.util.Date date=new java.util.Date();
       log.writeLog(date.toString());
        JPanel uPanel=new JPanel(new GridLayout(1,2));
        final JPanel userPanel=new JPanel(new FlowLayout());
        userPanel.setBorder(BorderFactory.createTitledBorder("Enter Player Name"));
       
        userPanel.add(this.pName);
        userPanel.add(this.okButton);
       
        uPanel.add(userPanel);
        
        userPanel.setBackground(Color.cyan);
        
        
        JPanel gamePanel=new JPanel(new FlowLayout( ));
        
        gamePanel.setBorder(BorderFactory.createTitledBorder("Select Game"));
        JPanel gamePanel1=new JPanel(new GridLayout(2,2));
        gamePanel1.add(this.gO);
        gamePanel1.add(this.gOne);
        gamePanel1.setBackground(Color.cyan);
        JPanel gamePanel2=new JPanel(new GridLayout(2,2));
        gamePanel2.add(this.gT);
        gamePanel2.add(this.gTwo);
        gamePanel2.setBackground(Color.cyan);
        JPanel gamePanel3=new JPanel(new GridLayout(2,2));
        gamePanel3.add(this.gTh);
        gamePanel3.add(this.gThree);
        gamePanel3.setBackground(Color.cyan);
        JPanel gamePanel4=new JPanel(new GridLayout(2,2));
        gamePanel4.add(this.gF);
        gamePanel4.add(this.gFour);
        gamePanel4.setBackground(Color.cyan);
        JPanel gamePanel5=new JPanel(new GridLayout(2,2));
        gamePanel5.add(this.gFi);
        gamePanel5.add(this.gFive);
        gamePanel5.setBackground(Color.cyan);
        JPanel gamePanel6=new JPanel(new GridLayout(2,2));
        gamePanel6.add(this.gS);
        gamePanel6.add(this.gSix);
        gamePanel6.setBackground(Color.cyan);
        final JPanel mPanel=new JPanel(new FlowLayout());
        mPanel.add(list);
        log.writeLog("Making panels");
       
        gamePanel.add(gamePanel1);
        gamePanel.add(gamePanel2);
        gamePanel.add(gamePanel3);
        gamePanel.add(gamePanel4);
        gamePanel.add(gamePanel5);
        gamePanel.add(gamePanel6);
        gamePanel.setBackground(Color.cyan);
        uPanel.add(gamePanel);
        gOne.setBackground(Color.white);
        gTwo.setBackground(Color.white);
        gThree.setBackground(Color.white);
        gFour.setBackground(Color.white);
        gFive.setBackground(Color.white);
        gSix.setBackground(Color.white);
        add(uPanel);
        
        log.writeLog("Adding panels to frame");
      
        gOne.setEnabled(false);
        gTwo.setEnabled(false);
        gThree.setEnabled(false);
        gFour.setEnabled(false);
        gFive.setEnabled(false);
        gSix.setEnabled(false);
    
    
    
    
    
    
    
okButton.addActionListener(new ActionListener()
{
            @Override
   public void actionPerformed(ActionEvent e){
                userPanel.setBorder(BorderFactory.createTitledBorder(""));
                log.writeLog("Ok Button Clicked");
                plName=pName.getText();
                log.writeLog("Player name received");
                pName.setText("");
                pName.setEnabled(false);
                gOne.setEnabled(true);
                gTwo.setEnabled(true);
                gThree.setEnabled(true);
                gFour.setEnabled(true);
                gFive.setEnabled(true);
                gSix.setEnabled(true);
                okButton.setEnabled(false);
                gOne.setBackground(Color.YELLOW);
                gTwo.setBackground(Color.yellow);
                gThree.setBackground(Color.yellow);
                gFour.setBackground(Color.yellow);
                gFive.setBackground(Color.yellow);
                gSix.setBackground(Color.yellow);
                userPanel.remove(pName);
                userPanel.remove(okButton);
                log.writeLog("TextField and OkButton Removed");
                userPanel.add(pLabel);
                pLabel.setFont(new Font("Serif", Font.ITALIC,50));
                pLabel.setForeground(Color.red);
                userPanel.add(highScore);
                log.writeLog("HighScore button added");
                userPanel.add(mPanel);
                userPanel.revalidate();
                userPanel.repaint();
                pLabel.setText("Hi "+plName+"!!!");
                log.writeLog("Hi "+plName+"!!! displayed");
}
});
    
    highScore.addActionListener(new ActionListener(){
            @Override
        public void actionPerformed(ActionEvent e){
           userPanel.remove(list);
           userPanel.remove(mPanel);
           log.writeLog("highScore button clicked");
           list=new JList(score.readScore(plName).toArray());
            userPanel.add(list);
            //userPanel.add(mPanel);
            userPanel.revalidate();
            userPanel.repaint();
            log.writeLog("Scores displayed");
        }
    });
    
    gOne.addActionListener(new ActionListener(){
            @Override
       public void actionPerformed(ActionEvent e){
                
                log.writeLog("Game1 started");
                Game1.main(null);
       } 
    });
    
    gTwo.addActionListener(new ActionListener(){
            @Override
       public void actionPerformed(ActionEvent e){
                
                log.writeLog("Mnemonics game started");
                Mnemonics.main(null);
       } 
    });
    
    
    gThree.addActionListener(new ActionListener(){
            @Override
       public void actionPerformed(ActionEvent e){
                
                log.writeLog("Car Race game started");
                PoliceRun.main(null);
       } 
    });
    
    
    gFour.addActionListener(new ActionListener(){
            @Override
       public void actionPerformed(ActionEvent e){
                
                log.writeLog("Hangman game started");
                HangmanFinal.main(null);
       } 
    });
    
     gFive.addActionListener(new ActionListener(){
            @Override
       public void actionPerformed(ActionEvent e){
                
                log.writeLog("TicTacToe game started");
                TicTacToe.main(null);
       } 
    });
    
    
    gSix.addActionListener(new ActionListener(){
            @Override
       public void actionPerformed(ActionEvent e){
                
                log.writeLog("GuessingGame started");
                NewClass.main(null);
       } 
    });
    
    }        
    
    public static String pName(){
        return plName;
    }
    public static void main(String[] args)
{
JFrame frame = new Collection();
frame.setTitle("Game");
//frame.setBackground(Color.);
frame.setSize(500,380);
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.setLocationRelativeTo(null);
frame.setVisible(true);

}
    
}