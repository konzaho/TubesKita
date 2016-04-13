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
    
    public ResultSet loadSemuaAkunDB(){
        String query = "Select * from akun";
        rs = getData(query);
        return rs;
    } 
    
    public ResultSet loadSemuaMediaDB(int id){
        String query = "Select * from media where id_user='" + id + "'";
        rs = getData(query);
        return rs;
    }
    
    public ResultSet loadSemuaFriendDB(int id){
        String query = "select * from friend where id_user'" + id +"'";
        rs = getData(query);
        return rs;
    }
    
    public void insertAkun(Akun a){
        String query = "insert into user(username,first_name,last_name,tempat_lahir,tanggal_lahir,email,password) values("
                        + "'" + a.getUsername() +"'"
                        + ",'" + a.getNamaDepan() + "'"
                        + ",'" + a.getNamaBelakang() + "'"
                        + ",'" + a.getTempatLahir() + "'"
                        + ",'" + a.getTanggalLahir() + "'"
                        + ",'" + a.getEmail() + "'"
                        + ",'" + a.getPassword() + "')";
        execute(query);
    }
    
    public void updateAkun(Akun a){
        String query = "update user set" +
                       "username ='" + a.getUsername() + "',"  +
                       "first_name ='" + a.getNamaDepan() + "'," +
                       "last_name ='" + a.getNamaDepan() + "'," +
                       "tempat_lahir ='" + a.getTempatLahir() + "'," +
                       "tanggal_lahir ='" + a.getTanggalLahir() + "'," +
                       "email ='" + a.getEmail() + "'," +
                       "password ='" +a.getPassword() + "'," +
                       "where id_user ='" + a.getIdAkun();
        execute(query);
    }
    
}
