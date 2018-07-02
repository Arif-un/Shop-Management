package Controller;

import javax.swing.JOptionPane;

import Model.Login_Admin;
import Model.Login_Employee;
import Model.Login_Manager;
import View.Dashboard_JFrm;
import View.Login.Login_Jfrm;

public class Login_cntrl {

	public Login_cntrl(String un, String ps,String rol) {
		
		//Employee
		if(rol.equals("Employee")){
			Login_Employee Login_m=new Login_Employee();
			String result=Login_m.emp_data_chek(un, ps,rol);
			
			if(result==null){
				System.out.println("No Employee");
				JOptionPane.showMessageDialog(null, "Login Failed");
				
			}
			else{
				
				System.out.println("you are an employee");
				Dashboard_JFrm Dashboard_JFrm=new Dashboard_JFrm(rol);
				Dashboard_JFrm.setVisible(true);
				
				Login_Jfrm.frmLoginPanel.dispose();
				

				
				
				
				
			}
			
		}
		
		//MAnager
		if(rol.equals("Manager")){
			Login_Manager Login_m=new Login_Manager();
			String result=Login_m.mngr_data_chek(un, ps,rol);
			
			if(result==null){
				System.out.println("No Manger");
				JOptionPane.showMessageDialog(null, "Login Failed");
				
			}
			else{
				System.out.println("you are an manager");
				Dashboard_JFrm Dashboard_JFrm=new Dashboard_JFrm(rol);
				Dashboard_JFrm.setVisible(true);
				Login_Jfrm.frmLoginPanel.dispose();
			}
			
		}
		
		//Admin
		if(rol.equals("Admin")){
			Login_Admin Login_m=new Login_Admin();
			String result=Login_m.admin_data_chek(un, ps,rol);
			
			if(result==null){
				System.out.println("No Admin");
				JOptionPane.showMessageDialog(null, "Login Failed");
				
			}
			else{
				System.out.println("you are an admin");
				Dashboard_JFrm Dashboard_JFrm=new Dashboard_JFrm(rol);
				Dashboard_JFrm.setVisible(true);
				Login_Jfrm.frmLoginPanel.dispose();
			}
		}
		
		
		
		
	}

}
