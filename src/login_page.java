import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JPopupMenu;
import javax.swing.JPasswordField;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class login_page {

	private JFrame frameLogin;
	private JPasswordField passwordField;
	ButtonGroup bg = new ButtonGroup();
	/**
	 * @wbp.nonvisual location=1001,274
	 */
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login_page window = new login_page();
					window.frameLogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public login_page() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameLogin = new JFrame();
		frameLogin.setBounds(100, 100, 881, 519);
		frameLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameLogin.getContentPane().setLayout(null);
		
		JLabel lblLoginPage = new JLabel("LOGIN PAGE");
		lblLoginPage.setBounds(343, 10, 164, 31);
		lblLoginPage.setFont(new Font("Tahoma", Font.BOLD, 25));
		frameLogin.getContentPane().add(lblLoginPage, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "LOGIN PAGE", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(164, 51, 525, 361);
		frameLogin.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblPassword = new JLabel("Password :");
		lblPassword.setBounds(10, 53, 158, 22);
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel.add(lblPassword);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("DONAR");
		rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		rdbtnNewRadioButton.setBounds(87, 128, 103, 21);
		panel.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnReceiver = new JRadioButton("RECEIVER");
		rdbtnReceiver.setFont(new Font("Tahoma", Font.BOLD, 15));
		rdbtnReceiver.setBounds(87, 158, 118, 21);
		panel.add(rdbtnReceiver);
		
		JRadioButton rdbtnAppointment = new JRadioButton("APPOINTMENT");
		rdbtnAppointment.setFont(new Font("Tahoma", Font.BOLD, 15));
		rdbtnAppointment.setBounds(87, 191, 141, 21);
		panel.add(rdbtnAppointment);
		
		JRadioButton rdbtnStorage = new JRadioButton("STORAGE");
		rdbtnStorage.setFont(new Font("Tahoma", Font.BOLD, 15));
		rdbtnStorage.setBounds(87, 221, 103, 21);
		panel.add(rdbtnStorage);
		
		bg.add(rdbtnNewRadioButton);
		bg.add(rdbtnStorage);
		bg.add(rdbtnAppointment);
		bg.add(rdbtnReceiver);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(235, 53, 237, 28);
		panel.add(passwordField);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s= new String("12345");
				String p=new String(new String(passwordField.getPassword()));
				if(rdbtnAppointment.isSelected() && p.equals(s)) {
					appointment ap = new appointment();
					ap.appointmentFrame.setVisible(true);
					frameLogin.dispose();
				}
				if(rdbtnReceiver.isSelected()&& p.equals(s)) {
					receiver re = new receiver();
					re.receiverFrame.setVisible(true);
					frameLogin.dispose();
					
				}
				if(rdbtnStorage.isSelected()&& p.equals(s)) {
					blood_storage bs = new blood_storage();
					bs.bsFrame.setVisible(true);
					frameLogin.dispose();
				}
				if(rdbtnNewRadioButton.isSelected()&& p.equals(s)) {
					donor dn = new donor();
					dn.donorFrame.setVisible(true);
					frameLogin.dispose();
				}
				
				}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(87, 271, 110, 34);
		panel.add(btnNewButton);
		
		JButton btnTryAgain = new JButton("Try Again");
		btnTryAgain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				passwordField.setText("");
			}
		});
		btnTryAgain.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnTryAgain.setBounds(274, 271, 110, 34);
		panel.add(btnTryAgain);
	}
}
