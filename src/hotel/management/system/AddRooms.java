/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.management.system;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

public class AddRooms extends JFrame implements ActionListener{

    private JPanel contentPane;
    JTextField t1,t2,t3,t4;
    JComboBox comboBox, comboBox_1, comboBox_2, comboBox_3;
    JButton b1,b2;
    Choice c1;

    public static void main(String[] args) {
        new AddRooms().setVisible(true);
    }


    public AddRooms() {
        super("Add Room");
        setLayout(null);
        
        setBounds(450, 200, 1000, 600);
	contentPane = new JPanel();
	setContentPane(contentPane);
	contentPane.setLayout(null);
        
        ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/bed.jpg"));
                Image i3 = i1.getImage().getScaledInstance(500,300,Image.SCALE_DEFAULT);
                ImageIcon i2 = new ImageIcon(i3);
                JLabel l15 = new JLabel(i2);
                l15.setBounds(400,30,500,400);
                contentPane.add(l15);
        
        JLabel l10 = new JLabel("Add Rooms");
        l10.setFont(new Font("Tahoma", Font.BOLD, 18));
	l10.setBounds(184, 10, 150,30);
	contentPane.add(l10);
        
	
        
	JLabel l1 = new JLabel("Room Number");
	l1.setForeground(new Color(25, 25, 112));
	l1.setFont(new Font("Tahoma", Font.BOLD, 14));
	l1.setBounds(64, 70, 102, 22);
	contentPane.add(l1);
        
        
        t4 = new JTextField();
	t4.setBounds(174, 70, 156, 20);
	contentPane.add(t4);
        
        JLabel l2 = new JLabel("Room Type");
	l2.setForeground(new Color(25, 25, 112));
	l2.setFont(new Font("Tahoma", Font.BOLD, 14));
	l2.setBounds(64, 130, 102, 22);
	contentPane.add(l2);
        
        comboBox = new JComboBox(new String[] { "Ac", "Non-Ac" });
	comboBox.setBounds(176, 130, 154, 20);
	contentPane.add(comboBox);

	JLabel l3 = new JLabel("Availability");
	l3.setForeground(new Color(25, 25, 112));
	l3.setFont(new Font("Tahoma", Font.BOLD, 14));
	l3.setBounds(64, 190, 102, 22);
	contentPane.add(l3);
        
        comboBox_1 = new JComboBox(new String[] { "Available", "Occupied" });
	comboBox_1.setBounds(176, 190, 154, 20);
	contentPane.add(comboBox_1);


	JLabel l4 = new JLabel("Cleaning Status");
	l4.setForeground(new Color(25, 25, 112));
	l4.setFont(new Font("Tahoma", Font.BOLD, 14));
	l4.setBounds(64, 250, 102, 22);
	contentPane.add(l4);
        
        comboBox_2 = new JComboBox(new String[] { "Cleaned", "Dirty" });
	comboBox_2.setBounds(176, 250, 154, 20);
	contentPane.add(comboBox_2);

	JLabel l5 = new JLabel("Price");
	l5.setForeground(new Color(25, 25, 112));
	l5.setFont(new Font("Tahoma", Font.BOLD, 14));
	l5.setBounds(64, 310, 102, 22);
	contentPane.add(l5);
        
        t2 = new JTextField();
	t2.setBounds(174, 310, 156, 20);
	contentPane.add(t2);

        JLabel l6 = new JLabel("Bed Type");
	l6.setForeground(new Color(25, 25, 112));
	l6.setFont(new Font("Tahoma", Font.BOLD, 14));
	l6.setBounds(64, 370, 102, 22);
	contentPane.add(l6);


        comboBox_3 = new JComboBox(new String[] { "Single Bed", "Double Bed"});
	comboBox_3.setBounds(176, 370, 154, 20);
	contentPane.add(comboBox_3);

	

	

	b1 = new JButton("Add");
	b1.addActionListener(this);
	b1.setBounds(64, 450, 111, 33);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
	contentPane.add(b1);

	b2 = new JButton("Back");
	b2.addActionListener(this);
	b2.setBounds(225, 450, 111, 33);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
	contentPane.add(b2);

	
        contentPane.setBackground(Color.WHITE);
    
    }
    
    public void actionPerformed(ActionEvent ae){
        try{
            
            if(ae.getSource() == b1){
                try{
                conn c = new conn();
                String room = t4.getText();
                String type = (String)comboBox.getSelectedItem();
                String available=(String)comboBox_1.getSelectedItem();
                String status = (String)comboBox_2.getSelectedItem();
                String price  = t2.getText();
                String Bedtype = (String)comboBox_3.getSelectedItem();
                String str = "INSERT INTO room values( '"+room+"','"+type+"', '"+available+"', '"+status+"','"+price+"', '"+Bedtype+"')";
              
                
		c.s.executeUpdate(str);
		JOptionPane.showMessageDialog(null, "Room Successfully Added");
                this.setVisible(false);
               
                }catch(Exception ee){
                    System.out.println(ee);
                }
            }
            else if(ae.getSource() == b2){
                this.setVisible(false);
            }
        }catch(Exception eee){
            
        }
    }
}