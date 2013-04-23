
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Random;


public class NewClass{
    public int jkl;
    public ImageIcon kl; 
    public static  ArrayList<ImageIcon> al=new ArrayList<ImageIcon>();
    public JLabel jl[] =new JLabel[100];
    public JLabel jli[] =new JLabel[100];
    public JFrame frame = new JFrame("tic");
    public int imran;
    LogWriter l=new LogWriter(); 
    public JButton press;
    public void tic(){
    
    //frame created
    
    l.writeLog("main frame created");
    frame.setSize(1366,760);
    frame.setResizable(true);
    frame.setLayout(new BorderLayout());
    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    frame.setVisible(true);
    
    
   
    
    //menubar
    
    //play again
    l.writeLog("menubar created");
    JMenuBar   menuMain =new JMenuBar();
    l.writeLog("play again jmenu item added");
    JMenuItem Play_Again =new JMenuItem("Play Again");
    menuMain.add(Play_Again);
    Play_Again.addActionListener(new Action3());
    
    
  
    
    //About
    l.writeLog("about jmenu item added");
    JMenuItem About =new JMenuItem("About");
    menuMain.add(About); 
    About.addActionListener(new Action());
    
   
    //Exit
    l.writeLog("exit jmenu item added");
    JMenuItem Exit =new JMenuItem("Exit");
    menuMain.add(Exit); 
    frame.setJMenuBar(menuMain);
    Exit.addActionListener(new Action1());
    
    
   //jpanel
    l.writeLog("jpanel created");
    JPanel jp=new JPanel(new GridBagLayout());
    GridBagConstraints gbc=new GridBagConstraints();
   l.writeLog("color of background changed to green");
    jp.setBackground(Color.GREEN);
    
   l.writeLog("image array list created and images stored");
    //adding image to array list
   // ArrayList<ImageIcon> al=new ArrayList<ImageIcon>();
   for(int j=0;j<46;j++)
   {   String s="a"+j+".gif";
       ImageIcon imj=new ImageIcon("new\\"+s);
       al.add(imj);
   }
l.writeLog("100 jlabels created to add the text to jpanel"); 
   //jlabel
    int i1=0,i2=0,i3=0,i4=0;
    for(int i=0;i<16;i++)
    {
    jl[i]=new JLabel(""+i);
    gbc.gridx=0;
    gbc.gridy=i;
    gbc.insets=new Insets(5,80,5,5);
    
    jp.add(jl[i],gbc);
    }
   
     for(int i=16;i<32;i++)
    {
    jl[i]=new JLabel(""+i);
    gbc.gridx=2;
    gbc.gridy=i1++;
    gbc.insets=new Insets(5,80,5,5);
    jp.add(jl[i],gbc);
    }
     
      for(int i=32;i<48;i++)
    {
    jl[i]=new JLabel(""+i);
    gbc.gridx=4;
    gbc.gridy=i2++;
    gbc.insets=new Insets(5,80,5,5);
    jp.add(jl[i],gbc);
    }
      
       for(int i=48;i<64;i++)
    {
    jl[i]=new JLabel(""+i);
    gbc.gridx=6;
    gbc.gridy=i3++;
    gbc.insets=new Insets(5,80,5,5);
    jp.add(jl[i],gbc);
    }
       
       
       for(int i=64;i<80;i++)
    {
    jl[i]=new JLabel(""+i);
    gbc.gridx=8;
    gbc.gridy=i4++;
    gbc.insets=new Insets(5,80,5,5);
    jp.add(jl[i],gbc);
    }
    
       int i5=0;
        for(int i=80;i<96;i++)
    {
    jl[i]=new JLabel(""+i);
    gbc.gridx=10;
    gbc.gridy=i5++;
    gbc.insets=new Insets(5,80,5,5);
    jp.add(jl[i],gbc);
    }
        
     
       int i6=0;
        for(int i=96;i<100;i++)
    {
    jl[i]=new JLabel(""+i);
    gbc.gridx=12;
    gbc.gridy=i6++;
    gbc.insets=new Insets(5,80,5,5);
    jp.add(jl[i],gbc);
    }   
        
     l.writeLog("100 jlabels added to the jpanel"); 
     i1=0;
     i2=0;
     i3=0;
     i4=0;
     Random rando =new Random();
     imran=rando.nextInt(46);
    
     
     
     
     
   
     //for image   
     
     l.writeLog("100 jlabels in an array created to store images"); 
    for(int i=0;i<16;i++)
    {
    jli[i]=new JLabel();
    gbc.gridx=1;
    gbc.gridy=i;
    gbc.insets=new Insets(5,5,5,5);
    if(i==9)
    {
    jli[i]=new JLabel(al.get(imran));
     jp.add(jli[i],gbc);
    }
    else
    {
    Random rand=new Random();
    int number=rand.nextInt(46);
    //System.out.println(number);
    jli[i]=new JLabel(al.get(number));
    jp.add(jli[i],gbc);
    }
    }
     for(int i=16;i<32;i++)
    {
    jli[i]=new JLabel();
    gbc.gridx=3;
    gbc.gridy=i1++;
    gbc.insets=new Insets(5,5,5,5);
    if(i==18 || i==27)
    {
   jli[i]=new JLabel(al.get(imran));
     jp.add(jli[i],gbc);
    }
    else
    {
    Random rand5=new Random();
    int number5=rand5.nextInt(46);
    //System.out.println(number5);
    jli[i]=new JLabel(al.get(number5));
    jp.add(jli[i],gbc);
    }
    }
     
      for(int i=32;i<48;i++)
    {
    jli[i]=new JLabel();
    gbc.gridx=5;
    gbc.gridy=i2++;
    gbc.insets=new Insets(5,5,5,5);
    if(i==36 || i==45)
    {
   jli[i]=new JLabel(al.get(imran));
     jp.add(jli[i],gbc);
    }
    else
    {
    Random rand4=new Random();
    int number4=rand4.nextInt(46);
    //System.out.println(number4);
    jli[i]=new JLabel(al.get(number4));
    jp.add(jli[i],gbc);
    }
    }  
       for(int i=48;i<64;i++)
    {
    jli[i]=new JLabel();
    gbc.gridx=7;
    gbc.gridy=i3++;
    gbc.insets=new Insets(5,5,5,5);
    if(i==54 || i==63)
    {
    jli[i]=new JLabel(al.get(imran));
     jp.add(jli[i],gbc);
    }
    else
    {
    Random rand3=new Random();
    int number3=rand3.nextInt(46);
    jli[i]=new JLabel(al.get(number3));
    jp.add(jli[i],gbc);
    }
    }   
       
       for(int i=64;i<80;i++)
    {
    jli[i]=new JLabel();
    gbc.gridx=9;
    gbc.gridy=i4++;
    gbc.insets=new Insets(5,5,5,5);
    if(i==72)
    {
    jli[i]=new JLabel(al.get(imran));
     jp.add(jli[i],gbc);
    }
    else
    {
    Random rand2=new Random();
    int number2=rand2.nextInt(46);
    jli[i]=new JLabel(al.get(number2));
    jp.add(jli[i],gbc);
    }
    }
    i5=0;
    for(int i=80;i<96;i++)
    {
    jli[i]=new JLabel();
    gbc.gridx=11;
    gbc.gridy=i5++;
    gbc.insets=new Insets(5,5,5,5);
    if(i==81 || i==90)
    {
    jli[i]=new JLabel(al.get(imran));
     jp.add(jli[i],gbc);
    }
    else
    {
    Random rand1=new Random();
    int number1=rand1.nextInt(46);
    jli[i]=new JLabel(al.get(number1));
    
    jp.add(jli[i],gbc);
    }
    }
    i6=0;
     for(int i=96;i<100;i++)
    {
    jli[i]=new JLabel();
    gbc.gridx=13;
    gbc.gridy=i6++;
    gbc.insets=new Insets(5,5,5,5);
    
    Random rand0=new Random();
    int number0=rand0.nextInt(46);
    jli[i]=new JLabel(al.get(number0));
    
    jp.add(jli[i],gbc);
    
    }
    l.writeLog("jlabels containing images in an array added to jpanel"); 
    
      
    
    
    //jbutton
    l.writeLog("jbutton created "); 
    press = new JButton("press me");
    gbc.gridx=902;
    gbc.gridy=7;
    jp.add(press,gbc);
    gbc.insets=new Insets(0,100,5,5);
    press.addActionListener(new Action4());
    l.writeLog("jbutton added to jpanel"); 
    
    l.writeLog("jbutton created"); 
    JButton ins = new JButton("How to Play");
    gbc.gridx=902;
    gbc.gridy=5;
   //gbc.insets=new Insets(5,5,5,5);
     jp.add(ins,gbc);
    l.writeLog("jbutton added to jpanel"); 
     ins.addActionListener(new Action2());
    frame.getContentPane().add(jp,BorderLayout.WEST);
    
    }



//jbutton action listener
    
    class Action4 implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent ae) {
        
        l.writeLog("action listener bor jbuuton /press me/ is called"); 
        l.writeLog("new jframe created");
        JFrame jfnew=new JFrame("press me");
        jfnew.setVisible(true);
        jfnew.setSize(300,300);
        jfnew.setLocation(620,30); 
        l.writeLog("new jpanel created to show the output of press me button");
        JPanel jpl=new JPanel(new GridLayout(10,0));
        jpl.setBackground(Color.CYAN);
         l.writeLog("jpanel background color changed lo light blue");
         l.writeLog("jlabel created to hold output text");
          l.writeLog("jlabel created to hold output image");
         JLabel txt=new JLabel("you were thinking of ");
        JLabel iml=new JLabel();
        jpl.add(txt);
         l.writeLog("both jalabels added to jpanel");
        ImageIcon k=new ImageIcon();
        k = al.get(imran);
        iml= new JLabel(k);
         jpl.add(iml);
         jfnew.add(jpl);
          l.writeLog("jpanel added to jframe");
         
          
         
   
    
    
    
    }
  }
//play again action listener
class Action3 implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent ae) {
       l.writeLog("action listener for play again called");
        l.writeLog("old frame is switched off"); 
       frame.setVisible(false);
        l.writeLog("new class object created");
         l.writeLog("tic function is called");
       NewClass n=new NewClass(); 
      n.tic();
    }
}





//about action listener
class Action implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent ae) {
        
        l.writeLog("action listener for about is called");
        l.writeLog("new jframe is created to add information about author");
        JFrame jfnew=new JFrame("about");
        jfnew.setVisible(true);
        jfnew.setSize(300,300);
        jfnew.setLocation(20,20);
        l.writeLog("new jlabet created to hold text");
        JLabel ja=new JLabel("author -- SHIVAM SINGH");
        jfnew.add(ja);
       l.writeLog("jlabel added to jframe");
            }

} 


//Exit action listener
class Action1 implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent ae) {
        l.writeLog("action listener for exit is called");
        frame.setVisible(false);
        l.writeLog("working");
    }

}

//instruction action listener
class Action2 implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent ae) {
       l.writeLog("action listener for instruction is called");
        JFrame jfnew=new JFrame("how to play");
        jfnew.setVisible(true);
        jfnew.setSize(700,300);
        jfnew.setLocation(10,20);
        l.writeLog("new jframe is created ");
        l.writeLog("new jpanel is created to hold jlabels");
        JPanel insjp=new JPanel(new GridLayout(10,0));
       insjp.setBackground(Color.YELLOW);
       l.writeLog("jlabel created"); 
       JLabel insjl=new JLabel("choose any two digit number add together the two digits and subtract the "
                + " sum of digits from the original number when u");
        JLabel insj3=new JLabel("have the final number look it up in the chart and find the relevant "
                + "symbol. CONCENTRATE on the symbol ");
         
       
        
        
        l.writeLog("jlabel added to jpanel");
        insjp.add(insjl);
          insjp.add(insj3);
        
        JLabel insj2=new JLabel(" and when u have it clearly in your mind click on the press me button"
                + "and it will show u the symbol ");
        l.writeLog("jlabel created ");
        l.writeLog("jlabel added to jpanel");
        insjp.add(insj2);
        JLabel insj4=new JLabel("you are thinking about....");
       
        
        insjp.add(insj4);
        l.writeLog("jpanel added to frame");
        jfnew.getContentPane().add(insjp,BorderLayout.WEST);
       
        
    }
  }




public static void main(String [] args){
NewClass ti=new NewClass();
ti.tic();


}
}
