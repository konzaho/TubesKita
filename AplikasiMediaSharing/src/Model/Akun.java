/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

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
    private String namaDepan,namaBelakang,username,password,tempatLahir,tanggalLahir,email;
    private int idAkun;
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

    public Akun(int idAkun, String username, String namaDepan, String namaBelakang,  String tempatLahir, String tanggalLahir, String email, String password) {
        this.namaDepan = namaDepan;
        this.namaBelakang = namaBelakang;
        this.username = username;
        this.password = password;
        this.tempatLahir = tempatLahir;
        this.tanggalLahir = tanggalLahir;
        this.email = email;
        this.idAkun = idAkun;
    }

    public String getNamaDepan() {
        return namaDepan;
    }

    public String getNamaBelakang() {
        return namaBelakang;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getTempatLahir() {
        return tempatLahir;
    }

    public String getTanggalLahir() {
        return tanggalLahir;
    }

    public String getEmail() {
        return email;
    }

    public int getIdAkun() {
        return idAkun;
    }

    public ArrayList<Media> getMedia() {
        return media;
    }

    public ArrayList<Akun> getFriend() {
        return friend;
    }

    public void setNamaDepan(String namaDepan) {
        this.namaDepan = namaDepan;
    }

    public void setNamaBelakang(String namaBelakang) {
        this.namaBelakang = namaBelakang;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setTempatLahir(String tempatLahir) {
        this.tempatLahir = tempatLahir;
    }

    public void setTanggalLahir(String tanggalLahir) {
        this.tanggalLahir = tanggalLahir;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setIdAkun(int idAkun) {
        this.idAkun = idAkun;
    }

    public void setMedia(ArrayList<Media> media) {
        this.media = media;
    }

    public void setFriend(ArrayList<Akun> friend) {
        this.friend = friend;
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
