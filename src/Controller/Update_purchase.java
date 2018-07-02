package Controller;

import Model.Products;
import Model.temp;

public class Update_purchase {
	private static int idd;
	
	public static void get_id_from_table(int id) {
		// TODO Auto-generated method stub
		idd=id;
	}

	public Update_purchase(String pdt_nm, String qn, String buy_p, String sell_p) {
		
		int id_n=idd;
		int pd_id=temp.get_id_by_pdt(pdt_nm);
		int quan = Integer.parseInt(qn);
		int bp = Integer.parseInt(buy_p);
		int sp = Integer.parseInt(sell_p);
		int total=quan*bp;
		temp temp=new temp();
		temp.prepare_update_puchase(id_n,pd_id,quan,bp,sp,total);
		temp.snd_to_db_update_purchase();
	}

	
	

}
