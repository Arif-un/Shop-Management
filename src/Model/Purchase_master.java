package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Purchase_master {
	private String date;
	private String vendr;
	private int total;
	private int paid;
	private int due;
	private int status;




public  void prepare_purchase_master(String dat, String vn, int t_am, int p_am, int due2, int st){
	this.date=dat;
	this.vendr=vn;
	this.total=t_am;
	this.paid=p_am;
	this.due=due2;
	this.status=st;
}

public void master_insert(){

	Connection is=Database.getconnection();
	
	String command="INSERT INTO `Purchase_master`(`date`, `vendor_name`, `total_amount`, `pay`, `Due`, `status`) VALUES (?,?,?,?,?,?)";
	
	try{
		PreparedStatement ps=is.prepareStatement(command);
		ps.setString(1, this.date);
		ps.setString(2, this.vendr);
		ps.setInt(3, this.total);
		ps.setInt(4, this.paid);
		ps.setInt(5, this.due);
		ps.setInt(6, this.status);
		ps.execute();
	}
	catch(Exception x){
		x.printStackTrace();
	}
}

public static int get_lastMaster_id(){
	Connection obj=Database.getconnection();
	
	String comnd="SELECT id FROM `purchase_master` ORDER BY id DESC limit 1";
	
	int get_LastMaster_id=0;
	
	try{
		PreparedStatement ps=obj.prepareStatement(comnd);

		ResultSet rs=ps.executeQuery();
		
		while(rs.next()){
			get_LastMaster_id=rs.getInt("id");
		}
		
		
	}
	catch(Exception e){
		
	}
	
	return get_LastMaster_id;
}
}