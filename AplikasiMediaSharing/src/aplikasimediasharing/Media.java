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
public abstract class Media {
    private double size;
    private Akun[] tagged = new Akun[10];
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
        if (getNumAk() < 10) {
            tagged[getNumAk()] = p;
            numAk++;
        }
        else {
            for (int i=0;i<10;i++) {
                if(tagged[i]==null) {
                    tagged[i] = p;
                    break;
                }
            }
        }
    }
    
    public void removeTag (int i) {
        tagged[i] = null;
    }
    
    public Akun getPersonTag (int i) {
        return tagged[i];
    }

    public int getNumAk() {
        return numAk;
    }
}
