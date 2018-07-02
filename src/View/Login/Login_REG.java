package View.Login;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;

import Controller.Login_REG_ctrl;
import Controller.Login_cntrl;
import Model.Login_Admin;
import Model.Login_Employee;
import Model.Login_Manager;
import View.Dashboard_JFrm;
import de.javasoft.plaf.synthetica.SyntheticaAluOxideLookAndFeel;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Window.Type;
import javax.swing.JToggleButton;
import javax.swing.JFormattedTextField;
import javax.swing.JPasswordField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

public class Login_REG {

	private JFrame frmLoginPanel;
	private JTextField user;
	private JTextField passw;
	private JComboBox rol;
	private JButton btnLogin;
	private JLabel user_lbl;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(new SyntheticaAluOxideLookAndFeel());
					Login_REG window = new Login_REG();
					window.frmLoginPanel.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login_REG() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		LOG_Splash obj=new LOG_Splash();
		
		
 
		
		frmLoginPanel = new JFrame();
		frmLoginPanel.setType(Type.POPUP);
		frmLoginPanel.setTitle("Account Registration");
		frmLoginPanel.setBounds(490, 250, 450, 300);
		frmLoginPanel.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmLoginPanel.getContentPane().setLayout(null);
		
		JLabel lblLogin = new JLabel("Account Registration Form");
		lblLogin.setBounds(137, 11, 157, 24);
		frmLoginPanel.getContentPane().add(lblLogin);
		
		user = new JTextField();
		
		
		
		user.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				String usr=user.getText();
				String ad=Login_Admin.username_exist_admin(usr);
				String em=Login_Employee.username_exist_emp(usr);
				String mng=Login_Manager.username_exist_mngr(usr);
				
				if(ad==null&&em==null&&mng==null){
					user.setBorder(null);
					//user.setBorder(new EmptyBorder(0, 0, 0, 0));
					user_lbl.setVisible(false);
					btnLogin.setEnabled(true);
				}
				else{
					user.setBorder(new LineBorder(new Color(255, 0, 0)));
					user_lbl.setVisible(true);
					btnLogin.setEnabled(false);
				}
			}
		});
		user.setBounds(124, 74, 207, 20);
		frmLoginPanel.getContentPane().add(user);
		user.setColumns(10);
		
		JLabel lblUsername = new JLabel("Username ::");
		lblUsername.setBounds(41, 77, 67, 14);
		frmLoginPanel.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password ::");
		lblPassword.setBounds(41, 113, 67, 14);
		frmLoginPanel.getContentPane().add(lblPassword);
		
		passw = new JTextField();
		
		passw.setColumns(10);
		passw.setBounds(124, 110, 207, 20);
		frmLoginPanel.getContentPane().add(passw);
		
		btnLogin = new JButton("Register\r\n");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(rol.getSelectedItem().toString().equals("Select")){
					JOptionPane.showMessageDialog(null, "Select Your Role");
				}
				else{
					String un=user.getText();
					String ps=passw.getText();
					String role=rol.getSelectedItem().toString();
					new Login_REG_ctrl(un,ps,role);
					JOptionPane.showMessageDialog(null, "Registration Successfull");
				}
				
			}
		});
		btnLogin.setBounds(124, 198, 89, 23);
		frmLoginPanel.getContentPane().add(btnLogin);
		
		rol = new JComboBox();
		rol.setModel(new DefaultComboBoxModel(new String[] {"Select", "Employee", "Manager", "Admin", "Super_Admin"}));
		rol.setBounds(124, 145, 89, 20);
		frmLoginPanel.getContentPane().add(rol);
		
		JLabel lblRole = new JLabel("Role ::");
		lblRole.setBounds(41, 148, 42, 14);
		frmLoginPanel.getContentPane().add(lblRole);
		
		user_lbl = new JLabel("Username Already Exist !!!");
		user_lbl.setForeground(new Color(255, 0, 0));
		user_lbl.setVisible(false);
		user_lbl.setBounds(124, 96, 207, 14);
		frmLoginPanel.getContentPane().add(user_lbl);
		

	}
}
