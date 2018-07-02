package Controller;

import java.util.ArrayList;

import Model.Purchase_details;
import Model.Purchase_master;
import Model.temp;

public class Purchase_details_cntrl {
	
	public Purchase_details_cntrl(){
		Purchase_master Purchase_master=new Purchase_master();
		int master_id=Purchase_master.get_lastMaster_id();
		
		ArrayList <Integer>p_id=new ArrayList<>();
		ArrayList <Integer>qun=new ArrayList<>();
		ArrayList <Integer>bp=new ArrayList<>();
		ArrayList <Integer>tp=new ArrayList<>();
		ArrayList <Integer>sp=new ArrayList<>();
		
		p_id=temp.all_pd_tmp();
		qun=temp.all_quan_tmp();
		bp=temp.get_all_bp_temp();
		tp=temp.get_all_total_temp();
		sp=temp.get_all_sell_temp();
				
		Purchase_details Purchase_details=new Purchase_details();
		Purchase_details.prepare_ara_master(master_id,p_id,qun,bp,tp,sp);
		Purchase_details.snd_to_db_purchase_details();
		
	}

}
