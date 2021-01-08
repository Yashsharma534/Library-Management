import java.awt.BorderLayout;
import java.sql.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class SignUp extends JFrame {

	private JPanel contentPane;
	private JTextField txt1;
	private JTextField txt2;
	private JPasswordField pwd;
	private JTextField txt3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUp frame = new SignUp();
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
	public SignUp() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1123, 757);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CREATE ACCOUNT");
		lblNewLabel.setBounds(437, 48, 187, 42);
		contentPane.add(lblNewLabel);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(156, 166, 89, 16);
		contentPane.add(lblUsername);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(156, 246, 89, 16);
		contentPane.add(lblName);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(156, 324, 89, 16);
		contentPane.add(lblPassword);
		
		JLabel lblSecurityQuestion = new JLabel("Security Question");
		lblSecurityQuestion.setBounds(156, 401, 127, 16);
		contentPane.add(lblSecurityQuestion);
		
		JLabel lblAnswer = new JLabel("Answer");
		lblAnswer.setBounds(156, 474, 89, 16);
		contentPane.add(lblAnswer);
		
		txt1 = new JTextField();
		txt1.setBounds(644, 163, 116, 22);
		txt1.setColumns(10);
		contentPane.add(txt1);
		
		txt2 = new JTextField();
		txt2.setBounds(644, 243, 116, 22);
		txt2.setColumns(10);
		contentPane.add(txt2);
		
		pwd = new JPasswordField();
		pwd.setBounds(644, 321, 116, 22);
		contentPane.add(pwd);
		
		JComboBox cb = new JComboBox();
		cb.setBounds(644, 398, 116, 22);
		cb.setModel(new DefaultComboBoxModel(new String[] {"Nickname", "Hobbies", "Place"}));
		cb.setSelectedIndex(0);
		contentPane.add(cb);
		
		txt3 = new JTextField();
		txt3.setBounds(644, 471, 116, 22);
		txt3.setColumns(10);
		contentPane.add(txt3);
		
		JButton btnNewButton = new JButton("Create");
		btnNewButton.setBounds(273, 581, 97, 25);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection c=DBInfo.getConn();
				String lusername,lname,lpassword,lsecurity,lanswer;
				 
				lusername=txt1.getText();
				lname=txt2.getText();
				lpassword=pwd.getText();
				lsecurity=cb.getSelectedItem().toString();
				lanswer=txt3.getText();
				try {
				PreparedStatement pst=c.prepareStatement("insert into login(username,name,password,securityQuestion,answer)values(?,?,?,?,?)");
				pst.setString(1, lusername);
				pst.setString(2, lname);
				pst.setString(3, lpassword);
				pst.setString(4, lsecurity);
				pst.setString(5, lanswer);
				pst.executeUpdate();
				JOptionPane.showMessageDialog(null, "Successfully Sign Up");
				txt1.setText("");
				txt2.setText("");
				pwd.setText("");
				
				txt3.setText("");
				}
				catch(SQLException e1)
				{
					e1.printStackTrace();
				}
			
			}
		});
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new Login().setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(480, 581, 97, 25);
		contentPane.add(btnNewButton_1);
	}
}
