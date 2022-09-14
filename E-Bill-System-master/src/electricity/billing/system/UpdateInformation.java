 
package electricity.billing.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class UpdateInformation extends JFrame implements ActionListener{
    
    JButton update,cancel;
    JTextField tfadd,tfphone,tfemail,tfstate,tfcity;
    String meter_no;
    UpdateInformation(String meter_no){
        
        super("User Information");
        this.meter_no = meter_no;
        setBounds(100,100,1050,450);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        JLabel heading = new JLabel("UPDATE CUSTOMER INFORMATION");
        heading.setFont(new Font("Tahoma",Font.BOLD,20));
        heading.setBounds(80,10,400,30);
        add(heading);
        
        JLabel name = new JLabel("Name");
        name.setBounds(30,70,100,20);
        add(name);
        
        JLabel lname = new JLabel("");
        lname.setBounds(230,70,200,20);
        add(lname);
        
        JLabel meterno = new JLabel("Meter Number");
        meterno.setBounds(30,110,100,20);
        add(meterno);
        
        JLabel lmeterno = new JLabel("");
        lmeterno.setBounds(230,110,200,20);
        add(lmeterno);
        
        JLabel add = new JLabel("Address");
        add.setBounds(30,150,100,20);
        add(add);
        
        tfadd = new JTextField();
        tfadd.setBounds(230,150,200,20);
        add(tfadd);
        
        JLabel city = new JLabel("City");
        city.setBounds(30,190,100,20);
        add(city);
        
        tfcity= new JTextField();
        tfcity.setBounds(230,190,200,20);
        add(tfcity);
        
        JLabel state = new JLabel("State");
        state.setBounds(30,230,100,20);
        add(state);
        
        tfstate = new JTextField();
        tfstate.setBounds(230,230,200,20);
        add(tfstate);
        
        
        JLabel email = new JLabel("Email");
        email.setBounds(30,270,100,20);
        add(email);
        
        tfemail= new JTextField();
        tfemail.setBounds(230,270,200,20);
        add(tfemail);
        
        JLabel phone = new JLabel("Phone Number");
        phone.setBounds(30,310,100,20);
        add(phone);
        
        tfphone = new JTextField();
        tfphone.setBounds(230,310,200,20);
        add(tfphone);
        
        update = new JButton("Update");
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.setBounds(70,360,100,25);
        update.addActionListener(this);
        add(update); 
       
        
        cancel = new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setBounds(230,360,100,25);
        cancel.addActionListener(this);
        add(cancel);
        
        ImageIcon im = new ImageIcon(ClassLoader.getSystemResource("icon/update.jpg"));
        Image ima = im.getImage().getScaledInstance(600,300,Image.SCALE_DEFAULT);
        
        JLabel image =new JLabel(new ImageIcon(ima));
        image.setBounds(550,50,400,300);
        add(image);
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer where meter_no='"+meter_no+"'");
            if(rs.next())
            {
                lname.setText(rs.getString("name"));
                lmeterno.setText(meter_no);
                tfphone.setText(rs.getString("pnumber"));
                tfemail.setText(rs.getString("email"));
                tfcity.setText(rs.getString("city"));
                tfstate.setText(rs.getString("state"));
                tfadd.setText(rs.getString("address"));   
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
        if(a.getSource() == update)
        {
            String pno = tfphone.getText();
            String email = tfemail.getText();
            String city = tfcity.getText();
            String state = tfstate.getText();
            String add = tfadd.getText();
            
            String query = "update customer set address='"+add+"',city='"+city+"',state='"+state+"',email='"+email+"',pnumber='"+pno+"' where meter_no='"+meter_no+"'";
            
            try{
                Conn c = new Conn();
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"User Information Updated Successfully");
                setVisible(false);
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
        new UpdateInformation("");
    }
}
