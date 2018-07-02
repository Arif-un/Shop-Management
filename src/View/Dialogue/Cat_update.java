package View.Dialogue;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.Update_cat;
import Model.Product_category;
import Model.Status;
import View.All_panel.Add_category;
import net.miginfocom.swing.MigLayout;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Cat_update extends JDialog {

	 private final JPanel contentPanel = new JPanel();
	public static JTextField textField;
	public JComboBox comboBox;
	private JButton okButton;
	
	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the dialog.
	 */
	public Cat_update(int id) {
		setBackground(new Color(0, 51, 153));
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new MigLayout("", "[][grow][grow][][][][grow]", "[][][][][][]"));
		{
			JLabel lblCategoryName = new JLabel("Category Name ::");
			contentPanel.add(lblCategoryName, "cell 0 1,alignx trailing");
		}
		{
			textField = new JTextField();
			contentPanel.add(textField, "cell 2 1 2 1,growx");
			textField.setColumns(10);
		}
		{
			JLabel lblStatus = new JLabel("Status ::");
			contentPanel.add(lblStatus, "cell 0 2");
		}
		{
			Status Status=new Status();
			ArrayList<String>status=new ArrayList<>();
			status=Status.return_status();
			
			
			comboBox = new JComboBox();
			
			contentPanel.add(comboBox, "cell 2 2 2 1,growx");
			comboBox.setModel(new DefaultComboBoxModel<>(status.toArray()));
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnNewButton = new JButton("Update");
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						String Cat_name=textField.getText();
						String st=comboBox.getSelectedItem().toString();
						
						//Add_category Add_categor=new Add_category();
						
						
						new Update_cat(Cat_name,st,id);
						Product_category.load();
						
						Cat_update.this.dispose();
						
					}
				});
				buttonPane.add(btnNewButton);
			}
			{
				okButton = new JButton("Delete");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						Product_category.delete_cat(id);
						Product_category.load();
						Cat_update.this.dispose();
					}
				});
				
				buttonPane.add(okButton);
				
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Product_category.load();
						Cat_update.this.dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
				getRootPane().setDefaultButton(cancelButton);
			}
		}
	}

}
