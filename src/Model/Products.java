package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import View.All_panel.Product_name;
import View.All_panel.Units;
import net.proteanit.sql.DbUtils;

public class Products {
	private String snd_name;
	private int cat_id;
	private int unit_id;
	private int st;
	
	private String u_name;
	private int u_cat_id;
	private int u_un_id;
	private int u_st;
	private int id;
	
	public  void prepare_for_send_product(String send_name,int send_cat_id,int send_unit_id,int send_status){
		
		this.snd_name=send_name;
		this.cat_id=send_cat_id;
		this.unit_id=send_unit_id;
		this.st=send_status;
		
	}
	
	public  void prepare_for_update_product(String pdt_name, int pdt_cat, int pdt_un, int st2, int id2){
		
		this.u_name=pdt_name;
		 this.u_cat_id=pdt_cat;
		 this.u_un_id=pdt_un;
		 this.u_st=st2;
		 this.id=id2;
		
	}
	
	public void snd_to_db_Upadate_product(){
		Connection is=Database.getconnection();
		
		String command="UPDATE `products` SET `Name`=?,`Status`=?,`unit_id`=?,`Catagory_id`=? WHERE id=?";
		
		try{
			PreparedStatement ps=is.prepareStatement(command);
			ps.setString(1, this.u_name);
			ps.setInt(2, this.u_st);
			ps.setInt(3, this.u_un_id);
			ps.setInt(4, this.u_cat_id);
			ps.setInt(5, this.id);
			ps.execute();
		}
		catch(Exception x){
			x.printStackTrace();
		}
	}
	
	public void snd_to_db_product(){
		Connection is=Database.getconnection();
		
		String command="INSERT INTO `products`(`Name`, `Status`, `unit_id`, `Catagory_id`) VALUES (?,?,?,?)";
		
		try{
			PreparedStatement ps=is.prepareStatement(command);
			ps.setString(1, this.snd_name);
			ps.setInt(2, this.st);
			ps.setInt(3, this.unit_id);
			ps.setInt(4, this.cat_id);
			ps.execute();
		}
		catch(Exception x){
			x.printStackTrace();
		}
	}
	
	public static void load(){
		Connection is=Database.getconnection();
		
		String command="SELECT a.Name as Product,b.Name as Category,c.Name as Unit,(CASE a.status WHEN 1 THEN 'Enable' ELSE 'Disable' END) as StatUs from products a,product_catagory b,unit c WHERE a.unit_id=c.id AND a.Catagory_id=b.id";
		
		try{
			PreparedStatement ps=is.prepareStatement(command);
			ResultSet rs=ps.executeQuery();
			Product_name.product_table.setModel(DbUtils.resultSetToTableModel(rs));
		}
		catch(Exception x){
			x.printStackTrace();
		}
		
	}
	
	
public static ArrayList<String> return_product_cat_wise(int Category_id){
		
		ArrayList<String> cat_wise_product=new ArrayList<>();
		Connection is=Database.getconnection();
		String command="SELECT * FROM products WHERE Catagory_id=?";
		
		try{
			PreparedStatement ps=is.prepareStatement(command);
			ps.setInt(1, Category_id);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				cat_wise_product.add(rs.getString("Name")); 
			}
			
		}
		catch(Exception e){
			
		}
		return cat_wise_product;
	}







public static int get_pd_id(String give_pd_name){
	Connection obj=Database.getconnection();
	
	String comnd="SELECT id FROM products WHERE Name=?";
	
	int pd_id=0;
	
	try{
		PreparedStatement ps=obj.prepareStatement(comnd);
		ps.setString(1,give_pd_name);
		ResultSet rs=ps.executeQuery();
		
		while(rs.next()){
			pd_id=rs.getInt("id");	
		}
		
		
	}
	catch(Exception e){
		
	}
	
	return pd_id;
}

public static void delete_product(int id_no){
	Connection is=Database.getconnection();
	
	String command="DELETE FROM `products` WHERE id=?";
	
	try{
		PreparedStatement ps=is.prepareStatement(command);
		ps.setInt(1,id_no);

		ps.execute();
	}
	catch(Exception x){
		x.printStackTrace();
	}
}

public static int get_unit_id_by_product(String give_pd_name){
	Connection obj=Database.getconnection();
	
	String comnd="SELECT `unit_id` FROM `products` WHERE Name=?";
	
	int un_id=0;
	
	try{
		PreparedStatement ps=obj.prepareStatement(comnd);
		ps.setString(1,give_pd_name);
		ResultSet rs=ps.executeQuery();
		
		while(rs.next()){
			un_id=rs.getInt("unit_id");	
		}
		
		
	}
	catch(Exception e){
		
	}
	
	return un_id;
}

}
