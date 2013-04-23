
import java.awt.*;
import javax.swing.*;

import java.awt.event.*;
import java.util.Random;





public class Game1 extends JFrame
{
    int  a,b,r=0, t=0,count=-1,total=-1,tl=0,time=0;
    LogWriter log=new LogWriter();
    char c;
    boolean stop=true;
    Random generator=new Random();
    
     

                
private JRadioButton jrbAdd = new JRadioButton("Add");
private JRadioButton jrbSubtract = new JRadioButton("Subtract");
private JRadioButton jrbMultiply = new JRadioButton("Multiply");
private JRadioButton jrbDivide = new JRadioButton("Divide");




private JRadioButton jrbLevel1 = new JRadioButton("Numbers from 0 to 9");
private JRadioButton jrbLevel2 = new JRadioButton("Numbers from 0 to 20");
private JRadioButton jrbLevel3 = new JRadioButton("Numbers from 0 to 50");
private JRadioButton jrbLevel4 = new JRadioButton("Any single/double digit number");

ButtonGroup GroupA = new ButtonGroup();
ButtonGroup GroupB = new ButtonGroup();

private JLabel jlblQuestion = new JLabel("Question will be shown ", 4);
private TextField jtfAnswer = new TextField("");

private JButton jbtStart = new JButton("Start");
private JButton jbtNext=new JButton("Next");
private JLabel jlblCorrectCount = new JLabel("0/0");
private JLabel jlblTimeSpent = new JLabel("0 seconds");




public Game1() {
    GroupA.add(jrbAdd);
    GroupA.add(jrbSubtract);
    GroupA.add(jrbMultiply);
    GroupA.add(jrbDivide);
    GroupB.add(jrbLevel1);
    GroupB.add(jrbLevel2);
    GroupB.add(jrbLevel3);
    GroupB.add(jrbLevel4);
JPanel jpTypeSetting = new JPanel(new GridLayout(4, 1));
jpTypeSetting.setBorder(BorderFactory.createTitledBorder("Choose a type"));
jpTypeSetting.add(this.jrbAdd);
jpTypeSetting.add(this.jrbSubtract);
jpTypeSetting.add(this.jrbMultiply);
jpTypeSetting.add(this.jrbDivide);

JPanel jpLevelSetting = new JPanel(new GridLayout(4, 1));
jpLevelSetting.setBorder(BorderFactory.createTitledBorder("Choose a level"));
jpLevelSetting.add(this.jrbLevel1);
jpLevelSetting.add(this.jrbLevel2);
jpLevelSetting.add(this.jrbLevel3);
jpLevelSetting.add(this.jrbLevel4);

JPanel jpSetting = new JPanel(new GridLayout(1, 2));
jpSetting.add(jpTypeSetting);
jpSetting.add(jpLevelSetting);

JPanel jpQuestion = new JPanel(new GridLayout(2, 2));
jpQuestion.add(new JLabel("Question:"));
jpQuestion.add(new JLabel("Answer:"));
jpQuestion.add(this.jlblQuestion);
jpQuestion.add(this.jtfAnswer);

JPanel jpButton = new JPanel(new FlowLayout(2));
jpButton.add(this.jbtStart);
//jpButton.add(this.jbtStop);
jpButton.add(this.jbtNext);
JPanel jpLabel = new JPanel(new GridLayout(1, 2));
jpLabel.add(this.jlblCorrectCount);
jpLabel.add(this.jlblTimeSpent);
this.jlblCorrectCount.setBorder(BorderFactory.createTitledBorder("Correct Count"));
this.jlblTimeSpent.setBorder(BorderFactory.createTitledBorder("Time Spent"));

JPanel jpResult = new JPanel(new BorderLayout());
jpResult.add(jpButton, "North");
jpResult.add(jpLabel, "Center");

add(jpSetting, "North");
add(jpQuestion, "Center");
add(jpResult, "South");
jtfAnswer.setEnabled(false);
jbtNext.setEnabled(false);
    


jrbAdd.setSelected(true);
jrbLevel1.setSelected(true);

this.jbtStart.addActionListener(new ActionListener() {
    
            
      
  
            @Override
public void actionPerformed(ActionEvent e) {
           
               log.writeLog("Started");
                jlblCorrectCount.setText("0/0");
                stop=true;
                jbtNext.setEnabled(true);
                jtfAnswer.setEnabled(true);
                tDisplay();
                logic();
                jbtStart.setEnabled(false);
                
 
       }    
       });


this.jbtNext.addActionListener(new ActionListener()
{
            @Override
   public void actionPerformed(ActionEvent e)
   {
       jtfAnswer.addActionListener(this);
           try{
            r=Integer.parseInt(jtfAnswer.getText());
           }catch(Exception ex){
               
           }
           log.writeLog("Input is "+r);
           jtfAnswer.setText("");
           
           
           logic();
           
       
   }
});




};


void tDisplay(){
    
    Thread th=new Thread(){
     int i=0;        
        
            @Override
            public void run(){
        while(true){
            if(i<=119){
            time=i;
            i=i+1;
            jlblTimeSpent.setText(i +" seconds");
            }
            else{
                Exit(time);
                break;
            }    
            try {
                                
                                sleep(1000);
                            } catch (InterruptedException ex) {
                            
                            }
                                
                                
                            
             
        }
    }  
    };
    th.start();
    
} 
void Exit(int n){
     if(n==119)
     {
         stop=false;
     
            
            
            
            
   jlblQuestion.setText("Questions will be shown");
jlblCorrectCount.setText(count+"");
Score sC=new Score();

sC.writeScore(Collection.pName(),"Game1",count);
total=-1;
count=0;
r = 0;

jtfAnswer.setText("");
jtfAnswer.setEnabled(false);
jbtStart.setEnabled(true);
jbtNext.setEnabled(false);
jlblTimeSpent.setText("");

}
}
 void logic(){
    
      if(stop && total-count<10){
          
           if (jrbAdd.isSelected()){  
          c='+';
          log.writeLog("Addition Selected");
      }
      else if(jrbSubtract.isSelected())
          c='-';
      else if(jrbMultiply.isSelected())
          c='*';
      else if(jrbDivide.isSelected())
          c='/';
           log.writeLog("Operation "+c);
    if(jrbLevel1.isSelected())
    {
        
        a=generator.nextInt(10);
        
        b=generator.nextInt(10);
    }
    
   else if(jrbLevel2.isSelected())
    {
        
        a=generator.nextInt(20);
        
        b=generator.nextInt(20);
    }
   else if(jrbLevel3.isSelected())
   {
        
        a=generator.nextInt(50);
        
        b=generator.nextInt(50);
        
   }
   else if(jrbLevel4.isSelected())
   {
        
        a=generator.nextInt(100);
        
        b=generator.nextInt(100);
   }
    if(c=='+' || (c=='-' /*&& a>b*/) || (c=='*' && (a<=10 || b<=10)) || (c=='/' /*&& a%b==0*/))
        {
 
            
                        
            jlblQuestion.setText(a +" "+ c +" "+ b + "=");
      
            
         
             
        total=total+1;       
           
       
        if(r==t){
            count++;
            log.writeLog("Correct answer");
            jlblCorrectCount.setText(count +"/"+ total);
        }
        else{
            log.writeLog("Wrong Answer");
            jlblCorrectCount.setText("Ans "+t+" "+" "+count +"/"+ total);    
        }
           log.writeLog("Correct Count is "+count);
        if( c=='+')
            t=a+b;
        else if(c=='-')
            t=a-b;
            
        else if(c=='*' )
            
            t=a*b;
        else if(c=='/')
            
            t=a/b;
        
        
        }
        }
          



         
     }

      
public static void main(String[] args)
{
JFrame frame = new Game1();
frame.setTitle("Game1");
frame.setSize(500, 350);
frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
frame.setLocationRelativeTo(null);
frame.setVisible(true);
}


    }



       
       
    



