
package datos;

import java.util.ArrayList;
import java.io.Serializable;
public class GrafoMat<Ciudades> implements Grafo<Ciudades>, Serializable {
    private int aristas[][];
    private ArrayList<Ciudades> vertices;

    public GrafoMat() {
        aristas=new int[100][100];
        vertices = new ArrayList<Ciudades>();
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if(i!=j){
                    aristas[i][j] = inf;
                }
            }
        }
    }

    
    public GrafoMat(int[][] aristas, ArrayList<Ciudades> vertices) {
        this.aristas = aristas;
        this.vertices = vertices;
    }
    
    
    @Override
    public void insVertice(Ciudades x) {
        vertices.add(x);
    }

    @Override
    public Ciudades obtVertice(int pos) {
        return vertices.get(pos);
    }

    @Override
    public void insArista(int vi, int vf, int tiempo) {
        aristas[vi][vf]=tiempo; 
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
    public ArrayList<Ciudades> sucesores(int pos) {
        ArrayList<Ciudades> suces=new ArrayList<Ciudades>();
        for (int i = 0; i < orden(); i++) {
            if(aristas[pos][i]!=inf && i!=pos){
                suces.add(obtVertice(i));
            }
        }
        return suces;
    }

   // @Override
  /*  public String mostrar() {
        String con="";
        for (int i = 0; i <orden(); i++) {
            con+="\n\n"+obtVertice(i);
            for(int j = 0 ; j<orden();j++){
               con+="\nDESTINOS: "++obtArista(i, j);
            }
        }
        return con;
*/

   
    
    
    
    
    
    
    
}
