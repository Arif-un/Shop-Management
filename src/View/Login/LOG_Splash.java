package View.Login;

import java.awt.Color;
import java.awt.Font;
import java.awt.PageAttributes.ColorType;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.plaf.ColorChooserUI;

import com.thehowtotutorial.splashscreen.JSplash;

import View.Dashboard_JFrm;

import java.awt.Cursor;
import java.awt.Rectangle;
import java.awt.ComponentOrientation;
import java.awt.Dimension;

public class LOG_Splash {
	
public static void main(String[] args) throws InterruptedException {
		


		//java.net.URL imgURL = 
		JSplash j=new JSplash(LOG_Splash.class.getResource("/resource/splash.png"), true, true, true, "RF's Programme",null, Color.BLACK,new Color(6,6,31));

		j.splashOn();
		
		for(int i=0;i<100;i++){
			j.setProgress(i, "");
			Thread.sleep(50);
		}
		
		j.splashOff();
		Login_Jfrm log=new Login_Jfrm();
		log.main(null);

	
	}


}
