import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.toedter.calendar.JDateChooser;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;

public class ReturnBook extends JFrame {

	private JPanel contentPane;
	private JTextField txtbid;
	private JTextField txtbname;
	private JTextField txtsid;
	private JTextField txtsname;
	private JTextField txt3;
	private JTextField txt4;
	private JTextField txt1;
	private JTextField txt2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReturnBook frame = new ReturnBook();
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
	public ReturnBook() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1059, 719);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Return Book");
		lblNewLabel.setBounds(410, 51, 98, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Book Id");
		lblNewLabel_1.setBounds(94, 118, 92, 16);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Name");
		lblNewLabel_1_1.setBounds(94, 165, 92, 16);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Student Id");
		lblNewLabel_1_2.setBounds(501, 118, 92, 16);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Name");
		lblNewLabel_1_3.setBounds(501, 165, 92, 16);
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_3 = new JLabel("Date of Issue");
		lblNewLabel_3.setBounds(94, 214, 92, 16);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Date of Return");
		lblNewLabel_4.setBounds(94, 259, 92, 16);
		contentPane.add(lblNewLabel_4);
		
		txtbid = new JTextField();
		txtbid.setBounds(244, 115, 116, 22);
		contentPane.add(txtbid);
		txtbid.setColumns(10);
		
		txtbname = new JTextField();
		txtbname.setColumns(10);
		txtbname.setBounds(244, 162, 116, 22);
		contentPane.add(txtbname);
		
		txtsid = new JTextField();
		txtsid.setColumns(10);
		txtsid.setBounds(670, 115, 116, 22);
		contentPane.add(txtsid);
		
		txtsname = new JTextField();
		txtsname.setColumns(10);
		txtsname.setBounds(670, 162, 116, 22);
		contentPane.add(txtsname);
		
		JButton btnNewButton = new JButton("Return");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Connection c=DBInfo.getConn();
				String bookid=txtbid.getText();
				String studentid=txtsid.getText();
				String bname=txtbname.getText();
				String sname=txtsname.getText();
				String issuedate=txt1.getText();
				String returndate=txt2.getText();
				String elap=txt3.getText();
				String fine=txt4.getText();
				try {
					PreparedStatement pst=c.prepareStatement("insert into returnbook(bookid,studentid,bname,sname,issuedate,returndate,elap,fine)values(?,?,?,?,?,?,?,?)");
					pst.setString(1, bookid);
					pst.setString(2, studentid);
					pst.setString(3, bname);
					pst.setString(4, sname);
					pst.setString(5, issuedate);
					pst.setString(6, returndate);
					pst.setString(7, elap);
					pst.setString(8, fine);
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Successfully Return Book!!!");
					String studentid1=txtsid.getText();
					pst=c.prepareStatement("delete from issuebook where studentid=?");
					pst.setString(1, studentid1);
					pst.executeUpdate();
					txtbid.setText("");
					txtsid.setText("");
					txtbname.setText("");
					txtsname.setText("");
					txt1.setText("");
					txt2.setText("");
					txt3.setText("");
					txt4.setText("");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(177, 497, 97, 25);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Operation().setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(501, 497, 97, 25);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_5 = new JLabel("Days Elap");
		lblNewLabel_5.setBounds(94, 307, 92, 16);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Fine");
		lblNewLabel_6.setBounds(94, 350, 92, 16);
		contentPane.add(lblNewLabel_6);
		
		txt3 = new JTextField();
		txt3.setBounds(244, 304, 116, 22);
		contentPane.add(txt3);
		txt3.setColumns(10);
		
		txt4 = new JTextField();
		txt4.setColumns(10);
		txt4.setBounds(244, 347, 116, 22);
		contentPane.add(txt4);
		
		JButton btnNewButton_2 = new JButton("Search");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String bid;
				bid=txtbid.getText();
			
				Connection c=DBInfo.getConn();
				try {
					PreparedStatement pst=c.prepareStatement("Select studentid,bname,sname,dateofissue,dateofreturn,DATEDIFF(now(),dateofreturn) as elap from issuebook where bookid=?");
					pst.setString(1, bid);
					ResultSet rst=pst.executeQuery();
					if(rst.next()==true)
					{
					String studentid=rst.getString(1);
					String bname=rst.getString(2);
					String sname=rst.getString(3);
					String dateofissue=rst.getString(4);
					String dateofreturn=rst.getString(5);
					String elap=rst.getString(6);
					txtsid.setText(studentid);
					txtbname.setText(bname);
					txtsname.setText(sname);
					txt1.setText(dateofissue);
					txt2.setText(dateofreturn);
					txt3.setText(elap);
					int e=Integer.parseInt(elap);
					if(e >0)
					{
						int fine=e*100;
						txt4.setText(String.valueOf(fine));
					}
					else {
						txt4.setText("0");
					}
					
					}
					else
					{
						txtsid.setText("");
						txtbname.setText("");
						txtsname.setText("");
						txt1.setText("");
						txt2.setText("");
						txt3.setText("");
						txt4.setText("");
						
					}
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		btnNewButton_2.setBounds(860, 114, 97, 25);
		contentPane.add(btnNewButton_2);
		
		txt1 = new JTextField();
		txt1.setBounds(244, 211, 116, 22);
		contentPane.add(txt1);
		txt1.setColumns(10);
		
		txt2 = new JTextField();
		txt2.setBounds(244, 256, 116, 22);
		contentPane.add(txt2);
		txt2.setColumns(10);
	}
}
