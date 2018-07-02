package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import View.All_panel.Add_category;
import net.proteanit.sql.DbUtils;

public class Product_category {
	
	private String snd_name;
	private int snd_st;
	
	private String u_name;
	private int u_st;
	private int u_id;
	
	public void prepare_for_send_category(String send_name,int send_status){
		
		this.snd_name=send_name;
		this.snd_st=send_status;
		
	}
	public void snd_to_db_cat(){
		Connection is=Database.getconnection();
		
		String command="INSERT INTO `product_catagory`(`Name`, `Status`) VALUES (?,?)";
		
		try{
			PreparedStatement ps=is.prepareStatement(command);
			ps.setString(1, this.snd_name);
			ps.setInt(2, this.snd_st);
			ps.execute();
		}
		catch(Exception x){
			x.printStackTrace();
		}
	}
	
	public static void load(){
		Connection is=Database.getconnection();
		
		String command="SELECT name ,(CASE status WHEN 1 THEN 'Available' ELSE 'Not Available' END) as Status FROM `product_catagory`";
		
		try{
			PreparedStatement ps=is.prepareStatement(command);
			ResultSet rs=ps.executeQuery();
			Add_category.table.setModel(DbUtils.resultSetToTableModel(rs));
		}
		catch(Exception x){
			x.printStackTrace();
		}
		
	}
	
public static ArrayList<String> return_category(){
		
		ArrayList<String> all_cat=new ArrayList<>();
		Connection is=Database.getconnection();
		String command="SELECT * FROM product_catagory";
		
		try{
			PreparedStatement ps=is.prepareStatement(command);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				all_cat.add(rs.getString("Name")); 
			}
			
		}
		catch(Exception e){
			
		}
		return all_cat;
	}



public static int get_cat_id(String give_cat_name){
	Connection obj=Database.getconnection();
	
	String comnd="SELECT id FROM product_catagory WHERE Name=?";
	
	int cat_id=0;
	
	try{
		PreparedStatement ps=obj.prepareStatement(comnd);
		ps.setString(1,give_cat_name);
		ps.execute();
		ResultSet rs=ps.executeQuery();
		
		while(rs.next()){
			cat_id=rs.getInt("id");	
		}
		
		
	}
	catch(Exception e){
		
	}
	
	return cat_id;
}

public void prepare_for_UPDATE_category(String update_name,int update_status,int by_id){
	
	this.u_name=update_name;
	this.u_st=update_status;
	this.u_id=by_id;
	
}

public void update_cat(){
	Connection is=Database.getconnection();
	 
	String a=this.u_name;
	System.out.println(a);
	String command="UPDATE `product_catagory` SET `Name`= ?,`Status`= ? WHERE id= ?";
	
	try{
		PreparedStatement ps=is.prepareStatement(command);
		ps.setString(1, this.u_name);
		ps.setInt(2, this.u_st);
		ps.setInt(3, this.u_id);
		ps.execute();
	}
	catch(Exception x){
		x.printStackTrace();
	}
}


public static void delete_cat(int id){
	Connection is=Database.getconnection();
	 
	
	String command="DELETE FROM `product_catagory` WHERE id=?";
	
	try{
		PreparedStatement ps=is.prepareStatement(command);
		ps.setInt(1,id);
		ps.execute();
	}
	catch(Exception x){
		x.printStackTrace();
	}
}

}
