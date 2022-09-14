 
package electricity.billing.system;
 
import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
import java.sql.*;

public class CalculateBill extends JFrame implements ActionListener{

    
    JTextField tfunits;
    JButton submit,cancel;
    long mnumber;
    Choice chmno,chmonth;
    JLabel mname,madd,mpnumber,memail;
    
    CalculateBill(){
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
        JLabel hea = new JLabel("Calculate Electricity Bill");
        hea.setBounds(180,10,400,20);
        hea.setFont(new Font("Tahoma",Font.BOLD,25));
        pan.add(hea);
     
    // Field 1 : Meter Number
        JLabel mnum = new JLabel("Meter Number");
        mnum.setBounds(120,80,100,20);
        pan.add(mnum);
       
        chmno = new Choice();
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer");
            
            while(rs.next())
            {
                chmno.add(rs.getString("meter_no"));
            }
            chmno.setBounds(240,80,200,20);
            pan.add(chmno);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
  
    // Field 2 : Name
        
        JLabel cname = new JLabel("Name");
        cname.setBounds(120,120,100,20);
        pan.add(cname);

        mname = new JLabel();
        mname.setBounds(240,120,100,20);
        pan.add(mname);

    // Field 3 : Address
        JLabel maddr = new JLabel("Address");
        maddr.setBounds(120,160,100,20);
        pan.add(maddr);
       
        madd = new JLabel();
        madd.setBounds(240,160,100,20);
        pan.add(madd);

    // Field 6 : Email
        JLabel email = new JLabel("Email");
        email.setBounds(120,280,100,20);
        pan.add(email);
       
        memail = new JLabel();
        memail.setBounds(240,280,200,20);
        pan.add(memail); 
 
    // Field 7 : Phone Number
        JLabel pnumber = new JLabel("Phone Number");
        pnumber.setBounds(120,320,100,20);
        pan.add(pnumber);
       
        mpnumber = new JLabel();
        mpnumber.setBounds(240,320,200,20);
        pan.add(mpnumber); 
        
        try{
            String meterno = chmno.getSelectedItem();

            String query = "select * from customer where meter_no='"+meterno+"'";

            Conn c = new Conn();
            ResultSet rst = c.s.executeQuery(query);

            if(rst.next())
            {
                mname.setText(rst.getString("name"));
                madd.setText(rst.getString("address"));
                mpnumber.setText(rst.getString("pnumber"));
                memail.setText(rst.getString("email"));
            }            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        chmno.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent r)
            {
                try{
                    String meterno = chmno.getSelectedItem();

                    String query = "select * from customer where meter_no='"+meterno+"'";

                    Conn c = new Conn();
                    ResultSet rst = c.s.executeQuery(query);

                    if(rst.next())
                    {
                        mname.setText(rst.getString("name"));
                        madd.setText(rst.getString("address"));
                        mpnumber.setText(rst.getString("pnumber"));
                        memail.setText(rst.getString("email"));
                    }            
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }
            }
        });
    // Field 4 : Units Consumed
        JLabel units = new JLabel("Unit Consumed");
        units.setBounds(120,200,100,20);
        pan.add(units);
       
        tfunits = new JTextField();
        tfunits.setBounds(240,200,200,20);
        pan.add(tfunits); 

    // Field 5 : Month
        JLabel month = new JLabel("Month");
        month.setBounds(120,240,100,20);
        pan.add(month);
       
        chmonth =  new Choice();
        chmonth.add("January");
        chmonth.add("Feburary");
        chmonth.add("March");
        chmonth.add("April");
        chmonth.add("May");
        chmonth.add("June");
        chmonth.add("July");
        chmonth.add("August");
        chmonth.add("September");
        chmonth.add("October");
        chmonth.add("November");
        chmonth.add("December");
        
        chmonth.setBounds(240,240,200,20);
        pan.add(chmonth);
        
    // Button 1 : Submit
        submit = new JButton("Submit");
        submit.setBounds(120,390,100,25);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        pan.add(submit);
 
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
        
        ImageIcon im = new ImageIcon(ClassLoader.getSystemResource("icon/hicon2.jpg"));
        Image ima = im.getImage().getScaledInstance(150, 300, Image.SCALE_DEFAULT);
        ImageIcon image = new ImageIcon(ima);
        JLabel label1 = new JLabel(image);
        
        add(label1,"West");
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent a)
    {
        if(a.getSource() == submit)
        {
            String cn = mname.getText();
            String mn = chmno.getSelectedItem();
            String cadd = madd.getText();
            String cemail = memail.getText();
            String cpn = mpnumber.getText();
            String units = tfunits.getText();
            String month = chmonth.getSelectedItem();
            
            long totalvalue = 0;
            long units_con = Integer.parseInt(units);
            String query = "select * from tax";
                        
            try{
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                
                if(rs.next())
                {
                    totalvalue = units_con * Integer.parseInt(rs.getString("cost_per_unit"));
                    totalvalue += Integer.parseInt(rs.getString("meter_rent"));
                    totalvalue += Integer.parseInt(rs.getString("service_charge"));
                    totalvalue += Integer.parseInt(rs.getString("service_tax"));
                    totalvalue += Integer.parseInt(rs.getString("swacch_bharat_cess"));
                    totalvalue += Integer.parseInt(rs.getString("fixed_tax"));   
                }
                
                String query2 = "insert into bill values('"+mn+"','"+units+"','"+month+"','"+totalvalue+"','Not Paid')";
                c.s.executeUpdate(query2);
                
                JOptionPane.showMessageDialog(null,"Customer Bill Updated Successfully");
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
        new CalculateBill();
    }

}
