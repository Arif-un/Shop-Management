package Controller;

import javax.swing.JOptionPane;

import Model.Login_Admin;
import Model.Login_Employee;
import Model.Login_Manager;
import View.Dashboard_JFrm;

public class Login_REG_ctrl {

	public Login_REG_ctrl(String un, String ps,String rol) {
		//Employee
		if(rol.equals("Employee")){
			
			
		}
		
		//MAnager
		if(rol.equals("Manager")){
			
			
		}
		
		//Admin
		if(rol.equals("Admin")){
			Login_Admin Login_m=new Login_Admin();
			Login_m.prepare_admin_data(un, ps,rol);
			Login_m.admin_data_insert();
			
			
		}
		
		
		
		
	}

}
