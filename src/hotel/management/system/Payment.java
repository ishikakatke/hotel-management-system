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

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JTable;
import java.sql.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Payment extends JFrame {

    Connection conn = null;
    private JPanel contentPane;
    private JTable table;
    private JLabel lblRoomType;
    private JLabel lblAvailability;
    private JLabel lblCleanStatus;
    private JLabel lblNewLabel;
    private JLabel lblNewLabel_1;
    private JLabel lblRoomNumber;
    private JLabel lblId;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {

                try {
                    Payment frame = new Payment();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Payment() throws SQLException {
        //conn = Javaconnect.getDBConnection();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(450, 200, 1200, 600);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/Payment.JPG"));
        Image i3 = i1.getImage().getScaledInstance(600, 600, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel l1 = new JLabel(i2);
        l1.setBounds(650, 0, 600, 600);
        add(l1);

        table = new JTable();
        table.setBounds(0, 40, 650, 400);
        contentPane.add(table);

        JButton btnLoadData = new JButton("Load Data");
        btnLoadData.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    conn c = new conn();
                    String displayCustomersql = "select * from Payment";
                    //PreparedStatement pst = conn.prepareStatement(displayCustomersql);
                    ResultSet rs = c.s.executeQuery(displayCustomersql);
                    table.setModel(DbUtils.resultSetToTableModel(rs));

                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });
        btnLoadData.setBounds(100, 470, 120, 30);
        btnLoadData.setBackground(Color.BLACK);
        btnLoadData.setForeground(Color.WHITE);
        contentPane.add(btnLoadData);

        JButton btnNewButton = new JButton("Back");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Dashboard1().setVisible(false);
                setVisible(false);
            }
        });
        btnNewButton.setBounds(290, 470, 120, 30);
        btnNewButton.setBackground(Color.BLACK);
        btnNewButton.setForeground(Color.WHITE);
        contentPane.add(btnNewButton);

        lblRoomType = new JLabel("Customer Name");
        lblRoomType.setBounds(110, 15, 105, 14);
        lblRoomType.setFont(new Font("serif", Font.BOLD, 12));
        contentPane.add(lblRoomType);

        lblAvailability = new JLabel("Date of Payment");
        lblAvailability.setBounds(215, 15, 105, 14);
        lblAvailability.setFont(new Font("serif", Font.BOLD, 12));
        contentPane.add(lblAvailability);

        lblCleanStatus = new JLabel("Contact");
        lblCleanStatus.setBounds(324, 15, 76, 14);
        lblCleanStatus.setFont(new Font("serif", Font.BOLD, 12));
        contentPane.add(lblCleanStatus);

        lblNewLabel = new JLabel("Total Bill");
        lblNewLabel.setBounds(432, 15,105, 14);
      lblNewLabel.setFont(new Font("serif", Font.BOLD, 12));   
        contentPane.add(lblNewLabel);

        lblNewLabel_1 = new JLabel("Mode Of Payment");
        lblNewLabel_1.setBounds(545, 15,105, 14);
     lblNewLabel_1.setFont(new Font("serif", Font.BOLD, 12)); 
        contentPane.add(lblNewLabel_1);

        lblId = new JLabel("Room Number");
        lblId.setBounds(2, 15, 100, 14);
        lblId.setFont(new Font("serif", Font.BOLD, 12));
        contentPane.add(lblId);

        getContentPane().setBackground(Color.WHITE);
    }

}
