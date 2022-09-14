 
package electricity.billing.system;
 
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Project extends JFrame implements ActionListener{
    
    String user_type,meter_numb;
    Project(String user_type,String meter_numb){
        
        this.user_type = user_type;
        this.meter_numb = meter_numb;
        setExtendedState(JFrame.MAXIMIZED_BOTH);
 
        ImageIcon im = new ImageIcon(ClassLoader.getSystemResource("icon/elect1.jpg"));
        Image ima = im.getImage().getScaledInstance(1500, 800, Image.SCALE_DEFAULT);
        
        JLabel i1 = new JLabel(new ImageIcon(ima));
        add(i1);

        JMenuBar mb = new JMenuBar();
        setJMenuBar(mb);
        
    // Menu 1 : Master
    
        JMenu mas = new JMenu("Master");
        mas.setForeground(Color.BLUE);

        
        JMenuItem it1 = new JMenuItem("New Customer");
        it1.setFont(new Font("monospaced",Font.PLAIN,12));
        it1.setBackground(Color.WHITE);
        ImageIcon im1 = new ImageIcon(ClassLoader.getSystemResource("icon/icon1.png"));
        Image ima1 = im1.getImage().getScaledInstance(30,20,Image.SCALE_DEFAULT);
        it1.setIcon(new ImageIcon(ima1));
        it1.setMnemonic('D');
        it1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D,ActionEvent.CTRL_MASK));
        
        it1.addActionListener(this);
        mas.add(it1);
        
        JMenuItem it2 = new JMenuItem("Customer Details");
        it2.setFont(new Font("monospaced",Font.PLAIN,12));
        it2.setBackground(Color.WHITE);
        ImageIcon im2 = new ImageIcon(ClassLoader.getSystemResource("icon/icon2.png"));
        Image ima2 = im2.getImage().getScaledInstance(30,20,Image.SCALE_DEFAULT);
        it2.setIcon(new ImageIcon(ima2));
        it2.setMnemonic('M');
        it2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M,ActionEvent.CTRL_MASK));
        
        it2.addActionListener(this);
        mas.add(it2);
        
        JMenuItem it3 = new JMenuItem("Deposit Details");
        it3.setFont(new Font("monospaced",Font.PLAIN,12));
        it3.setBackground(Color.WHITE);
        ImageIcon im3 = new ImageIcon(ClassLoader.getSystemResource("icon/icon3.png"));
        Image ima3 = im3.getImage().getScaledInstance(30,20,Image.SCALE_DEFAULT);
        it3.setIcon(new ImageIcon(ima3));
        it3.setMnemonic('N');
        it3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,ActionEvent.CTRL_MASK));
        
        it3.addActionListener(this);
        mas.add(it3);        
  
        JMenuItem it4 = new JMenuItem("Calculate eBill");
        it4.setFont(new Font("monospaced",Font.PLAIN,12));
        it4.setBackground(Color.WHITE);
        ImageIcon im4 = new ImageIcon(ClassLoader.getSystemResource("icon/icon4.png"));
        Image ima4 = im4.getImage().getScaledInstance(30,20,Image.SCALE_DEFAULT);
        it4.setIcon(new ImageIcon(ima4));
        it4.setMnemonic('B');
        it4.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B,ActionEvent.CTRL_MASK));
        
        it4.addActionListener(this);
        mas.add(it4);
        
    // Menu 2 : Information
        
    
        JMenu info = new JMenu("Information");
        info.setForeground(Color.RED);
        

        JMenuItem it5 = new JMenuItem("Update Information");
        it5.setFont(new Font("monospaced",Font.PLAIN,12));
        it5.setBackground(Color.WHITE);
        ImageIcon im5 = new ImageIcon(ClassLoader.getSystemResource("icon/icon5.png"));
        Image ima5 = im5.getImage().getScaledInstance(30,20,Image.SCALE_DEFAULT);
        it5.setIcon(new ImageIcon(ima5));
        it5.setMnemonic('P');
        it5.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P,ActionEvent.CTRL_MASK));
        
        it5.addActionListener(this);
        info.add(it5);
 
        
        JMenuItem it6 = new JMenuItem("View Information");
        it6.setFont(new Font("monospaced",Font.PLAIN,12));
        it6.setBackground(Color.WHITE);
        ImageIcon im6 = new ImageIcon(ClassLoader.getSystemResource("icon/icon6.png"));
        Image ima6 = im6.getImage().getScaledInstance(30,20,Image.SCALE_DEFAULT);
        it6.setIcon(new ImageIcon(ima6));
        it6.setMnemonic('L');
        it6.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L,ActionEvent.CTRL_MASK));
        
        it6.addActionListener(this);
        info.add(it6);
        
    // Menu 3 : User
    
        JMenu user = new JMenu("User");
        user.setForeground(Color.BLUE);
        

        JMenuItem it7 = new JMenuItem("Pay Bill");
        it7.setFont(new Font("monospaced",Font.PLAIN,12));
        it7.setBackground(Color.WHITE);
        ImageIcon im7 = new ImageIcon(ClassLoader.getSystemResource("icon/icon7.png"));
        Image ima7 = im7.getImage().getScaledInstance(30,20,Image.SCALE_DEFAULT);
        it7.setIcon(new ImageIcon(ima7));
        it7.setMnemonic('R');
        it7.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R,ActionEvent.CTRL_MASK));
        
        it7.addActionListener(this);
        user.add(it7);
 
        
        JMenuItem it8 = new JMenuItem("Bill Details");
        it8.setFont(new Font("monospaced",Font.PLAIN,12));
        it8.setBackground(Color.WHITE);
        ImageIcon im8 = new ImageIcon(ClassLoader.getSystemResource("icon/icon8.png"));
        Image ima8 = im8.getImage().getScaledInstance(30,20,Image.SCALE_DEFAULT);
        it8.setIcon(new ImageIcon(ima8));
        it8.setMnemonic('K');
        it8.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_K,ActionEvent.CTRL_MASK));
        
        it8.addActionListener(this);
        user.add(it8);
     
    // Menu 4 : View eBill Slip
    
        JMenu rep = new JMenu("Report");
        rep.setForeground(Color.RED);
        

        JMenuItem it9 = new JMenuItem("Generate Bill");
        it9.setFont(new Font("monospaced",Font.PLAIN,12));
        it9.setBackground(Color.WHITE);
        ImageIcon im9 = new ImageIcon(ClassLoader.getSystemResource("icon/bill.png"));
        Image ima9 = im9.getImage().getScaledInstance(30,20,Image.SCALE_DEFAULT);
        it9.setIcon(new ImageIcon(ima9));
        it9.setMnemonic('V');
        it9.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V,ActionEvent.CTRL_MASK));
        
        it9.addActionListener(this);
        rep.add(it9);
        
    // Menu 5 : Utility
        
        JMenu ut = new JMenu("Utility");
        ut.setForeground(Color.BLUE);
        

        JMenuItem it10 = new JMenuItem("Notepad");
        it10.setFont(new Font("monospaced",Font.PLAIN,12));
        it10.setBackground(Color.WHITE);
        ImageIcon im10 = new ImageIcon(ClassLoader.getSystemResource("icon/icon12.png"));
        Image ima10 = im10.getImage().getScaledInstance(30,20,Image.SCALE_DEFAULT);
        it10.setIcon(new ImageIcon(ima10));
        it10.setMnemonic('N');
        it10.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,ActionEvent.CTRL_MASK));
        
        it10.addActionListener(this);
        ut.add(it10);
        
        JMenuItem it11 = new JMenuItem("Calculator");
        it11.setFont(new Font("monospaced",Font.PLAIN,12));
        it11.setBackground(Color.WHITE);
        ImageIcon im11 = new ImageIcon(ClassLoader.getSystemResource("icon/icon9.png"));
        Image ima11 = im11.getImage().getScaledInstance(30,20,Image.SCALE_DEFAULT);
        it11.setIcon(new ImageIcon(ima11));
        it11.setMnemonic('C');
        it11.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,ActionEvent.CTRL_MASK));
        
        it11.addActionListener(this);
        ut.add(it11);
        
    // Menu 6 : Exit
    
        JMenu exit = new JMenu("Exit");
        exit.setForeground(Color.RED);
        

        JMenuItem it12 = new JMenuItem("Exit");
        it12.setFont(new Font("monospaced",Font.PLAIN,12));
        it12.setBackground(Color.WHITE);
        ImageIcon im12 = new ImageIcon(ClassLoader.getSystemResource("icon/icon11.png"));
        Image ima12 = im12.getImage().getScaledInstance(30,20,Image.SCALE_DEFAULT);
        it12.setIcon(new ImageIcon(ima12));
        it12.setMnemonic('W');
        it12.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W,ActionEvent.CTRL_MASK));
        
        it12.addActionListener(this);
        exit.add(it12);
        
        
        if(user_type.equals("Admin"))
        {
            mb.add(mas);
        }
        else if(user_type.equals("Customer"))
        {
            mb.add(info);
            mb.add(user);
            mb.add(rep);
        }
        mb.add(ut);
        mb.add(exit);
 
        setLayout(new FlowLayout());
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent a)
    {
        String msg = a.getActionCommand();
        if(msg.equals("New Customer"))
        {
            new NewCustomer();
        }
        else if(msg.equals("Customer Details"))
        {
            new CustomerDetails();
        }
        else if(msg.equals("Deposit Details"))
        {
            new DepositDetails();
        }
        else if(msg.equals("Calculate eBill"))
        {
            new CalculateBill();
        }
 
        else if(msg.equals("View Information"))
        {
            new ViewInformation(meter_numb);
        }
        else if(msg.equals("Update Information"))
        {
            new UpdateInformation(meter_numb);
        }
        else if(msg.equals("Bill Details"))
        {
            new BillDetails(meter_numb);
        }
        else if(msg.equals("Notepad"))
        {
            try{
                Runtime.getRuntime().exec("notepad.exe");
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        else if(msg.equals("Calculator"))
        {
            try{
                Runtime.getRuntime().exec("calc.exe");
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        else if(msg.equals("Exit"))
        {
            setVisible(false);
            new Login();
        }
        else if(msg.equals("Pay Bill"))
        {
            new PayBill(meter_numb);
        }
        else if(msg.equals("Generate Bill"))
        {
            new GenerateBill(meter_numb);
        }         
    }
    
    public static void main(String[] args){
        new Project("","");
    }
}
