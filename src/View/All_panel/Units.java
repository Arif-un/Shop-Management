package View.All_panel;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Controller.Get_Category_data;
import Controller.Get_unit;
import Model.Status;
import Model.Unit_t;
import View.Dialogue.Unit_update;

import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Units extends JPanel {
	private JTextField textField;
	public static JTable table;
	private JComboBox cmb;
	Unit_t obj=new Unit_t();
	/**
	 * Create the panel.
	 */
	public Units() {
		setLayout(new MigLayout("", "[][][grow][grow]", "[][][][][grow]"));
		
		JLabel lblAllUnits = new JLabel("All Units");
		add(lblAllUnits, "cell 3 0");
		
		JLabel lblUnitName = new JLabel("Unit Name ::");
		add(lblUnitName, "cell 1 1");
		
		textField = new JTextField();
		add(textField, "cell 3 1,growx");
		textField.setColumns(10);
		
		JLabel lblStatus = new JLabel("Status ::");
		add(lblStatus, "cell 1 2");
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String name=textField.getText();
				String st=cmb.getSelectedItem().toString();
				if(cmb.getSelectedIndex()==0){
					JOptionPane.showMessageDialog(null,"Select Status");
				}
				else{
					Get_unit Get_unit=new Get_unit(name,st);
					obj.load();
				}
				
			}
		});
		
		
		Status Status=new Status();
		ArrayList<String>status=new ArrayList<>();
		status=Status.return_status();
		
		cmb = new JComboBox();
		cmb.setModel(new DefaultComboBoxModel<>(status.toArray()));
		add(cmb, "cell 3 2,growx");
		add(btnSave, "cell 3 3");
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, "cell 0 4 4 1,grow");
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
					int row=table.getSelectedRow();
				
					String get_unit_nme=table.getModel().getValueAt(row, 0).toString();
					String get_unit_st=table.getModel().getValueAt(row, 1).toString();
					
					Unit_t Unit_t=new Unit_t();
					int id=Unit_t.get_unit_id(get_unit_nme);
					
					Unit_update Unit_update=new Unit_update(id);
					Unit_update.un.setText(get_unit_nme);
					Unit_update.comboBox.setSelectedItem(get_unit_st);
					
					Unit_update.setVisible(true);
					
			}
		});
		scrollPane.setViewportView(table);
		
		obj.load();

	}

}
