 
package electricity.billing.system;
 
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
    
    JButton blogin,bsignup,bcancel;
    Choice logas;
    JTextField uname,pass;
    Login(){
        
        // frame heading
        super("Login Page");
        
        // changes whole frame color
        getContentPane().setBackground(Color.WHITE); 
        
        // remove defalut layout
        setLayout(null);    
        
        // username label 
        JLabel username = new JLabel("Username");
        username.setBounds(300,20,100,20);
        add(username);
        uname = new JTextField();
        uname.setBounds(400,20,100,20);
        add(uname);
        
        // password label
        JLabel password = new JLabel("Password");
        password.setBounds(300,60,100,20);
        add(password);
        pass = new JTextField();
        pass.setBounds(400,60,100,20);
        add(pass);
        
        // login as label
        JLabel loginas = new JLabel("Login as");
        loginas.setBounds(300,100,100,20);
        add(loginas);
        logas = new Choice();
        logas.add("Admin");
        logas.add("Customer");
        logas.setBounds(400,100,100,20);
        add(logas);
        
        // login Button 
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/login.png"));
        Image i2 = i1.getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);  
        blogin = new JButton("login",i3);
        blogin.setBounds(300,160,100,20);
        blogin.addActionListener(this);
        add(blogin);
        
        // cancel button
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icon/cancel.jpg"));
        Image i5 = i4.getImage().getScaledInstance(16,16,Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        bcancel = new JButton("cancel",i6);
        bcancel.setBounds(420,160,100,20);
        bcancel.addActionListener(this);
        add(bcancel);
        
        // signup button
        ImageIcon i7 = new ImageIcon(ClassLoader.getSystemResource("icon/signup.png"));
        Image i8 = i7.getImage().getScaledInstance(16,16,Image.SCALE_DEFAULT);
        ImageIcon i9 = new ImageIcon(i8);
        bsignup = new JButton("signup",i9);
        bsignup.setBounds(360,200,100,20);
        bsignup.addActionListener(this);
        add(bsignup);
        
        // left side image
        ImageIcon i10 = new ImageIcon(ClassLoader.getSystemResource("icon/second.jpg"));
        Image i11 = i10.getImage().getScaledInstance(250,250,Image.SCALE_DEFAULT);
        ImageIcon i12 = new ImageIcon(i11);
        JLabel ima = new JLabel(i12);
        ima.setBounds(0,0,250,250);
        add(ima);
        
        // frame
        setSize(640,300);
        setLocation(400,200);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent a)
    {
        if(a.getSource()==blogin){
            
            String username = uname.getText();
            String password = pass.getText();
            String loginact = logas.getSelectedItem();
            String meterno = "";
            try{
                Conn c = new Conn();
                String query = "select * from login where username='"+username+"' and password='"+password+"' and user_typ='"+loginact+"'";
                
                ResultSet rs = c.s.executeQuery(query);
               
                if(rs.next()){
                    setVisible(false);
                    meterno = rs.getString("meter_no");
                    new Project(loginact,meterno);
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Invalid Login");
                    uname.setText("");
                    pass.setText("");
                }    
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
        else if(a.getSource()==bsignup){
            setVisible(false);
            new Signup();
        }
        else if(a.getSource()==bcancel){
            setVisible(false);
        }
    }
    public static void main(String[] args)
    {
        new Login();
    }
}
