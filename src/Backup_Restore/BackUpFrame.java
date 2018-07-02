package Backup_Restore;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Backup_Restore.BackUp;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.zip.Deflater;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;


import javax.swing.JOptionPane;

import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class BackUpFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	
	public static String getBackUpPath() {

        String backUpPath = "";
        JFileChooser fc = null;
        if (fc == null) {
               fc = new JFileChooser();
               fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
               fc.setAcceptAllFileFilterUsed(false);
       }
       int returnVal = fc.showDialog(null, "Open");
       if (returnVal == JFileChooser.APPROVE_OPTION) {
           File file = fc.getSelectedFile();
           backUpPath = file.getAbsolutePath();
       }
      return backUpPath;
}
	
	public BackUpFrame() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(10, 79, 313, 27);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnBrows = new JButton("Click To BackUP");
		btnBrows.setFont(new Font("SansSerif", Font.PLAIN, 14));
		btnBrows.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String backuppath=textField.getText();
				   String Database ="";
				   String Password ="";
				   String user="root";
				   BackUp b = new BackUp();
				   try
				  {
					   Date todays=new Date();
					   DateFormat dfm=new SimpleDateFormat("YYYY-MM-dd");
						
						
						String datemysql=dfm.format(todays);
					   
					  
				       byte[] data = b.getData("localhost", "3306", user,   Password, Database).getBytes();
				       File filedst = new File(backuppath+"\\"+Database+datemysql+".zip");
				       FileOutputStream dest = new FileOutputStream(filedst);
				      // Date todays=new Date();
				       ZipOutputStream zip = new ZipOutputStream(
				       new BufferedOutputStream(dest));
				       zip.setMethod(ZipOutputStream.DEFLATED);
				       zip.setLevel(Deflater.BEST_COMPRESSION);
				       zip.putNextEntry(new ZipEntry(todays+"sealab.sql"));
				       zip.write(data);
				       zip.close();
				       dest.close();
				   
				      JOptionPane.showMessageDialog(null, "Back Up Successfully."+"\n"+"For Database: "+Database+"\n         "+"On Dated: "+todays,"Database BackUp Wizard",JOptionPane.INFORMATION_MESSAGE);
				      
				   }catch (Exception ex){
				    JOptionPane.showMessageDialog(null, "Back Up Failed."+"\n"+"For Database: "+Database+"\n "+"On     Dated: ","Database BackUp Wizard",JOptionPane.INFORMATION_MESSAGE);
				    ex.printStackTrace();
				  }
			}
		});
		btnBrows.setBounds(119, 135, 144, 27);
		contentPane.add(btnBrows);
		
		JButton btnChoose = new JButton("Browse");
		btnChoose.setFont(new Font("SansSerif", Font.PLAIN, 14));
		btnChoose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				textField.setText(getBackUpPath());
			}
		});
		btnChoose.setBounds(331, 79, 93, 27);
		contentPane.add(btnChoose);
		
	}
}
