/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddEmployee extends JFrame implements ActionListener{
    JTextField t1,t2,t3,t4,t5,t6;
    JRadioButton r1,r2;
    JComboBox c1;
    JButton b1;
    
    AddEmployee(){
        super("Add Employee");
        setLayout(null);
        
        JLabel name=new JLabel("Name");
        name.setFont(new Font("Tahoma",Font.PLAIN,24));
        name.setBounds(60,30,150,30);
        add(name);
        
        t1=new JTextField();
        t1.setBounds(200,30,250,30);
        add(t1);
         
        JLabel age=new JLabel("AGE");
        age.setFont(new Font("Tahoma",Font.PLAIN,24));
        age.setBounds(60,100,120,30);
        add(age);
        
        t2=new JTextField();
        t2.setBounds(200,100,250,30);
        add(t2);
        
        JLabel gender=new JLabel("GENDER");
        gender.setFont(new Font("Tahoma",Font.PLAIN,24));
        gender.setBounds(60,160,120,30);
        add(gender);
        
        r1=new JRadioButton("MALE");
        r1.setFont(new Font("Tahoma",Font.PLAIN,12));
        r1.setBounds(200,160,80,30);
        r1.setBackground(Color.WHITE);
        add(r1);
        
        r2=new JRadioButton("FEMALE");
        r2.setFont(new Font("Tahoma",Font.PLAIN,12));
        r2.setBounds(300,160,80,30);
        r2.setBackground(Color.WHITE);
        add(r2);
        
        JLabel job=new JLabel("JOB");
        job.setFont(new Font("Tahoma",Font.PLAIN,24));
        job.setBounds(60,220,250,30);
        add(job);
        
        String str[]={"Front Desk clerks","Porters","Housekeeping","Kitchen Staff","Room Service","Waiter/waiteress","Manager","Accountant","Chef","Receptionist"};
        c1=new JComboBox(str);
        c1.setBounds(200,220,250,30);
        c1.setBackground(Color.WHITE);
        add(c1);
        
        JLabel salary=new JLabel("SALARY");
        salary.setFont(new Font("Tahoma",Font.PLAIN,24));
        salary.setBounds(60,280,200,30);
        add(salary);
        
        t3=new JTextField();
        t3.setBounds(200,280,250,30);
        add(t3);
        
        JLabel phone=new JLabel("PHONE");
        phone.setFont(new Font("Tahoma",Font.PLAIN,24));
        phone.setBounds(60,340,200,30);
        add(phone);
        
        t4=new JTextField();
        t4.setBounds(200,340,250,30);
        add(t4);
        
        JLabel aadhar=new JLabel("AADHAR");
        aadhar.setFont(new Font("Tahoma",Font.PLAIN,24));
        aadhar.setBounds(60,400,200,30);
        add(aadhar);
        
        t5=new JTextField();
        t5.setBounds(200,400,250,30);
        add(t5);
        
        JLabel email=new JLabel("EMAIL");
        email.setFont(new Font("Tahoma",Font.PLAIN,24));
        email.setBounds(60,460,200,30);
        add(email);
        
        t6=new JTextField();
        t6.setBounds(200,460,250,30);
        add(t6);
        
        b1=new JButton("SUBMIT");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(200,550,250,50);
        b1.addActionListener(this);
        add(b1);
       
        ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/employe1.jpg"));
        JLabel l1=new JLabel(i1);
        l1.setBounds(800,20,850,1000);
        add(l1);
        
        JLabel l2=new JLabel("ADD EMPLOYEE DEATAILS");
        l2.setForeground(Color.BLUE);
        l2.setBounds(1050,30,400,30);
        l2.setFont(new Font("Tahoma",Font.PLAIN,30));
        add(l2);
        
        
        
        setLayout(null);
        setBounds(0,0,1900,1020);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        String name=t1.getText();
        String age=t2.getText();
        String salary=t3.getText();
        String phone=t4.getText();
        String aadhar=t5.getText();
        String email=t6.getText();
        
        String gender=null;
        if(r1.isSelected()){
            gender="Male";
        }else if(r2.isSelected()){
            gender="Female";
        
        }
        String job=(String)c1.getSelectedItem();
        conn c=new conn();
        String str="insert into employee values('"+name+"','"+age+"','"+gender+"','"+job+"','"+salary+"','"+phone+"','"+aadhar+"','"+email+"')";
        try{
            c.s.executeUpdate(str);
            JOptionPane.showMessageDialog(null,"New Employee Added");
            this.setVisible(false);
        }
        catch(Exception e){
            System.out.println(e);
            
        }
    }
    public static void main(String[] args){
        new AddEmployee().setVisible(true);
    }
}
