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
import Model.Akun;
import java.sql.Connection;
import java.sql.DriverAction;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Database {
    private Statement stmt = null;
    private Connection con = null;
    private ResultSet rs = null;
    private String dbUser = "root";
    private String password = "";
    private ArrayList<Akun> listAkun = new ArrayList<Akun>();
    
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
    
    public ArrayList<Akun> initiateListAkun(){
        String query = "Select * from akun";
        rs = getData(query);
        try {
            while(rs.next()){
                Akun akun = new Akun(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8));
                listAkun.add(akun);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listAkun;
    } 
    
    public ResultSet getData(String query){
        try {
            rs = stmt.executeQuery(query);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null," "+ ex.getMessage(), "Can't Get Data", JOptionPane.WARNING_MESSAGE);
        }
        return rs;
    }
    
    public void execute(String query){
        try {
            stmt.execute(query);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null," "+ ex.getMessage(), "Can't Execute Query", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public int loginDatabase(String username, String password){
        if(listAkun.contains(username));
        String query = "Select count(*) from user where username='"+username+"' and password='"+password+"'";
        rs = getData(query);
        try {
            if(!rs.next()){
                return 0;
            }
            while(rs.next()){
                
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null," "+ ex.getMessage(), "Login System Fail", JOptionPane.WARNING_MESSAGE);
        }
        return 0;
        
    }
    
}
