import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class New_Employee extends JFrame implements ActionListener{
    
    //Declarations
    JLabel l1,l2,l3,l4,l5,l6,l7;
    JTextField t1,t2,t3,t4,t5,t6,t7;
    JButton b1,b2;
    Choice c1;
    
    New_Employee(){
        
        //Title
        super("New Employee");
        
        //Setting Size and Location
        setSize(410,630);
        setLocation(500,50);
        getContentPane().setBackground(new Color(217, 202, 179));    
        setLayout(null);
        
        //Setting and adding parameters and text fields
        l1 = new JLabel("Name :");
        l2 = new JLabel("Gender :");
        l3 = new JLabel("Address :");
        l4 = new JLabel("State :");
        l5 = new JLabel("City :");
        l6 = new JLabel("Email :");
        l7 = new JLabel("Phone :");
        c1 = new Choice();
        c1.add("Male");
        c1.add("Female");
        
        l1.setFont(new Font("serif", Font.PLAIN, 18));
        l2.setFont(new Font("serif", Font.PLAIN, 18));
        l3.setFont(new Font("serif", Font.PLAIN, 18));
        l4.setFont(new Font("serif", Font.PLAIN, 18));
        l5.setFont(new Font("serif", Font.PLAIN, 18));
        l6.setFont(new Font("serif", Font.PLAIN, 18));
        l7.setFont(new Font("serif", Font.PLAIN, 18));
        
        t1 = new JTextField(10);
        t3 = new JTextField(10);
        t4 = new JTextField(10);
        t5 = new JTextField(10);
        t6 = new JTextField(10);
        t7= new JTextField(10);
        
        l1.setBounds(40,200,100,20);
        t1.setBounds(160,200,200,20);
        l2.setBounds(40,240,100,20);
        c1.setBounds(160,240,200,20);
        l3.setBounds(40,280,100,20);
        t3.setBounds(160,280,200,20);
        l4.setBounds(40,320,100,20);
        t4.setBounds(160,320,200,20);
        l5.setBounds(40,360,100,20);
        t5.setBounds(160,360,200,20);
        l6.setBounds(40,400,100,20);
        t6.setBounds(160,400,200,20);
        l7.setBounds(40,440,100,20);
        t7.setBounds(160,440,200,20);
        
        add(l1);
        add(t1);            
        add(l2);
        add(c1);
        add(l3);
        add(t3);
        add(l4);
        add(t4); 
        add(l5);
        add(t5);
        add(l6);
        add(t6);
        add(l7);
        add(t7);
        
        //Adding submit and cancel buttons
        b1 =new JButton("Submit");
        b2 = new JButton("Cancel");
        b1.setBounds(40,520,150,30);
        b2.setBounds(200,520,150,30);
        add(b1);
        add(b2);       
        setLayout(new BorderLayout());
        add(new JLabel(new ImageIcon(ClassLoader.getSystemResource("icons/new_employee.jpg"))),"North");
 
        setBackground(new Color(217, 202, 179));
        b1.addActionListener(this);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b2.addActionListener(this);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
       
    }
    
    public void actionPerformed(ActionEvent ae){
        
        //Getting Inputs
        String n = t1.getText();
        String g = c1.getSelectedItem();
        String a = t3.getText();
        String s = t4.getText();
        String c = t5.getText();
        String e = t6.getText();
        String p = t7.getText();
        
        //Storing inputs in database
        String qry = "insert into employee values(null,'"+n+"','"+g+"','"+a+"','"+s+"','"+c+"','"+e+"','"+p+"')";
       
        try{
            //Connecting to Database
            conn c1 = new conn();
            c1.s.executeUpdate(qry);
            
            //Displaying Employee Created window
            JOptionPane.showMessageDialog(null,"Employee Created");
            this.setVisible(false);  
        }catch(Exception ee){
            ee.printStackTrace();
        }
    }
    
    //Main method
    public static void main(String s[]){
        new New_Employee().setVisible(true);
    }
}
