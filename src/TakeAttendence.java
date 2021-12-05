import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TakeAttendence extends JFrame implements ActionListener{
    
    //Declarations
    JLabel c,l1,l2,l3,l4,l5,l6,l7;
    JTextField t1,t2,t3,t4,t5,t6,t7;
    JButton b1,b2;
    Choice c2,fh,sh;
    
    TakeAttendence(){
        setLayout(new GridLayout(4,2,50,50));
        c2 = new Choice();
        try{
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * from employee");
            while(rs.next()){
                c2.add(rs.getString("id"));    
            }
       }catch(Exception e){ }
       
        //Adding parameters
        c=new JLabel("Select Empno");
        l1 = new JLabel("First Half");
        l2 = new JLabel("Second Half");
        c.setFont(new Font("serif", Font.PLAIN, 15));
        l1.setFont(new Font("serif", Font.PLAIN, 15));
        l2.setFont(new Font("serif", Font.PLAIN, 15));
        c.setHorizontalAlignment(JLabel.CENTER);
        l1.setHorizontalAlignment(JLabel.CENTER);
        l2.setHorizontalAlignment(JLabel.CENTER);
        fh = new Choice();
        fh.add("Present");
        fh.add("Absent");
        fh.add("Leave");
        sh = new Choice();
        sh.add("Present");
        sh.add("Absent");
        sh.add("Leave");
        add(c);
        add(c2);
        add(l1);
        add(fh);
        add(l2);
        add(sh);
       
        //Adding Buttons
        b1 =new JButton("Submit");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b2 = new JButton("Cancel");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        add(b1);
        add(b2);
        b1.addActionListener(this);
        b2.addActionListener(this);
        
        //Setting size, location and background colour
        setVisible(true);
        setSize(400,300);
        setLocation(500,200);
        getContentPane().setBackground(new Color(217, 202, 179)); 
    }
    
    public void actionPerformed(ActionEvent ae){
       
        //Getting inputs
        String f = fh.getSelectedItem();
        String s = sh.getSelectedItem();
        String dt = new java.util.Date().toString();
        String id=c2.getSelectedItem();
        String qry = "insert into attendence values("+ id +",'"+dt+"','"+f+"','"+s+"')";
       
        //Connecting to Database
        try{
            conn c1 = new conn();
            c1.s.executeUpdate(qry);
            JOptionPane.showMessageDialog(null,"Attendence confirmed");
            this.setVisible(false);
        }catch(Exception ee){
            ee.printStackTrace();
        }
    }
    
    //Main method
    public static void main(String s[]){
        new TakeAttendence();
    }
}
