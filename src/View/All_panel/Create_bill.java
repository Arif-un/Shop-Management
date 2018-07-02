package View.All_panel;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import com.toedter.calendar.JDateChooser;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JCheckBox;
import java.awt.SystemColor;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.UIManager;

public class Create_bill extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTable table;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Create the panel.
	 */
	public Create_bill() {
		setBackground(SystemColor.activeCaption);
		setLayout(new MigLayout("", "[][grow][][96.00,grow][][grow][][grow][][grow]", "[grow][][][grow][][][grow]"));
		
		JLabel lblCategory = new JLabel("Category :");
		add(lblCategory, "cell 0 0,alignx trailing");
		
		JComboBox comboBox = new JComboBox();
		add(comboBox, "cell 1 0,growx");
		
		JLabel lblDate = new JLabel("Date :");
		add(lblDate, "cell 2 0,alignx right");
		
		JDateChooser dateChooser = new JDateChooser();
		add(dateChooser, "cell 3 0,growx,aligny center");
		
		JLabel lblCustomarName = new JLabel("Customar Name :");
		add(lblCustomarName, "cell 4 0");
		
		textField_1 = new JTextField();
		add(textField_1, "cell 7 0,growx");
		textField_1.setColumns(10);
		
		JLabel lblProduct = new JLabel("Product :");
		add(lblProduct, "cell 0 1,alignx trailing");
		
		JComboBox comboBox_1 = new JComboBox();
		add(comboBox_1, "cell 1 1,growx");
		
		JLabel lblQuantity = new JLabel("Quantity :");
		add(lblQuantity, "cell 2 1,alignx trailing");
		
		textField = new JTextField();
		add(textField, "cell 3 1,growx");
		textField.setColumns(10);
		
		JButton btnEnter = new JButton("Enter");
		add(btnEnter, "cell 4 1");
		
		JButton btnNew = new JButton("New");
		add(btnNew, "cell 7 1");
		
		JPanel panel_1 = new JPanel();
		add(panel_1, "cell 0 3 4 4,grow");
		panel_1.setLayout(new MigLayout("", "[grow]", "[grow]"));
		
		JScrollPane scrollPane = new JScrollPane();
		panel_1.add(scrollPane, "cell 0 0,grow");
		
		table = new JTable();
		scrollPane.setColumnHeaderView(table);
		
		JPanel panel = new JPanel();
		panel.setBorder(UIManager.getBorder("ComboBox.editorBorder"));
		panel.setBackground(SystemColor.inactiveCaption);
		add(panel, "cell 4 3 6 4,grow");
		panel.setLayout(null);
		
		JLabel lblTotalamount = new JLabel("Total-Amount :");
		lblTotalamount.setBounds(10, 11, 72, 14);
		panel.add(lblTotalamount);
		
		JLabel lblPaid = new JLabel("Paid :");
		lblPaid.setBounds(10, 36, 46, 14);
		panel.add(lblPaid);
		
		JLabel lblDue = new JLabel("Due:");
		lblDue.setBounds(10, 60, 46, 14);
		panel.add(lblDue);
		
		JCheckBox chckbxBalanced = new JCheckBox("Balanced");
		chckbxBalanced.setBounds(6, 81, 97, 23);
		panel.add(chckbxBalanced);
		
		textField_2 = new JTextField();
		textField_2.setBounds(110, 8, 86, 20);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(110, 33, 86, 20);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(110, 57, 86, 20);
		panel.add(textField_4);
		textField_4.setColumns(10);
		
		JButton btnSave = new JButton("Save");
		btnSave.setBounds(107, 180, 89, 23);
		panel.add(btnSave);

	}
}
