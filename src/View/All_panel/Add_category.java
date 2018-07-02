package View.All_panel;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Controller.Get_Category_data;
import Model.Product_category;
import Model.Status;
import View.Dialogue.Cat_update;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;

public class Add_category extends JPanel {
	private JTextField name;
	public static JTable table;
	Product_category is=new Product_category();
	private JComboBox cmb;

	/**
	 * Create the panel.
	 */
	public Add_category() {
		
		setForeground(new Color(0, 51, 204));
		setLayout(new MigLayout("", "[grow][][][][grow]", "[][][][][grow]"));
		
		JLabel lblCategoryName = new JLabel("Category Name ::");
		add(lblCategoryName, "cell 1 0");
		
		name = new JTextField();
		add(name, "cell 4 0,growx");
		name.setColumns(10);
		
		JLabel lblStatus = new JLabel("Status ::");
		add(lblStatus, "cell 1 1");
		
		JButton save = new JButton("Save");
		save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String Cat_name=name.getText();
				String Cat_status=cmb.getSelectedItem().toString();
				
				if(cmb.getSelectedIndex()==0){
					JOptionPane.showMessageDialog(null,"Select Status");
				}
				else{
					Get_Category_data Get_Category_data=new Get_Category_data(Cat_name,Cat_status);
					
					is.load();
					
				}
			}
		});
		
		Status Status=new Status();
		ArrayList<String>status=new ArrayList<>();
		status=Status.return_status();
		
		cmb = new JComboBox();
		cmb.setModel(new DefaultComboBoxModel<>(status.toArray()));
		add(cmb, "cell 4 1,growx");
		add(save, "cell 4 2");
		
		JScrollPane scrollPane = new JScrollPane();
		
		add(scrollPane, "cell 0 4 5 1,grow");
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int row=table.getSelectedRow();
				
				String get1stColumeValue_name=table.getModel().getValueAt(row, 0).toString();
				String get2ndColumeValue_st=table.getModel().getValueAt(row, 1).toString();
				
				Product_category Product_category=new Product_category();
				int id=Product_category.get_cat_id(get1stColumeValue_name);
				
				
				
				Cat_update Cat_update=new Cat_update(id);
				
				Cat_update.textField.setText(get1stColumeValue_name);
				Cat_update.comboBox.setSelectedItem(get2ndColumeValue_st);
				
				Cat_update.setVisible(true);
				
			}
		});
		scrollPane.setViewportView(table);
		is.load();

	}

}
