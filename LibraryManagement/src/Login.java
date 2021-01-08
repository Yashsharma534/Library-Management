import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txt;
	private JPasswordField pwd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1106, 747);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("LOGIN PAGE");
		lblNewLabel.setBounds(405, 73, 169, 56);
		contentPane.add(lblNewLabel);
		
		JPanel contentPane_1 = new JPanel();
		contentPane_1.setLayout(null);
		contentPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane_1.setBounds(0, 0, 1088, 700);
		contentPane.add(contentPane_1);
		
		JLabel lblNewLabel_1 = new JLabel("LOGIN PAGE");
		lblNewLabel_1.setBounds(405, 73, 169, 56);
		contentPane_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("UserName");
		lblNewLabel_1_1.setBounds(116, 180, 159, 43);
		contentPane_1.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setBounds(116, 285, 159, 43);
		contentPane_1.add(lblNewLabel_2);
		
		txt = new JTextField();
		txt.setColumns(10);
		txt.setBounds(560, 180, 219, 43);
		contentPane_1.add(txt);
		
		pwd = new JPasswordField();
		pwd.setBounds(560, 273, 219, 43);
		contentPane_1.add(pwd);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String username,password;
				Connection c=DBInfo.getConn();
				username=txt.getText();
				password=pwd.getText();
				try
				{
					PreparedStatement pst=c.prepareStatement("select username,password from login");
					ResultSet rst=pst.executeQuery();
					while(rst.next())
					{
						if(rst.getString(1).equals(username) && rst.getString(2).equals(password))
						{
							JOptionPane.showMessageDialog(null, "Successfully Login!!!");
							new Operation().setVisible(true);
							dispose();
							
						}
						else
						{
							JOptionPane.showMessageDialog(null, "inncorrect email or password");
							
						}
						break;
						
					}
					
					
				}
				
				catch(SQLException e1)
				{
					e1.printStackTrace();
				}
				
				
				
				
				
				
			}
		});
		btnNewButton.setBounds(190, 440, 110, 56);
		contentPane_1.add(btnNewButton);
		
		JButton btnSignUp = new JButton("Sign Up");
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new SignUp().setVisible(true);
				dispose();
			}
		});
		btnSignUp.setBounds(405, 440, 110, 56);
		contentPane_1.add(btnSignUp);
		
		JButton btnForgetPassword = new JButton("Forget Password");
		btnForgetPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ForgetPwd().setVisible(true);
				dispose();
			}
		});
		btnForgetPassword.setBounds(638, 440, 181, 56);
		contentPane_1.add(btnForgetPassword);
	}
}
