import javax.swing.*;
import java.awt.*;


class Finalgui {    
    //--------------------------All Global Variables Start here ----------------------------//
    final String game_name = "Police-run:";
    public  JLayeredPane lpane = new JLayeredPane();
    Logic l = new Logic();
    Car c = new Car();
    public JFrame f = new JFrame("Game !!");
    LogWriter lg = new LogWriter(); 
    
    // --------All Track variables which cause animation ---------//
    public JPanel track1 =  createTrack(-100);
    public JPanel track2 =  createTrack(150);
    public JPanel track3 =  createTrack(300);
    public JPanel track4 =  createTrack(450);
    public JPanel track5 =  createTrack(600);
    // --------All Track variables which cause animation end here ---------//
    
    //For creating cars !!
    String common = "images\\";
    JLabel my_car = c.create_car("my_car.png");
    JLabel police = c.create_car("police.png");
    JLabel ob2 = c.create_car("ob2.png");
    //--------------------------All Global Variables End here ----------------------------//
    
    //--------------------------Creating Track of a Particular ---------------------------//
    JPanel createTrack(int size)
    {
        Color c = Color.YELLOW;
        JPanel temp = new JPanel();
        temp.setSize(10, 25);
        temp.setBackground(c);
        temp.setLayout(null);
        //This below line is used to set the x and y axis of track !!!
        temp.setBounds(740, size, 25, 100);
        temp.setOpaque(true);
        return temp;
    }
    //--------------------------Creating Track of a Particular (above)---------------------------//
    
                      
    //---------Create the final frame here with all Jpanel added to it !!!----------------//
    public int createframe()
    {
        lg.writeLog(game_name+":Main_frame:Started to create frame");
        f.setPreferredSize(new Dimension(2000, 1000));
        f.add(panels());
        f.pack();
        f.setBackground(Color.black);
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        f.setVisible(true);
        lg.writeLog(game_name+":Main_frame:Done with creating frame");
        return 0;
    }
    //---------Create the final frame here with all Jpanel added to it above !!!----------------//
    
    
    //---------Creates different layers of the Game!!! ----------------------------------------//
    JLayeredPane panels()
    {
        lg.writeLog(game_name+":Main_frame:Started to create Panels");
        JPanel mainpanel = new JPanel(new GridLayout(1,3));
        JPanel green1 = createRect(Color.green, 50);
        JPanel black = createRect(Color.black, 2000);
        JPanel green2 = createRect(Color.green, 50);
        mainpanel.add(green1);
        mainpanel.add(black);
        mainpanel.add(green2);
        mainpanel.setBounds(0, 0, 1500, 700);
        mainpanel.setOpaque(true);
        lpane.setBounds(0, 0, 60, 40);
        lpane.add(mainpanel, new Integer(0), 0);
        //===========Adding all tracks for animation !! ==========//
        lpane.add(track1, new Integer(1), 0);
        lpane.add(track2, new Integer(1), 0);
        lpane.add(track3, new Integer(1), 0);
        lpane.add(track4, new Integer(1), 0);
        lpane.add(track5, new Integer(1), 0);
        //===========Adding all tracks for animation !! ==========//
        
        //===========Adding all vehicles =========================//
        lpane.add(my_car,new Integer(2),0);
        lpane.add(police,new Integer(2),0);
        lpane.add(ob2,new Integer(2),0);
        //===========Adding all vehicles above =========================//
        lg.writeLog(game_name+":Main_frame:Done with creating Panels");
        return lpane;
    }
    //---------Creates different layers of the Game above!!! ----------------------------------------//

    
    JPanel createRect(Color c,int size)
    {
        JPanel temp = new JPanel();
        temp.setBackground(c);
        temp.setLayout(null);
        temp.setSize( 5 , 100);
        temp.setOpaque(true);
        return temp;
    }
 
    
    //------------------Main Part which has everything ---------------------------------------------//
    int change(final int size)
    {
        lg.writeLog(game_name+":Main_frame:Entered to main part of the game");
        Thread th = new Thread(){
        int t1=-99,t2=151,t3=301,t4=451,t5=601;
        int x_loc;  
        int ob_x = 0,ob_x2=0;
        int ob_y=0,ob_y2=0;
        @Override
        public void run()
        {
        int tmp;
        tmp = size; 
        ob_y=0;
        l.st();
        for(int i=0,flag=1,end = 0,flag2=1;;i++)
        {    
                try {
//                    if (l.get_time() < 15)
                    sleep(1);
                } catch (InterruptedException ex) {
                       lg.writeLog("Error in main_change_class"+ex);
                }
                
                x_loc = c.my_pos_x();
                
                //=============To avoid car going out of the frame =========//
                if (x_loc < 500)
                {
                    x_loc = 500;
                }
                if (x_loc > 900)
                    x_loc = 900;
                //=============To avoid car going out of the frame =========//
                
                //================To check any thing going out of the frame ============//
                if (t1 > 700)
                    t1 = -100;
                if (t2 > 700)
                    t2 = -100;
                if (t3 > 700)
                    t3 = -100;
                if (t4 > 700)
                    t4 = -100;
                if (t5 > 700)
                    t5 = -100;
                //================To check any thing going out of the frame ============//
                
                //================Start car when time is more than 5secs================//
                if (l.get_time() > 5 && flag != 0)
                {
                    ob_x = 500 + l.gen_random();
                    police.setBounds(ob_x,0,25,100);
                    lg.writeLog(game_name+":Main_frame:More than 5 secs and creating a obstacle");
                    flag =0;
                }
                if(l.get_time() > 15 && flag2 !=0)
                {   
                    ob_x2 = 500 + l.gen_random();
                    while( !(ob_x2 > ob_x+30 || ob_x2 < ob_x-30 ))
                        ob_x2 = 500 + l.gen_random();
                    ob2.setBounds(ob_x2,0,100,25);
                    lg.writeLog(game_name+":Main_frame:More than 15 secs and creating a obstacle");
                    flag2 = 0;
                }
                //================Start car when time is more than 5secs================//
                
                
                if ( flag == 0)
                {
                    police.setBounds(ob_x,ob_y++,25,100);
                    if (ob_y > 700)
                    {
                        flag = 1;
                        ob_y=0;
                    }
                }
                if ( flag2 == 0)
                {
                    ob2.setBounds(ob_x2,ob_y2++,100,25);
                    if (ob_y2 > 700)
                    {
                        flag2 = 1;
                        ob_y2=0;
                    }
                }
                if (ob_y >= 600)
                    if (check_collision(ob_x,x_loc) == 1)
                    {
                        f.setVisible(false);
                        break;
                    }
                if (ob_y2 >= 600 && l.time > 15)
                    if (check_collision(ob_x2,x_loc) == 1)
                    {       
                        f.setVisible(false);
                        break;
                    }
                my_car.setBounds(x_loc,600,100,100);
                track1.setBounds(740,t1++,25,100);
                track2.setBounds(740,t2++,25,100);
                track3.setBounds(740,t3++,25,100);
                track4.setBounds(740,t4++,25,100);
                track5.setBounds(740,t5++,25,100);
            }
        }
       };
       th.start();      
        return 0;
    }
    
    //-----------------------Function to Check Collisions !!! ---------------------//
    int check_collision(int ob,int my)
    {
        if (my > ob-30 && ob+30 > my )
        {
            lg.writeLog(game_name+":Main_frame:Collided!!");
            End e = new End(l.get_time());
            return 1;
        }
        if ((ob < my && my < ob+30) || (ob < my+20 && my+20 < ob+30))
        {
            lg.writeLog(game_name+":Main_frame:Colidded!!");
            End e = new End(l.get_time());
            return 1;
        }
        if ((ob < my && my < ob+20) || (ob < my+20 && my+20 < ob+20))
        {
            lg.writeLog(game_name+":Main_frame:Collided!!");
            End e = new End(l.get_time());
            return 1;
        }
        return 0;
    }
    //-----------------------Function to Check Collisions !!! ---------------------//
    
    
}
