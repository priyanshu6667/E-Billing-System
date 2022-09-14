 
package electricity.billing.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
 
public class Paytm extends JFrame implements ActionListener{
    
  
    String meter_no;
    JButton back;
    
    Paytm(String meter_no){
        
        this.meter_no = meter_no;
        setBounds(50,20,1200,650);
        
        JEditorPane ed = new JEditorPane();
        ed.setEditable(false);
        
        try{
            ed.setPage("https://paytm.com/online-payments");
        }
        catch(Exception e)
        {
            ed.setContentType("text/html");
            ed.setText("<html>Could not load<html>");
        }
        JScrollPane pan = new JScrollPane(ed);
        add(pan);
        
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(1000,20,80,30);
        back.addActionListener(this);
        ed.add(back);
        
        
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent a)
    {
        setVisible(false);
        new PayBill(meter_no);
    }
    
    public static void main(String[] args)
    {
        new Paytm("");
    }
    
}
