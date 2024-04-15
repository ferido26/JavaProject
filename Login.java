package com.sms;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Login {

	private JFrame frmWelcomeToSms;
	private JTextField uf;
	private JPasswordField pf;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frmWelcomeToSms.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmWelcomeToSms = new JFrame();
		frmWelcomeToSms.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Sunil\\Desktop\\Login\\SMS.png"));
		frmWelcomeToSms.setTitle("Welcome to SMS");
		frmWelcomeToSms.setBounds(280, 130, 723, 405);
		frmWelcomeToSms.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmWelcomeToSms.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter Username");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(333, 36, 282, 42);
		frmWelcomeToSms.getContentPane().add(lblNewLabel);
		
		uf = new JTextField();
		uf.setBounds(333, 76, 282, 42);
		frmWelcomeToSms.getContentPane().add(uf);
		uf.setColumns(10);
		
		JLabel lblEnterPassword = new JLabel("Enter Password");
		lblEnterPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEnterPassword.setBounds(333, 146, 282, 42);
		frmWelcomeToSms.getContentPane().add(lblEnterPassword);
		
		pf = new JPasswordField();
		pf.setBounds(333, 185, 287, 42);
		frmWelcomeToSms.getContentPane().add(pf);
		
		JButton btnNewButton = new JButton("Sign In");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String q="Select * from users where username=? and password=?";
				
				try {
					PreparedStatement ps=DbConn.getConn().prepareStatement(q);
					ps.setString(1, uf.getText());
					ps.setString(2, String.valueOf(pf.getPassword()));
					
					ResultSet rs=ps.executeQuery();
					
					if(rs.next()) {
						JOptionPane.showMessageDialog(null, "Welcome to Student Management System");
						
						//StudentTracker frame = new StudentTracker();
						//frame.setVisible(true);
					}
					else {
						JOptionPane.showMessageDialog(null, "Username/Password invalid");
					}
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setBounds(333, 273, 287, 48);
		frmWelcomeToSms.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Sunil\\Desktop\\Login\\login6.jpg"));
		lblNewLabel_1.setBounds(0, 0, 709, 368);
		frmWelcomeToSms.getContentPane().add(lblNewLabel_1);
	}
}
