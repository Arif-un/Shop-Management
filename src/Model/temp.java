package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import View.All_panel.Create_Purchase;
import View.All_panel.Units;
import net.proteanit.sql.DbUtils;

public class temp {
	
	//private String date;
	//private String vn;
	//private int cate_id;
	private int pdt_id;
	private int qun;
	//private int unit;
	private int buy;
	private int total_p;
	private int sell;
	
	private int id;
	//private String dat;
	//private String vnd;
	//private int cat_id;
	private int pd_id;
	private int qn;
	//private int unit_id;
	private int by;
	private int total;
	private int ssel;
	
	
	
	public void prepare_for_snd_tmp(int pd_id, int qnt, int buy_p,int total_price, int sell_p){
		
		//this.date=dat;
		//this.vn=vendor_n;
		//this.cate_id=cat_id;
		this.pdt_id=pd_id;
		this.qun=qnt;
		//this.unit=unit;
		this.buy=buy_p;
		this.total_p=total_price;
		this.sell=sell_p;
	}
	
	public void snd_to_db_purchase(){
		Connection is=Database.getconnection();
		
		String command="INSERT INTO `temp`(`Product_id`, `Quantity`, `Buy_price`, `Total_Price`, `Sell_price`) VALUES (?,?,?,?,?)";
		
		try{
			PreparedStatement ps=is.prepareStatement(command);
			ps.setInt(1, this.pdt_id);
			ps.setInt(2, this.qun);
			ps.setInt(3, this.buy);
			ps.setInt(4, this.total_p);
			ps.setInt(5, this.sell);
			
			ps.execute();
		}
		catch(Exception x){
			x.printStackTrace();
		}
	}
	
	public static void load(){
		Connection is=Database.getconnection();
		
		//String command="SELECT a.id,a.Date,a.Vendor_Name,c.Name as Category,d.Name as Product,a.Quantity,f.Name as Unit,a.Buy_price,a.Sell_price FROM temp a,product_catagory c,products d,unit f WHERE a.Category_id=c.id AND a.Product_id=d.id AND a.q_unit_id=f.id ORDER BY `a`.`id` ASC ";
		//String command="SELECT a.id,a.Date,a.Vendor_Name,c.Name as Category,d.Name as Product,a.Quantity,a.Buy_price,a.Sell_price FROM temp a,product_catagory c,products d WHERE a.Category_id=c.id AND a.Product_id=d.id ORDER BY `a`.`id` ASC";
		
		
		String command="SELECT a.Name as Product,b.Quantity,b.Buy_Price,b.Total_Price,b.Sell_price FROM products a,temp b WHERE a.id=b.Product_id";
		try{
			PreparedStatement ps=is.prepareStatement(command);
			ResultSet rs=ps.executeQuery();
			
			Create_Purchase.table.setModel(DbUtils.resultSetToTableModel(rs));
		}
		catch(Exception x){
			x.printStackTrace();
		}

}


	public void prepare_update_puchase(int id_n, int pd_id2, int quan, int bp, int sp, int total2){
		this.id=id_n;
		//this.dat=dat2;
		//this.vnd=vendor;
		//this.cat_id=categ_id;
		this.pd_id=pd_id2;
		this.qn=quan;
		//this.unit_id=unit_id2;
		this.by=bp;
		this.ssel=sp;
		this.total=total2;
		
	}
	
	public void snd_to_db_update_purchase(){
		Connection is=Database.getconnection();
		
		//String command="UPDATE `temp` SET `Date`=?,`Vendor_name`=?,`Category_id`=?,`Product_id`=?,`Quantity`=?,`Buy_price`=?,`Sell_price`=? WHERE id=?";
		//String command="UPDATE `temp` SET `Date`=?,`Vendor_name`=?,`Category_id`=?,`Product_id`=?,`Quantity`=?,`q_unit_id`=?,`Buy_price`=?,`Sell_price`=? WHERE id=?";
		String command="UPDATE `temp` SET ``Product_id`=?,`Quantity`=?,`Buy_price`=?,`Total_Price`=?,`Sell_price`=? WHERE id=?";
		try{
			PreparedStatement ps=is.prepareStatement(command);
		
		
		
			ps.setInt(1, this.pd_id);
			ps.setInt(2, this.qn);
		
			ps.setInt(3, this.by);
			ps.setInt(4,total);
			ps.setInt(5, this.ssel);
			ps.setInt(6, this.id);
			
			ps.execute();
		}
		catch(Exception x){
			x.printStackTrace();
		}
	}
	
	public void delete_temp(int id2){
		Connection is=Database.getconnection();
		
		String command="DELETE FROM `temp` WHERE id=?";
		
		try{
			PreparedStatement ps=is.prepareStatement(command);
			ps.setInt(1,id2);
			
			ps.execute();
		}
		catch(Exception x){
			x.printStackTrace();
		}
	}
	
	public static int get_id_by_pd_id(int PD_id){
		Connection is=Database.getconnection();
		
		String command="SELECT id FROM `temp` WHERE Product_id=?";
		int id=0;
		try{
			PreparedStatement ps=is.prepareStatement(command);
			ps.setInt(1,PD_id);
			
			ps.execute();
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				id=rs.getInt("id");
			}
		}
		catch(Exception x){
			x.printStackTrace();
		}
		return id;
	}
	
	public static void truncate_temp(){
		Connection is=Database.getconnection();
		
		String command="TRUNCATE TABLE `temp`";
		
		try{
			PreparedStatement ps=is.prepareStatement(command);
			
			ps.execute();
		}
		catch(Exception x){
			x.printStackTrace();
		}
	}
	
	public static int get_total(){
		Connection obj=Database.getconnection();
		
		String comnd="SELECT SUM(Total_Price) FROM temp";
		
		int get_total=0;
		
		try{
			PreparedStatement ps=obj.prepareStatement(comnd);
			
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()){
				get_total=rs.getInt("SUM(Total_Price)");
			}
			
			
		}
		catch(Exception e){
			
		}
		
		return get_total;
	}
	
	public static int get_id_by_pdt(String give_pd_name){
		Connection obj=Database.getconnection();
		
		String comnd="SELECT id FROM products WHERE Name=?";
		
		int pd_id=0;
		
		try{
			PreparedStatement ps=obj.prepareStatement(comnd);
			ps.setString(1,give_pd_name);
			ps.execute();
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()){
				pd_id=rs.getInt("id");	
			}
			
			
		}
		catch(Exception e){
			
		}
		
		return pd_id;
	}

	public static int ck_existing_pdt(int product_id){
		Connection obj=Database.getconnection();
		
		String comnd="SELECT Product_id FROM `temp` WHERE Product_id=?";
		
		int get_pdt_id=0;
		
		try{
			PreparedStatement ps=obj.prepareStatement(comnd);
            ps.setInt(1,product_id);
			
			ps.execute();
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()){
				get_pdt_id=rs.getInt("Product_id");
			}
			
			
		}
		catch(Exception e){
			
		}
		
		return get_pdt_id;
	}


	public static ArrayList<Integer> all_pd_tmp(){
		Connection obj=Database.getconnection();
		
		ArrayList<Integer>product_id=new ArrayList<>();

		
		String comnd="SELECT * FROM temp";
		
		
		
		try{
			PreparedStatement ps=obj.prepareStatement(comnd);
			
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()){
					
				product_id.add(rs.getInt("Product_id"));

			}
			
			
		}
		catch(Exception e){
			
		}
		
		return product_id;
	}
	
	public static ArrayList<Integer>all_quan_tmp(){
		Connection obj=Database.getconnection();

		ArrayList<Integer>quantity=new ArrayList<>();

		
		String comnd="SELECT * FROM temp";
		
		try{
			PreparedStatement ps=obj.prepareStatement(comnd);
			
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()){

				quantity.add(rs.getInt("Quantity"));

			}
			
			
		}
		catch(Exception e){
			
		}
		
		return quantity;
	}
	
	public static ArrayList<Integer>get_all_bp_temp(){
		Connection obj=Database.getconnection();
		

		ArrayList<Integer>buy_price=new ArrayList<>();

		
		String comnd="SELECT * FROM temp";
		
		
		
		try{
			PreparedStatement ps=obj.prepareStatement(comnd);
			
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()){
					

				buy_price.add(rs.getInt("Buy_price"));

			}
			
			
		}
		catch(Exception e){
			
		}
		
		return buy_price;
	}
	
	public static ArrayList<Integer>get_all_total_temp(){
		Connection obj=Database.getconnection();
		

		ArrayList<Integer>total=new ArrayList<>();

		
		String comnd="SELECT * FROM temp";
		
		
		
		try{
			PreparedStatement ps=obj.prepareStatement(comnd);
			
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()){
					
				total.add(rs.getInt("Total_Price"));

			}
			
			
		}
		catch(Exception e){
			
		}
		
		return total;
	}
	
	public static ArrayList<Integer>get_all_sell_temp(){
		Connection obj=Database.getconnection();
		ArrayList<Integer>sell=new ArrayList<>();
		
		String comnd="SELECT * FROM temp";
		
		
		
		try{
			PreparedStatement ps=obj.prepareStatement(comnd);
			
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()){

				sell.add(rs.getInt("Sell_price"));
			}
			
			
		}
		catch(Exception e){
			
		}
		
		return sell;
	}
}
