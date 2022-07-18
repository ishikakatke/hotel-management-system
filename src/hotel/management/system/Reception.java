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
import javax.swing.*;

import java.sql.*;	
import java.awt.event.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;

public class  Reception extends JFrame implements ActionListener{
    JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12;
    Reception(){
        super("Reception");
        setLayout(null);
        
        b1=new JButton("New Customer Form");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(10,30,200,40);
        b1.setFont(new Font("Serif",Font.BOLD,18));
        b1.addActionListener(this);
        add(b1);
        
        b2=new JButton("Room");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(10,80,200,40);
        b2.setFont(new Font("Serif",Font.BOLD,20));
        b2.addActionListener(this);
        add(b2);
        
        b3=new JButton("Search Room");
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        b3.setBounds(10,130,200,40);
        b3.setFont(new Font("serif",Font.BOLD,20));
        b3.addActionListener(this);
        add(b3);
        
        b4=new JButton("All Employee Info");
        b4.setBackground(Color.BLACK);
        b4.setForeground(Color.WHITE);
        b4.setBounds(10,180,200,40);
        b4.setFont(new Font("serif",Font.BOLD,18));
        b4.addActionListener(this); 
        add(b4);
        
        b5=new JButton("Customer Info");
        b5.setBackground(Color.BLACK);
        b5.setForeground(Color.WHITE);
        b5.setBounds(10,230,200,40);
        b5.setFont(new Font("serif",Font.BOLD,20));
        b5.addActionListener(this);
        add(b5);
        
        b6=new JButton("Manager Info");
        b6.setBackground(Color.BLACK);
        b6.setForeground(Color.WHITE);
        b6.setBounds(10,280,200,40);
        b6.setFont(new Font("serif",Font.BOLD,20));
        b6.addActionListener(this);
        add(b6);
        
        b7=new JButton("Check Out");
        b7.setBackground(Color.BLACK);
        b7.setForeground(Color.WHITE);
        b7.setBounds(10,330,200,40);
        b7.setFont(new Font("serif",Font.BOLD,20));
        b7.addActionListener(this);
        add(b7);
        
        b8=new JButton("Update Check Status");
        b8.setBackground(Color.BLACK);
        b8.setForeground(Color.WHITE);
        b8.setBounds(10,380,200,40);
        b8.setFont(new Font("serif",Font.BOLD,18));
        b8.addActionListener(this);
        add(b8);
        
        b9=new JButton("Update Room Status");
        b9.setBackground(Color.BLACK);
        b9.setForeground(Color.WHITE);
        b9.setBounds(10,430,200,40);
        b9.setFont(new Font("serif",Font.BOLD,18));
        b9.addActionListener(this);
        add(b9);
        
        b10=new JButton("Pick Up Service");
        b10.setBackground(Color.BLACK);
        b10.setForeground(Color.WHITE);
        b10.setBounds(10,480,200,40);
        b10.setFont(new Font("serif",Font.BOLD,18));
        b10.addActionListener(this);
        add(b10);
        
        b11=new JButton("Payment");
        b11.setBackground(Color.BLACK);
        b11.setForeground(Color.WHITE);
        b11.setBounds(10,530,200,40);
        b11.setFont(new Font("serif",Font.BOLD,20));
        b11.addActionListener(this);
        add(b11);
        
        b12=new JButton("Log Out");
        b12.setBackground(Color.BLACK);
        b12.setForeground(Color.WHITE);
        b12.setBounds(10,580,200,40);
        b12.setFont(new Font("serif",Font.BOLD,20));
        b12.addActionListener(this);
        add(b12);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("Hotel/Management/System/icons/Reception.jpg"));
        JLabel l1=new JLabel(i1);
        l1.setBounds(250,30,700,600);
        add(l1);
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setBounds(500,200,1000,700);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
       if(ae.getActionCommand().equals("New Customer Form")){
            try {  
                new NewCustomer().setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(Reception.class.getName()).log(Level.SEVERE, null, ex);
            }
       }else if(ae.getActionCommand().equals("Room")){
            try {  
                new Room().setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(Reception.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else if(ae.getActionCommand().equals("Payment")){
            try {  
                new AddPayment().setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(Reception.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else if (ae.getActionCommand().equals("All Employee Info")){
             try{
                 new EmployeeInfo().setVisible(true);
             }catch (SQLException ex) {
                Logger.getLogger(Reception.class.getName()).log(Level.SEVERE, null, ex);
             }
        }else if(ae.getActionCommand().equals("Customer Info")){
            try {  
                new CustomerInfo().setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(Reception.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else if(ae.getActionCommand().equals("Manager Info")){
            try {  
                new ManagerInfo().setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(Reception.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else if(ae.getActionCommand().equals("Check Out")){
            try {  
                new CheckOut().setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(Reception.class.getName()).log(Level.SEVERE, null, ex);
            }
    }else if(ae.getActionCommand().equals("Update Check Status")){
            try {  
                new UpdateCheck().setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(Reception.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else if(ae.getActionCommand().equals("Update Room Status")){
            try {  
                new UpdateRoom().setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(Reception.class.getName()).log(Level.SEVERE, null, ex);
            }
            }else if(ae.getActionCommand().equals("Search Room")){
            try {  
                new SearchRoom().setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(Reception.class.getName()).log(Level.SEVERE, null, ex);
                    }
            
             }else if(ae.getActionCommand().equals("Pick Up Service")){
            try {  
                new PickupServices().setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(Reception.class.getName()).log(Level.SEVERE, null, ex);
            }
            }else if(ae.getActionCommand().equals("Log Out")){
                    new Login().setVisible(true);
             
                    }
    } }

