
package electricity.billing.system;
 
import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

public class NewCustomer extends JFrame implements ActionListener{
    
    JTextField tfname,tfadd,tfcity,tfstate,tfemail,tfpnum;
    JButton next,cancel;
    long mnumber;
    NewCustomer(){
        super("Customer Details");
        setSize(700,500);
        setLocation(400,200);
        getContentPane().setBackground(Color.WHITE);
    
    // Panel 
        JPanel pan = new JPanel();
        pan.setLayout(null);
        pan.setBackground(new Color(173,216,230));
        add(pan);
        
    // Heading of Panel   
        JLabel hea = new JLabel("New Customer");
        hea.setBounds(180,10,200,20);
        hea.setFont(new Font("Tahoma",Font.BOLD,25));
        pan.add(hea);
     
    // Field 1 : Customer Name
        JLabel cname = new JLabel("Customer Name");
        cname.setBounds(120,80,100,20);
        pan.add(cname);
       
        tfname = new JTextField();
        tfname.setBounds(240,80,200,20);
        pan.add(tfname);
  
    // Field 2 : Meter Number  
        JLabel meterno = new JLabel("Meter Number");
        meterno.setBounds(120,120,100,20);
        pan.add(meterno);

        JLabel mnumb = new JLabel("");
        mnumb.setBounds(240,120,100,20);
        pan.add(mnumb);
        
        Random num = new Random();
        mnumber = num.nextLong() %1000000000;
        mnumber = Math.abs(mnumber);
        mnumb.setText("" + mnumber);

    // Field 3 : Address
        JLabel addr = new JLabel("Address");
        addr.setBounds(120,160,100,20);
        pan.add(addr);
       
        tfadd = new JTextField();
        tfadd.setBounds(240,160,200,20);
        pan.add(tfadd);  
 
    // Field 4 : City
        JLabel city = new JLabel("City");
        city.setBounds(120,200,100,20);
        pan.add(city);
       
        tfcity = new JTextField();
        tfcity.setBounds(240,200,200,20);
        pan.add(tfcity); 

    // Field 5 : State
        JLabel state = new JLabel("State");
        state.setBounds(120,240,100,20);
        pan.add(state);
       
        tfstate = new JTextField();
        tfstate.setBounds(240,240,200,20);
        pan.add(tfstate);  
 
    // Field 6 : Email
        JLabel email = new JLabel("Email");
        email.setBounds(120,280,100,20);
        pan.add(email);
       
        tfemail = new JTextField();
        tfemail.setBounds(240,280,200,20);
        pan.add(tfemail); 
 
    // Field 7 : Phone Number
        JLabel pnumber = new JLabel("Phone Number");
        pnumber.setBounds(120,320,100,20);
        pan.add(pnumber);
       
        tfpnum = new JTextField();
        tfpnum.setBounds(240,320,200,20);
        pan.add(tfpnum); 
        
    // Button 1 : Next
        next = new JButton("Next");
        next.setBounds(120,390,100,25);
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        pan.add(next);
 
    // Button 2 : cancel
        cancel = new JButton("Cancel");
        cancel.setBounds(250,390,100,25);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        pan.add(cancel);
    
    /* 
        Border Layout :
            panel is at center and 
            image is at west       
    */
        setLayout(new BorderLayout());
        add(pan,"Center");
        
        ImageIcon im = new ImageIcon(ClassLoader.getSystemResource("icon/hicon1.jpg"));
        Image ima = im.getImage().getScaledInstance(150, 300, Image.SCALE_DEFAULT);
        ImageIcon image = new ImageIcon(ima);
        JLabel label1 = new JLabel(image);
        
        add(label1,"West");
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent a)
    {
        if(a.getSource() == next)
        {
            String cn = tfname.getText();
            String mn = ""+mnumber;
            String cadd = tfadd.getText();
            String cemail = tfemail.getText();
            String cpn = tfpnum.getText();
            String ccity = tfcity.getText();
            String cstate = tfstate.getText();
            
            String query1 = "insert into customer values('"+cn+"','"+mn+"','"+cadd+"','"+ccity+"','"+cstate+"','"+cemail+"','"+cpn+"')";
            String query2 = "insert into login values('"+mn+"','','"+cn+"','','')";
            
            try{
                Conn c = new Conn();
                c.s.executeUpdate(query1);
                c.s.executeUpdate(query2);
                
                JOptionPane.showMessageDialog(null,"Customer details added successfully");
                setVisible(false);
                new MeterInfo(mnumber);
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        else if(a.getSource() == cancel)
        {
            setVisible(false);
        }
    }
    
    public static void main(String[] args)
    {
        new NewCustomer();
    }
    
}
