/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author ISHIKA
 */
public class ForgetPassword extends JFrame implements ActionListener{
    
    JLabel l1,l2,l3,l4;
    JTextField t1;
    JPasswordField t2,t3,t4;
    JButton b1,b2;

    ForgetPassword(){
    
        super("ForgetPassword");
        setLayout(null);

        l1 = new JLabel("Username  :");
        l1.setBounds(40,120,500,100);
        l1.setFont(new Font("serif",Font.BOLD,40));
        add(l1);
        
        l2 = new JLabel("Old Password   :");
        l2.setBounds(40,240,500,100);
        l2.setFont(new Font("serif",Font.BOLD,40));
        add(l2);
        
        l3 = new JLabel("New Password   :");
        l3.setBounds(40,360,500,100);
        l3.setFont(new Font("serif",Font.BOLD,40));
        add(l3);
        
        l4 = new JLabel("Confirm Password   :");
        l4.setBounds(40,480,500,100);
        l4.setFont(new Font("serif",Font.BOLD,40));
        add(l4);
    
        t1=new JTextField();
        t1.setBounds(415,150,200,50);
        t1.setFont(new Font("serif",Font.BOLD,25));
        add(t1);

        
        t2=new JPasswordField();
        t2.setBounds(415,270,200,50);
        t2.setFont(new Font("serif",Font.BOLD,25));
        add(t2);
        
        t3=new JPasswordField();
        t3.setBounds(415,390,200,50);
        t3.setFont(new Font("serif",Font.BOLD,25));
        add(t3);
        
        t4=new JPasswordField();
        t4.setBounds(415,510,200,50);
        t4.setFont(new Font("serif",Font.BOLD,25));
        add(t4);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/forgot.png"));
        Image i2 = i1.getImage().getScaledInstance(500,500,Image.SCALE_DEFAULT);
        ImageIcon i3 =  new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(450,10,1800,900);
        add(l3);
        
        b1 = new JButton("Change");
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
        b2.addActionListener(this);
        add(b2);
        
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
            String v1 = t3.getText();
            String v2 = t4.getText();
                   
            conn c1 = new conn();
            String q1 ="select * from login where Username = '"+u+"'"; 
            String q2 ="update login set Password='"+v1+"' where Username='"+u+"'";            
            try {
                ResultSet rs = c1.s.executeQuery(q1);
                if(rs.next()){
                    if(rs.getString("Password").equals(v))
                    {
                       t2.setText("");
                       if(v1.equals(v2))
                       {
                           t4.setText("");
                           c1.s.executeUpdate(q2);
                           JOptionPane.showMessageDialog(rootPane,"Password Changed Succesfully");
                       }
                       else{
                           t4.setText("");
                           JOptionPane.showMessageDialog(rootPane,"Confirm Password does not match");  
                       }
                    }
                       else{
                        t2.setText("");
                        JOptionPane.showMessageDialog(rootPane,"Invalid Old Password");
                               
                               }
                    }
                else{
                    t1.setText("");
                    JOptionPane.showMessageDialog(rootPane,"Invalid Username");
                }
            
              
                
            } catch (SQLException ex) {
                Logger.getLogger(ForgetPassword.class.getName()).log(Level.SEVERE, null, ex);
            }
       }catch(Exception e){                 
            e.printStackTrace();
       }
               
        }if(ae.getSource()==b2){
            new Login().setVisible(true);
            setVisible(false);
        }}
   
    public static void main(String[] arg){
        new Login();
    }
}

   
