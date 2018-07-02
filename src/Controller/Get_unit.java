package Controller;

import Model.Unit_t;

public class Get_unit {
	public Get_unit(String a,String b){
int status;
		
		if(b.equals("Enable")){
			status=1;
		}
		else{
			status=0;
		}
		
		Unit_t is=new Unit_t();
		is.prepare_for_send_unit(a,status);
		is.snd_to_db_unit();
		
		
	}

}
