package com.sms;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JToggleButton;
import javax.swing.JComboBox;
import java.awt.Color;
import javax.swing.table.DefaultTableModel;
import java.awt.SystemColor;
import javax.swing.UIManager;
import javax.swing.JScrollPane;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.awt.Toolkit;

public class StudentTracker extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTextField tf1;
	private JTextField tf2;
	private JTextField tf3;
	private JTextField tf4;
	private JTextField tf5;
	private JTextField sf;
	private JTable table_1;
	
	JComboBox comboBox;
	
	JRadioButton r1,r2,r3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentTracker frame = new StudentTracker();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public StudentTracker() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Sunil\\Desktop\\Login\\SMS.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1290, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Load");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				showData();
				
			}
		});
		btnNewButton.setBounds(226, 555, 182, 34);
		contentPane.add(btnNewButton);
		
		table = new JTable();
		table.setBounds(576, 122, 671, 446);
		contentPane.add(table);
		
		JLabel l1 = new JLabel("Roll Number");
		l1.setEnabled(false);
		l1.setBackground(Color.BLACK);
		l1.setForeground(Color.BLACK);
		l1.setFont(new Font("Tahoma", Font.BOLD, 14));
		l1.setBounds(51, 112, 151, 34);
		contentPane.add(l1);
		
		tf1 = new JTextField();
		tf1.setBounds(226, 112, 182, 34);
		contentPane.add(tf1);
		tf1.setColumns(10);
		
		tf2 = new JTextField();
		tf2.setColumns(10);
		tf2.setBounds(226, 176, 182, 34);
		contentPane.add(tf2);
		
		JLabel l2 = new JLabel("Full Name");
		l2.setEnabled(false);
		l2.setFont(new Font("Tahoma", Font.BOLD, 14));
		l2.setBounds(51, 176, 151, 34);
		contentPane.add(l2);
		
		tf3 = new JTextField();
		tf3.setColumns(10);
		tf3.setBounds(226, 241, 182, 34);
		contentPane.add(tf3);
		
		JLabel l3 = new JLabel("Marks");
		l3.setFont(new Font("Tahoma", Font.BOLD, 14));
		l3.setEnabled(false);
		l3.setBounds(51, 241, 151, 34);
		contentPane.add(l3);
		
		tf4 = new JTextField();
		tf4.setColumns(10);
		tf4.setBounds(226, 307, 182, 34);
		contentPane.add(tf4);
		
		JLabel l4 = new JLabel("Email Address");
		l4.setFont(new Font("Tahoma", Font.BOLD, 14));
		l4.setEnabled(false);
		l4.setBounds(51, 305, 151, 34);
		contentPane.add(l4);
		
		tf5 = new JTextField();
		tf5.setColumns(10);
		tf5.setBounds(226, 370, 182, 34);
		contentPane.add(tf5);
		
		JLabel l5 = new JLabel("Department");
		l5.setFont(new Font("Tahoma", Font.BOLD, 14));
		l5.setEnabled(false);
		l5.setBounds(51, 370, 151, 34);
		contentPane.add(l5);
		
		JLabel l6 = new JLabel("Gender");
		l6.setFont(new Font("Tahoma", Font.BOLD, 14));
		l6.setEnabled(false);
		l6.setBounds(51, 421, 151, 34);
		contentPane.add(l6);
		
		r1 = new JRadioButton("Male");
		r1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		r1.setBounds(226, 423, 59, 31);
		contentPane.add(r1);
		
		r2 = new JRadioButton("Female");
		r2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		r2.setBounds(282, 421, 74, 34);
		contentPane.add(r2);
		
		r3 = new JRadioButton("Others");
		r3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		r3.setBounds(358, 423, 74, 31);
		contentPane.add(r3);
		
		ButtonGroup bg=new ButtonGroup();
		bg.add(r1);bg.add(r2);bg.add(r3);
		
		JButton btnInsert = new JButton("Insert\r\n");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String rn=tf1.getText();
				String fn=tf2.getText();
				int marks=Integer.parseInt(tf3.getText());
				String ea=tf4.getText();
				String dept=tf5.getText();
				String gender=getGender();
				
				
				
				String q="Insert into student values(?,?,?,?,?,?)";
				
				try {
					PreparedStatement ps=DbConn.getConn().prepareStatement(q);
					ps.setString(1, rn);
					ps.setString(2, fn);
					ps.setInt(3, marks);
					ps.setString(4, ea);
					ps.setString(5, dept);
					ps.setString(6, gender);
					
					ps.execute();
					
					JOptionPane.showMessageDialog(null, "Data Inserted");
					
					showData();
					
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}
			}
		});
		btnInsert.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnInsert.setBounds(20, 555, 182, 34);
		contentPane.add(btnInsert);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.out.println("Deleting Soon");
				
				String q="Delete from student where rollno=?";
				
				try {
					PreparedStatement ps=DbConn.getConn().prepareStatement(q);
					
					ps.setString(1, tf1.getText());
					
					ps.execute();
					
					JOptionPane.showConfirmDialog(null, "Record Deleted");
					
					showData();
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}
			}
		});
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnDelete.setBounds(23, 485, 182, 34);
		contentPane.add(btnDelete);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String rollno=tf1.getText();
				String fn=tf2.getText();
				int marks=Integer.parseInt(tf3.getText());
				String ea=tf4.getText();
				String dept=tf5.getText();
				String gender=getGender();
				
				String q="Update student set fullname=?, marks=?, email=?, department=?, gender=? where rollno=?";
				
				try {
					PreparedStatement ps=DbConn.getConn().prepareStatement(q);
					ps.setString(1, fn);
					ps.setInt(2, marks);
					ps.setString(3, ea);
					ps.setString(4, dept);
					ps.setString(5, gender);
					ps.setString(6, rollno);
					
					ps.execute();
					
					JOptionPane.showMessageDialog(null, "Record Updated");
					
					showData();
					
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}
			}
		});
		btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnUpdate.setBounds(226, 485, 182, 34);
		contentPane.add(btnUpdate);
		
		// JComboBox
		
		comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String rollno=(String) comboBox.getSelectedItem();
				
				String q="Select * from student where rollno=?";
				
				try {
					PreparedStatement ps=DbConn.getConn().prepareStatement(q);
					
					ps.setString(1, rollno);
					
					ResultSet rs=ps.executeQuery();			
					
					
					
					if(rs.next()) {
						tf1.setText(rs.getString(1));
						tf2.setText(rs.getString(2));
						tf3.setText(rs.getString(3));
						tf4.setText(rs.getString(4));
						tf5.setText(rs.getString(5));
						
					}
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}
			}
		});
		comboBox.setBounds(51, 11, 357, 40);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel = new JLabel("Search Here");
		lblNewLabel.setEnabled(false);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(649, 27, 134, 34);
		contentPane.add(lblNewLabel);
		
		sf = new JTextField();
		sf.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				String q="Select * from student where fullname=?";
				
				try {
					PreparedStatement ps=DbConn.getConn().prepareStatement(q);
					
					ps.setString(1, sf.getText());
					ResultSet rs=ps.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
					
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}
			}
		});
		sf.setBounds(796, 29, 257, 34);
		contentPane.add(sf);
		sf.setColumns(10);
		
		JButton btnShutdown = new JButton("Shutdown");
		btnShutdown.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String time=JOptionPane.showInputDialog("Enter Time in Sec");
				System.out.println(time);
				try {
					Runtime.getRuntime().exec("shutdown -s -t "+time);
				} catch (IOException e1) {
					
					e1.printStackTrace();
				}
			}
		});
		btnShutdown.setForeground(new Color(255, 255, 255));
		btnShutdown.setBackground(Color.RED);
		btnShutdown.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnShutdown.setBounds(1005, 602, 182, 34);
		contentPane.add(btnShutdown);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(576, 97, 671, 25);
		contentPane.add(scrollPane);
		
		table_1 = new JTable();
		scrollPane.setViewportView(table_1);
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Roll Number", "Full Name", "Marks", "Email Address", "Department", "Gender"
			}
		));
		
		fillComboBox();
	}// Constructor ends here
	void fillComboBox() {
		
		String q="Select * from student";
	try {
		Statement stmt=DbConn.getConn().createStatement();
		
		ResultSet rs=stmt.executeQuery(q);
		
		while(rs.next()) {
			comboBox.addItem(rs.getString(1));
		}
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
	}
	
	// getGender
	
	String getGender() {
		
		if(r1.isSelected()) return "Male";
		else if(r2.isSelected()) return "Female";
		else return "Others";
	}

	// showData for table
	public void showData() {
		String q="Select * from student";
		
		Connection conn=DbConn.getConn();
		try {
			Statement stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery(q);
			
			table.setModel(DbUtils.resultSetToTableModel(rs));
			
		} catch (SQLException e1) {
			
			e1.printStackTrace();
		}
	}
}// Class ends here
