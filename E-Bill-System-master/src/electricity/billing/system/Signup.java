 
package electricity.billing.system;
 
import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.sql.*;

public class Signup extends JFrame implements ActionListener{
    
    JButton cre,back;
    JTextField meter,user,name,pass;
    Choice acc;
    Signup(){
        
        super("SignUp Page");
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JPanel pan = new JPanel();
        pan.setLayout(null);
        pan.setBounds(10,10,610,310);
        pan.setBorder(new TitledBorder(new LineBorder(new Color(173,216,230),2),"Create-Account",TitledBorder.LEADING,TitledBorder.TOP,null,new Color(173,216,230)));
        pan.setBackground(Color.WHITE);
        add(pan);
  
        JLabel i10 = new JLabel("Meter Number");
        i10.setBounds(80,60,150,20);
        pan.add(i10);
        meter = new JTextField();
        meter.setBounds(230,60,150,20);
        pan.add(meter); 
        
        meter.setVisible(false);
        i10.setVisible(false);
        
        JLabel i2 = new JLabel("Username");
        i2.setBounds(80,100,150,20);
        pan.add(i2);
        user = new JTextField();
        user.setBounds(230,100,150,20);
        pan.add(user);
        
        JLabel i3 = new JLabel("Name");
        i3.setBounds(80,140,150,20);
        pan.add(i3);
        name = new JTextField();
        name.setBounds(230,140,150,20);
        pan.add(name);

        JLabel i1 = new JLabel("Create Account As");
        i1.setBounds(80,20,150,20);
        pan.add(i1);
        acc = new Choice();
        acc.setBounds(230,20,150,20);
        acc.add("Admin");
        acc.add("Customer");
        
        acc.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent a)
            {
                String str = acc.getSelectedItem();
                if(str.equals("Admin"))
                {
                    meter.setVisible(false);
                    i10.setVisible(false); 
                    name.setEditable(true);
                }
                else
                {
                    meter.setVisible(true);
                    i10.setVisible(true);
                    name.setEditable(false);
                }
            }
        });
        pan.add(acc);

        
        meter.addFocusListener(new FocusListener(){
           
            public void focusGained(FocusEvent a){
                
            }
            public void focusLost(FocusEvent b){
 
                try{
                    Conn c = new Conn();
                    ResultSet rs = c.s.executeQuery("select * from customer where meter_no='"+meter.getText()+"'");
                    if(rs.next())
                    {
                        name.setText(rs.getString("name"));
                    }                                          
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }
 
            }
        });
               
        JLabel i4 = new JLabel("Password");
        i4.setBounds(80,180,150,20);
        pan.add(i4);
        pass = new JTextField();
        pass.setBounds(230,180,150,20);
        pan.add(pass);
        
        
        cre = new JButton("Create");
        cre.setBounds(80,230,120,30);
        cre.addActionListener(this);
        pan.add(cre);
        
        back = new JButton("Back");
        back.setBounds(230,230,120,30);
        back.addActionListener(this);
        pan.add(back);
        
        
        ImageIcon im = new ImageIcon(ClassLoader.getSystemResource("icon/signupImage.png"));
        Image ima = im.getImage().getScaledInstance(250,250,Image.SCALE_DEFAULT);
        ImageIcon image = new ImageIcon(ima);
        JLabel i5 = new JLabel(image);
        i5.setBounds(380,20,250,250);
        pan.add(i5);
        
        
        setSize(650,380);
        setLocation(300,150);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent a)
    {
        if(a.getSource()==back){
            setVisible(false);
            new Login();
        }else if(a.getSource()==cre){
            String actype = acc.getSelectedItem();
            String suser = user.getText();
            String sname = name.getText();
            String smeter = meter.getText();
            String spass = pass.getText();
            
            try{
                Conn c = new Conn();
                if(actype.equals("Admin"))
                {
                    String query1 = "insert into login values('"+smeter+"','"+suser+"','"+sname+"','"+spass+"','"+actype+"')";       
                    c.s.executeUpdate(query1);
                    JOptionPane.showMessageDialog(null,"Account created Successfully");
                    setVisible(false);
                    new Login();
                }
                else
                {
                    ResultSet rs = c.s.executeQuery("select * from customer where meter_no='"+smeter+"'");
                    if(rs.next())
                    {
                        String query2 = "update login set  username='"+suser+"',password='"+spass+"',user_typ='"+actype+"' where meter_no='"+smeter+"'";       
                        c.s.executeUpdate(query2);
                        JOptionPane.showMessageDialog(null,"Account Updated Successfully");
                        setVisible(false);  
                        new Login();
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null,"No Such Customer Exits");
                    }
                }
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
    }
    
    public static void main(String[] args)
    {
        new Signup();
    }
}
