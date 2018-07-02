package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Login_Manager {
	
	public static String mngr_data_chek(String give_username,String give_password, String give_rol){
		Connection obj=Database.getconnection();
		
		String comnd="SELECT `username`, `password` FROM `login_manager` WHERE username=? AND password=? AND role=?";
		
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
	
	public static String username_exist_mngr(String give_username){
		Connection obj=Database.getconnection();
		
		String comnd="SELECT username FROM login_manager WHERE username=?";
		
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
