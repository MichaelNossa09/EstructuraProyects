
package datos;

import java.util.ArrayList;


public interface Grafo<Ciudades>{
    void insVertice(Ciudades x);
    Ciudades obtVertice(int pos);
    void insArista(int vi,int vf, int tiempo); //enteros
    int obtArista(int vi, int vf);
    void elimArista(int vi, int vf);
    int orden(); //vertices
    ArrayList<Ciudades> sucesores(int pos);
    int inf=9999999;
}
