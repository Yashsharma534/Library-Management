import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class ForgetPwd extends JFrame {

	private JPanel contentPane;
	private JTextField txt1;
	private JTextField textField;
	private JTextField txt2;
	private JTextField txt3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ForgetPwd frame = new ForgetPwd();
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
	public ForgetPwd() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1146, 762);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("FORGET PASSWORD");
		lblNewLabel.setBounds(480, 52, 171, 41);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.setBounds(183, 149, 124, 33);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setBounds(183, 223, 124, 33);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Name");
		lblNewLabel_3.setBounds(183, 299, 124, 50);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Security Question");
		lblNewLabel_4.setBounds(183, 383, 124, 33);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Answer");
		lblNewLabel_5.setBounds(183, 460, 124, 33);
		contentPane.add(lblNewLabel_5);
		
		JComboBox cb = new JComboBox();
		cb.setModel(new DefaultComboBoxModel(new String[] {"Nickname", "Hobbies", "Place"}));
		cb.setSelectedIndex(0);
		cb.setBounds(646, 388, 171, 22);
		contentPane.add(cb);
		
		txt1 = new JTextField();
		txt1.setBounds(646, 465, 171, 22);
		contentPane.add(txt1);
		txt1.setColumns(10);
		
		JButton btnNewButton = new JButton("Click");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection c=DBInfo.getConn();
				String security,answer,username,name,password;
				security=cb.getSelectedItem().toString();
				answer=txt1.getText();
				try {
					PreparedStatement pst=c.prepareStatement("select username,name,password from login where securityQuestion=? and answer=?");
					pst.setString(1,security);
					pst.setString(2,answer);
					ResultSet rst=pst.executeQuery();
					if(rst.next()==true)
					{
						username=rst.getString(1);
						name=rst.getString(2);
						password=rst.getString(3);
						txt1.setText(username);
						txt2.setText(name);
						txt3.setText(password);
					}
					else
					{
						txt1.setText("");
						txt2.setText("");
						txt3.setText("");
					}
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		btnNewButton.setBounds(277, 581, 150, 55);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Login().setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(566, 581, 143, 55);
		contentPane.add(btnNewButton_1);
		
		textField = new JTextField();
		textField.setBounds(646, 154, 171, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		txt2 = new JTextField();
		txt2.setBounds(646, 228, 171, 22);
		contentPane.add(txt2);
		txt2.setColumns(10);
		
		txt3 = new JTextField();
		txt3.setBounds(646, 313, 171, 22);
		contentPane.add(txt3);
		txt3.setColumns(10);
	}
}
