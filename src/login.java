import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class login extends JFrame implements ActionListener{
    
    //Declarations
    JLabel l1,l2;
    JTextField t1;
    JPasswordField t2;
    JButton b1,b2;
    login(){
        
        //Title
        super("Login Page");
        setLayout(new BorderLayout());
        
        //Text fields
        t1 = new JTextField(15);
        t1.setMargin(new Insets(5, 5, 5, 5));
        t2 = new JPasswordField(15);
        t2.setMargin(new Insets(5, 5, 5, 5));
        
        //Adding image
        JLabel l = new JLabel(new ImageIcon(ClassLoader.getSystemResource("icon\\defaultpic.jpg")));
        
        //Submit and cancel buttons
        b1 = new JButton("Submit", new ImageIcon(ClassLoader.getSystemResource("icon\\login.png")));
        b1.setMargin(new Insets(5, 20, 5, 20));
        b2 = new JButton("Cancel", new ImageIcon(ClassLoader.getSystemResource("icon\\Cancel.png")));
        b2.setMargin(new Insets(5, 20, 5, 20));
        b1.addActionListener(this);
        b2.addActionListener(this);

        //Declarations
        JPanel p1,p2,p3,p4;
        p1=new JPanel();
        p2=new JPanel();
        p3=new JPanel();
        p4=new JPanel();  
        
        //Adding Labels, Buttons and managing layout
        add(l,BorderLayout.WEST);
        p2.add(Box.createRigidArea(new Dimension(0,40)));
        p2.add(new JLabel("User Name   "));
        p2.add(t1);
        p2.add(new JLabel("Password   "));
        p2.add(Box.createRigidArea(new Dimension(0,40)));
        p2.add(t2); 
        add(p2,BorderLayout.CENTER);
        p4.add(b1);
        p4.add(b2);
        add(p4,BorderLayout.SOUTH);

        //Setting Size and Location
        setSize(500,300);
        setLocation(450,250);	
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        try
        {
            //Connecting to Database
            conn c1=new conn();
            
            //Getting Inputs
            String u=t1.getText();
            String v=t2.getText();
            
            //Comparing with Database values
            String q="select * from login where username='"+u+"' and password='"+v+"'";
            ResultSet rs=c1.s.executeQuery(q); 
            
            //If matches then open project else display invalid login window
            if(rs.next()){
                new project().setVisible(true);
                setVisible(false);
            }else{
                JOptionPane.showMessageDialog(null, "Invalid login");
                setVisible(false);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    //Main method
    public static void main(String[] args){
        new login();
    }
}
