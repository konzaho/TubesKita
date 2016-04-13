/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/*import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;*/
import Model.Akun;
import java.util.ArrayList;

/**
 *
 * @author muham
 */
public abstract class Media implements java.io.Serializable {
    private double size;
    private ArrayList<Akun> tagged = new ArrayList();
    private int numAk=0;
    private int idMedia;
    private String nama;
    
    public Media (int idMedia, String nama, double size) {
        this.nama = nama;
        this.idMedia = idMedia;
        this.size = size;
    }

    public Media(String nama, double size) {
        this.size = size;
        this.nama = nama;
    }

    public void setNumAk(int numAk) {
        this.numAk = numAk;
    }

    public void setIdMedia(int idMedia) {
        this.idMedia = idMedia;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getNumAk() {
        return numAk;
    }

    public int getIdMedia() {
        return idMedia;
    }

    public String getNama() {
        return nama;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }
    
    public void tagPerson (Akun p) {
        //loadTag();
        tagged.add(p);
        //savedataTag(tagged, "tag.ser");
    }
    
    public void removeTag (int i) {
        tagged.remove(i);
        //savedataTag(tagged, "tag.ser");
    }
    
    public Akun getPersonTag (int i) {
        return tagged.get(i);
    }
    
    public int sizeTag() {
        return tagged.size();
    }
    
    public boolean cekTag() {
        //loadTag();
        return tagged.isEmpty();
    }
    
   /* public void loadTag() {
        Path path = Paths.get("D:/My Programs/Belajar java/Tubes/TubesKita/AplikasiMediaSharing/tag.ser");//ganti dengan folder project
        if (Files.exists(path)) {
            //System.out.println("data loaded");
            ArrayList<Akun> obj = loaddataTag("tag.ser");
            tagged =  obj;
        }
    }
    
    public void savedataTag (ArrayList<Akun> a,String name) {
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
    
    public ArrayList<Akun> loaddataTag (String nama) {
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
    
    
}
