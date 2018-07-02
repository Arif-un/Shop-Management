package View.All_panel;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Controller.Get_product;
import Model.Products;
import Model.Product_category;
import Model.Status;
import Model.Unit_t;
import View.Dialogue.Pdt_update;

import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JToggleButton;

import Backup_Restore.BackUpFrame;

import javax.swing.JFormattedTextField;
import javax.swing.JSeparator;
import javax.swing.JScrollBar;
import javax.swing.JSlider;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Product_name extends JPanel {
	private  JTextField pn;
	public static  JTable product_table;
	private  JComboBox cmb;
	

	
	
	/**
	 * Create the panel.
	 */
	public Product_name() {
		setLayout(new MigLayout("", "[][grow][][][][grow]", "[][][][][][][grow]"));
		
		JLabel lblProductName = new JLabel("Product name ::");
		add(lblProductName, "cell 1 0");
		
		pn = new JTextField();
		add(pn, "cell 5 0,growx");
		pn.setColumns(10);
		
		JLabel lblSelectProductCategory = new JLabel("Select Product Category ::");
		add(lblSelectProductCategory, "cell 1 1");
		
		Product_category Product_category=new Product_category();
		ArrayList<String>all_categoryy=new ArrayList<>();
		all_categoryy=Product_category.return_category();
		
		JComboBox comboPC = new JComboBox();
		comboPC.setModel(new DefaultComboBoxModel<>(all_categoryy.toArray()));
		add(comboPC, "cell 5 1,growx");
		
		JLabel lblSelectUnit = new JLabel("Select Unit ::");
		add(lblSelectUnit, "cell 1 2");
		
		
		Unit_t unit_t=new Unit_t();
		ArrayList<String>allunit=new ArrayList<>();
		allunit=unit_t.return_unit();
		
		JComboBox combo_un = new JComboBox();
		combo_un.setModel(new DefaultComboBoxModel<>(allunit.toArray()));
		add(combo_un, "cell 5 2,growx");
		
		
		JLabel lblStatus = new JLabel("Status ::");
		add(lblStatus, "cell 1 3");
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String name=pn.getText();
				String p_cat=comboPC.getSelectedItem().toString();
				String p_u=combo_un.getSelectedItem().toString();
				String p_s=cmb.getSelectedItem().toString();
				
				new Get_product(name,p_cat,p_u,p_s);
				Products p=new Products();
				p.load();
				
				
				
				
			}
		});
		Status Status=new Status();
		ArrayList<String>status=new ArrayList<>();
		status=Status.return_status();
		
		cmb = new JComboBox();
		cmb.setModel(new DefaultComboBoxModel<>(status.toArray()));
		add(cmb, "cell 5 3,growx");
		
		JSeparator separator = new JSeparator();
		add(separator, "cell 1 4");
		
		JButton btnBackupDatabase = new JButton("Backup Database");
		btnBackupDatabase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				BackUpFrame b=new BackUpFrame();
				b.setVisible(true);
			}
		});
		add(btnBackupDatabase, "cell 1 5");
		add(btnSave, "cell 5 5");
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, "cell 0 6 6 1,grow");
		
		product_table = new JTable();
		product_table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
					int row=product_table.getSelectedRow();
				
				String get1stColumeValue_pd_nme=product_table.getModel().getValueAt(row, 0).toString();
				String get2ndColumeValue_cat_nme=product_table.getModel().getValueAt(row, 1).toString();
				String get3rdColumeValue_un_nme=product_table.getModel().getValueAt(row, 2).toString();
				String get3rdColumeValue_st=product_table.getModel().getValueAt(row, 3).toString();
				int id=Products.get_pd_id(get1stColumeValue_pd_nme);
				
				Pdt_update Pdt_update =new Pdt_update (id);
				Pdt_update.pn.setText(get1stColumeValue_pd_nme);
				Pdt_update.cmc.setSelectedItem(get2ndColumeValue_cat_nme);
				Pdt_update.combo_un.setSelectedItem(get3rdColumeValue_un_nme);
				Pdt_update.cms.setSelectedItem(get3rdColumeValue_st);
				Pdt_update.setVisible(true);
				
			}
		});
		Products p=new Products();
		p.load();
		scrollPane.setViewportView(product_table);

	}

}
