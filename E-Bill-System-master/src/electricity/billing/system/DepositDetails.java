 
package electricity.billing.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;

public class DepositDetails extends JFrame implements ActionListener{
    
    Choice chmno,chmonth;
    JTable table;
    JButton search,print;
    
    DepositDetails(){
        
        super("DepositDetails");
        
        setSize(700,600);
        setLocation(260,50);
        
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        JLabel mno = new JLabel("Search by Meter Number");
        mno.setBounds(20,20,150,20);
        add(mno);
        
        chmno = new Choice();
        chmno.setBounds(180,20,150,20);
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from bill");
            while(rs.next())
            {
                chmno.add(rs.getString("meter_no"));
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        add(chmno);
        
        JLabel month = new JLabel("Search by Month");
        month.setBounds(400,20,100,20);
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
        chmonth.setBounds(520,20,150,20);
        add(chmonth);
        
        table = new JTable();
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from bill");
            
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        JScrollPane sp = new JScrollPane(table);
        sp.setBounds(0,100,700,600);
        add(sp);
        
        search = new JButton("Search");
        search.setBounds(20,70,80,20);
        search.addActionListener(this);
        add(search);
    
        print = new JButton("Print");
        print.setBounds(120,70,80,20);
        print.addActionListener(this);
        add(print);
        
        
        setVisible(true);
    }
    public void actionPerformed(ActionEvent a)
    {
        String msg = a.getActionCommand();
        if(msg.equals("Search"))
        {
            String query = "select * from bill where meter_no='"+chmno.getSelectedItem()+"' and month='"+chmonth.getSelectedItem()+"'";
            try{
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        else if(msg.equals("Print"))
        {
            try{
                table.print();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args)
    {
        new DepositDetails();
    }
    
}
