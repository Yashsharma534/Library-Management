import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class AddStudent extends JFrame {

	private JPanel contentPane;
	private JTextField txt2;
	private JTextField txt3;
	private JTextField txt4;
	private JTextField txt5;
	private JTextField txt6;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddStudent frame = new AddStudent();
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
	public AddStudent() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 997, 707);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Add Student");
		lblNewLabel.setBounds(385, 37, 116, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("Name");
		lblNewLabel_2.setBounds(132, 182, 110, 16);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Father's Name");
		lblNewLabel_3.setBounds(132, 239, 110, 16);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_5 = new JLabel("Branch");
		lblNewLabel_5.setBounds(132, 293, 110, 16);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Year");
		lblNewLabel_6.setBounds(132, 345, 110, 16);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Semester");
		lblNewLabel_7.setBounds(132, 399, 110, 16);
		contentPane.add(lblNewLabel_7);
		
		txt2 = new JTextField();
		txt2.setColumns(10);
		txt2.setBounds(570, 179, 116, 22);
		contentPane.add(txt2);
		
		txt3 = new JTextField();
		txt3.setColumns(10);
		txt3.setBounds(570, 236, 116, 22);
		contentPane.add(txt3);
		
		txt4 = new JTextField();
		txt4.setColumns(10);
		txt4.setBounds(570, 290, 116, 22);
		contentPane.add(txt4);
		
		txt5 = new JTextField();
		txt5.setColumns(10);
		txt5.setBounds(570, 342, 116, 22);
		contentPane.add(txt5);
		
		txt6 = new JTextField();
		txt6.setColumns(10);
		txt6.setBounds(570, 396, 116, 22);
		contentPane.add(txt6);
		
		JButton btnNewButton = new JButton("ADD");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Connection c=DBInfo.getConn();
				String name,fathername,branch,year,semester;
				
				name=txt2.getText();
				fathername=txt3.getText();
				branch=txt4.getText();
				year=txt5.getText();
				semester=txt6.getText();
				try {
					PreparedStatement pst=c.prepareStatement("insert into addstudent(sname,fathername,branch,year,semester)values(?,?,?,?,?)");
					
					pst.setString(1, name);
					pst.setString(2, fathername);
					pst.setString(3, branch);
					pst.setString(4, year);
					pst.setString(5, semester);
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Successfully Student Added!!!");
					
					txt2.setText("");
					txt3.setText("");
					txt4.setText("");
					txt5.setText("");
					txt6.setText("");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		btnNewButton.setBounds(216, 499, 135, 52);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Operation().setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(452, 499, 129, 52);
		contentPane.add(btnNewButton_1);
	}
}
