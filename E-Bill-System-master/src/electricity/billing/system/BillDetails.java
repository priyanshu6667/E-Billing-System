 
package electricity.billing.system;
 
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;

public class BillDetails extends JFrame{
    
    String meter_no;
    JTable table;
    
    BillDetails(String meter_no){
        
        super("Bill Details");
        this.meter_no = meter_no;
        setBounds(200,50,800,600);
        
        table = new JTable();
        
        try{
            Conn c = new Conn();
            String query = "select * from bill where meter_no='"+meter_no+"'";
            ResultSet rs = c.s.executeQuery(query);
 
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        JScrollPane pane = new JScrollPane(table);
        pane.setBounds(0,0,800,600);
        add(pane);
        
        setVisible(true);
    }
    public static void main(String[] args)
    {
        
        new BillDetails("");
    }
}
