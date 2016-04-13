/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

public class Foto extends Media implements java.io.Serializable{
    
    public Foto (int idMedia, String nama, double size) {
        super(idMedia, nama, size);
    }

    public Foto(String nama, double size){
        super(nama,size);
    }
    
    public String getNama() {
        return super.getNama();
    }

    public void setNama(String nama) {
        super.setNama(nama);
    }
    
    public int getIdMedia(){
        return super.getIdMedia();
    }
    
    public void setIdMedia(int id){
        super.setIdMedia(id);
    }
    
    public double getSize(){
        return super.getSize();
    }
    
    public void setSize(double size){
        super.setSize(size);
    }
    
}
