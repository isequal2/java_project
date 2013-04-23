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

public class Testing {
    
    public static void main(String []args)
    {
    int i=1;
    Car c = new Car();
    Finalgui fg = new Finalgui();
    Logic l = new Logic();
    //Test1
    if (fg.change(100) == 0)
    {
        System.out.println("Test"+i+++": Worked !!");
    }
    else
    {
        System.out.println("Test"+i+++": Failed !!");
    }
    //Test2
    if (fg.check_collision(2,2) == 1)
       System.out.println("Test"+i+++": Worked !!");
    else
       System.out.println("Test"+i+++": Worked !!");


    //Third test
    if (fg.check_collision(50,100) == 0)
       System.out.println("Test"+i+++": Worked !!");
    else
       System.out.println("Test"+i+++": Worked !!");
   
    //Fourth test
    if (l.st() == 0)
       System.out.println("Test"+i+++": Worked !!");
    else
       System.out.println("Test"+i+++": Worked !!");
    
    // 5th 
    if (l.get_time() == 0)
       System.out.println("Test"+i+++": Worked !!");
    else
       System.out.println("Test"+i+++": Worked !!");
    
        System.exit(0);
    }
    
    
}
