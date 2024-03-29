
package hotel.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
    
    JLabel l1,l2,l3;
    JTextField t1;
    JPasswordField t2;
    JComboBox d1;
    JButton b1,b2,b3;

    Login(){

        super("Login");
        setLayout(null);

        l1 = new JLabel("Username  :");
        l1.setBounds(40,200,500,100);
        l1.setFont(new Font("serif",Font.BOLD,40));
        add(l1);
        
        l2 = new JLabel("Password   :");
        l2.setBounds(40,320,500,100);
        l2.setFont(new Font("serif",Font.BOLD,40));
        add(l2);
        
        l3 = new JLabel("Select User Type");
        l3.setBounds(40,440,500,100);
        l3.setFont(new Font("serif",Font.BOLD,40));
        add(l3);
 
        t1=new JTextField();
        t1.setBounds(350,240,200,50);
        t1.setFont(new Font("serif",Font.BOLD,30));
        add(t1);

        t2=new JPasswordField();
        t2.setBounds(350,360,200,50);
        t2.setFont(new Font("serif",Font.BOLD,30));
        add(t2);
        
        String str[]={"Manager","Receptionist"};
        d1=new JComboBox(str);
        d1.setBounds(350,480,200,50);
        d1.setFont(new Font("serif",Font.BOLD,20));
        d1.setBackground(Color.WHITE);
        add(d1);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/second.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1200,1000,Image.SCALE_AREA_AVERAGING);
        ImageIcon i3 =  new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(450,10,1800,900);
        add(l3);


        b1 = new JButton("Login");
        b1.setBounds(40,620,200,40);
        b1.setFont(new Font("serif",Font.BOLD,30));
        b1.addActionListener(this);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        add(b1);

        b2=new JButton("Cancel");
        b2.setBounds(345,620,200,40);
        b2.setFont(new Font("serif",Font.BOLD,30));
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        add(b2);
        b2.addActionListener(this);
        
        b3=new JButton("Forget Password");
        b3.setBounds(195,720,200,40);
        b3.setFont(new Font("serif",Font.BOLD,20));
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        add(b3);
        b3.addActionListener(this);
        
        
        getContentPane().setBackground(Color.WHITE);

        setVisible(true);
        setSize(600,300);
        setLocation(600,350);
        setBounds(0,0,1950,1020);

    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){  
        try{
            String u = t1.getText();
            String v = t2.getText();
            String JComboBox=(String)d1.getSelectedItem();
            conn c1 = new conn();
            String q1 ="select * from login where Username = '"+u+"' and Password = '"+v+"'";     
            ResultSet rs = c1.s.executeQuery(q1);
            
           if(rs.next()) {
               JOptionPane.showMessageDialog(null, "Username and password matched and you are logined as "  +  rs.getString ("Usertype"));
           
           if(JComboBox.equals("Receptionist")){
                new Dashboard().setVisible(true);
                setVisible(false);
                
            }else if (JComboBox.equals("Manager")) {
                new Dashboard1().setVisible(true);
                setVisible(false);
            }
                
            }else{
                
                JOptionPane.showMessageDialog(null, "Username and Password is incorrect");
                setVisible(true);
            }
        }catch(Exception e){                 
            e.printStackTrace();
         
        }
        }if(ae.getSource()==b2){
            System.exit(0);
        }if(ae.getSource()==b3){
            new ForgetPassword().setVisible(true);
            setVisible(false);
        } }
   
    public static void main(String[] arg){
        new Login();
    }
}

