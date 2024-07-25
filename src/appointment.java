import java.awt.EventQueue;
import java.util.*;
import java.sql.*;
import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import javax.swing.border.EtchedBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.AbstractAction;
import javax.swing.Action;

public class appointment {

    JFrame appointmentFrame;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private final Action action = new SwingAction();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					appointment window = new appointment();
					window.appointmentFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public appointment() {
		initialize();
		Connect();
		
	}
	Connection con;
	PreparedStatement pst;
	ResultSet rs;
	private JTextField textField_4;
	 
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
		appointmentFrame = new JFrame();
		appointmentFrame.setBounds(100, 100, 1145, 611);
		appointmentFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		appointmentFrame.getContentPane().setLayout(null);
		
		JLabel appointment = new JLabel("APPOINTMENT");
		appointment.setFont(new Font("Tahoma", Font.BOLD, 25));
		appointment.setBounds(442, 10, 186, 31);
		
		appointmentFrame.getContentPane().add(appointment);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Registration", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 92, 525, 323);
		appointmentFrame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblAppointmentId = new JLabel("Appointment Id :");
		lblAppointmentId.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblAppointmentId.setBounds(10, 50, 158, 22);
		panel.add(lblAppointmentId);
		
		JLabel lblBranchName = new JLabel("Branch Name :");
		lblBranchName.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblBranchName.setBounds(10, 98, 158, 22);
		panel.add(lblBranchName);
		
		JLabel lblAppDate = new JLabel("App Date :");
		lblAppDate.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblAppDate.setBounds(10, 170, 134, 22);
		panel.add(lblAppDate);
		
		JLabel lblAppSlot = new JLabel("App Slot :");
		lblAppSlot.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblAppSlot.setBounds(10, 210, 134, 22);
		panel.add(lblAppSlot);
		
		JTextArea rta = new JTextArea();
		rta.setBounds(545, 51, 576, 364);
		appointmentFrame.getContentPane().add(rta);
		
		JButton addbtn = new JButton("ADD");
		addbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String s1,s2,s3,s4,s5,s6;
				Date date=null;
				s1=textField_1.getText();
				s2=textField_2.getText();
				s3=textField_3.getText();
				s4=textField_4.getText();
				s5=textField_5.getText();
				s6=textField_6.getText();
				
				try {
					pst = con.prepareStatement("insert into appointment values(?,?,?,?,?,?)");
					pst.setString(1, s2);
					pst.setString(2, s1);
					pst.setString(3, s3);
					pst.setInt(4,Integer.parseInt(s4));
					pst.setString(5,s5);
					
					pst.setInt(6,Integer.parseInt(s6));
					
					pst.executeUpdate();
					
					textField_1.setText("");
					textField_2.setText("");
					textField_3.setText("");
					textField_4.setText("");
					textField_5.setText("");
					textField_6.setText("");
					rta.setText("Successful!");
					
					   }
					 
					catch (SQLException e1)
					        {
						rta.setText("Unsuccesful!");
					e1.printStackTrace();
					}
				
				
			}
		});
		addbtn.setFont(new Font("Tahoma", Font.BOLD, 15));
		addbtn.setBounds(45, 242, 85, 38);
		panel.add(addbtn);
		
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnUpdate.setBounds(203, 242, 102, 38);
		panel.add(btnUpdate);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(223, 54, 269, 22);
		panel.add(textField_1);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(223, 98, 269, 22);
		panel.add(textField_3);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(223, 174, 269, 22);
		panel.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(223, 214, 269, 22);
		panel.add(textField_6);
		
		JButton btnUpdate_1 = new JButton("CLEAR");
		btnUpdate_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_1.setText("");
				textField_2.setText("");
				textField_2.setText("");
				textField_3.setText("");
				textField_5.setText("");
				textField_6.setText("");
				textField_7.setText("");
			}
		});
		btnUpdate_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnUpdate_1.setBounds(361, 242, 102, 38);
		panel.add(btnUpdate_1);
		
		JLabel lblQuantity = new JLabel("Quantity:");
		lblQuantity.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblQuantity.setBounds(10, 130, 134, 22);
		panel.add(lblQuantity);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(223, 130, 269, 22);
		panel.add(textField_4);
		
		
		
		JPanel search = new JPanel();
		search.setLayout(null);
		search.setBorder(new TitledBorder(null, "Search", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		search.setBounds(10, 453, 422, 85);
		appointmentFrame.getContentPane().add(search);
		
		JLabel lblAppointmentId_1 = new JLabel("Appointment Id :");
		lblAppointmentId_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblAppointmentId_1.setBounds(10, 42, 158, 22);
		search.add(lblAppointmentId_1);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(189, 42, 223, 29);
		search.add(textField_7);
		
		JButton delbtn = new JButton("DELETE");
		delbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					String id=textField_7.getText();
					pst = con.prepareStatement("delete from appointment where appointment_id=?");
					pst.setString(1,id);
					
					
					int rdel=pst.executeUpdate();
					
					
		
					if(rdel>0)
					{
						rta.setText("Succesful!");
					}
					else
					{
						rta.setText("No such record exists!");
					}
					
					   }
					 
					catch (SQLException e1)
					        {
						rta.setText("Unsuccesful!");
					e1.printStackTrace();
					}
				
			}
		});
		delbtn.setFont(new Font("Tahoma", Font.BOLD, 15));
		delbtn.setBounds(620, 480, 163, 38);
		appointmentFrame.getContentPane().add(delbtn);
		
		JButton btnCheck_1 = new JButton("CHECK");
		btnCheck_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try
			     {
				
					String id = textField_7.getText();
					String query = "select * from appointment where appointment_id = ?";
					pst=con.prepareStatement(query);
					pst.setString(1, id);
					rs=pst.executeQuery();
					int f=0;
			    if(rs.next())
			    {
			    	String name=rs.getString("receiver_id");
			    	String bg=rs.getString("appointment_id");
			    	String sex=rs.getString("branch_name");
			    	String ag=rs.getString("quantity");
			    	String ph=rs.getString("app_date");
			    	String aps=rs.getString("app_slot");
			    	rta.setText(name+'\n'+bg+'\n'+sex+'\n'+ag+'\n'+ph+'\n'+aps);
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
		btnCheck_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnCheck_1.setBounds(465, 480, 107, 38);
		appointmentFrame.getContentPane().add(btnCheck_1);
		
		JLabel lblId = new JLabel("Receiver Id :");
		lblId.setBounds(24, 49, 134, 22);
		appointmentFrame.getContentPane().add(lblId);
		lblId.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		textField_2 = new JTextField();
		textField_2.setBounds(163, 53, 269, 22);
		appointmentFrame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnCheck_1_1 = new JButton("SHOW");
		btnCheck_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				try
			     {
					String id = textField_2.getText();
					String query = "select s.branch_name,sum(s.quantity) as total from blood_storage s join donor d on s.donor_id=d.donor_id where b_group=(select b_group from receiver where receiver_id = ?) group by branch_name";
					pst=con.prepareStatement(query);
					pst.setString(1, id);
					rs=pst.executeQuery();
					int f=0;
			    while(rs.next())
			    {
			   	
			    	String bname=rs.getString("branch_name");
			    	int dt=rs.getInt("total");
			    	String old=rta.getText();
			    	rta.setText(old+bname+'\n'+dt+'\n'+'\n'+'\n');
			    	f=1;
			    }
			    if (f==0)
			    	rta.setText("No blood available of the required blood group!");
			
			}
				catch (SQLException ex)
			     {
			    	 rta.setText("No blood available of the required blood group!");
			     ex.printStackTrace();
			  }
				
			}
		});
		btnCheck_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnCheck_1_1.setBounds(442, 51, 93, 31);
		appointmentFrame.getContentPane().add(btnCheck_1_1);
	}

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}

	

	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
