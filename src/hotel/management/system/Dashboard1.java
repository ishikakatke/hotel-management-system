/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.management.system;

/**
 *
 * @author ISHIKA
 */
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;



public class Dashboard1 extends JFrame implements ActionListener{
    JMenuBar mb;
    JMenu m2,m3,m4,m5;
    JMenuItem i2,i3,i4,i5,i6,i7;
    Dashboard1(){
        super("Dashboard1");
        setLayout(null);
        
        mb=new JMenuBar();
        add(mb);
        
        m2=new JMenu("ADMIN");
        m2.setForeground(Color.BLUE);
        mb.add(m2);
        
        m3=new JMenu("PAYMENT");
        m3.setForeground(Color.RED);
        mb.add(m3);
        
        m4=new JMenu("DELETE  EMPLOYEE");
        m4.setForeground(Color.BLUE);
        mb.add(m4);
        
        m5=new JMenu("DEPARTMENT");
        m5.setForeground(Color.RED);
        mb.add(m5);
                
        
        
        i2=new JMenuItem("ADD EMPLOYEE");
        i2.addActionListener(this);
        m2.add(i2);
        
        i3=new JMenuItem("ADD ROOMS");
        i3.addActionListener(this);
        m2.add(i3);
        
        i4=new JMenuItem("ADD DRIVERS");
        i4.addActionListener(this);
        m2.add(i4);
        
        i5=new JMenuItem("VIEW");
        i5.addActionListener(this);
        m3.add(i5);
        
        i6=new JMenuItem("DETAILS");
        i6.addActionListener(this);
        m4.add(i6);
        
        i7=new JMenuItem("CHECK");
        i7.addActionListener(this);
        m5.add(i7);
        
       mb.setBounds(0,0,1950,30);
       
       ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("Hotel/Management/System/icons/hotel23.jpg"));
       Image i2=i1.getImage().getScaledInstance(1950,1000,Image.SCALE_DEFAULT);
       ImageIcon i3=new ImageIcon(i2);
       JLabel l1=new JLabel(i3);
       l1.setBounds(0,0,1950,1000);      
       add(l1);
       
       JLabel l2=new JLabel("WELCOME!!! ");
       l2.setBounds(730,60,1000,50);
       l2.setForeground(Color.red);
       l2.setFont(new Font("Algerian",Font.BOLD,46));
       l1.add(l2);
       
       setLayout(null);
       setBounds(0,0,1950,1020);
       setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getActionCommand().equals("VIEW")){
            try {    
                new Payment().setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(Dashboard1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else  if(ae.getActionCommand().equals("DETAILS")){
            try {
                new DeleteEmployee().setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(Dashboard1.class.getName()).log(Level.SEVERE, null, ex);
            }
            }else  if(ae.getActionCommand().equals("CHECK")){
            try {
                new Department().setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(Dashboard1.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else  if(ae.getActionCommand().equals("ADD EMPLOYEE")){
            new AddEmployee().setVisible(true);
        }else if(ae.getActionCommand().equals("ADD ROOMS")){
            new AddRooms().setVisible(true);
        }else if(ae.getActionCommand().equals("ADD DRIVERS")){
            new AddDrivers().setVisible(true);
    }
    }
    public static void main(String[]args){
        new Dashboard1().setVisible(true);
       
    }
}

    
