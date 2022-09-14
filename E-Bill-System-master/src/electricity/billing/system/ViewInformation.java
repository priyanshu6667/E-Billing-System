 
package electricity.billing.system;
 
import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;

public class ViewInformation extends JFrame implements ActionListener{
    
    JButton cancel;
    String meter_no;
    ViewInformation(String meter_no)
    {
        super("User Information");
        this.meter_no = meter_no;
        setBounds(200,20,850,650);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        JLabel heading = new JLabel("VIEW CUSTOMER INFORMATION");
        heading.setFont(new Font("Tahoma",Font.BOLD,20));
        heading.setBounds(250,0,500,40);
        add(heading);
        
        JLabel name = new JLabel("Name");
        name.setBounds(70,80,100,20);
        add(name);
        
        JLabel lname = new JLabel("");
        lname.setBounds(220,80,300,20);
        add(lname);
        
        JLabel meterno = new JLabel("Meter Number");
        meterno.setBounds(70,140,100,20);
        add(meterno);
        
        JLabel lmeterno = new JLabel("");
        lmeterno.setBounds(220,140,300,20);
        add(lmeterno);
        
        JLabel add = new JLabel("Address");
        add.setBounds(70,200,100,20);
        add(add);
        
        JLabel ladd = new JLabel("");
        ladd.setBounds(220,200,400,20);
        add(ladd);
        
        JLabel city = new JLabel("City");
        city.setBounds(70,260,100,20);
        add(city);
        
        JLabel lcity= new JLabel("");
        lcity.setBounds(220,260,300,20);
        add(lcity);
        
        JLabel state = new JLabel("State");
        state.setBounds(500,80,100,20);
        add(state);
        
        JLabel lstate = new JLabel("");
        lstate.setBounds(650,80,300,20);
        add(lstate);
        
        
        JLabel email = new JLabel("Email");
        email.setBounds(500,140,100,20);
        add(email);
        
        JLabel lemail= new JLabel("");
        lemail.setBounds(650,140,400,20);
        add(lemail);
        
        JLabel phone = new JLabel("Phone Number");
        phone.setBounds(500,200,100,20);
        add(phone);
        
        JLabel lphone = new JLabel("");
        lphone.setBounds(650,200,300,20);
        add(lphone);
        
        
        cancel = new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setBounds(500,300,100,20);
        cancel.addActionListener(this);
        add(cancel);
        
        ImageIcon im = new ImageIcon(ClassLoader.getSystemResource("icon/viewcustomer.jpg"));
        Image ima = im.getImage().getScaledInstance(600,300,Image.SCALE_DEFAULT);
        
        JLabel image =new JLabel(new ImageIcon(ima));
        image.setBounds(100,350,600,300);
        add(image);
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer where meter_no='"+meter_no+"'");
            if(rs.next())
            {
                lname.setText(rs.getString("name"));
                lphone.setText(rs.getString("pnumber"));
                lemail.setText(rs.getString("email"));
                lcity.setText(rs.getString("city"));
                lstate.setText(rs.getString("state"));
                ladd.setText(rs.getString("address"));   
                lmeterno.setText(meter_no);
            }     
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent a)
    {
        setVisible(false);
    }
    public static void main(String[] args)
    {
        new ViewInformation("");
    }
}
