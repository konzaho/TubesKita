/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasimediasharing;

/*import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;*/
import java.util.ArrayList;
//import java.nio.file.*;
/**
 *
 * @author muham
 */
public class Akun implements java.io.Serializable{
    private String nama,pass,username;
    private String tempattanggallahir;
    private ArrayList<Media> media = new ArrayList();
    private ArrayList<Akun> friend = new ArrayList();
    
    //mengambil data dari database friend
    /*public void loadFriend() {
        Path path = Paths.get("D:/My Programs/Belajar java/Tubes/TubesKita/AplikasiMediaSharing/friend.ser");//ganti dengan folder project
        if (Files.exists(path)) {
            //System.out.println("data loaded");
            ArrayList<Akun> obj = loaddataFriend("friend.ser");
            friend =  obj;
        }
    }
    
    //mengambil data dari database media
    public void loadMedia() {
        Path path = Paths.get("D:/My Programs/Belajar java/Tubes/TubesKita/AplikasiMediaSharing/media.ser");//ganti dengan folder project
        if (Files.exists(path)) {
            //System.out.println("data loaded");
            ArrayList<Media> obj = loaddataMedia("media.ser");
            media =  obj;
        }
    }
    
    public void savedataMedia (ArrayList<Media> a,String name) {
        try {
            FileOutputStream fout = new FileOutputStream(name);
            ObjectOutputStream oout = new ObjectOutputStream(fout);
            oout.writeObject(a);
            oout.close();
            fout.close();
        } catch (Exception e) {
            System.out.println("terjadi exception");
        }
    }
    
    public ArrayList<Media> loaddataMedia (String nama) {
        ArrayList<Media> obj = new ArrayList();
        try {
            FileInputStream fin = new FileInputStream(nama);
            ObjectInputStream oin = new ObjectInputStream(fin);
            obj= (ArrayList<Media>)oin.readObject();
            oin.close();
            fin.close();
        } catch (Exception e) {
            System.out.println("terjadi exception");
        }
        return obj;
    }
    
    public void savedataFriend (ArrayList<Akun> a,String name) {
        try {
            FileOutputStream fout = new FileOutputStream(name);
            ObjectOutputStream oout = new ObjectOutputStream(fout);
            oout.writeObject(a);
            oout.close();
            fout.close();
        } catch (Exception e) {
            System.out.println("terjadi exception");
        }
    }
    
    public ArrayList<Akun> loaddataFriend (String nama) {
        ArrayList<Akun> obj = new ArrayList();
        try {
            FileInputStream fin = new FileInputStream(nama);
            ObjectInputStream oin = new ObjectInputStream(fin);
            obj= (ArrayList<Akun>)oin.readObject();
            oin.close();
            fin.close();
        } catch (Exception e) {
            System.out.println("terjadi exception");
        }
        return obj;
    }*/
    
    public Akun(String nama, String pass, String username, String tempattanggallahir) {
        this.nama = nama;
        this.pass = pass;
        this.username = username;
        this.tempattanggallahir = tempattanggallahir;
    }
    
    public Akun () {
        
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTempattanggallahir() {
        return tempattanggallahir;
    }

    public void setTempattanggallahir(String tempattanggallahir) {
        this.tempattanggallahir = tempattanggallahir;
    }
    
    public void createMediaFoto (double size,String nama) {
        media.add(new Foto(size,nama));
        //savedataMedia(media, "media.ser");
    }
    
    public void createMediaVideo (double size,String nama) {
        media.add(new Video(size,nama));
        //savedataMedia(media, "media.ser");
    }
    
    public void followFriend (Akun p) {
        friend.add(p);
        //savedataFriend(friend,"friend.ser");
    }
    
    public Media getMedia (int i) {
        return media.get(i);
    }
    
    public void removeMedia (int i) {
        media.remove(i);
        //savedataMedia(media, "media.ser");
    }
    
    public Akun getPerson (int i) {
        return friend.get(i);
    }
    
    public void removePerson (int i) {
        friend.remove(i);
        //savedataFriend(friend,"friend.ser");
    }
    
    public boolean cekMedia () {
        //loadMedia();
        return media.isEmpty();
    }
    public int sizeMedia() {
        return media.size();
    }
    
    public boolean cekFriend () {
        //loadFriend();
        return friend.isEmpty();
    }
    public int sizeFriend() {
        return friend.size();
    }
    
    public void editFoto (int i, String nama, double size) {
        Foto f = (Foto)getMedia(i);
        f.setNama(nama);
        getMedia(i).setSize(size);
        //savedataMedia(media, "media.ser");
    }
    
    public void editVideo (int i, String nama, double size) {
        Video f = (Video)getMedia(i);
        f.setNama(nama);
        getMedia(i).setSize(size);
        //savedataMedia(media, "media.ser");
    }
} 
