package Controller;

import Model.Product_category;

public class Get_Category_data {
	
	public Get_Category_data(String get_cat_name,String get_catST){
		int status;
		
		if(get_catST.equals("Enable")){
			status=1;
		}
		else{
			status=0;
		}
		
		Product_category Product_category=new Product_category();
		Product_category.prepare_for_send_category(get_cat_name, status);
		Product_category.snd_to_db_cat();
		
	}
	
	

}
