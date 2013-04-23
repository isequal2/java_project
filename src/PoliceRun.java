/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author vikas
 */

import java.awt.event.*;
import java.util.Random;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.*;
public class PoliceRun
{
    public static void main(String[] args) {
        //Below thread is for making the whole GUI thread safe !!
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                LogWriter lg = new LogWriter(); 
                lg.writeLog("Police_run:Game Started with initial Frame");
                //Open the first Page!!
                FirstPage fir = new FirstPage();
                fir.create_one();
            }
    });
}
}

class Car 
{
//    String path = get_url();images
    String common = "images\\";
    JLabel create_car(String file)
    {
        JLabel my_car = new JLabel(make_icons(common+file));
        return my_car;
    }
    Icon make_icons(String src)
    {
        Icon icon = new ImageIcon(src);
//        JLabel label = new JLabel(icon);
        return icon;
    }
    int my_pos_x()
    {
        int a = MouseInfo.getPointerInfo().getLocation().x-50;
        return a;
    }
}

class Logic 
{
    LogWriter lg = new LogWriter();
    String game_name = "Police Run:";
    int x;
    int time=0;
    Random randomGenerator = new Random();
    int gen_random()
    {
        x = randomGenerator.nextInt(400);
        lg.writeLog(game_name+":Main_frame:Getting Random number!!");
        return x;
    }
    int st()
    {
        Thread tim = new Thread(){             
        @Override
        public void run(){
        for(int i=0;;i++)
        {    
                try {
                    sleep(1000);
                } catch (InterruptedException ex) {
                   
                }
                time++;
        }
        }
       };
        tim.start();
        lg.writeLog(game_name+":Main_frame:Started Time!!");
        return 0;
    }
    int get_time()
    {
        return time;
    }
}
//-----------------------------------End of the game ----------------------------//
class End extends FirstPage
{
    String game_name = "Police Run";
    LogWriter lg = new LogWriter();
    JFrame f2 = new JFrame();
    Icon icon = new ImageIcon(common+"final.jpg");
    Icon icon2 = new ImageIcon(common+"play_again.png");
    End(int time)
    {
        Score sc = new Score();
        sc.writeScore(Collection.pName(),"Police Run",time);
        lg.writeLog(game_name+":Main_frame:Game Ends !!");
        JLayeredPane l = new JLayeredPane();
        JLabel ob3 = new JLabel(icon);
        final JLabel play_again = new JLabel(icon2);
        ob3.setBounds(0,0,icon.getIconWidth(),icon.getIconHeight());
        play_again.setBounds(0,0,icon2.getIconWidth(),icon2.getIconHeight());
        l.add(ob3,new Integer(0),0);
        JLabel l2 = new JLabel("Your Score = "+time);
            lg.writeLog(game_name+":Main_frame:Score =  !!"+time);
            l2.setForeground(Color.red);
            l2.setFont(new Font("Serif", Font.PLAIN, 50));
            l2.setBounds(600, 400, 500, 500);
            l.add(l2,new Integer(1),0);
            l.add(play_again,new Integer(1),0);
            f2.add(l);
            f2.setBackground(Color.blue);
            f2.setSize(1000,800);
            f2.setVisible(true);
           play_again.addMouseListener(new MouseAdapter()  
        {  
            public void mousePressed(MouseEvent e)  
            {  
                Rectangle rects = getClickableRegions(play_again);  
                Point p = e.getPoint();  
                String s = "error";  
                if(rects.contains(p))  
                {
                f2.setVisible(false);
                Finalgui fin = new Finalgui();
                fin.createframe();
                fin.change(-99);
                lg.writeLog(game_name+":Main_frame:User Wants to play again!!");
                }  
            }
        public Rectangle getClickableRegions(JLabel label) {
        int w = label.getWidth();  
        int h = label.getHeight();  
        Rectangle but = new Rectangle(0, 0, w, h); 
        return but; 
            }
        }); 
}
}
//-----------------------------------End of the game ----------------------------//


//-----------------------------------FirstPage of the game ----------------------------//
class FirstPage
{
    //Initializing all variables!!
    String game_name = "Police Run:";
    LogWriter lg = new LogWriter();
    String common = "images\\";
    JFrame frm1 = new JFrame();
    JLayeredPane full = new JLayeredPane();
    Icon icon = new ImageIcon(common+"first.jpg");
    Icon strt = new ImageIcon(common+"run.png");
    Icon story = new ImageIcon(common+"story.png");
    
    //Creating the frame!!
    public int create_one()
    {
       lg.writeLog(game_name+":First_frame:Creating first frame!!");
       JLabel back = new JLabel(icon);
       final JLabel st1 = new JLabel(strt);
       final JLabel stry = new JLabel(story);
       back.setBounds(50,0,icon.getIconWidth(),icon.getIconHeight());
       st1.setBounds(70,100,strt.getIconWidth(),strt.getIconHeight());
       stry.setBounds(70,200,story.getIconWidth(),story.getIconHeight());
       full.add(back , new Integer(0),0);
       full.add(st1 , new Integer(1),0);
       full.add(stry , new Integer(1),0);
       full.setVisible(true);
       frm1.add(full);
       frm1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frm1.setSize(1400,1000);
       frm1.setVisible(true);
       st1.addMouseListener(new MouseAdapter()  
        {  
            public void mousePressed(MouseEvent e)  
            {  
                Rectangle rects = getClickableRegions(st1);  
                Point p = e.getPoint();  
                String s = "error";  
                if(rects.contains(p))  
                {
                frm1.setVisible(false);
                Finalgui fin = new Finalgui();
                fin.createframe();
                fin.change(-99);
                lg.writeLog(game_name+":First_frame:User pressed Start game!!");
                }  
            }
           
        public Rectangle getClickableRegions(JLabel label) {
        int w = label.getWidth();  
        int h = label.getHeight();  
        Rectangle but = new Rectangle(0, 0, w, h); 
        return but; 
            }
        });  
       stry.addMouseListener(new MouseAdapter()  
        {  
            public void mousePressed(MouseEvent e)  
            {  
                Rectangle rects = getClickableRegions(stry);  
                Point p = e.getPoint();  
                String s = "error";  
                if(rects.contains(p))  
                {
                    JLabel lab = new JLabel("YOU HAVE ROBBED A BANK AND  TRYING TO ESCAPE FROM");
                    JLabel lab2 = new JLabel("POLICE, GUIDE YOUR CAR AND SEE FOR HOW MUCH TIME POLICE WILL FOLLOW YOU!!");
                    JLabel lab1 = new JLabel("SOMETIMES YOUR CAR MIGHT SEEM TO CRASH");
                    JLabel lab3 = new JLabel("BUT IT SO HAPPENS THAT DUE TO POWER OF YOUR CAR IT ESCAPED THE CRASH !!HURRAY !! ");
//                    System.out.println("Done!1");
                    lab.setFont(new Font("Serif", Font.PLAIN, 30));
                    lab1.setFont(new Font("Serif", Font.PLAIN, 30));
                    lab2.setFont(new Font("Serif", Font.PLAIN, 30));
                    lab3.setFont(new Font("Serif", Font.PLAIN, 30));
                    lab.setBounds(0, 0, 1200, 50);
                    lab2.setBounds(0, 10, 1200, 100);
                    lab1.setBounds(0, 200, 1200, 100);
                    lab3.setBounds(0, 600, 1200, 100);
                    JFrame fr = new JFrame();
//                    fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    
                    fr.add(lab);
                    fr.add(lab1);
                    fr.add(lab2);
                    fr.add(lab3);
                    fr.setBackground(Color.blue);
                    fr.setSize(1500,700);
                    fr.setVisible(true);
                }
                lg.writeLog(game_name+":First_frame:User pressed Start game!!");
                }  
        public Rectangle getClickableRegions(JLabel label) {
        int w = label.getWidth();  
        int h = label.getHeight();  
        Rectangle but = new Rectangle(0, 0, w, h); 
        return but; 
            }
        });
       return 0;
    }
}
//-----------------------------------FirstPage of the game ----------------------------//