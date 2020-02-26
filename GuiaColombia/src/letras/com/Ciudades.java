
package letras.com;

import java.io.Serializable;
import java.util.ArrayList;


public class Ciudades implements Serializable{
    private String nombre;
    private ArrayList<hoteles> c;
    private ArrayList<restaurantes> r;
    private ArrayList<sitiosTuristicos> sT;
    private ArrayList<platosTipicos> pT;
    public int i=0;

    public Ciudades() {
    }

    public Ciudades(String nombre) {
        this.nombre = nombre;
    }
    

    public Ciudades(String nombre, ArrayList<hoteles> c, ArrayList<restaurantes> r, ArrayList<sitiosTuristicos> sT, ArrayList<platosTipicos> pT) {
        this.nombre = nombre;
        this.c = c;
        this.r = r;
        this.sT = sT;
        this.pT = pT;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<hoteles> getC() {
        return c;
    }

    public void setC(ArrayList<hoteles> c) {
        this.c = c;
    }

    public ArrayList<restaurantes> getR() {
        return r;
    }

    public void setR(ArrayList<restaurantes> r) {
        this.r = r;
    }

    public ArrayList<sitiosTuristicos> getsT() {
        return sT;
    }

    public void setsT(ArrayList<sitiosTuristicos> sT) {
        this.sT = sT;
    }

    public ArrayList<platosTipicos> getpT() {
        return pT;
    }

    public void setpT(ArrayList<platosTipicos> pT) {
        this.pT = pT;
    }

    @Override
    public String toString() {
        i++;
        return "\nCiudad: "+ nombre + "\nHoteles:" + c + "\nRestaurantes:" + r + "\nSitios Turisticos:" + sT + "\nPlatos Tipicos:" + pT;
        
    }

    

    
    
    
    
    
    
}
