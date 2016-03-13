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
public class AplikasiMediaSharing {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Akun a1 = new Akun ("Andi","papua, 29-mei-2000");
        Akun a2 = new Akun ("Budi","ntt, 10-februari-1999");
        Akun a3 = new Akun ("Demian","ntb, 1-januari-1450");
        
        a1.createMediaFoto("c:", 20, "pemandangan");
        a2.createMediaVideo("d:", 100, "ip man");
        a3.createMediaFoto("e:", 50, "rumah");
        a3.createMediaFoto("C:", 50, "mobil");
        
        a1.getMedia(0).tagPerson(a2);
        a2.getMedia(0).tagPerson(a1);
        a3.getMedia(0).tagPerson(a1);
        
        a1.followFriend(a3);
        a2.followFriend(a3);
        a3.followFriend(a1);
        a3.followFriend(a2);
        
        a1.display();
        System.out.println("");
        a2.display();
        System.out.println("");
        a3.display();
    }
    
}
