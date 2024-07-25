import java.awt.EventQueue;

import java.text.SimpleDateFormat;  
import java.util.Date;  

import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class blood_storage {

	JFrame bsFrame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_7;
	private JTextField textField_6;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					blood_storage window = new blood_storage();
					window.bsFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public blood_storage() {
		initialize();
		Connect();
	}
	Connection con;
	PreparedStatement pst;
	ResultSet rs;
	 
	public void Connect()
	    {
	        try {
	            Class.forName("com.mysql.jdbc.Driver");
	            con = DriverManager.getConnection("jdbc:mysql://localhost/dbs proj", "root","");
	        }
	        catch (ClassNotFoundException ex)
	        {
	          ex.printStackTrace();
	        }
	        catch (SQLException ex)
	        {
	            ex.printStackTrace();
	        }
	 
	    }

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		bsFrame = new JFrame();
		bsFrame.setBounds(100, 100, 1138, 577);
		bsFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		bsFrame.getContentPane().setLayout(null);
		
		JLabel lblBloodStorage = new JLabel("Blood Storage");
		lblBloodStorage.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblBloodStorage.setBounds(409, 10, 180, 31);
		bsFrame.getContentPane().add(lblBloodStorage);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Storing", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 40, 500, 310);
		bsFrame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblStorageId = new JLabel("Donor Id :");
		lblStorageId.setBounds(10, 24, 158, 22);
		lblStorageId.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel.add(lblStorageId);
		
		JLabel lblDonarId = new JLabel("Storage Id :");
		lblDonarId.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblDonarId.setBounds(10, 67, 158, 22);
		panel.add(lblDonarId);
		
		JLabel lblBranchName = new JLabel("Branch Name :");
		lblBranchName.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblBranchName.setBounds(10, 113, 158, 22);
		panel.add(lblBranchName);
		
		JLabel lblPincode = new JLabel("Pincode :");
		lblPincode.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblPincode.setBounds(10, 157, 158, 22);
		panel.add(lblPincode);
		
		JLabel lblDonationDate = new JLabel("Quantity:");
		lblDonationDate.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblDonationDate.setBounds(10, 203, 158, 22);
		panel.add(lblDonationDate);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(208, 24, 269, 22);
		panel.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(208, 67, 269, 22);
		panel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(208, 113, 269, 22);
		panel.add(textField_2);
		
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(208, 157, 269, 22);
		panel.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(208, 203, 269, 22);
		panel.add(textField_4);
		
		JTextArea rta = new JTextArea();
		rta.setBounds(520, 51, 594, 294);
		bsFrame.getContentPane().add(rta);
		
		JButton addbtn = new JButton("ADD");
		addbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s1,s2,s3,s4,s5;
				s1=textField.getText();
				s2=textField_1.getText();
				s3=textField_2.getText();
				s4=textField_3.getText();
				s5=textField_4.getText();
				
				
				try {
					pst = con.prepareStatement("insert into blood_storage(donor_id,storage_id,branch_name,pincode,quantity,donation_Date,expiry_date) values(?,?,?,?,?,'04-05-2023','04-11-2023')");
					pst.setString(1, s1);
					pst.setString(2, s2);
					pst.setString(3, s3);
					pst.setString(4, s4);
					pst.setInt(5,Integer.parseInt(s5));
					
				
					pst.executeUpdate();
					
					textField.setText("");
					textField_1.setText("");
					textField_2.setText("");
					textField_3.setText("");
					textField_4.setText("");
				
					rta.setText("Succesful!");
					
					   }
					 
					catch (SQLException e1)
					        {
						rta.setText("Unsuccesful!");
					e1.printStackTrace();
					}
			}
		});
		addbtn.setFont(new Font("Tahoma", Font.BOLD, 15));
		addbtn.setBounds(24, 252, 85, 38);
		panel.add(addbtn);
		
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String s1,s2,s3,s4,s5;
				s1=textField.getText();
				s2=textField_1.getText();
				s3=textField_2.getText();
				s4=textField_3.getText();
				s5=textField_4.getText();
				
			
				try {
					pst = con.prepareStatement("update blood_storage set donor_id =?,storage_id=?,branch_name=?,pincode=?,quantity=? where donor_id=?");
					pst.setString(1, s1);
					pst.setString(2, s2);
					pst.setString(3, s3);
					pst.setString(4, s4);
					pst.setString(5, s5);
					pst.setString(6, s1);
					
					pst.executeUpdate();
					
					textField.setText("");
					textField_1.setText("");
					textField_2.setText("");
					textField_3.setText("");
					textField_4.setText("");
					
					rta.setText("Succesful!");
					
					   }
					 
					catch (SQLException e1)
					        {
						rta.setText("Unsuccesful!");
					e1.printStackTrace();
					}
				
			}
		});
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnUpdate.setBounds(191, 252, 101, 38);
		panel.add(btnUpdate);
		
		JButton btnDelete = new JButton("CLEAR");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
				textField_4.setText("");
			}
		});
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnDelete.setBounds(355, 252, 101, 38);
		panel.add(btnDelete);
		
		
		
		JPanel search = new JPanel();
		search.setLayout(null);
		search.setBorder(new TitledBorder(null, "Search", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		search.setBounds(20, 446, 422, 91);
		bsFrame.getContentPane().add(search);
		
		JLabel lblAppointmentId_1 = new JLabel("Donor Id :");
		lblAppointmentId_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblAppointmentId_1.setBounds(10, 42, 158, 22);
		search.add(lblAppointmentId_1);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(189, 42, 223, 29);
		search.add(textField_7);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Blood group search", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(20, 367, 422, 69);
		bsFrame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblAppointmentId_1_1 = new JLabel("Blood group :");
		lblAppointmentId_1_1.setBounds(10, 28, 125, 22);
		lblAppointmentId_1_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel_1.add(lblAppointmentId_1_1);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(189, 21, 223, 29);
		panel_1.add(textField_6);
		
		JButton btnCheck = new JButton("CHECK");
		btnCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try
			     {
					String id = textField_7.getText();
					String query = "select s.storage_id,d.donor_name,s.branch_name,s.donation_date from donor d join blood_storage s on d.donor_id=s.donor_id where s.donor_id = ?";
					pst=con.prepareStatement(query);
					pst.setString(1, id);
					rs=pst.executeQuery();
					int f=0;
			    while(rs.next())
			    {
			    	
			    	String sid=rs.getString("storage_id");
			    	String name=rs.getString("donor_name");
			    	String bname=rs.getString("branch_name");
			    	String dt=rs.getString("donation_date");
			    	String old=rta.getText();
			    	rta.setText(old+sid+'\n'+name+'\n'+bname+'\n'+dt+'\n'+'\n'+'\n');
			    	f=1;
			    }
			    if (f==0)
			    	rta.setText("No such record exists!");
			
			}
				catch (SQLException ex)
			     {
			    	 rta.setText("No such record exists!");
			     ex.printStackTrace();
			  }
				
			}
		});
		btnCheck.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnCheck.setBounds(477, 479, 112, 38);
		bsFrame.getContentPane().add(btnCheck);
		
		JButton btnCheck_1 = new JButton("CHECK");
		btnCheck_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try
			     {
					String id = textField_6.getText();
					String query = "select s.branch_name,sum(s.quantity) as total from blood_storage s join donor d on s.donor_id=d.donor_id where d.b_group=? group by s.branch_name";
					pst=con.prepareStatement(query);
					pst.setString(1, id);
					rs=pst.executeQuery();
					int f=0;
			    while(rs.next())
			    {
	
			    	String bname=rs.getString("branch_name");
			    	int dt=rs.getInt("total");
			    	String old=rta.getText();
			    	rta.setText(old+bname+"->"+dt+'\n'+'\n'+'\n');
			    	f=1;
			    }
			    if (f==0)
			    	rta.setText("!");
				
			}
				catch (SQLException ex)
			     {
			    	 rta.setText("No such record exists!");
			     ex.printStackTrace();
			  }
			}
		});
		btnCheck_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnCheck_1.setBounds(477, 389, 112, 38);
		bsFrame.getContentPane().add(btnCheck_1);
	}
}
