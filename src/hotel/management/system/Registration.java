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
import java.sql.*;
import java.awt.event.*;
import javax.swing.border.*;

public class Registration extends JFrame implements ActionListener{

    private JPanel contentPane;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JButton b1, b2,b3;
    


    public static void main(String[] args) {
        new Registration().setVisible(true);
    }

    public Registration() {
        super("Registration");
        setBounds(700, 250,900,706);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(1, 1, 1, 1));
	setContentPane(contentPane);
        contentPane.setBackground(Color.WHITE);
	contentPane.setLayout(null);
 
        
        
	JLabel lblFullName = new JLabel("Username :");
	lblFullName.setForeground(Color.DARK_GRAY);
	lblFullName.setFont(new Font("Tahoma", Font.BOLD, 14));
	lblFullName.setBounds(69, 86, 92, 26);
	contentPane.add(lblFullName);

	JLabel lblUserName = new JLabel("Password :");
	lblUserName.setForeground(Color.DARK_GRAY);
	lblUserName.setFont(new Font("Tahoma", Font.BOLD, 14));
	lblUserName.setBounds(69, 123, 92, 26);
	contentPane.add(lblUserName);

	JLabel lblPassword = new JLabel("User Type :");
	lblPassword.setForeground(Color.DARK_GRAY);
	lblPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
	lblPassword.setBounds(69, 160, 92, 26);
	contentPane.add(lblPassword);

        ImageIcon c1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/Icons/Registration.png"));
        Image i1 = c1.getImage().getScaledInstance(300, 300,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i1);
         
        JLabel l6 = new JLabel(i2);
        l6.setBounds(460, 70, 300, 300);
        add(l6);

        
        b1 = new JButton("Create");
	b1.addActionListener(this);
	b1.setFont(new Font("Tahoma", Font.BOLD, 13));
	b1.setBounds(95, 289, 100, 30);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
	contentPane.add(b1);

	b2 = new JButton("Back");
	b2.addActionListener(this);
	b2.setFont(new Font("Tahoma", Font.BOLD, 13));
	b2.setBounds(300, 289, 100, 30);
	b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
	contentPane.add(b2);
        
        b3 = new JButton("Login");
	b3.addActionListener(this);
	b3.setFont(new Font("Tahoma", Font.BOLD, 13));
	b3.setBounds(205,350, 100, 30);
	b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
	contentPane.add(b3);
        
        textField = new JTextField();
	textField.setBounds(200, 91, 148, 20);
	contentPane.add(textField);
	textField.setColumns(10);

	textField_1 = new JTextField();
	textField_1.setColumns(10);
	textField_1.setBounds(200, 128, 148, 20);
	contentPane.add(textField_1);

        textField_2 = new JTextField();
	textField_2.setColumns(10);
	textField_2.setBounds(200, 165, 148, 20);
	contentPane.add(textField_2);
        
        

	JPanel panel = new JPanel();
	panel.setForeground(new Color(34, 139, 34));
	panel.setBounds(15, 30, 640, 310);
        panel.setBackground(Color.WHITE);
	contentPane.add(panel);
    }
public void actionPerformed(ActionEvent ae){
        try{
            conn con = new conn();
            
            if(ae.getSource() == b1){
                String sql = "insert into login (username,password,usertype) values(?,?,?)";
		PreparedStatement st = con.c.prepareStatement(sql);

		st.setString(1, textField.getText());
                st.setString(2, textField_1.getText());
		st.setString(3, textField_2.getText());
		
		

		int i = st.executeUpdate();
		if (i > 0){
                    JOptionPane.showMessageDialog(null,"Account Created Successfully ");
                }

                textField.setText("");
                textField_1.setText("");
		textField_2.setText("");
            }
                else if (ae.getSource() == b3){
                this.setVisible(false);
                new Login().setVisible(true);
			
            }else if(ae.getSource()==b2){
            System.exit(0);
            }
        }catch(Exception e){
                System.out.println(e);
        }
    }
}