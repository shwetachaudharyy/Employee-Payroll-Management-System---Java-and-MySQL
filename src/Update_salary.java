import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Update_salary extends JFrame implements ActionListener,ItemListener{
    JLabel l1,l2,l3,l4,l5,l6;
    JTextField t1,t2,t3,t4,t5,t6;
    JButton b1,b2;
    Choice c2;
    
    Update_salary(){
        super("Update Salary");
        setLayout(null);
        c2 = new Choice();
        try{
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * from salary");
            while(rs.next()){
                c2.add(rs.getString("id"));    
            }
           
        }catch(Exception e){ }
       
        JLabel emp = new JLabel("Select Empno :");
        l1 = new JLabel("Hra :");
        t1 = new JTextField(15);
        l2 = new JLabel("Da :");
        t2 = new JTextField(15);
        l3 = new JLabel("Med :");
        t3 = new JTextField(15);
        l4 = new JLabel("Pf :");
        t4 = new JTextField(15);
        l5 = new JLabel("Basic Salary :");
        t5 = new JTextField(15);
        
        emp.setFont(new Font("serif", Font.PLAIN, 15));
        l1.setFont(new Font("serif", Font.PLAIN, 15));
        l2.setFont(new Font("serif", Font.PLAIN, 15));
        l3.setFont(new Font("serif", Font.PLAIN, 15));
        l4.setFont(new Font("serif", Font.PLAIN, 15));
        l5.setFont(new Font("serif", Font.PLAIN, 15));
        
        c2.setBounds(160,40,200,20);
        emp.setBounds(40,40,100,20);
        l1.setBounds(40,80,100,20);
        t1.setBounds(160,80,200,20);
        l2.setBounds(40,120,100,20);
        t2.setBounds(160,120,200,20);
        l3.setBounds(40,160,100,20);
        t3.setBounds(160,160,200,20);
        l4.setBounds(40,200,100,20);
        t4.setBounds(160,200,200,20);
        l5.setBounds(40,240,100,20);
        t5.setBounds(160,240,200,20);
        
        add(emp);
        add(c2);
        add(l1);
        add(t1);
        add(l2);
        add(t2);
        add(l3);
        add(t3);
        add(l4);
        add(t4); 
        add(l5);
        add(t5);
        
        b1 =new JButton("Update");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        
        b2 = new JButton("Delete");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        
        b1.setBounds(40,300,150,30);
        b2.setBounds(200,300,150,30);
        add(b1);
        add(b2);
       
        b1.addActionListener(this);
        b2.addActionListener(this);
        c2.addItemListener(this);
        
        getContentPane().setBackground(new Color(217, 202, 179)); 
       
        setVisible(true);
        setSize(400,400);
        setLocation(500,150);
    }
    
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource()==b1){
            String hra = t1.getText();
            String id = c2.getSelectedItem();
            String da = t2.getText();
            String med = t3.getText();
            String pf = t4.getText();
            String basic = t5.getText();
      
            String qry = "update salary set hra="+hra+",da="+da+",med="+med+",pf="+pf+",basic_salary="+basic+"  where id="+c2.getSelectedItem();
       
            try{
                conn c1 = new conn();
                c1.s.executeUpdate(qry);
                JOptionPane.showMessageDialog(null,"Salary Updated");
                this.setVisible(false);
            }catch(Exception ee){
                ee.printStackTrace();
            }
        }
        
        if(ae.getSource()==b2){
            
            try{
                conn c1 = new conn();
                c1.s.executeUpdate("delete from salary where id="+c2.getSelectedItem());
                JOptionPane.showMessageDialog(null,"Salary Deleted");
                this.setVisible(false);
            }catch(Exception ee){
                ee.printStackTrace();
            }
        }
    }
    
    public void itemStateChanged(ItemEvent ie)
    {
        try{
           conn c1 = new conn();
            ResultSet rs = c1.s.executeQuery("select * from salary where id="+c2.getSelectedItem());
            if(rs.next()){
                t1.setText(rs.getString("hra"));
                t2.setText(rs.getString("da"));
                t3.setText(rs.getString("med"));
                t4.setText(rs.getString("pf"));
                t5.setText(rs.getString("basic_salary"));
         
            }
       }catch(Exception ee){
           ee.printStackTrace();
       }
        
        
    }
    
    public static void main(String[] args){
        new Update_salary();
    }
    
}
