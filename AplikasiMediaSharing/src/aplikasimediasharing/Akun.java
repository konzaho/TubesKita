/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasimediasharing;
/**
 *
 * @author muham
 */
public class Akun {
    private String nama;
    private String tempattanggallahir;
    private Media[] media = new Media[10];
    private Akun[] friend = new Akun[10];
    private int numMed=0,numAk=0,numMedAk=0;

    public Akun (String nama, String ttl) {
        this.nama = nama;
        tempattanggallahir = ttl;
        numMedAk = 0;
    }

    public void createMediaFoto (String path,double size,String nama) {
        Media m = new Foto(size,nama);
        if (numMed < 10) {
            media[numMed] = m;
            numMed++;
            numMedAk++;
        }
        else {
            for (int i=0;i<10;i++) {
                if(media[i]==null) {
                    media[i] = m;
                    break;
                }
            }
        }
    }

    public void createMediaVideo (String path,double size,String nama) {
        Media m = new Video(size,nama);
        if (numMed < 10) {
            media[numMed] = m;
            numMed++;
            numMedAk++;
        }
        else {
            for (int i=0;i<10;i++) {
                if(media[i]==null) {
                    media[i] = m;
                    break;
                }
            }
        }
    }

    public void followFriend (Akun p) {
        if (numAk < 10) {
            friend[numAk] = p;
            numAk++;
        }
        else {
            for (int i=0;i<10;i++) {
                if(friend[i]==null) {
                    friend[i] = p;
                    break;
                }
            }
        }
    }

    public void removeFriend (int i) {
        friend[i] = null;
    }

    public void removeMedia (int i) {
        media[i] = null;
        numMedAk -= 1;
    }

    public Media getMedia (int i) {
        return media[i];
    }

    public Akun getFriend (int i) {
        return friend[i];
    }

    public String getNama() {
        return nama;
    }


    public void setNama(String nama) {
        this.nama = nama;
    }


    public String getTempattanggallahir() {
        return tempattanggallahir;
    }

    public int getNumMedAk(){
        return numMedAk;
    }


    public void setTempattanggallahir(String tempattanggallahir) {
        this.tempattanggallahir = tempattanggallahir;
    }

    public void display() {
        boolean cekv=false,cekf=false;
        System.out.println("Nama : "+nama);
        System.out.println("TTL  : "+tempattanggallahir);
        System.out.println("=======Friend List=======");
        for (int i=0;i<numAk;i++) {
            if (friend[i]!=null) {
                System.out.println((i+1)+". "+friend[i].getNama());
            }
        }
        System.out.println("=======Media=======");
        System.out.println("Number of Media: "+getNumMedAk());
        for (int i =0;i<numMed;i++) {
            if (media[i] instanceof Video) {
                cekv=true;
            }
            if (media[i] instanceof Foto) {
                cekf=true;
            }
        }
        System.out.println("Foto");
        if (cekf) {
            for (int i = 0;i<numMed;i++) {
                if (media[i] instanceof Foto) {
                    Foto f = (Foto) media[i];
                    System.out.println("Nama : "+f.getNama());
                    System.out.println("Size : "+media[i].getSize()+" kb");
                    System.out.println("Tagged Person in this Foto");
                    for (int j=0;j<media[i].getNumAk();j++) {
                        System.out.println((j+1)+". "+media[i].getPersonTag(j).getNama());
                    }
                }
            }
        }
        else {
            System.out.println("Akun ini belum menambahkan foto");
        }
        System.out.println("Video");
        if (cekv) {
            for (int i = 0;i<numMed;i++) {
                if (media[i] instanceof Video) {
                    Video f = (Video) media[i];
                    System.out.println("Nama : "+f.getNama());
                    System.out.println("Size : "+media[i].getSize()+" MB");
                    System.out.println("Tagged Person in this Video");
                    for (int j=0;j<media[i].getNumAk();j++) {
                        System.out.println((j+1)+". "+media[i].getPersonTag(j).getNama());
                    }
                }
            }
        }
        else {
            System.out.println("Akun ini belum menambahkan video");
        }
    }
}
