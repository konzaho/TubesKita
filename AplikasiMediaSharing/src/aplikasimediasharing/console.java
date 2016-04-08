/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasimediasharing;
import java.util.Scanner;
/**
 *
 * @author muham
 */
public class console {
       int inp,pil,pil2;
       double pil1;
       String user,pass,nama,ttl;
       Scanner i1 = new Scanner(System.in);
       Aplikasi a = new Aplikasi();
       
       public void editprofile() {
           System.out.print("Masukkan Nama : ");
           nama = i1.next();
           System.out.print("Masukkan Tempat dan tanggal lahir : ");
           ttl = i1.next();
           System.out.print("Masukkan Username : ");
           user = i1.next();
           System.out.print("Masukkan Password : ");
           pass = i1.next();
           a.edProfile(nama, pass, user, ttl);
       }
       
       public void editFoto() {
           System.out.print("Pilih Nomor Foto yang ingin di edit : ");
           pil = i1.nextInt();
           System.out.print("Nama Foto baru: ");
           nama = i1.next();
           System.out.print("Size Foto baru(angka): ");
           pil1 = i1.nextDouble();
           a.edFoto(pil, nama, pil1);
       }
       
       public void editVideo() {
           System.out.print("Pilih Nomor Video yang ingin di edit : ");
           pil = i1.nextInt();
           System.out.print("Nama Video baru: ");
           nama = i1.next();
           System.out.print("Size Video baru(angka): ");
           pil1 = i1.nextDouble();
           a.edVideo(pil, nama, pil1);
       }
       
       public void delFoto () {
           System.out.print("Pilih Nomor Foto yang ingin di hapus : ");
           pil = i1.nextInt();
           a.deleteFotodanVideo(pil);
       }
       
       public void delVideo () {
           System.out.print("Pilih Nomor Video yang ingin di hapus : ");
           pil = i1.nextInt();
           a.deleteFotodanVideo(pil);
       }
       
       public void Menuutama() {
           console c = new console();
           System.out.println("1. Timeline");
           System.out.println("2. Profile");
           System.out.println("3. Media");
           System.out.println("4. Friend");
           System.out.println("5. Logout");
           System.out.print("Pilihan : ");
           pil = i1.nextInt();
           switch (pil) {
               case 1:
                   a.timeline();
                   Menuutama();
                   break;
               case 2:
                   a.menuDua();
                   System.out.println("");
                   System.out.println("1. Edit Profile");
                   System.out.println("2. Menu Utama");
                   System.out.print("Pilihan : ");
                   pil = i1.nextInt();
                   switch (pil) {
                       case 1:
                           editprofile();
                           break;
                       case 2:
                           Menuutama();
                           break;
                       default :
                           System.out.println("inputan salah");
                   }
                   break;
               case 3:
                   System.out.println("1. Add Media");
                   System.out.println("2. Edit Media");
                   System.out.println("3. Delete Media");
                   System.out.println("4. Tag Friend");
                   System.out.println("5. Remove Tag");
                   System.out.println("6. Menu Utama");
                   System.out.print("Pilihan : ");
                   pil = i1.nextInt();
                   switch (pil) {
                       case 1:
                           System.out.println("1. Foto");
                           System.out.println("2. Video");
                           System.out.print("Pilihan : ");
                           pil = i1.nextInt();
                           switch (pil) {
                               case 1:
                                   System.out.print("Nama Foto : ");
                                   nama = i1.next();
                                   System.out.print("Size Foto (angka): ");
                                   pil1 = i1.nextDouble();
                                   a.addFoto(nama, pil1);
                                   Menuutama();
                                   break;
                               case 2:
                                   System.out.print("Nama Video : ");
                                   nama = i1.next();
                                   System.out.print("Size Video (angka): ");
                                   pil1 = i1.nextDouble();
                                   a.addVideo(nama, pil1);
                                   Menuutama();
                                   break;
                           }
                           break;
                       case 2:
                           System.out.println("1. Foto");
                           System.out.println("2. Video");
                           System.out.print("Pilihan : ");
                           pil = i1.nextInt();
                           switch (pil) {
                               case 1:
                                   a.lihatFoto();
                                   editFoto();
                                   Menuutama();
                                   break;
                               case 2:
                                   a.lihatVideo();
                                   editVideo();
                                   Menuutama();
                                   break;
                           }
                           break;
                       case 3:
                           System.out.println("1. Foto");
                           System.out.println("2. Video");
                           System.out.print("Pilihan : ");
                           pil = i1.nextInt();
                           switch (pil) {
                               case 1:
                                   a.lihatFoto();
                                   delFoto();
                                   Menuutama();
                                   break;
                               case 2:
                                   a.lihatVideo();
                                   delVideo();
                                   Menuutama();
                                   break;
                           }
                           break;
                       case 4:
                           System.out.println("1. Foto");
                           System.out.println("2. Video");
                           System.out.print("Pilihan : ");
                           pil = i1.nextInt();
                           switch (pil) {
                               case 1:
                                   a.lihatFoto();
                                   a.lihatTeman();
                                   System.out.print("Pilih nomor foto yang ingin di tag : ");
                                   pil = i1.nextInt();
                                   System.out.print("Pilih nomor friend yang ingin di tag : ");
                                   pil2 = i1.nextInt();
                                   a.taggedMedia(pil, pil2);
                                   Menuutama();
                                   break;
                               case 2:
                                   a.lihatVideo();
                                   a.lihatTeman();
                                   System.out.print("Pilih nomor video yang ingin di tag : ");
                                   pil = i1.nextInt();
                                   System.out.print("Pilih nomor friend yang ingin di tag : ");
                                   pil2 = i1.nextInt();
                                   a.taggedMedia(pil, pil2);
                                   Menuutama();
                                   break;
                           }
                           break;
                       case 5:
                           System.out.println("1. Foto");
                           System.out.println("2. Video");
                           System.out.print("Pilihan : ");
                           pil = i1.nextInt();
                           switch (pil) {
                               case 1:
                                   a.lihatFoto();
                                   System.out.print("Pilih Foto : ");
                                   pil = i1.nextInt();
                                   a.lihattagFoto(pil);
                                   System.out.println("Pilih Tag yang ingin di hapus ");
                                   pil2 = i1.nextInt();
                                   a.removeTag(pil, pil2);
                                   break;
                           }
                           break;
                   }
                   break;
               case 4:
                   a.lihatTeman();
                   System.out.println("1. Add Friend");
                   System.out.println("2. Delete Friend");
                   System.out.println("3. Menu Utama");
                   System.out.print("Pilihan : ");
                   pil = i1.nextInt();
                   switch(pil) {
                       case 1:
                           a.lihatFriend();
                           if (a.cF == a.sizeAkun()-1) {
                               System.out.println("semua akun telah menjadi teman anda");
                               a.cF=0;
                               Menuutama();
                           } 
                           else {
                               System.out.print("Pilih nomor teman yang ingin di add : ");
                               pil = i1.nextInt();
                               a.addFriend(pil);
                               a.cF=0;
                               Menuutama();
                           }
                           break;
                       case 2:
                           a.lihatTeman();
                           if (a.cF == 0) {
                               System.out.println("tidak ada teman yang bisa di hapus");
                               Menuutama();
                           }
                           else {
                               System.out.print("Pilih nomor teman yang ingin di hapus : ");
                               pil = i1.nextInt();
                               a.removeFriend(pil);
                               a.cF=0;
                               Menuutama();
                           }
                           break;
                   }
                   break;
               case 5:
                   c.Display();
           }
           System.out.println("");
           c.Menuutama();
       }
       
       public void Display() {
           a.loadfile();
           console c = new console();
           System.out.println("1. Login");
           System.out.println("2. Buat Akun");
           System.out.print("Pilihan : ");
           inp = i1.nextInt();
           switch(inp) {
               case 1:
                   System.out.print("Username : ");
                   user = i1.next();
                   System.out.print("Password : ");
                   pass = i1.next();
                   if (a.cekAkun(user)) {
                       if (a.doLogin(user, pass)) {
                           a.userr = user;
                           Menuutama();
                       }
                       else {
                           System.out.println("Username / password salah"); 
                       }
                   }
                   else {
                       System.out.println("Username belum terdaftar");
                   }
                   break;
               case 2:
                   System.out.print("Masukkan Nama : ");
                   nama = i1.next();
                   System.out.print("Masukkan Tempat dan tanggal lahir : ");
                   ttl = i1.next();
                   System.out.print("Masukkan Username : ");
                   user = i1.next();
                   System.out.print("Masukkan Password : ");
                   pass = i1.next();
                   a.addAkun(nama, pass, user, ttl);
                   break;
               default :
                   System.out.println("tidak ada dalam menu");
                   break;
           }
           System.out.println("");
           c.Display();
       }
}
