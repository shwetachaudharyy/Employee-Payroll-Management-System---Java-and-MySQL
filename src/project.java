import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class project extends JFrame implements ActionListener {
    project(){
        
        //Setting Size and Location
        setSize(1200,750);
        setLocation(80,0);
        getContentPane().setBackground(Color.WHITE);
        
        //Adding Image to the display
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/payroll.jpeg"));
        Image i2 = i1.getImage().getScaledInstance(1200,700,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);
        add(l1);
        
        //Creating MenuBar
        JMenuBar mb = new JMenuBar();
        setJMenuBar(mb);
        Font f = new Font("sans-serif", Font.BOLD, 16);
        UIManager.put("Menu.font", f);
       
        //Master Option
        JMenu m1 = new JMenu("Master");
        m1.setForeground(Color.blue);
        JMenuItem t1 = new JMenuItem("New Employee");
        t1.setForeground(Color.blue);
        t1.setFont(new Font("sans-serif",Font.PLAIN,15));
        t1.setMnemonic('N');
        t1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
        t1.setIcon(new ImageIcon(ClassLoader.getSystemResource("Icons/New.png")));
        JMenuItem t3 = new JMenuItem("Set Salary");
        t3.setForeground(Color.blue);
        t3.setFont(new Font("sans-serif",Font.PLAIN,15));
        t3.setMnemonic('S');
        t3.setIcon(new ImageIcon(ClassLoader.getSystemResource("icon/schedreport.png")));
        t3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
        JMenuItem t4 = new JMenuItem("List Employee");
        t4.setForeground(Color.blue);
        t4.setFont(new Font("sans-serif",Font.PLAIN,15));
        t4.setMnemonic('L');
        t4.setIcon(new ImageIcon(ClassLoader.getSystemResource("icon/newinvoice.png")));
        t4.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, ActionEvent.CTRL_MASK));
        m1.add(t1);
        m1.addSeparator();
        m1.add(t3);
        m1.addSeparator();
        m1.add(t4);
        mb.add(m1);
        t1.addActionListener(this);
        t3.addActionListener(this);
        t4.addActionListener(this);
        
        //Adding space 
        JMenu a = new JMenu("   ");
        a.setEnabled(false);
        mb.add(a);
        
        //Update Option
        JMenu edit =new JMenu("Update");
        edit.setForeground(Color.BLUE);
        mb.add(edit);
        JMenuItem s1 = new JMenuItem("Update Salary");
        s1.setForeground(Color.blue);
        s1.setFont(new Font("sans-serif",Font.PLAIN,15));
        s1.setMnemonic('U');
        s1.setIcon(new ImageIcon(ClassLoader.getSystemResource("Icons/EditOpen.png")));
        s1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U, ActionEvent.CTRL_MASK));  
        edit.add(s1);
        edit.addSeparator();   
        JMenuItem s2 = new JMenuItem("Update Employee");  
        s2.setForeground(Color.blue);
        s2.setFont(new Font("sans-serif",Font.PLAIN,15));
        s2.setMnemonic('p');
        s2.setIcon(new ImageIcon(ClassLoader.getSystemResource("icon/empreport.png")));
        s2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));         
        edit.add(s2);
        edit.addSeparator();
        JMenuItem s3 = new JMenuItem("Take Attendence");
        s3.setForeground(Color.blue);
        s3.setFont(new Font("sans-serif",Font.PLAIN,15));
        s3.setMnemonic('T');
        s3.setIcon(new ImageIcon(ClassLoader.getSystemResource("icon/EXPENSE.PNG")));
        s3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T, ActionEvent.CTRL_MASK));
        edit.add(s3);
        s1.addActionListener(this);
        s2.addActionListener(this);
        s3.addActionListener(this);
        
        //Adding space
        JMenu a1 = new JMenu("   ");
        a1.setEnabled(false);
        mb.add(a1);
        
        //Reports Option
        JMenu rep =new JMenu("Reports");
        rep.setForeground(Color.blue);
        mb.add(rep);
        JMenuItem p1 = new JMenuItem("Generate PaySlip");
        p1.setForeground(Color.blue);
        p1.setFont(new Font("sans-serif",Font.PLAIN,15));
        p1.setMnemonic('P');
        p1.setIcon(new ImageIcon(ClassLoader.getSystemResource("icon/payments.png")));
        p1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));
        rep.add(p1);
        rep.addSeparator();
        JMenuItem p2 = new JMenuItem("List Attendence");   
        p2.setForeground(Color.blue);
        p2.setFont(new Font("sans-serif",Font.PLAIN,15));
        p2.setMnemonic('L');
        p2.setIcon(new ImageIcon(ClassLoader.getSystemResource("icon/empreport.png")));
        p2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, ActionEvent.CTRL_MASK));
        rep.add(p2);
        p1.addActionListener(this);
        p2.addActionListener(this);
        
        //Adding Space
        JMenu a2 = new JMenu("   ");
        a2.setEnabled(false);
        mb.add(a2);
        
        //Exit Option
        JMenu m8=new JMenu("Exit");
        m8.setForeground(Color.red);
        mb.add(m8);
        JMenuItem m8i1=new JMenuItem("Exit");
        m8.add(m8i1);
        m8i1.setForeground((Color.blue));
        m8i1.setFont(new Font("sans-serif", Font.PLAIN, 15));
        m8i1.setMnemonic('X');
        m8i1.setIcon(new ImageIcon(ClassLoader.getSystemResource("icon/exit.PNG")));
        m8i1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));
        m8i1.addActionListener(this);
    }
    
    //Enabling SetVisible Property
    public void actionPerformed(ActionEvent ae){
        String msg= ae.getActionCommand();     
        if(msg.equals("New Employee"))
            new New_Employee().setVisible(true);
        else if(msg.equals("List Employee"))
            new List_Employee().setVisible(true);
        else if(msg.equals("Update Employee"))
            new Update_employee().setVisible(true);
        else if(msg.equals("Set Salary"))
            new Salary().setVisible(true);
        else if(msg.equals("Update Salary"))
            new Update_salary().setVisible(true);
        else if(msg.equals("Take Attendence")){
            new TakeAttendence().setVisible(true);
        }
        else if(msg.equals("Exit"))
            System.exit(0);
        else if(msg.equals("Generate PaySlip"))
            new pay_slip().setVisible(true);
        else if(msg.equals("List Attendence"))
            new List_Attendence().setVisible(true);
    }    
    
    //Main method
    public static void main(String[] args){
        new project().setVisible(true);
    }  
}
