
package Controller;
import Model.Unit_t;
public class Update_unit {
	

	public void Update_units(String unit, String un_st, int id) {
		// TODO Auto-generated constructor stub
        int status;
		
		if(un_st.equals("Enable")){
			status=1;
		}
		else{
			status=0;
		}
		
		Unit_t is=new Unit_t();
		is.prepare_for_Update_unit(unit, status, id);
		is.send_update_unit();
	}

	
	

}
