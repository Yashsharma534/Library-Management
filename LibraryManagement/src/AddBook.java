import java.awt.BorderLayout;
import java.sql.*;
import java.util.Random;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddBook extends JFrame {

	private JPanel contentPane;
	private JTextField txt2;
	private JTextField txt3;
	private JTextField txt4;
	private JTextField txt5;
	private JTextField txt6;
	private JTextField txt7;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddBook frame = new AddBook();
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
	public AddBook() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1114, 742);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Add Book");
		lblNewLabel.setBounds(348, 123, 132, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1_1 = new JLabel("Name");
		lblNewLabel_1_1.setBounds(102, 207, 122, 16);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("ISBN");
		lblNewLabel_1_2.setBounds(102, 265, 122, 16);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Publisher");
		lblNewLabel_1_3.setBounds(102, 323, 122, 16);
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Edition");
		lblNewLabel_1_4.setBounds(102, 386, 122, 16);
		contentPane.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_5 = new JLabel("Price");
		lblNewLabel_1_5.setBounds(102, 447, 122, 16);
		contentPane.add(lblNewLabel_1_5);
		
		JLabel lblNewLabel_1_6 = new JLabel("Pages");
		lblNewLabel_1_6.setBounds(102, 504, 122, 16);
		contentPane.add(lblNewLabel_1_6);
		
		JButton btnNewButton = new JButton("ADD");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection c =DBInfo.getConn();
				
				String bookid,name,isbn,publisher,edition,price,pages;
				
				
				name=txt2.getText();
				isbn=txt3.getText();
				publisher=txt4.getText();
				edition=txt5.getText();
				price=txt6.getText();
				pages=txt7.getText();
				try {
					PreparedStatement pst=c.prepareStatement("insert into addbook(bname,isbn,publisher,edition,price,pages)values(?,?,?,?,?,?)");
					
					pst.setString(1,name);
					pst.setString(2, isbn);
					pst.setString(3,publisher);
					pst.setString(4, edition);
					pst.setString(5,price);
					pst.setString(6, pages);
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Successfully Add Book!!!");
					
					txt2.setText("");
					txt3.setText("");
					txt4.setText("");
					txt5.setText("");
					txt6.setText("");
					txt7.setText("");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(227, 582, 97, 25);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Operation().setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(497, 582, 97, 25);
		contentPane.add(btnNewButton_1);
		
		txt2 = new JTextField();
		txt2.setColumns(10);
		txt2.setBounds(674, 204, 116, 22);
		contentPane.add(txt2);
		
		txt3 = new JTextField();
		txt3.setColumns(10);
		txt3.setBounds(674, 262, 116, 22);
		contentPane.add(txt3);
		
		txt4 = new JTextField();
		txt4.setColumns(10);
		txt4.setBounds(674, 320, 116, 22);
		contentPane.add(txt4);
		
		txt5 = new JTextField();
		txt5.setColumns(10);
		txt5.setBounds(674, 370, 116, 22);
		contentPane.add(txt5);
		
		txt6 = new JTextField();
		txt6.setColumns(10);
		txt6.setBounds(674, 444, 116, 22);
		contentPane.add(txt6);
		
		txt7 = new JTextField();
		txt7.setColumns(10);
		txt7.setBounds(674, 501, 116, 22);
		contentPane.add(txt7);
	}
}
