import java.awt.EventQueue;


import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;



import javax.swing.border.EtchedBorder;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;

public class donor {

	JFrame donorFrame;
	private JTextField ditfield;
	private JTextField dntfield;
	private JTextField bgtfield;
	private JTextField dstfield;
	private JTextField datfield;
	private JTextField dptfield;
	private JTextField dsearchtfield;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					donor window = new donor();
					window.donorFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public donor() {
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
		donorFrame = new JFrame();
		donorFrame.setBounds(100, 100, 1138, 541);
		donorFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		donorFrame.getContentPane().setLayout(null);
		
		JLabel dn = new JLabel("Donar Name : ");
		dn.setFont(new Font("Tahoma", Font.BOLD, 18));
		dn.setBounds(10, 89, 137, 32);
		donorFrame.getContentPane().add(dn);
		
		JLabel bg = new JLabel("B_Group : ");
		bg.setFont(new Font("Tahoma", Font.BOLD, 18));
		bg.setBounds(10, 131, 116, 32);
		donorFrame.getContentPane().add(bg);
		
		JLabel ds = new JLabel("D_Sex : ");
		ds.setFont(new Font("Tahoma", Font.BOLD, 18));
		ds.setBounds(10, 173, 116, 32);
		donorFrame.getContentPane().add(ds);
		
		JLabel da = new JLabel("D_Age : ");
		da.setFont(new Font("Tahoma", Font.BOLD, 18));
		da.setBounds(10, 215, 116, 32);
		donorFrame.getContentPane().add(da);
		
		JLabel dp = new JLabel("D_Phno : ");
		dp.setFont(new Font("Tahoma", Font.BOLD, 18));
		dp.setBounds(10, 257, 116, 32);
		donorFrame.getContentPane().add(dp);
		
		dntfield = new JTextField();
		dntfield.setColumns(10);
		dntfield.setBounds(157, 89, 223, 29);
		donorFrame.getContentPane().add(dntfield);
		
		bgtfield = new JTextField();
		bgtfield.setColumns(10);
		bgtfield.setBounds(157, 131, 223, 29);
		donorFrame.getContentPane().add(bgtfield);
		
		dstfield = new JTextField();
		dstfield.setColumns(10);
		dstfield.setBounds(157, 173, 223, 29);
		donorFrame.getContentPane().add(dstfield);
		
		datfield = new JTextField();
		datfield.setColumns(10);
		datfield.setBounds(157, 215, 223, 29);
		donorFrame.getContentPane().add(datfield);
		
		dptfield = new JTextField();
		dptfield.setColumns(10);
		dptfield.setBounds(157, 257, 223, 29);
		donorFrame.getContentPane().add(dptfield);
		
		JLabel donor = new JLabel("DONOR");
		donor.setFont(new Font("Tahoma", Font.BOLD, 25));
		donor.setBounds(445, 10, 101, 29);
		donorFrame.getContentPane().add(donor);
		
		JPanel donorregpanel = new JPanel();
		donorregpanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Registration", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		donorregpanel.setBounds(0, 36, 397, 320);
		donorFrame.getContentPane().add(donorregpanel);
		donorregpanel.setLayout(null);
		
		JLabel di = new JLabel("Donar Id : ");
		di.setBounds(10, 18, 134, 22);
		di.setFont(new Font("Tahoma", Font.BOLD, 18));
		donorregpanel.add(di);
		
		ditfield = new JTextField();
		ditfield.setBounds(154, 18, 222, 22);
		donorregpanel.add(ditfield);
		ditfield.setColumns(10);
		
		JButton clearbtn = new JButton("CLEAR");
		clearbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dntfield.setText("");
				bgtfield.setText("");
				dstfield.setText("");
				datfield.setText("");
				dptfield.setText("");
				ditfield.setText("");
			}
		});
		clearbtn.setFont(new Font("Tahoma", Font.BOLD, 15));
		clearbtn.setBounds(269, 282, 95, 28);
		donorregpanel.add(clearbtn);
		
		JTextArea dta = new JTextArea();
		dta.setBounds(426, 49, 581, 304);
		donorFrame.getContentPane().add(dta);
		
		JButton updatebtn = new JButton("UPDATE");
		updatebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s1,s2,s3,s4,s5,s6;
				s1=ditfield.getText();
				s2=dntfield.getText();
				s3=bgtfield.getText();
				s4=dstfield.getText();
				s5=datfield.getText();
				s6=dptfield.getText();
				
				try {
					pst = con.prepareStatement("update donor set donor_name =?,b_group=?,donor_sex=?,donor_age=?,donor_phno=? where donor_id=?");
					pst.setString(1, s2);
					pst.setString(2, s3);
					pst.setString(3, s4);
					pst.setString(4, s5);
					pst.setString(5, s6);
					pst.setString(6, s1);
					
					
					pst.executeUpdate();
					
					ditfield.setText("");
					dntfield.setText("");
					bgtfield.setText("");
					dstfield.setText("");
					datfield.setText("");
					dptfield.setText("");
					dta.setText("Succesful!");
					
					   }
					 
					catch (SQLException e1)
					        {
						dta.setText("Unsuccesful!");
					e1.printStackTrace();
					}
			}
		});
		updatebtn.setBounds(128, 277, 120, 38);
		donorregpanel.add(updatebtn);
		updatebtn.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		
		JButton addbtn = new JButton("ADD");
		addbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s1,s2,s3,s4,s5,s6;
				s1=ditfield.getText();
				s2=dntfield.getText();
				s3=bgtfield.getText();
				s4=dstfield.getText();
				s5=datfield.getText();
				s6=dptfield.getText();
				
				try {
					pst = con.prepareStatement("insert into donor values(?,?,?,?,?,?)");
					pst.setString(1, s1);
					pst.setString(2, s2);
					pst.setString(3, s3);
					pst.setString(4, s4);
					pst.setString(5, s5);
					pst.setString(6, s6);
					
					pst.executeUpdate();
					
					ditfield.setText("");
					dntfield.setText("");
					bgtfield.setText("");
					dstfield.setText("");
					datfield.setText("");
					dptfield.setText("");
					dta.setText("Succesful!");
					
					   }
					 
					catch (SQLException e1)
					        {
						dta.setText("Unsuccesful!");
					e1.printStackTrace();
					}
			}
		});
		addbtn.setBounds(26, 277, 85, 38);
		donorregpanel.add(addbtn);
		addbtn.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JPanel search = new JPanel();
		search.setBorder(new TitledBorder(null, "Search", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		search.setBounds(10, 378, 422, 100);
		donorFrame.getContentPane().add(search);
		search.setLayout(null);
		
		JLabel searchdi = new JLabel("Donar Id : ");
		searchdi.setBounds(10, 42, 99, 22);
		searchdi.setFont(new Font("Tahoma", Font.BOLD, 18));
		search.add(searchdi);
		
		dsearchtfield = new JTextField();
		dsearchtfield.setColumns(10);
		dsearchtfield.setBounds(161, 42, 223, 29);
		search.add(dsearchtfield);
		
		JButton delbtn = new JButton("DELETE");
		delbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				try {
					String id=dsearchtfield.getText();
					pst = con.prepareStatement("delete from donor where donor_id=?");
					pst.setString(1,id);
					
					
					int rdel=pst.executeUpdate();
					
					
		
					if(rdel>0)
					{
						dta.setText("Succesful!");
					}
					else
					{
						dta.setText("No such record exists!");
					}
					
					   }
					 
					catch (SQLException e1)
					        {
						dta.setText("Unsuccesful!");
					e1.printStackTrace();
					}
			
			}
		});
		delbtn.setBounds(601, 422, 163, 38);
		donorFrame.getContentPane().add(delbtn);
		
		delbtn.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JButton btnCheck_1 = new JButton("CHECK");
		btnCheck_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
			     {
				
					String id = dsearchtfield.getText();
					String query = "select * from donor where donor_id = ?";
					pst=con.prepareStatement(query);
					pst.setString(1, id);
					rs=pst.executeQuery();
					int f=0;
			    if(rs.next())
			    {
			    	String name=rs.getString("donor_name");
			    	String bg=rs.getString("B_Group");
			    	String sex=rs.getString("donor_sex");
			    	String ag=rs.getString("donor_age");
			    	String ph=rs.getString("donor_phno");
			    	dta.setText(name+'\n'+bg+'\n'+sex+'\n'+ag+'\n'+ph);
			    	f=1;
			    }
			    if (f==0)
			    	dta.setText("No such record exists!");
			    
			}
				
			
				
			     catch (SQLException ex)
			     {
			    	 dta.setText("No such record exists!");
			     ex.printStackTrace();
			  }
				
			}
		});
		btnCheck_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnCheck_1.setBounds(464, 422, 101, 38);
		donorFrame.getContentPane().add(btnCheck_1);
		
		
		
		
		
	}
}
