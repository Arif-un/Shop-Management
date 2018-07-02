package Controller;

import Model.Products;
import Model.Product_category;
import Model.Unit_t;

public class Get_product {
	public Get_product(String nme,String p_cat,String p_unit,String p_st){
		
		int status;
		
		if(p_st.equals("Enable")){
			status=1;
		}
		else{
			status=0;
		}
		
		Product_category Product_category=new Product_category();
		
		int cat_id=Product_category.get_cat_id(p_cat);
		
		Unit_t unit_t=new Unit_t();
		
		int unit_id=Unit_t.get_unit_id(p_unit);
		
		Products p=new Products();
		p.prepare_for_send_product(nme, cat_id, unit_id, status);
		
		p.snd_to_db_product();
		
		
		
		
	}

}
