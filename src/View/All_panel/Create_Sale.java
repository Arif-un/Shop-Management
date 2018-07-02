package View.All_panel;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import com.toedter.calendar.JDateChooser;

import Controller.Purchase;
import Controller.Purchase_master_contrl;
import Controller.Sale;
import Controller.Sale_master_contrl;
import Controller.Update_purchase;
import Model.Products;
import Model.Unit_t;
import Model.Product_category;
import Model.temp;
import Model.temp_sale;
import View.Dialogue.Purchase_update;

import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JCheckBox;
import java.awt.SystemColor;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSlider;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.JProgressBar;
import javax.swing.border.LineBorder;
import javax.swing.JSeparator;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Create_Sale extends JPanel {
	private JTextField qn;
	public JTextField vn;
	public static JTable table;
	private JTextField Tm;
	private JTextField pd;
	private JTextField du;
	private JTextField textField_5;
	private JTextField sell_p;
	private JTextField buy_p;
	private JComboBox cmc;
	private JComboBox cmp;
	private JSlider slider;
	public JDateChooser dateChooser;
	private JLabel unit_lbl;
	public static JCheckBox chckbxBalanced;

	/**
	 * Create the panel.
	 */
	public Create_Sale() {
		setBackground(SystemColor.activeCaption);
		setLayout(new MigLayout("", "[][grow][][96.00,grow][][][][grow][][grow][][grow]", "[grow][][][][grow][][][grow]"));
		
		JLabel lblCategory = new JLabel("MRR No :");
		add(lblCategory, "cell 0 0,alignx trailing");
		
		textField_5 = new JTextField();
		add(textField_5, "cell 1 0,growx");
		textField_5.setColumns(10);
		
		JLabel lblDate = new JLabel("Date :");
		add(lblDate, "cell 2 0,alignx right");
		
		 DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
	       Date dateobj = new Date();
		dateChooser = new JDateChooser();
		dateChooser.setDate(dateobj);
		add(dateChooser, "cell 3 0,growx,aligny center");
		
		JLabel lblCustomarName = new JLabel("Customar Name :");
		add(lblCustomarName, "cell 4 0,alignx right");
		
		JButton btnEnter = new JButton("Enter");
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String pd_nam=cmp.getSelectedItem().toString();
				int pd_id=Products.get_pd_id(pd_nam);
				int ex_pd_id=temp.ck_existing_pdt(pd_id);
				System.out.println(pd_id);
				System.out.println(ex_pd_id);
				if(pd_id==ex_pd_id){
					JOptionPane.showMessageDialog(null,"This Product Already Exist !!!");
				}
				else{
					//Date date=dateChooser.getDate();
					//String vendor=vn.getText();
					//String cat_name=cmc.getSelectedItem().toString();
					String pd_name=cmp.getSelectedItem().toString();
					String qun=qn.getText();
					//String unit=unit_lbl.getText();
					String buy=buy_p.getText();
					String sell=sell_p.getText();
					
					//int s=slider.getValue();
					//System.out.println(s);
					
				   Sale Sale=new Sale();
				   Sale.tocontroller(pd_name,qun,buy,sell);
				   
				   temp_sale temp_sale=new temp_sale();
				   int tam=temp_sale.get_total();
				   String t_amnt = new Integer(tam).toString();
				   Tm.setText(t_amnt);
				   temp_sale.load();
				   
				   vn.setEditable(false);
				   dateChooser.setEnabled(false);
				}
				
				
				
			   
			}
		});
		
		vn = new JTextField();
		add(vn, "cell 6 0,growx");
		vn.setColumns(10);
		add(btnEnter, "cell 9 0");
		
		JLabel lblCategory_1 = new JLabel("Category ::");
		add(lblCategory_1, "cell 0 1,alignx trailing");
		
		Product_category Product_category=new Product_category();
		ArrayList<String>cat=new ArrayList<>();
		cat=Product_category.return_category();
		
		cmc = new JComboBox();
		cmc.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				
				String cat=cmc.getSelectedItem().toString();
				int cat_id=Product_category.get_cat_id(cat);
				
				ArrayList<String> prdct_by_cat_wise=new ArrayList<>();
				prdct_by_cat_wise=Products.return_product_cat_wise(cat_id);
				
				cmp.setModel(new DefaultComboBoxModel<>(prdct_by_cat_wise.toArray()));
				
			}
		});
		cmc.setModel(new DefaultComboBoxModel<>(cat.toArray()));
		add(cmc, "cell 1 1,growx");
		
		JLabel lblQuantity = new JLabel("Quantity :");
		add(lblQuantity, "cell 2 1,alignx trailing");
		
		qn = new JTextField();
		add(qn, "cell 3 1,growx");
		qn.setColumns(10);
		
		unit_lbl = new JLabel("");
		add(unit_lbl, "flowx,cell 4 1");
		
		JSeparator separator_3 = new JSeparator();
		add(separator_3, "cell 4 1");
		
		buy_p = new JTextField();
		add(buy_p, "cell 6 1,growx");
		buy_p.setColumns(10);
		
		JButton btnNew = new JButton("New");
		btnNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				vn.setText("");
				qn.setText("");
				buy_p.setText("");
				sell_p.setText("");
				Tm.setText("");
				pd.setText("");
				du.setText("");
				
				vn.setEditable(true);
			   dateChooser.setEnabled(true);
			   temp_sale.truncate_temp_sale();
			   temp_sale.load();
			}
			
		});
		add(btnNew, "cell 9 1");
		
		JLabel lblProduct = new JLabel("Product :");
		add(lblProduct, "cell 0 2,alignx trailing");
		
		cmp = new JComboBox();
		cmp.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				String pd_name=cmp.getSelectedItem().toString();
				int unit_id=Products.get_unit_id_by_product(pd_name);
				String unit_name=Unit_t.get_unit_name(unit_id);
				unit_lbl.setText(unit_name);
				//System.out.println(unit_name);
			}
		});
		
		add(cmp, "cell 1 2,growx");
		
		slider = new JSlider();
		slider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				int st=slider.getValue();
				String w=Integer.toString(st);
				qn.setText(w);
			}
		});
		add(slider, "cell 2 2 2 1,growx");
		
		JLabel lblNewLabel = new JLabel("Sell-Price :");
		add(lblNewLabel, "cell 4 2,alignx trailing");
		
		sell_p = new JTextField();
		add(sell_p, "cell 6 2,growx");
		sell_p.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		add(panel_1, "cell 0 4 5 4,grow");
		panel_1.setLayout(new MigLayout("", "[grow]", "[grow]"));
		
		JScrollPane scrollPane = new JScrollPane();
		panel_1.add(scrollPane, "cell 0 0,grow");
		
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int row=table.getSelectedRow();
				
				String pd_nm=table.getModel().getValueAt(row, 0).toString();
				String quan=table.getModel().getValueAt(row, 1).toString();
				String bup=table.getModel().getValueAt(row, 2).toString();
				String tam=table.getModel().getValueAt(row, 3).toString();
				String selp=table.getModel().getValueAt(row, 4).toString();
				
				int pd_id=Products.get_pd_id(pd_nm);
				int id=temp.get_id_by_pd_id(pd_id);
				
				Date dat=dateChooser.getDate();
				String ven=vn.getText();
				String cat=cmc.getSelectedItem().toString();
				String uniit=unit_lbl.getText();
				//int pdt_id=Products.get_pd_id(pdt_name);
				
				Purchase_update Purchase_update=new Purchase_update();
					
				Purchase_update.dateChooser.setDate(dat);
					Purchase_update.ven.setText(ven);
					Purchase_update.cat.setSelectedItem(cat);
					Purchase_update.pdt.setSelectedItem(pd_nm);
					Purchase_update.quan.setText(quan);
					Purchase_update.unit.setText(uniit);
					Purchase_update.bp.setText(bup);
					Purchase_update.sp.setText(selp);
					
					Update_purchase.get_id_from_table(id);
					Purchase_update.setVisible(true);
					
			}
		});
		
		scrollPane.setViewportView(table);
		temp_sale temp_sale=new temp_sale();
		temp_sale.load();
		
		JPanel panel = new JPanel();
		panel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, Color.GRAY, Color.BLACK));
		panel.setBackground(SystemColor.inactiveCaption);
		add(panel, "cell 6 4 6 4,grow");
		panel.setLayout(new MigLayout("", "[97px][89px]", "[20px][][20px][20px][23px][][23px]"));
		
		JLabel lblTotalamount = new JLabel("Total-Amount :");
		panel.add(lblTotalamount, "cell 0 0,alignx left,aligny center");
		
		JSeparator separator = new JSeparator();
		panel.add(separator, "cell 0 1 2 1");
		
		JLabel lblPaid = new JLabel("Paid :");
		panel.add(lblPaid, "cell 0 2,alignx left,aligny center");
		
		JLabel lblDue = new JLabel("Due:");
		panel.add(lblDue, "cell 0 3,alignx left,aligny center");
		
		chckbxBalanced = new JCheckBox("Balanced");
		panel.add(chckbxBalanced, "cell 0 4,growx,aligny top");
		
		Tm = new JTextField();
		panel.add(Tm, "cell 1 0,alignx right,aligny top");
		Tm.setColumns(10);
		
		pd = new JTextField();
		pd.addKeyListener(new KeyAdapter() {
			
			
			@Override
			public void keyReleased(KeyEvent e) {
				String tm=Tm.getText();
				int t_am = Integer.parseInt(tm);
				String paid=pd.getText();
				int pd_am = Integer.parseInt(paid);
				
				/*temp temp=new temp();
				   int tam=temp.get_total();*/
				   
				   
				   
				   int due=t_am-pd_am;
				   String duee = Integer.toString(due);
				   du.setText(duee);
			}
		});
		panel.add(pd, "cell 1 2,alignx right,aligny top");
		pd.setColumns(10);
		
		du = new JTextField();
		panel.add(du, "cell 1 3,alignx right,aligny top");
		du.setColumns(10);
		
		JSeparator separator_1 = new JSeparator();
		panel.add(separator_1, "cell 0 5 2 1");
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Date date=dateChooser.getDate();
				String vendor=vn.getText();
				String tam=Tm.getText();
				String paid=pd.getText();
				String due=du.getText();
				new Sale_master_contrl(date,vendor,tam,paid,due);
				temp_sale.load();
			}
		});
		btnSave.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel.add(btnSave, "cell 1 6,growx,aligny top");
		
		JSeparator separator_2 = new JSeparator();
		add(separator_2, "cell 5 0 1 8");
		
		JLabel lblBuyprice = new JLabel("Buy-Price:");
		add(lblBuyprice, "cell 4 1,alignx right");

	}
}
