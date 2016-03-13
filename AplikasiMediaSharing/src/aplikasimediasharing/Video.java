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
public class Video extends Media {
    private String nama;
    
    public Video (double size, String nama) {
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
