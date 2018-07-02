package Controller;

import Model.Product_category;

public class Update_cat {
	public Update_cat(String cat_name, String st, int id){
int status;
		
		if(st.equals("Enable")){
			status=1;
		}
		else{
			status=0;
		}
		
		Product_category Product_category=new Product_category();
		Product_category.prepare_for_UPDATE_category(cat_name, status, id);
//System.out.println(cat_name+id);
		Product_category.update_cat();
	}

}
