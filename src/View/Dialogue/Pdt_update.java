package View.Dialogue;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.Update_pdt;
import Model.Product_category;
import Model.Products;
import Model.Status;
import Model.Unit_t;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Pdt_update extends JDialog {

	private final JPanel contentPanel = new JPanel();
	public JTextField pn;
	public JComboBox cmc;
	public JComboBox combo_un;
	public JComboBox cms;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the dialog.
	 */
	public Pdt_update(int id) {
		setBackground(new Color(0, 51, 153));
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new MigLayout("", "[][][][grow]", "[][][][][]"));
		{
			JLabel lblProductName = new JLabel("Product Name ::");
			contentPanel.add(lblProductName, "cell 1 1");
		}
		{
			pn = new JTextField();
			contentPanel.add(pn, "cell 3 1,growx");
			pn.setColumns(10);
		}
		{
			JLabel lblCategory = new JLabel("Category ::");
			contentPanel.add(lblCategory, "cell 1 2");
		}
		{
			Product_category Product_category=new Product_category();
			ArrayList<String>all_categoryy=new ArrayList<>();
			all_categoryy=Product_category.return_category();
			
			cmc = new JComboBox();
			cmc.setModel(new DefaultComboBoxModel<>(all_categoryy.toArray()));
			contentPanel.add(cmc, "cell 3 2,growx");
		}
		{
			JLabel lblUnit = new JLabel("Unit ::");
			contentPanel.add(lblUnit, "cell 1 3");
		}
		{
			
			Unit_t unit_t=new Unit_t();
			ArrayList<String>allunit=new ArrayList<>();
			allunit=unit_t.return_unit();
			
			combo_un = new JComboBox();
			combo_un.setModel(new DefaultComboBoxModel<>(allunit.toArray()));
			contentPanel.add(combo_un, "cell 3 3,growx");
		}
		{
			JLabel lblStatus = new JLabel("Status ::");
			contentPanel.add(lblStatus, "cell 1 4");
		}
		{
			Status Status=new Status();
			ArrayList<String>status=new ArrayList<>();
			status=Status.return_status();
			
			cms = new JComboBox();
			cms.setModel(new DefaultComboBoxModel<>(status.toArray()));
			contentPanel.add(cms, "cell 3 4,growx");
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnUpdate = new JButton("Update");
				btnUpdate.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						String pd_nme=pn.getText();
						String pd_c=cmc.getSelectedItem().toString();
						String pd_un=combo_un.getSelectedItem().toString();
						String pd_st=cms.getSelectedItem().toString();
						
						new Update_pdt(pd_nme,pd_c,pd_un,pd_st,id);
						Products.load();
						Pdt_update.this.dispose();
					}
				});
				buttonPane.add(btnUpdate);
			}
			{
				JButton okButton = new JButton("Delete");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Products.delete_product(id);
						Products.load();
						Pdt_update.this.dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						Products.load();
						Pdt_update.this.dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
				getRootPane().setDefaultButton(cancelButton);
			}
		}
	}

}
