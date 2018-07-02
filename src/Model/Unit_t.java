package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import View.All_panel.Add_category;
import View.All_panel.Units;
import net.proteanit.sql.DbUtils;

public class Unit_t {
	private String snd_name;
	private int snd_st;
	
	private String u_name;
	private int u_st;
	private int id;
	
	public void prepare_for_send_unit(String send_name,int send_status){
		
		this.snd_name=send_name;
		this.snd_st=send_status;
		
	}
	public void snd_to_db_unit(){
		Connection is=Database.getconnection();
		
		String command="INSERT INTO `unit`(`Name`, `Status`) VALUES (?,?)";
		
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
	
	public void load(){
		Connection is=Database.getconnection();
		
		String command="SELECT name ,(CASE status WHEN 1 THEN 'Available' ELSE 'Not Available' END) as Status FROM `unit`";
		
		try{
			PreparedStatement ps=is.prepareStatement(command);
			ResultSet rs=ps.executeQuery();
			Units.table.setModel(DbUtils.resultSetToTableModel(rs));
		}
		catch(Exception x){
			x.printStackTrace();
		}
		
	}
	
	public ArrayList<String> return_unit(){
		
		ArrayList<String> allunit=new ArrayList<>();
		Connection is=Database.getconnection();
		String command="SELECT * FROM unit";
		
		try{
			PreparedStatement ps=is.prepareStatement(command);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				allunit.add(rs.getString("Name")); 
			}
			
		}
		catch(Exception e){
			
		}
		return allunit;
	}
	
	public static int get_unit_id(String give_unit_name){
		Connection obj=Database.getconnection();
		
		String comnd="SELECT id FROM unit WHERE Name=?";
		
		int unit_id=0;
		
		try{
			PreparedStatement ps=obj.prepareStatement(comnd);
			ps.setString(1,give_unit_name);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()){
				unit_id=rs.getInt("id");
			}
		}
		catch(Exception e){
			
		}
		
		return unit_id;
	}
	
	public void prepare_for_Update_unit(String update_name,int update_status,int id){
		
		this.u_name=update_name;
		this.u_st=update_status;
		this.id=id;
		
	}
	public void send_update_unit(){
		Connection is=Database.getconnection();
		
		String command="UPDATE `unit` SET `Name`=?,`Status`=? WHERE id=?";
		
		try{
			PreparedStatement ps=is.prepareStatement(command);
			ps.setString(1, this.u_name);
			ps.setInt(2, this.u_st);
			ps.setInt(3, this.id);
			ps.execute();
		}
		catch(Exception x){
			x.printStackTrace();
		}
	}

	
	public void delete_unit(int id2){
		Connection is=Database.getconnection();
		
		String command="DELETE FROM `unit` WHERE id=?";
		
		try{
			PreparedStatement ps=is.prepareStatement(command);
			ps.setInt(1,id2);
			
			ps.execute();
		}
		catch(Exception x){
			x.printStackTrace();
		}
	}
	
	public static String get_unit_name(int give_unit_id){
		Connection obj=Database.getconnection();
		
		String comnd="SELECT`Name` FROM `unit` WHERE id=?";
		
		String unit_name = null;
		
		try{
			PreparedStatement ps=obj.prepareStatement(comnd);
			ps.setInt(1,give_unit_id);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()){
				unit_name=rs.getString("Name");
			}
			
			
		}
		catch(Exception e){
			
		}
		
		return unit_name;
	}
}
