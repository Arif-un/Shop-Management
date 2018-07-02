package View.Login;

import Controller.Login_cntrl;
import de.javasoft.plaf.synthetica.SyntheticaAluOxideLookAndFeel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

//import com.seaglasslookandfeel.SeaGlassLookAndFeel;
//import de.javasoft.plaf.synthetica.SyntheticaAluOxideLookAndFeel;
//import napkin.NapkinLookAndFeel;

public class Login_Jfrm extends JFrame {

    public static JFrame frmLoginPanel;
    public static Login_Jfrm window;
    private JTextField user;
    private JTextField passw;
    private JComboBox rol;
    private JToggleButton tglbtnNewToggleButton;

    /**
     * Create the application.
     */
    public Login_Jfrm() {
        initialize();
    }

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    //UIManager.setLookAndFeel(new SyntheticaBlackEyeLookAndFeel());
                    UIManager.setLookAndFeel(new SyntheticaAluOxideLookAndFeel());
                    //UIManager.setLookAndFeel(new SyntheticaAluOxideLookAndFeel());
                    window = new Login_Jfrm();
                    window.frmLoginPanel.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {


        frmLoginPanel = new JFrame();
        frmLoginPanel.setType(Type.POPUP);
        frmLoginPanel.setTitle("Login Panel");
        frmLoginPanel.setBounds(480, 250, 450, 300);
        frmLoginPanel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmLoginPanel.getContentPane().setLayout(null);

        JLabel lblLogin = new JLabel("Login \r\n");
        lblLogin.setBounds(196, 39, 46, 24);
        frmLoginPanel.getContentPane().add(lblLogin);

        user = new JTextField();
        user.setBounds(124, 74, 207, 20);
        frmLoginPanel.getContentPane().add(user);
        user.setColumns(10);

        JLabel lblUsername = new JLabel("Username ::");
        lblUsername.setBounds(41, 77, 67, 14);
        frmLoginPanel.getContentPane().add(lblUsername);

        JLabel lblPassword = new JLabel("Password ::");
        lblPassword.setBounds(41, 113, 67, 14);
        frmLoginPanel.getContentPane().add(lblPassword);

        passw = new JPasswordField();


        passw.setColumns(10);
        passw.setBounds(124, 110, 207, 20);
        frmLoginPanel.getContentPane().add(passw);

        JButton btnLogin = new JButton("Login");
        btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                if (rol.getSelectedItem().toString().equals("Select")) {
                    JOptionPane.showMessageDialog(null, "Select Your Role");
                } else {
                    String un = user.getText();
                    String ps = passw.getText();
                    String role = rol.getSelectedItem().toString();
                    new Login_cntrl(un, ps, role);


                }

            }
        });
        btnLogin.setBounds(124, 198, 89, 23);
        frmLoginPanel.getContentPane().add(btnLogin);

        rol = new JComboBox();
        rol.setModel(new DefaultComboBoxModel(new String[]{"Select", "Employee", "Manager", "Admin", "Super_Admin"}));
        rol.setBounds(124, 145, 89, 20);
        frmLoginPanel.getContentPane().add(rol);

        JLabel lblRole = new JLabel("Role ::");
        lblRole.setBounds(41, 148, 42, 14);
        frmLoginPanel.getContentPane().add(lblRole);

        tglbtnNewToggleButton = new JToggleButton("");
        tglbtnNewToggleButton.setIcon(new ImageIcon(Login_Jfrm.class.getResource("/resource/eye.png")));
        tglbtnNewToggleButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                if (tglbtnNewToggleButton.isSelected()) {
                    ((JPasswordField) passw).setEchoChar((char) 0);
                } else {
                    ((JPasswordField) passw).setEchoChar('*');
                }

            }
        });
        tglbtnNewToggleButton.setBounds(341, 113, 18, 14);
        frmLoginPanel.getContentPane().add(tglbtnNewToggleButton);

        JLabel lblNotRegisterYet = new JLabel("Not Register Yet ? ");
        lblNotRegisterYet.setFont(new Font("Tahoma", Font.PLAIN, 9));
        lblNotRegisterYet.setBounds(124, 236, 94, 14);
        frmLoginPanel.getContentPane().add(lblNotRegisterYet);

        JLabel lblRegisterHere = new JLabel("Register here !!!");
        lblRegisterHere.setForeground(new Color(0, 51, 153));
        lblRegisterHere.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                Login_REG Login_REG = new Login_REG();
                Login_REG.main(null);
            }

            @Override
            public void mouseEntered(MouseEvent arg0) {
                lblRegisterHere.setFont(new Font("Tahoma", Font.PLAIN, 11));
                lblRegisterHere.setForeground(new Color(0, 51, 204));
            }

            @Override
            public void mouseExited(MouseEvent arg0) {
                lblRegisterHere.setFont(new Font("Tahoma", Font.PLAIN, 10));
                lblRegisterHere.setForeground(new Color(0, 51, 153));
            }
        });
        lblRegisterHere.setFont(new Font("Tahoma", Font.PLAIN, 10));
        lblRegisterHere.setBounds(211, 236, 82, 14);
        frmLoginPanel.getContentPane().add(lblRegisterHere);


    }
}
