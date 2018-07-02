package View.Dialogue;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.Update_unit;
import Model.Unit_t;
import Model.Status;
import View.All_panel.Units;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Unit_update extends JDialog {

	private final JPanel contentPanel = new JPanel();
	public JTextField un;
	public JComboBox comboBox;
	//protected Object Unit;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the dialog.
	 */
	public Unit_update(int id) {
		setBackground(new Color(0, 51, 153));
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblUnitName = new JLabel("Unit Name ::");
		lblUnitName.setBounds(45, 49, 67, 14);
		contentPanel.add(lblUnitName);
		
		un = new JTextField();
		un.setBounds(114, 46, 203, 20);
		contentPanel.add(un);
		un.setColumns(10);
		
		JLabel lblStatus = new JLabel("Status ::");
		lblStatus.setBounds(45, 86, 46, 14);
		contentPanel.add(lblStatus);
		
		
		Status Status=new Status();
		ArrayList<String>status=new ArrayList<>();
		status=Status.return_status();
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel<>(status.toArray()));
		comboBox.setBounds(114, 83, 203, 20);
		contentPanel.add(comboBox);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			
			JButton btnUpdate = new JButton("Update");
			btnUpdate.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					String unit=un.getText();
					String un_st=comboBox.getSelectedItem().toString();
					
					Unit_t Unit_t=new Unit_t();
					
					
					Update_unit i=new Update_unit();
					i.Update_units(unit,un_st,id);
					
					Unit_t.load();
					Unit_update.this.dispose();
				}
			});
			buttonPane.add(btnUpdate);
			{
				JButton Delete = new JButton("Delete");
				Delete.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						//String unit=un.getText();
						
						Unit_t Unit_t=new Unit_t();
						
						Unit_t.delete_unit(id);
						Unit_t.load();
						Unit_update.this.dispose();
					}
				});
				Delete.setActionCommand("OK");
				buttonPane.add(Delete);
				
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						Unit_t Unit_t=new Unit_t(); 
						Unit_t.load();
						Unit_update.this.dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
				getRootPane().setDefaultButton(cancelButton);
			}
		}
	}
}
