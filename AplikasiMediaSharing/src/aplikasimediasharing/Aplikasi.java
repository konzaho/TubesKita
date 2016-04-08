/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasimediasharing;
import java.util.ArrayList;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.*;
import java.util.Iterator;
/**
 *
 * @author muham
 */
public class Aplikasi {
    private ArrayList<Akun> akun = new ArrayList();
    boolean cek = false;
    public String userr;
    public int cF=0;
    
    public void loadfile() {
        String workingDir = System.getProperty("user.dir");
        Path path = Paths.get(workingDir+"/akun.ser");//ganti dengan folder project
        if (Files.exists(path)) {
            //System.out.println("data loaded");
            cek = true;
            ArrayList<Akun> obj = loaddata("akun.ser");
            akun =  obj;
        }
    }
    
    
    public void addAkun (String nama, String pass, String username, String tempattanggallahir) {
        boolean ceka = false;
        if (cek) {
            for (Akun p : akun) {
                if (username.equals(p.getUsername())) {
                    ceka=true;
                    break;
                }
            }
            if (ceka) {
                System.out.println("Username sudah ada di database tolong coba dengan yang lain");
            }
            else {
                akun.add(new Akun(nama,pass,username,tempattanggallahir));
                savedata(akun, "akun.ser");
            }
        }
        else {
            akun.add(new Akun(nama,pass,username,tempattanggallahir));
            savedata(akun, "akun.ser");
        }
    }
    
    public boolean cekAkun (String username) {
        boolean cekk = false;
        for (Akun p : akun) {
            if (username.equals(p.getUsername())) {
                cekk= true;    
            }
        }
        return cekk;
    }
    
    public int sizeAkun () {
        return akun.size();
    }
    
    public Akun getAkun (String user) {
        Akun t = new Akun();
        for (Akun p : akun) {
            if (p.getUsername().equals(user)) {
                t=p;
                break;
            }
        }
        return t;
    }
    
    public Akun getAkun (int i) {
        return akun.get(i);
    }
    
    public void deleteAkun (int i) {
        akun.remove(i);
    }
    
    public void savedata (ArrayList<Akun> a,String name) {
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
    
    public ArrayList<Akun> loaddata (String nama) {
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
    }
    
    public boolean doLogin (String user,String pass) {
       Akun s = getAkun(user);
       boolean cekk = false;
       if (s.getPass().equals(pass)) {
           //System.out.println("masuk");
           cekk = true;
       }
       return cekk;
    }
    
    public void edProfile (String nama, String pass, String username, String tempattanggallahir) {
        getAkun(userr).setNama(nama);
        getAkun(userr).setTempattanggallahir(tempattanggallahir);
        getAkun(userr).setUsername(username);
        userr=username;
        getAkun(userr).setPass(pass);
        savedata(akun, "akun.ser");
    }
    
    public void addFriend(int s) {
        getAkun(userr).followFriend(getAkun(s-1));
    }
    
    public void removeFriend (int s) {
        getAkun(userr).removePerson(s-1);
    }
    
    public void lihatTeman() {
        System.out.println("==========teman anda sekarang============");
        //getAkun(userr).loadFriend();
        if (!getAkun(userr).cekFriend()) {
            for (int i=0;i<getAkun(userr).sizeFriend();i++) {
               System.out.println((i+1)+" . "+getAkun(userr).getPerson(i).getNama());
               cF++;
            }
        }
    }
    
    public void lihatFriend() {
        boolean cekf;
        System.out.println("==========teman anda sekarang============");
        //getAkun(userr).loadFriend();
        if (!getAkun(userr).cekFriend()) {
            for (int i=0;i<getAkun(userr).sizeFriend();i++) {
               System.out.println((i+1)+" . "+getAkun(userr).getPerson(i).getNama());
            }
        }
        else {
            System.out.println("belum ada teman");
        }
        System.out.println("==== akun yang bisa di tambahkan menjadi teman");
        for (int y = 0;y<akun.size();y++) {
           cekf = false;
           if (!getAkun(userr).cekFriend()) {
               for (int i=0;i<getAkun(userr).sizeFriend();i++) {
                   if (getAkun(y).getUsername().equals(getAkun(userr).getPerson(i).getUsername())) {
                       cekf=true;
                       cF++;
                   }
               }
               if (cekf==false) {
                   if (getAkun(userr).getUsername() != getAkun(y).getUsername()) {
                       System.out.println((y+1)+" . "+getAkun(y).getNama());
                   }
               }
           }
           else {
               if (getAkun(userr).getUsername() != getAkun(y).getUsername()) {
                   System.out.println((y+1)+" . "+getAkun(y).getNama());
                }
           }
        }
    }
    
    public void removeTag (int s,int y) {
        getAkun(userr).getMedia(s-1).removeTag(y-1);
    }
    
    public void lihattagFoto(int i) {
        if (!getAkun(userr).cekMedia()) {
            System.out.println("Foto");
            if (getAkun(userr).getMedia(i-1) instanceof Foto) {
                if (!getAkun(userr).getMedia(i-1).cekTag()) {
                    for (int x=0;x<getAkun(userr).getMedia(i-1).sizeTag();x++) {
                        System.out.println((x+1)+". "+getAkun(userr).getMedia(i-1).getPersonTag(x).getNama());
                    }
                }
                else {
                    System.out.println("-");
                }
                System.out.println("");
            }
        }
    }
    
    public void taggedMedia(int i,int y) {
        getAkun(userr).getMedia(i-1).tagPerson(getAkun(userr).getPerson(y-1));
    }
    
    public void timeline() {
        System.out.println("Nama : "+getAkun(userr).getNama());
        if (!getAkun(userr).cekMedia()) {
            System.out.println("Foto");
            for (int i=0;i<getAkun(userr).sizeMedia();i++) {
                if (getAkun(userr).getMedia(i) instanceof Foto) {
                    Foto f = (Foto) getAkun(userr).getMedia(i);
                    System.out.println("Nama Foto : "+f.getNama());
                    System.out.println("Size Foto : "+getAkun(userr).getMedia(i).getSize());
                    System.out.print("tagged person : ");
                    if (!getAkun(userr).getMedia(i).cekTag()) {
                        for (int x=0;x<getAkun(userr).getMedia(i).sizeTag();x++) {
                            System.out.print(getAkun(userr).getMedia(i).getPersonTag(x).getNama()+" ");
                        }
                    }
                    else {
                        System.out.print("-");
                    }
                    System.out.println("");
                }
            }
            System.out.println("Video");
            for (int i=0;i<getAkun(userr).sizeMedia();i++) {
               if (getAkun(userr).getMedia(i) instanceof Video) {
                   Video f = (Video) getAkun(userr).getMedia(i);
                   System.out.println("Nama Video : "+f.getNama());
                   System.out.println("Size Video : "+getAkun(userr).getMedia(i).getSize());
                   System.out.print("tagged person : ");
                    if (!getAkun(userr).getMedia(i).cekTag()) {
                        for (int x=0;x<getAkun(userr).getMedia(i).sizeTag();x++) {
                            System.out.print(getAkun(userr).getMedia(i).getPersonTag(x).getNama()+" ");
                        }
                    }
                    else {
                        System.out.print("-");
                    }
                    System.out.println("");
                }
            }
         }
        System.out.println("");
        //getAkun(userr).loadFriend();
        if (!getAkun(userr).cekFriend()) {
            for (int i=0;i<getAkun(userr).sizeFriend();i++) {
               System.out.println("Nama : "+getAkun(userr).getPerson(i).getNama());
               if (!getAkun(userr).getPerson(i).cekMedia()) {
                    System.out.println("Foto");
                    for (int y=0;y<getAkun(userr).getPerson(i).sizeMedia();i++) {
                        if (getAkun(userr).getPerson(i).getMedia(y) instanceof Foto) {
                            Foto f = (Foto) getAkun(userr).getPerson(i).getMedia(y);
                            System.out.println("Nama Foto : "+f.getNama());
                            System.out.println("Size Foto : "+getAkun(userr).getPerson(i).getMedia(y).getSize());
                            System.out.print("tagged person : ");
                            if (!getAkun(userr).getMedia(i).cekTag()) {
                                for (int x=0;x<getAkun(userr).getPerson(i).getMedia(y).sizeTag();x++) {
                                    System.out.print(getAkun(userr).getPerson(i).getMedia(y).getPersonTag(x).getNama()+" ");
                                }
                            }
                            else {
                                System.out.print("-");
                            }
                            System.out.println("");
                        }
                    }
                   System.out.println("Video");
                    for (int y=0;y<getAkun(userr).getPerson(i).sizeMedia();i++) {
                        if (getAkun(userr).getPerson(i).getMedia(y) instanceof Video) {
                            Video f = (Video) getAkun(userr).getPerson(i).getMedia(y);
                            System.out.println("Nama Video : "+f.getNama());
                            System.out.println("Size Video : "+getAkun(userr).getPerson(i).getMedia(y).getSize());
                            System.out.print("tagged person : ");
                            if (!getAkun(userr).getMedia(i).cekTag()) {
                                for (int x=0;x<getAkun(userr).getPerson(i).getMedia(y).sizeTag();x++) {
                                    System.out.print(getAkun(userr).getPerson(i).getMedia(y).getPersonTag(x).getNama()+" ");
                                }
                            }
                            else {
                                System.out.print("-");
                            }
                        }
                    }
                }
            }
        }
        
    }
    
    public void menuDua() {
        System.out.println("Nama : "+getAkun(userr).getNama());
        System.out.println("Tempat,Tanggal Lahir : "+getAkun(userr).getTempattanggallahir());
        System.out.println("Username : "+getAkun(userr).getUsername());
        System.out.println("Password : "+getAkun(userr).getPass());
    }
    
    public void addFoto (String nama, double size) {
        getAkun(userr).createMediaFoto(size, nama);
    }
    
    public void addVideo (String nama,double size) {
        getAkun(userr).createMediaVideo(size, nama);
    }
    
    public void lihatFoto () {
        if (!getAkun(userr).cekMedia()) {
            for (int i=0;i<getAkun(userr).sizeMedia();i++) {
                if (getAkun(userr).getMedia(i) instanceof Foto) {
                    Foto f = (Foto) getAkun(userr).getMedia(i);
                    System.out.println((i+1)+". Nama : "+f.getNama());
                    System.out.println("   Size : "+getAkun(userr).getMedia(i).getSize());
                 }
             }
        }
    }
    
    public void lihatVideo () {
        if (!getAkun(userr).cekMedia()) {
            for (int i=0;i<getAkun(userr).sizeMedia();i++) {
                if (getAkun(userr).getMedia(i) instanceof Video) {
                    Video f = (Video) getAkun(userr).getMedia(i);
                    System.out.println((i+1)+". Nama : "+f.getNama());
                    System.out.println("   Size : "+getAkun(userr).getMedia(i).getSize());
                 }
             }
        }
    }
    
    public void edFoto(int i,String nama,double size) {
        if (!getAkun(userr).cekMedia()) {
            getAkun(userr).editFoto(i-1, nama, size); 
        }        
    }
    
    public void edVideo(int i,String nama,double size) {
        if (!getAkun(userr).cekMedia()) {
            getAkun(userr).editVideo(i-1, nama, size); 
        }        
    }
    
    public void deleteFotodanVideo (int i) {
        if (!getAkun(userr).cekMedia()) {
            getAkun(userr).removeMedia(i-1);
        }  
    }
    
}
