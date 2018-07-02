package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class Sale_master {
	private String date;
	private String vendr;
	private int total;
	private int paid;
	private int due;
	private int status;




public  void prepare_sale_master(String dat, String vn, int t_am, int p_am, int due2, int st){
	this.date=dat;
	this.vendr=vn;
	this.total=t_am;
	this.paid=p_am;
	this.due=due2;
	this.status=st;
}

public void master_insert(){
	Connection is=Database.getconnection();
	
	String command="INSERT INTO `sale_master`(`date`, `vendor_name`, `total_amount`, `pay`, `Due`, `status`) VALUES (?,?,?,?,?,?)";
	
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

}