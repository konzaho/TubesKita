/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasimediasharing;

/*import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;*/
import java.util.ArrayList;

/**
 *
 * @author muham
 */
public abstract class Media implements java.io.Serializable {
    private double size;
    private ArrayList<Akun> tagged = new ArrayList();
    private int numAk=0;
    
    public Media (double size) {
        this.size = size;
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
