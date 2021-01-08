import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class IssueBook extends JFrame {

	private JPanel contentPane;
	private JTextField txt1;
	private JTextField txt2;
	private JTextField txt3;
	private JTextField txt4;
	private JTextField txt5;
	private JTextField txt6;
	private JTextField txt7;
	private JTextField txts1;
	private JTextField txts2;
	private JTextField txts3;
	private JTextField txts4;
	private JTextField txts5;
	private JTextField txts6;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IssueBook frame = new IssueBook();
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
	public IssueBook() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1064, 722);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Issue Book");
		lblNewLabel.setBounds(451, 31, 126, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Book Id");
		lblNewLabel_1.setBounds(107, 97, 94, 16);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Name");
		lblNewLabel_1_1.setBounds(107, 147, 94, 16);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("ISBN");
		lblNewLabel_1_2.setBounds(107, 195, 94, 16);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Publisher");
		lblNewLabel_1_3.setBounds(107, 246, 94, 16);
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Edition");
		lblNewLabel_1_4.setBounds(107, 295, 94, 16);
		contentPane.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_5 = new JLabel("Price");
		lblNewLabel_1_5.setBounds(107, 346, 94, 16);
		contentPane.add(lblNewLabel_1_5);
		
		JLabel lblNewLabel_1_6 = new JLabel("Pages");
		lblNewLabel_1_6.setBounds(107, 400, 94, 16);
		contentPane.add(lblNewLabel_1_6);
		
		txt1 = new JTextField();
		txt1.setBounds(256, 94, 116, 22);
		contentPane.add(txt1);
		txt1.setColumns(10);
		
		txt2 = new JTextField();
		txt2.setColumns(10);
		txt2.setBounds(256, 144, 116, 22);
		contentPane.add(txt2);
		
		txt3 = new JTextField();
		txt3.setColumns(10);
		txt3.setBounds(256, 192, 116, 22);
		contentPane.add(txt3);
		
		txt4 = new JTextField();
		txt4.setColumns(10);
		txt4.setBounds(256, 243, 116, 22);
		contentPane.add(txt4);
		
		txt5 = new JTextField();
		txt5.setColumns(10);
		txt5.setBounds(256, 292, 116, 22);
		contentPane.add(txt5);
		
		txt6 = new JTextField();
		txt6.setColumns(10);
		txt6.setBounds(256, 343, 116, 22);
		contentPane.add(txt6);
		
		txt7 = new JTextField();
		txt7.setColumns(10);
		txt7.setBounds(256, 397, 116, 22);
		contentPane.add(txt7);
		
		JLabel lblNewLabel_2 = new JLabel("Date Of Issue");
		lblNewLabel_2.setBounds(58, 479, 105, 16);
		contentPane.add(lblNewLabel_2);
		
		JDateChooser issuedate = new JDateChooser();
		issuedate.setBounds(256, 479, 116, 22);
		contentPane.add(issuedate);
		
		JDateChooser txtdate = new JDateChooser();
		txtdate.setBounds(714, 473, 122, 22);
		contentPane.add(txtdate);
		
		JLabel lblNewLabel_3 = new JLabel("Student Id");
		lblNewLabel_3.setBounds(535, 97, 86, 16);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("Name");
		lblNewLabel_3_1.setBounds(535, 147, 86, 16);
		contentPane.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_2 = new JLabel("Father's Name");
		lblNewLabel_3_2.setBounds(535, 195, 86, 16);
		contentPane.add(lblNewLabel_3_2);
		
		JLabel lblNewLabel_3_3 = new JLabel("Branch");
		lblNewLabel_3_3.setBounds(535, 246, 86, 16);
		contentPane.add(lblNewLabel_3_3);
		
		JLabel lblNewLabel_3_4 = new JLabel("Year");
		lblNewLabel_3_4.setBounds(535, 295, 86, 16);
		contentPane.add(lblNewLabel_3_4);
		
		JLabel lblNewLabel_3_5 = new JLabel("Semester");
		lblNewLabel_3_5.setBounds(535, 346, 86, 16);
		contentPane.add(lblNewLabel_3_5);
		
		txts1 = new JTextField();
		txts1.setBounds(720, 94, 116, 22);
		contentPane.add(txts1);
		txts1.setColumns(10);
		
		txts2 = new JTextField();
		txts2.setColumns(10);
		txts2.setBounds(720, 144, 116, 22);
		contentPane.add(txts2);
		
		txts3 = new JTextField();
		txts3.setColumns(10);
		txts3.setBounds(720, 192, 116, 22);
		contentPane.add(txts3);
		
		txts4 = new JTextField();
		txts4.setColumns(10);
		txts4.setBounds(720, 243, 116, 22);
		contentPane.add(txts4);
		
		txts5 = new JTextField();
		txts5.setColumns(10);
		txts5.setBounds(720, 292, 116, 22);
		contentPane.add(txts5);
		
		txts6 = new JTextField();
		txts6.setColumns(10);
		txts6.setBounds(720, 343, 116, 22);
		contentPane.add(txts6);
		
		JButton btnNewButton = new JButton("Issue Book");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String issue,rdate,bookid,studentid,bname,sname;
				Connection c=DBInfo.getConn();
				bookid=txt1.getText();
				studentid=txts1.getText();
				bname=txt2.getText();
				sname=txts2.getText();
				DateFormat df=new SimpleDateFormat("yyyy-MM-dd");
				issue=df.format(issuedate.getDate());
				DateFormat df1=new SimpleDateFormat("yyyy-MM-dd");
				rdate=df1.format(txtdate.getDate());
				try {
					PreparedStatement pst=c.prepareStatement("insert into issuebook(bookid,studentid,bname,sname,dateofissue,dateofreturn)values(?,?,?,?,?,?)");
					pst.setString(1, bookid);
					pst.setString(2, studentid);
					pst.setString(3, bname);
					pst.setString(4, sname);
					pst.setString(5, issue);
					pst.setString(6, rdate);
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Successfully Issue Book");
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		btnNewButton.setBounds(172, 583, 200, 48);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Operation().setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(535, 583, 208, 48);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Search");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Connection c=DBInfo.getConn();
				String bid=txt1.getText();
				
				try {
					PreparedStatement pst=c.prepareStatement("select b.bname,b.isbn,b.publisher,b.edition,b.price,b.pages from addbook b where b.bookid=?");
					pst.setString(1, bid);
					ResultSet rst=pst.executeQuery();
					if(rst.next()==true)
					{
						String name=rst.getString(1);
						String isbn=rst.getString(2);
						String publisher=rst.getString(3);
						String edition=rst.getString(4);
						String price=rst.getString(5);
						String pages=rst.getString(6);
						txt2.setText(name);
						txt3.setText(isbn);
						txt4.setText(publisher);
						txt5.setText(edition);
						txt6.setText(price);
						txt7.setText(pages);
					}
					else
					{
						txt2.setText("");
						txt3.setText("");
						txt4.setText("");
						txt5.setText("");
						txt6.setText("");
						txt7.setText("");
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnNewButton_2.setBounds(414, 93, 97, 25);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Search");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Connection c=DBInfo.getConn();
				String sid=txts1.getText();
				try {
					PreparedStatement pst=c.prepareStatement("select s.sname,s.fathername,s.branch,s.year,s.semester from addstudent s where studentid=?");
					pst.setString(1, sid);
					ResultSet rst=pst.executeQuery();
					if(rst.next()==true)
					{
					String name=rst.getString(1);
					String fathername=rst.getString(2);
					String branch=rst.getString(3);
					String year=rst.getString(4);
					String semester=rst.getString(5);
					txts2.setText(name);
					txts3.setText(fathername);
					txts4.setText(branch);
					txts5.setText(year);
					txts6.setText(semester);
					
						
					}
					else
					{
						txts2.setText("");
						txts3.setText("");
						txts4.setText("");
						txts5.setText("");
						txts6.setText("");
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnNewButton_3.setBounds(903, 93, 97, 25);
		contentPane.add(btnNewButton_3);
		
		JLabel lblNewLabel_4 = new JLabel("Date Of Return");
		lblNewLabel_4.setBounds(507, 479, 114, 16);
		contentPane.add(lblNewLabel_4);
		
	
		
		
	}
}
