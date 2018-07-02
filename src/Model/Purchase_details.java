package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import View.All_panel.Create_Purchase;
import net.proteanit.sql.DbUtils;

public class Purchase_details {
	private int mastr_id;
	private ArrayList <Integer>p_id=new ArrayList<>();
	private ArrayList <Integer>qun=new ArrayList<>();
	private ArrayList <Integer>bp=new ArrayList<>();
	private ArrayList <Integer>tp=new ArrayList<>();
	private ArrayList <Integer>sp=new ArrayList<>();
	
	public void prepare_ara_master(int master_id, ArrayList<Integer> p_id2, ArrayList<Integer> qun2, ArrayList<Integer> bp2, ArrayList<Integer> tp2, ArrayList<Integer> sp2){
		this.mastr_id=master_id;
		this.p_id=p_id2;
		this.qun=qun2;
		this.bp=bp2;
		this.tp=tp2;
		this.sp=sp2;
		
	}
	
	public static void temp_to_Purchase_details(){
		Connection is=Database.getconnection();
		

		
		String command="INSERT INTO purchase_details SELECT * FROM temp";
		try{
			PreparedStatement ps=is.prepareStatement(command);
			ResultSet rs=ps.executeQuery();
			
			Create_Purchase.table.setModel(DbUtils.resultSetToTableModel(rs));
		}
		catch(Exception x){
			x.printStackTrace();
		}

}
	public void snd_to_db_purchase_details(){
		Connection is=Database.getconnection();
		
		String command="INSERT INTO `purchase_details`(`master_id`, `Product_id`, `Quantity`, `Buy_price`, `Total_Price`, `Sell_price`) VALUES (?,?,?,?,?,?)";
		
		try{
			for(int i=0;i<p_id.size();i++){
				PreparedStatement ps=is.prepareStatement(command);
				ps.setInt(1, this.mastr_id);
				ps.setInt(2, this.p_id.get(i));
				ps.setInt(3, this.qun.get(i));
				ps.setInt(4, this.bp.get(i));
				ps.setInt(5, this.tp.get(i));
				ps.setInt(6, this.sp.get(i));
				
				
				ps.execute();
			}
			
		}
		catch(Exception x){
			x.printStackTrace();
		}
	}

}
