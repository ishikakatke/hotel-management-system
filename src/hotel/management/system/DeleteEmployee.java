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
import java.sql.*;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DeleteEmployee extends JFrame {
    Connection conn = null;
    PreparedStatement pst = null;
	private JPanel contentPane;
	private JTextField txt_Job;
	private JTextField txt_Salary;
	private JTextField txt_Phone;
        
        Choice c1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteEmployee frame = new DeleteEmployee();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void close(){
		this.dispose();
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public DeleteEmployee() throws SQLException {
		//conn = Javaconnect.getDBConnection();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(530, 200, 1000, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
                
                ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/delete.JPG"));
                Image i3 = i1.getImage().getScaledInstance(550, 250,Image.SCALE_DEFAULT);
                ImageIcon i2 = new ImageIcon(i3);
                JLabel l1 = new JLabel(i2);
                l1.setBounds(400,80,600,250);
                add(l1);
		
		JLabel lblDeleteEmployeeStatus = new JLabel("DELETE EMPLOYEE DETAILS");
		lblDeleteEmployeeStatus.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDeleteEmployeeStatus.setBounds(85, 11, 300, 34);
		contentPane.add(lblDeleteEmployeeStatus);
		
		JLabel lblNewLabel = new JLabel("Name:");
		lblNewLabel.setBounds(27, 87, 90, 14);
		contentPane.add(lblNewLabel);
                
                c1 = new Choice();
                try{
                    conn c = new conn();
                    ResultSet rs = c.s.executeQuery("select * from employee");
                    while(rs.next()){
                        c1.add(rs.getString("name"));    
                    }
                }catch(Exception e){ }
                c1.setBounds(160, 84, 140, 20);
		contentPane.add(c1);
		
		JLabel lblJob = new JLabel("JOB :");
		lblJob.setBounds(27, 187, 90, 14);
		contentPane.add(lblJob);
		
		JLabel lblSalary = new JLabel("SALARY:");
		lblSalary.setBounds(27, 240, 90, 14);
		contentPane.add(lblSalary);
		
                JLabel lblPhone = new JLabel("PHONE :");
		lblPhone.setBounds(27, 133, 100, 14);
		contentPane.add(lblPhone);
		
		txt_Job = new JTextField();
		txt_Job.setBounds(160, 184, 140, 20);
		contentPane.add(txt_Job);
		txt_Job.setColumns(10);
		
		txt_Salary = new JTextField();
		txt_Salary.setBounds(160, 237, 140, 20);
		contentPane.add(txt_Salary);
		txt_Salary.setColumns(10);
                
                txt_Phone = new JTextField();
		txt_Phone.setBounds(160, 130, 140, 20);
		contentPane.add(txt_Phone);
		txt_Phone.setColumns(10);
                
                JButton b1 = new JButton("Check");
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                            try{
                                String s1 = c1.getSelectedItem();
				conn c = new conn();
                                String q1="select * from employee where name = '"+s1+"'";
                                ResultSet rs1=c.s.executeQuery(q1);
                               
                                
                                while(rs1.next()){
                                    txt_Phone.setText(rs1.getString("phone"));   
                                    txt_Job.setText(rs1.getString("Job")); 
                                    txt_Salary.setText(rs1.getString("salary"));
                                }
                            }catch(Exception ee){
                                ee.printStackTrace();
                        
                                }
                          
                        }
		} );
		b1.setBounds(120, 315, 89, 23);
                b1.setBackground(Color.BLACK);
                b1.setForeground(Color.WHITE);
		contentPane.add(b1);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) throws NumberFormatException {
				
				try{
                                    conn c = new conn();
                                    String s2=txt_Job.getText();
                                    String q2 ="delete from employee where job='"+s2+"'";
                                    c.s.executeUpdate(q2);
                                    JOptionPane.showMessageDialog(null, "Delete Sucessful");
                                    
                                    new Dashboard1().setVisible(true);
                                    setVisible(false);
				}catch (Exception ee){
					ee.printStackTrace();
				}
				
			
			}
		});
		btnDelete.setBounds(60, 355, 89, 23);
                btnDelete.setBackground(Color.BLACK);
                btnDelete.setForeground(Color.WHITE);
		contentPane.add(btnDelete);
		
		JButton btnExit = new JButton("Back");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Dashboard1().setVisible(false);
                                setVisible(false);
			}
		});
		btnExit.setBounds(180, 355, 89, 23);
                btnExit.setBackground(Color.BLACK);
                btnExit.setForeground(Color.WHITE);
		contentPane.add(btnExit);
		
		
		
		getContentPane().setBackground(Color.WHITE);
	}

}

  
