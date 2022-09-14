 
package electricity.billing.system;

import javax.swing.*;
import java.awt.*;

public class Splash extends JFrame implements Runnable{
    
    Thread t;
    Splash()
    {
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/elect.jpg")); 
        Image i2 = i1.getImage().getScaledInstance(730,550,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);        
        JLabel im = new JLabel(i3);
        
        add(im);
        
        setVisible(true);
        int x=1;
        for(int i=2;i<600;i+=4,x++)
        {
            setSize(i+x,i);
            setLocation(600-((i+x)/2),350-(i/2));           
        
            try{
                Thread.sleep(5);
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        } 
        t = new Thread(this);
        t.start();
    }
    
    // threading abstract method
    public void run()
    {
        try{
            Thread.sleep(7000);
            setVisible(false);
            
            new Login();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args)
    {
        new Splash();
    }
}
