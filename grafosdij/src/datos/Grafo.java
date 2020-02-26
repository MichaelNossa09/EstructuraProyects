
package datos;

import java.util.ArrayList;


public interface Grafo<E>{
    void insVertice(E x);
    E obtVertice(int pos);
    void insArista(int vi,int vf, int dato); //enteros
    int obtArista(int vi, int vf);
    void elimArista(int vi, int vf);
    int orden(); //vertices
    ArrayList<E> sucesores(int pos);
    String mostrar();
    int inf=9999999;
}
