package Backup_Restore;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import Model.Database;

public class BackUp
{

    private static ResultSet res;
    private static Connection con;
    private Statement st;
    private int BUFFER = 99999;
    public String getData(String host, String port, String user, String password, String db) {
       // String Mysqlpath = getMysqlBinPath(user, password, db);
        
        String Mysqlpath ="E:/xampp/mysql/bin/";
       /* try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.print("yaha dekho");
        }*/
        try {
        	con=Database.getconnection();
        	
            //con = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + db, user, password);
            st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            //e.printStackTrace();
        }


        
        Process run = null;
        try {
           // System.out.println(Mysqlpath + "mysqldump --host=" + host + " --port=" + port + " --user=" + user + " --password=" + password + " --compact --complete-insert --extended-insert " + "--skip-comments --skip-triggers " + db);
            run = Runtime.getRuntime().exec(Mysqlpath + "mysqldump --host=" + host + " --port=" + port + " --user=" + user + " --password=" + password + "  " + "--skip-comments --skip-triggers " + db);
        } catch (IOException ex) {
            // Logger.getLogger(Backup.class.getName()).log(Level.SEVERE, null, ex);
        	JOptionPane.showMessageDialog(null, "Contact with F.F.I");
        }


        InputStream in = run.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        StringBuffer temp = new StringBuffer();
   

        int count;
        char[] cbuf = new char[BUFFER];
        try {
            while ((count = br.read(cbuf, 0, BUFFER)) != -1) {
                temp.append(cbuf, 0, count);
            }
        } catch (IOException ex) {
            Logger.getLogger(BackUp.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            br.close();
            in.close();
        } catch (IOException ex) {
            Logger.getLogger(BackUp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return temp.toString();
    }

// Mysql path is required to locate the bin folder inside it because it contains the Mysqldump which performs a //main role while taking backup.
/*Function to find MySql Path*/
    public  String getMysqlBinPath(String user, String password, String db) {
        /*try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception e) {
            e.printStackTrace();
            
        }*/
        try {
        	con=Database.getconnection();
          //  con = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + db, user, password);
            st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        } catch (Exception e) {
        	JOptionPane.showMessageDialog(null, "Contact with F.F.I");
           /* System.out.print("I am here yaaar");
            e.printStackTrace();*/
        }


        String a = "";

        try {
            res = st.executeQuery("select @@basedir");
            while (res.next()) {
                a = res.getString(1);
            }
        } catch (Exception eee) {
            eee.printStackTrace();
        }
        a = a + "bin\\";
    //    System.err.println("Mysql path is :" + a);
        return a;
    }
}