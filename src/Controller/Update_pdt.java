package Controller;

import Model.Product_category;
import Model.Products;
import Model.Unit_t;

public class Update_pdt {

	public Update_pdt(String pd_nme, String pd_c, String pd_un, String pd_st, int id) {
		int status;
		
		if(pd_st.equals("Enable")){
			status=1;
		}
		else{
			status=0;
		}
		
		
		String pdt_name=pd_nme;
		
		int pdt_cat=Product_category.get_cat_id(pd_c);
		int pdt_un=Unit_t.get_unit_id(pd_un);
		int st=status;
		
		Products Products=new Products();
		Products.prepare_for_update_product(pdt_name,pdt_cat,pdt_un,st,id);
		Products.snd_to_db_Upadate_product();
		
	}

}
