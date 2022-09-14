 
package electricity.billing.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class MeterInfo extends JFrame implements ActionListener{
    
    Choice tfmlc,tfmtype,tfpcode,tfbtype;
    JButton submit,cancel;
    long mnumber;
    MeterInfo(long number){
        super("Meter Information");
        this.mnumber = number;
        setSize(700,500);
        setLocation(400,200);
        getContentPane().setBackground(Color.WHITE);
    
    // Panel 
        JPanel pan = new JPanel();
        pan.setLayout(null);
        pan.setBackground(new Color(173,216,230));
        add(pan);
        
    // Heading of Panel   
        JLabel hea = new JLabel("Meter Information");
        hea.setBounds(180,10,300,20);
        hea.setFont(new Font("Tahoma",Font.BOLD,25));
        pan.add(hea);
     
    // Field 1 : Meter Number
        JLabel mno = new JLabel("Meter Number");
        mno.setBounds(120,80,100,20);
        pan.add(mno);
       
        JLabel mn = new JLabel(""+mnumber);
        mn.setBounds(240,80,100,20);
        pan.add(mn);
        
    // Field 2 : Meter Location 
        JLabel mlocation = new JLabel("Meter Location");
        mlocation.setBounds(120,120,100,20);
        pan.add(mlocation);

        tfmlc = new Choice();
        tfmlc.add("Outside");
        tfmlc.add("Inside");
        tfmlc.setBounds(240,120,200,20);
        pan.add(tfmlc);

    // Field 3 : Meter Type
        JLabel mtype = new JLabel("Meter Type");
        mtype.setBounds(120,160,100,20);
        pan.add(mtype);
       
        tfmtype = new Choice();
        tfmtype.add("Electric Meter");
        tfmtype.add("Solar Meter");
        tfmtype.add("Smart Meter");
        tfmtype.setBounds(240,160,200,20);
        pan.add(tfmtype);  
 
    // Field 4 : Phase Code
        JLabel pcode = new JLabel("Phase Code");
        pcode.setBounds(120,200,100,20);
        pan.add(pcode);
       
        tfpcode = new Choice();
        tfpcode.add("011");
        tfpcode.add("022");
        tfpcode.add("033");
        tfpcode.add("044");
        tfpcode.add("055"); 
        tfpcode.add("066");
        tfpcode.add("077");
        tfpcode.add("088");
        tfpcode.add("099"); 
        tfpcode.setBounds(240,200,200,20);
        pan.add(tfpcode); 

    // Field 5 : Bill Type
        JLabel state = new JLabel("Bill Type");
        state.setBounds(120,240,100,20);
        pan.add(state);
       
        tfbtype = new Choice();
        tfbtype.add("Normal");
        tfbtype.add("Industrial");
        tfbtype.setBounds(240,240,200,20);
        pan.add(tfbtype);  
 
    // Field 6 : Days
        JLabel days = new JLabel("Days");
        days.setBounds(120,280,100,20);
        pan.add(days);

        JLabel totdays = new JLabel("30 Days");
        totdays.setBounds(240,280,200,20);
        pan.add(totdays);
        
    // Field 7 : Note
        JLabel note = new JLabel("Note");
        note.setBounds(120,320,100,20);
        pan.add(note);
 
        JLabel notedis = new JLabel("By Default Bill is calculated for 30 days only");
        notedis.setBounds(240,320,400,20);
        pan.add(notedis);
        
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
        
        ImageIcon im = new ImageIcon(ClassLoader.getSystemResource("icon/hicon1.jpg"));
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
            String mloc = tfmlc.getSelectedItem();
            String mn = ""+mnumber;
            String mtype = tfmtype.getSelectedItem();
            String pcode = tfpcode.getSelectedItem();
            String btype = tfbtype.getSelectedItem();
            String days = "30";
            
            String query1 = "insert into meter_info values('"+mn+"','"+mloc+"','"+mtype+"','"+pcode+"','"+btype+"','"+days+"')";
                        
            try{
                Conn c = new Conn();
                c.s.executeUpdate(query1);
                
                JOptionPane.showMessageDialog(null,"Meter Information added successfully");
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
        new MeterInfo(0);
    }   
    
}
