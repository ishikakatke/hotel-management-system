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
import java.awt.BorderLayout;
import java.awt.*;
import java.awt.EventQueue;

import javax.swing.border.EmptyBorder;

import java.awt.Font;
import java.awt.Image;
import java.sql.*;	
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class AddPayment extends JFrame {
	Connection conn = null;
	PreparedStatement pst = null;
	private JPanel contentPane;
	private JTextField t1,t2,t3,t4,t5,t6;
        JComboBox comboBox;
        /*JRadioButton r1,r2;
        Choice c1;*/
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddPayment frame = new AddPayment();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public AddPayment() throws SQLException {
		
                setBounds(530, 200, 850, 550);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
                
                ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/sixth.jpg"));
                Image i3 = i1.getImage().getScaledInstance(300, 400,Image.SCALE_DEFAULT);
                ImageIcon i2 = new ImageIcon(i3);
                JLabel l1 = new JLabel(i2);
                l1.setBounds(480,10,300,500);
                add(l1);
		
		JLabel lblName = new JLabel("Add Payment Details");
		lblName.setFont(new Font("Yu Mincho", Font.PLAIN, 20));
		lblName.setBounds(118, 11, 260, 53);
		contentPane.add(lblName);
                
               /* JLabel lblId = new JLabel("ID :");
		lblId.setBounds(35, 76, 200, 14);
		contentPane.add(lblId);*/
                
                
                
                JLabel l2 = new JLabel("ROOM NO :");
		l2.setBounds(35, 111, 200, 14);
		contentPane.add(l2);
                
                t1 = new JTextField();
		t1.setBounds(271, 111, 150, 20);
		contentPane.add(t1);
		t1.setColumns(10);
		
		JLabel lblName_1 = new JLabel("CUSTOMER NAME :");
		lblName_1.setBounds(35, 151, 200, 14);
		contentPane.add(lblName_1);
		
		t2 = new JTextField();
		t2.setBounds(271, 151, 150, 20);
		contentPane.add(t2);
		t2.setColumns(10);

                
		/*JLabel lblGender = new JLabel("Gender :");
		lblGender.setBounds(35, 191, 200, 14);
		contentPane.add(lblGender);*/
                
                
		JLabel lblFamilyMembers = new JLabel("DATE OF PAYMENT :");
		lblFamilyMembers.setBounds(35,191,400, 14);
		contentPane.add(lblFamilyMembers);
		
		JLabel lblReserveRoomNumber = new JLabel("CONTACT :");
		lblReserveRoomNumber.setBounds(35, 231, 200, 14);
		contentPane.add(lblReserveRoomNumber);
                
                
		
		JLabel lblCheckInStatus = new JLabel("TOTAL BILL :");
		lblCheckInStatus.setBounds(35,271, 200, 14);
		contentPane.add(lblCheckInStatus);
		
		JLabel lblDeposite = new JLabel("PAYMENT MODE :");
		lblDeposite.setBounds(35, 311, 200, 14);
		contentPane.add(lblDeposite);
		
		
		
		
		
		t3 = new JTextField();
		t3.setBounds(271,191, 150, 20);
		contentPane.add(t3);
		t3.setColumns(10);
                
		t4 = new JTextField();
		t4.setBounds(271, 231, 150, 20);
		contentPane.add(t4);
		t4.setColumns(10);
		
		t5 = new JTextField();
		t5.setBounds(271,271, 150, 20);
		contentPane.add(t5);
		t5.setColumns(10);
		
		comboBox = new JComboBox(new String[] {"Cash", "Google Pay", "Paytm", "Debit Card"});
		comboBox.setBounds(271,311, 150, 20);
		contentPane.add(comboBox); 
                
		JButton btnNewButton = new JButton("Payment");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                            
                          
                            try{
	    			conn c = new conn();
                                
	    			String s2 =  t1.getText();
	    			String s3 =  t2.getText();
                            	String s5 =  t3.getText();
                                String s6 =  t4.getText();
	    			String s7 =  t5.getText();
                                String s8 = (String)comboBox.getSelectedItem(); 
                                
                                String q1 = "insert into Payment values('"+s2+"','"+s3+"','"+s5+"','"+s6+"','"+s7+"','"+s8+"')";
                               
                                c.s.executeUpdate(q1);
                               
	    			
	    			
	    			JOptionPane.showMessageDialog(null, "Payment Done Successfully!!!");
                                new Reception().setVisible(true);
                                setVisible(false);
	    		}catch(SQLException e1){
	    			System.out.println(e1.getMessage());
	    		}
		    	
			}
		});
		btnNewButton.setBounds(100, 430, 120, 30);
                btnNewButton.setBackground(Color.BLACK);
                btnNewButton.setForeground(Color.WHITE);
		contentPane.add(btnNewButton);
		
		JButton btnExit = new JButton("Back");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                            new Reception().setVisible(true);
                            setVisible(false);
			}
		}); 
		btnExit.setBounds(260, 430, 120, 30);
                btnExit.setBackground(Color.BLACK);
                btnExit.setForeground(Color.WHITE);
		contentPane.add(btnExit);
                
                getContentPane().setBackground(Color.WHITE);
	}
}
