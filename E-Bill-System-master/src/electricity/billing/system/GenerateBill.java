 
package electricity.billing.system;
 
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class GenerateBill extends JFrame implements ActionListener{
    
    Choice chmonth;
    JTextArea area;
    JButton bill;
    String meter_no;
    GenerateBill(String meter_no){
        
        this.meter_no = meter_no;
        setSize(520,645);
        setLocation(400,30);
        
        setLayout(new BorderLayout());
        
        JPanel pan = new JPanel();
        
        JLabel head = new JLabel("Generate Bill");
        
        JLabel meter = new JLabel(meter_no);
        
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
        
        area = new JTextArea(50,15);
        area.setText("\n\n\t\t................Click on the.............\n\t To Generate Bill Click on Button to get bill of the selected Month");
        area.setFont(new Font("Senserif",Font.ITALIC,13));
        
        JScrollPane span = new JScrollPane(area);
        
        bill = new JButton("Generate Bill");
        bill.addActionListener(this);
        
        pan.add(head);
        pan.add(meter);
        pan.add(chmonth);
        
        
        add(pan,"North");        
        add(span,"Center");
        add(bill,"South");
        
        setVisible(true);
    }
    
    
    public void actionPerformed(ActionEvent a)
    {
        try{
            Conn c = new Conn();
            
            String month = chmonth.getSelectedItem();
            
            area.setText("\n\t\tReliance Power Limited\n\n\tELECTRICITY BILL GENERATED FOR THE MONTH \n\t\tOF "+month.toUpperCase()+",2022");
            
            ResultSet rs = c.s.executeQuery("select * from customer where meter_no= '"+meter_no+"'");
            
            if(rs.next())
            {
                area.append("\n");
                area.append("\n        Customer Name:\t"+rs.getString("name"));
                area.append("\n        Meter Number: \t"+rs.getString("meter_no"));
                area.append("\n        Address:      \t"+rs.getString("address"));
                area.append("\n        City:         \t"+rs.getString("city"));
                area.append("\n        State:        \t"+rs.getString("state"));
                area.append("\n        Email:        \t"+rs.getString("email"));
                area.append("\n        Phone Number: \t"+rs.getString("pnumber"));
            }
            
            rs = c.s.executeQuery("select * from meter_info where m_no= '"+meter_no+"'");
            
            if(rs.next())
            {
                area.append("\n        ---------------------------------------------------------------------------------------");
                area.append("\n        Meter Locaton:\t"+rs.getString("m_location"));
                area.append("\n        Meter Type: \t"+rs.getString("m_type"));
                area.append("\n        Phase Code:      \t"+rs.getString("phase_code"));
                area.append("\n        Bill Type:         \t"+rs.getString("bill_type"));
                area.append("\n        Days:        \t"+rs.getString("days"));
            }
            
            rs = c.s.executeQuery("select * from tax");
            
            if(rs.next())
            {
                area.append("\n        ---------------------------------------------------------------------------------------");
                area.append("\n        Cost Per Unit:\t"+rs.getString("cost_per_unit"));
                area.append("\n        Meter Rent: \t"+rs.getString("meter_rent"));
                area.append("\n        Service Charge:      \t"+rs.getString("service_charge"));
                area.append("\n        Service Tax:         \t"+rs.getString("service_tax"));
                area.append("\n        Swacch Bharat Cess:     "+rs.getString("swacch_bharat_cess"));
                area.append("\n        Fixed Tax:\t"+rs.getString("fixed_tax"));
            }
            
            rs = c.s.executeQuery("select * from bill where meter_no = '"+meter_no+"' and month='"+month+"'");
            
            if(rs.next())
            {
                area.append("\n        ---------------------------------------------------------------------------------------");
                area.append("\n        Units Consumed:\t"+rs.getString("units"));
                area.append("\n        Current Month: \t"+rs.getString("month"));
                area.append("\n        Total Bill:      \t"+rs.getString("totalbill"));  
                area.append("\n        Status:      \t"+rs.getString("status"));  
                area.append("\n        ---------------------------------------------------------------------------------------");
                area.append("\n\n        Total Payable:\t"+rs.getString("totalbill"));
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args)
    {
        new GenerateBill("");
    }
}
