package Controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import Model.Purchase_master;
import Model.Sale_master;
import View.All_panel.Create_Purchase;
import View.All_panel.Create_Sale;

public class Sale_master_contrl {

	public Sale_master_contrl(Date date, String vendor, String tam, String paid, String due) {
		
		SimpleDateFormat is=new SimpleDateFormat("YYYY-MM-dd");
		String dat=is.format(date);
		String vn=vendor;
		int t_am = Integer.parseInt(tam);
		int p_am = Integer.parseInt(paid);
		int d_am = Integer.parseInt(due);
		int st=0;
		
		if(Create_Sale.chckbxBalanced.isSelected()){
			st=0;
		}
		else if(paid.equals(0)){
			st=0;
		}
		else{
			st=1;
		}
		
		Sale_master Sale_master=new Sale_master();
		Sale_master.prepare_sale_master(dat,vn,t_am,p_am,d_am,st);
		Sale_master.master_insert();
		
	}
	

}
