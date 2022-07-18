/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;



public class Dashboard extends JFrame implements ActionListener{
    JMenuBar mb;
    JMenu m1,m2,m3;
    JMenuItem i1,i2,i3,i4,i5;
    Dashboard(){
        super("Dashboard");
        setLayout(null);
        
        mb=new JMenuBar();
        add(mb);
        
        m1=new JMenu("RECEPTION");
        m1.setForeground(Color.RED);
        mb.add(m1);
        
        i1=new JMenuItem("Details");
        i1.addActionListener(this);
        m1.add(i1);
        
       mb.setBounds(0,0,1950,30);     
       ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("Hotel/Management/System/icons/hotel23.jpg"));
       Image i2=i1.getImage().getScaledInstance(1950,1000,Image.SCALE_DEFAULT);
       ImageIcon i3=new ImageIcon(i2);
       JLabel l1=new JLabel(i3);
       l1.setBounds(0,0,1950,1000);      
       add(l1);
       
       JLabel l2=new JLabel("THE  FLORA GRAND HOTEL ");
       l2.setBounds(620,60,1000,50);
       l2.setForeground(Color.red);
       l2.setFont(new Font("Algerian",Font.BOLD,46));
       l1.add(l2);
       
       setLayout(null);
       setBounds(0,0,1950,1020);
       setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getActionCommand().equals("Details")){
            new Reception().setVisible(true);    
        }
    }
    
    public static void main(String[]args){
        new Dashboard().setVisible(true);
    }
}

    