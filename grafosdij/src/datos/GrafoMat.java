
package datos;

import java.util.ArrayList;
import java.io.Serializable;
public class GrafoMat<E> implements Grafo<E>, Serializable {
    private int aristas[][];
    private ArrayList<E> vertices;

    public GrafoMat() {
        aristas=new int[100][100];
        vertices = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if(i!=j){
                    aristas[i][j] = inf;
                }
            }
        }
    }

    
    public GrafoMat(int[][] aristas, ArrayList<E> vertices) {
        this.aristas = aristas;
        this.vertices = vertices;
    }
    
    
    @Override
    public void insVertice(E x) {
        vertices.add(x);
    }

    @Override
    public E obtVertice(int pos) {
        return vertices.get(pos);
    }

    @Override
    public void insArista(int vi, int vf, int dato) {
        aristas[vi][vf]=dato; 
    }

    @Override
    public int obtArista(int vi, int vf) {
        return aristas[vi][vf];
    }

    @Override
    public void elimArista(int vi, int vf) {
        aristas[vi][vf] = inf;
    }

    @Override
    public int orden() {
        return vertices.size();
    }

    @Override
    public ArrayList<E> sucesores(int pos) {
        ArrayList<E> suces=new ArrayList<>();
        for (int i = 0; i < orden(); i++) {
            if(aristas[pos][i]!=inf && i!=pos){
                suces.add(obtVertice(i));
            }
        }
        return suces;
    }

    @Override
    public String mostrar() {
        String con="";
        for (int i = 0; i <orden(); i++) {
            con+="Vertice:"+obtVertice(i);
            for (int j = 0; j < orden(); j++) {
                con+="-"+obtArista(i, j);
            }
            con+="\n";
        }
        return con;
    }
    
    
    
    
    
    
}
