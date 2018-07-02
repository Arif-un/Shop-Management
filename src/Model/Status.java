package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Status {
public static ArrayList<String> return_status(){
		
		ArrayList<String> status=new ArrayList<>();
		Connection is=Database.getconnection();
		String command="SELECT * FROM status";
		
		try{
			PreparedStatement ps=is.prepareStatement(command);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				status.add(rs.getString("name")); 
			}
			
		}
		catch(Exception e){
			
		}
		return status;
	}

}
