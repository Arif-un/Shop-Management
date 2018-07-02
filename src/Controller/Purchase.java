package Controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import Model.Products;
import Model.Unit_t;
import Model.Product_category;
import Model.temp;

public class Purchase {
	public static void tocontroller(String pd_name, String qun, String buy, String sell){
		
		/*SimpleDateFormat is=new SimpleDateFormat("YYYY-MM-dd");
		String dat=is.format(date);
		//System.out.println(dat);
		String vendor_n=vendor;*/
		
		//int cat_id=Product_category.get_cat_id(cat_name);
		
		int pd_id=Products.get_pd_id(pd_name);
		
		int qnt = Integer.parseInt(qun);
		
		//int unit_id=Unit_t.get_unit_id(unit);
		//System.out.println(unit_id);
		
		int buy_p = Integer.parseInt(buy);
		
		int total_price=qnt*buy_p;
		
		int sell_p = Integer.parseInt(sell);
		System.out.println(buy_p);
		temp temp=new temp();
		temp.prepare_for_snd_tmp(pd_id,qnt,buy_p,total_price,sell_p);
		temp.snd_to_db_purchase();
		
	}

}
