import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Salary extends JFrame implements ActionListener{
    
    //Declarations
    JLabel c,l1,l2,l3,l4,l5,l6,l7;
    JTextField t1,t2,t3,t4,t5,t6,t7;
    JButton b1,b2;
    Choice c2;
    
    Salary(){
        
        //Title
        super("Salary");
       
        //Grid layout
        setLayout(null);
        c2 = new Choice();
        c2.setBounds(160,40,200,20);
        //Connecting to database
        try{
           conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * from employee");
      
            while(rs.next()){
                c2.add(rs.getString("id"));    
            }
        }catch(Exception e){ }
       
        //Setting and adding parameters and text fields
        c=new JLabel("Select Empno");
        c.setBounds(40,40,100,20);
        c.setFont(new Font("serif", Font.PLAIN, 15));
        add(c);
        add(c2);        
        l1 = new JLabel("HRA :");
        l3 = new JLabel("DA :");
        l4 = new JLabel("MED :");
        l5 = new JLabel("PF :");
        l6 = new JLabel("Basic Salary :");
        
        l1.setFont(new Font("serif", Font.PLAIN, 15));
        l3.setFont(new Font("serif", Font.PLAIN, 15));
        l4.setFont(new Font("serif", Font.PLAIN, 15));
        l5.setFont(new Font("serif", Font.PLAIN, 15));
        l6.setFont(new Font("serif", Font.PLAIN, 15));
        
        t1 = new JTextField(15);
        t3 = new JTextField(15);
        t4 = new JTextField(15);
        t5 = new JTextField(15);
        t6 = new JTextField(15);
        
        l1.setBounds(40,80,100,20);
        t1.setBounds(160,80,200,20);
        l3.setBounds(40,120,100,20);
        t3.setBounds(160,120,200,20);
        l4.setBounds(40,160,100,20);
        t4.setBounds(160,160,200,20);
        l5.setBounds(40,200,100,20);
        t5.setBounds(160,200,200,20);
        l6.setBounds(40,240,100,20);
        t6.setBounds(160,240,200,20);
        
        add(l1);
        add(t1);
        add(l3);
        add(t3);
        add(l4);
        add(t4); 
        add(l5);
        add(t5);
        add(l6);
        add(t6);
       
        //Adding Buttons
        b1 =new JButton("Submit");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE); 
        b2 = new JButton("Cancel");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b1.setBounds(40,320,150,30);
        b2.setBounds(200,320,150,30);
        add(b1);
        add(b2);
        b1.addActionListener(this);
        b2.addActionListener(this);
        
        //Setting size and location
        setSize(400,430);
        setLocation(500,150);
        setVisible(true);
       
        //Background Color
        getContentPane().setBackground(new Color(217, 202, 179)); 
    }
    
    public void actionPerformed(ActionEvent ae){
       
        //Getting Inputs
        String hra = t1.getText();
        String id = c2.getSelectedItem();
        String da = t3.getText();
        String med = t4.getText();
        String pf = t5.getText();
        String basic = t6.getText();
        String qry = "insert into salary values("+ id +","+hra+","+da+","+med+","+pf+","+basic+")";
        try{
            conn c1 = new conn();
            c1.s.executeUpdate(qry);

            //Displaying Salary Updated window
            JOptionPane.showMessageDialog(null,"Salary Updated");
            this.setVisible(false);
        }catch(Exception ee){
            ee.printStackTrace();
        }
    }
    
    //Main method
    public static void main(String[] args){
        new Salary().setVisible(true);
    }
}
