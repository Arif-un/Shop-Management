package View.Dialogue;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.toedter.calendar.JDateChooser;

import Controller.Update_purchase;
import Model.Product_category;
import Model.Products;
import Model.Status;
import Model.Unit_t;
import Model.temp;
import View.All_panel.Create_Purchase;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.ImageIcon;

public class Purchase_update extends JDialog {

	private final JPanel contentPanel = new JPanel();
	public JDateChooser dateChooser;
	public JTextField ven;
	public JTextField textField_1;
	public static JTextField quan;
	public static JTextField bp;
	public static JTextField sp;
	public JComboBox cat;
	public static JComboBox pdt;
	public JLabel id_n;
	public JLabel unit;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Purchase_update dialog = new Purchase_update();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Purchase_update() {
		setBackground(new Color(0, 51, 153));
		setBounds(100, 100, 639, 314);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		dateChooser = new JDateChooser();
		
		dateChooser.setBounds(62, 121, 109, 20);
		contentPanel.add(dateChooser);
		
		JLabel lblVendorName = new JLabel("Vendor Name ::");
		lblVendorName.setBounds(149, 11, 75, 14);
		contentPanel.add(lblVendorName);
		
		ven = new JTextField();
		ven.setBounds(234, 8, 168, 20);
		contentPanel.add(ven);
		ven.setColumns(10);
		
		JLabel lblMrrNo = new JLabel("MRR No ::");
		lblMrrNo.setBounds(23, 40, 52, 14);
		contentPanel.add(lblMrrNo);
		
		textField_1 = new JTextField();
		textField_1.setBounds(85, 36, 86, 20);
		contentPanel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblCategory = new JLabel("Category ::");
		lblCategory.setBounds(188, 40, 67, 14);
		contentPanel.add(lblCategory);
		
		Product_category Product_category=new Product_category();
		ArrayList<String>all_cat=new ArrayList<>();
		all_cat=Product_category.return_category();		
 
		cat = new JComboBox();
		cat.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				String cate=cat.getSelectedItem().toString();
				int cat_id=Product_category.get_cat_id(cate);
				
				ArrayList<String> prdct_by_cat_wise=new ArrayList<>();
				prdct_by_cat_wise=Products.return_product_cat_wise(cat_id);
				
				pdt.setModel(new DefaultComboBoxModel<>(prdct_by_cat_wise.toArray()));
			}
		});
		cat.setModel(new DefaultComboBoxModel<>(all_cat.toArray()));
		cat.setBounds(256, 37, 75, 20);
		contentPanel.add(cat);
		
		JLabel lblProduct = new JLabel("Product ::");
		lblProduct.setBounds(345, 39, 57, 14);
		contentPanel.add(lblProduct);
		
		pdt = new JComboBox();
		pdt.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				String pd_name=pdt.getSelectedItem().toString();
				int unit_id=Products.get_unit_id_by_product(pd_name);
				String unit_name=Unit_t.get_unit_name(unit_id);
				unit.setText(unit_name);
				System.out.println(unit_name);
			}
		});
		pdt.setBounds(398, 37, 75, 20);
		contentPanel.add(pdt);
		
		JLabel lblUnit = new JLabel("Unit ::");
		lblUnit.setBounds(483, 40, 46, 14);
		contentPanel.add(lblUnit);
		
		Status Status=new Status();
		ArrayList<String>status=new ArrayList<>();
		status=Status.return_status();
		
		JLabel lblQuantity = new JLabel("Quantity ::");
		lblQuantity.setBounds(23, 86, 67, 14);
		contentPanel.add(lblQuantity);
		
		quan = new JTextField();
		quan.setBounds(85, 83, 86, 20);
		contentPanel.add(quan);
		quan.setColumns(10);
		
		JLabel lblDate = new JLabel("Date ::");
		lblDate.setBounds(23, 127, 46, 14);
		contentPanel.add(lblDate);
		
		JLabel lblBurprice = new JLabel("Buy-Price ::");
		lblBurprice.setBounds(234, 89, 67, 14);
		contentPanel.add(lblBurprice);
		
		JLabel lblSellprice = new JLabel("Sell-Price ::");
		lblSellprice.setBounds(234, 127, 67, 14);
		contentPanel.add(lblSellprice);
		
		bp = new JTextField();
		bp.setBounds(304, 83, 128, 20);
		contentPanel.add(bp);
		bp.setColumns(10);
		
		sp = new JTextField();
		sp.setColumns(10);
		sp.setBounds(304, 121, 128, 20);
		contentPanel.add(sp);
		
		id_n = new JLabel("\r\n\r\n");
		id_n.setBounds(494, 103, 46, 14);
		contentPanel.add(id_n);
		
		unit = new JLabel("");
		unit.setBounds(516, 40, 46, 14);
		contentPanel.add(unit);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			
			JButton btnUpdate = new JButton("Update");
			btnUpdate.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					Create_Purchase Create_Purchase=new Create_Purchase();
					
					Date dt=dateChooser.getDate();
					Create_Purchase.dateChooser.setDate(dt);
					
					String vn=ven.getText();
					Create_Purchase.vn.setText(vn);
					
					//String cat_nm=cat.getSelectedItem().toString();
					String pdt_nm=pdt.getSelectedItem().toString();
					//String unt_nm=unit.getText();
					String qn=quan.getText();
					String buy_p=bp.getText();
					String sell_p=sp.getText();
					
					new Update_purchase(pdt_nm,qn,buy_p,sell_p);
					
					temp temp=new temp();
					temp.load();
					Purchase_update.this.dispose();
					
					
					
				}
			});
			buttonPane.add(btnUpdate);
			{
				JButton okButton = new JButton("Delete");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						
						String id=id_n.getText();
						int id_num = Integer.parseInt(id);
						temp temp=new temp();
						temp.delete_temp(id_num);
						temp.load();
						
						Purchase_update.this.dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						temp temp=new temp();
						temp.load();
						Purchase_update.this.dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
