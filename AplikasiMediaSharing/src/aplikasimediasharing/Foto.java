/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasimediasharing;

public class Foto extends Media implements java.io.Serializable{
    private String nama;
    
    public Foto (double size, String nama) {
        super(size);
        this.nama = nama;
    }

    public String getNama() {
        return nama;
    }

   
    public void setNama(String nama) {
        this.nama = nama;
    }
    
}
