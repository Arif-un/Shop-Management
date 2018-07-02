package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Login_Admin {
	private String user;
	private String pss;
	private String rl;
	
	public static String admin_data_chek(String give_username,String give_password, String give_rol){
		Connection obj=Database.getconnection();
		
		String comnd="SELECT `username`, `password` FROM `login_admin` WHERE username=? AND password=? AND role=?";
		
		String user = null;
		String pass;
		
		try{
			PreparedStatement ps=obj.prepareStatement(comnd);
			ps.setString(1,give_username);
			ps.setString(2,give_password);
			ps.setString(3,give_rol);
			ps.execute();
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()){
				user=rs.getString("username");
				pass=rs.getString("password");
				
			}
			
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		return user;
	}
	
	public void prepare_admin_data(String give_username,String give_password, String give_rol){

		this.user=give_username;
		this.pss=give_password;
		this.rl=give_rol;
	}
	
	public void admin_data_insert(){
		Connection obj=Database.getconnection();
		
		String comnd="INSERT INTO `login_admin`(`username`, `password`, `role`) VALUES (?,?,?)";
		
		try{
			PreparedStatement ps=obj.prepareStatement(comnd);
			ps.setString(1,this.user);
			ps.setString(2,this.pss);
			ps.setString(3,this.rl);
			ps.execute();
		}
		catch(Exception e){
			e.printStackTrace();
		}

	}
	
	public static String username_exist_admin(String give_username){
		Connection obj=Database.getconnection();
		
		String comnd="SELECT username FROM login_admin WHERE username=?";
		
		String user = null;

		
		try{
			PreparedStatement ps=obj.prepareStatement(comnd);
			ps.setString(1,give_username);

			ps.execute();
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()){
				user=rs.getString("username");			
			}
	
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		return user;
	}
	

}
