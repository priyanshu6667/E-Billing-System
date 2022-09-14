 
package electricity.billing.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
 
public class PayBill extends JFrame implements ActionListener{
    
    Choice chmonth;
    String meter_no;
    JButton pay,back;
    
    PayBill(String meter_no){
        
        this.meter_no = meter_no;
        setLayout(null);
        setBounds(160,50,900,600);
        
        JLabel head = new JLabel("Electricity Bill");
        head.setFont(new Font("Tahoma",Font.BOLD,24));
        head.setBounds(120,5,400,30);
        add(head);
        
        JLabel mno = new JLabel("Meter Number");
        mno.setBounds(35,80,200,20);
        add(mno);
        
        JLabel lmno = new JLabel("");
        lmno.setBounds(300,80,200,20);
        add(lmno);
        
        JLabel name = new JLabel("Name");
        name.setBounds(35,140,200,20);
        add(name);
        
        JLabel lname = new JLabel("");
        lname.setBounds(300,140,200,20);
        add(lname);
        
        
        JLabel month = new JLabel("Month");
        month.setBounds(35,200,200,20);
        add(month);
 
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
        chmonth.setBounds(300,200,200,20);
        add(chmonth);
 
        JLabel units = new JLabel("Units");
        units.setBounds(35,260,200,20);
        add(units);
        
        JLabel lunits = new JLabel("");
        lunits.setBounds(300,260,200,20);
        add(lunits);
        
        JLabel tbill = new JLabel("Total Bill");
        tbill.setBounds(35,320,200,20);
        add(tbill);
        
        JLabel ltbill = new JLabel("");
        ltbill.setBounds(300,320,200,20);
        add(ltbill);
        
        JLabel status = new JLabel("Status");
        status.setBounds(35,380,200,20);
        add(status);
        
        JLabel lstatus = new JLabel("");
        lstatus.setBounds(300,380,200,20);
        lstatus.setFont(new Font("Tahoma",Font.BOLD,15));
        lstatus.setForeground(Color.RED);
        add(lstatus);
        
        
        chmonth.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent a)
            {
                try{
                    Conn c = new Conn();
                    ResultSet rs = c.s.executeQuery("select * from customer where meter_no='"+meter_no+"'");
                    if(rs.next())
                    {
                        lname.setText(rs.getString("name"));
                        lmno.setText(meter_no);
                    }
                    rs = c.s.executeQuery("select * from bill where meter_no='"+meter_no+"'and month='"+chmonth.getSelectedItem()+"'");
                    if(rs.next())
                    {
                        lunits.setText(rs.getString("units"));
                        ltbill.setText(rs.getString("totalbill"));
                        String sta = rs.getString("status");
                        if(sta.equals("Paid"))
                        {
                            lstatus.setForeground(Color.BLUE);
                        }
                        else
                        {
                            lstatus.setForeground(Color.RED);
                        }
                        lstatus.setText(sta);
                    }
                    else
                    {
                        lunits.setText("");
                        ltbill.setText("");
                        lstatus.setText("");
                    }
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }
            }
        });
        
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer where meter_no='"+meter_no+"'");
            if(rs.next())
            {
                lname.setText(rs.getString("name"));
                lmno.setText(meter_no);
            }
            rs = c.s.executeQuery("select * from bill where meter_no='"+meter_no+"'and month='"+chmonth.getSelectedItem()+"'");
            if(rs.next())
            {
                lunits.setText(rs.getString("units"));
                ltbill.setText(rs.getString("totalbill"));
                String sta = rs.getString("status");
                if(sta.equals("Paid"))
                {
                    lstatus.setForeground(Color.BLUE);
                }
                else
                {
                    lstatus.setForeground(Color.RED);
                }
                lstatus.setText(sta);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        pay = new JButton("Pay");
        pay.setBackground(Color.BLACK);
        pay.setForeground(Color.WHITE);
        pay.setBounds(100,460,100,25);
        pay.addActionListener(this);
        add(pay);
        
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(230,460,100,25);
        back.addActionListener(this);
        add(back);
        
        
        ImageIcon im = new ImageIcon(ClassLoader.getSystemResource("icon/bill.png"));
        Image ima = im.getImage().getScaledInstance(600,300,Image.SCALE_DEFAULT);
        
        JLabel image = new JLabel(new ImageIcon(ima));
        image.setBounds(400,120,600,300);
        add(image);
        
        
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent a)
    {
        if(a.getSource() == pay)
        {
            try{
                Conn c = new Conn();
                String query = "update bill set status='Paid' where meter_no='"+meter_no+"' and month='"+chmonth.getSelectedItem()+"'";
                c.s.executeUpdate(query);
                
                new Paytm(meter_no);
                setVisible(false);
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        else
        {
            setVisible(false);
        }
    }
    
    public static void main(String[] args)
    {
        new PayBill("");
    }
    
}
