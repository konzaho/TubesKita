    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

/**
 *
 * @author Fiqih
 */
import java.sql.Connection;
import java.sql.DriverAction;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class Database {
    private Statement stmt = null;
    private Connection con = null;
    private ResultSet rs = null;
    private String dbUser = "root";
    private String password = "";
    
    public void connection(){
        try {
            Class.forName("org.gjt.mm.mysql.Driver");
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null," " + ex.getMessage(), "JDBC Error", JOptionPane.WARNING_MESSAGE);
        }
        try{
        con = DriverManager.getConnection("JDBC:mysql://localhost/media_sharing",dbUser,password);
        } catch (Exception e){
            JOptionPane.showMessageDialog(null," "+ e.getMessage(), "Connection Error", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    
}
