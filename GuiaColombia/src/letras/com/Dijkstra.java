package letras.com;

import datos.Grafo;
import java.io.Serializable;
import java.util.ArrayList;
import letras.com.Ciudades;

public class Dijkstra extends GrafoCiudades implements Serializable{

    private int d[];
    Grafo<Ciudades> gra;
    private int vi;
    ArrayList<Integer> visitar = new ArrayList<>();

    public void Dijkstra(Grafo<Ciudades> g, int vi) {
        int tam = gra.orden();
        this.gra = gra;
        this.vi = vi;
        d = new int[tam];
        for (int i = 0; i < d.length; i++) {
            d[i] = gra.obtArista(vi, i);
        }

    }

    public void Cminimo() {
        visitar.add(vi);
        for (int x = 0; x < d.length; x++) {
            int m = menor();
            visitar.add(m);
            for (int j = 0; j < gra.orden(); j++) {
                d[j] = minimo(d[j], d[m] + gra.obtArista(m, j));
            }
        }
    }

    public int minimo(int a, int b) {
        if (a < b) {
            return a;
        }
        return b;
    }

    public int menor() {
        int menor = 999999, pos = -1;
        for (int i = 0; i < gra.orden(); i++) {
            if (!visitar.contains(i)) { 
                if (d[i] < menor) {
                    menor = d[i];
                    pos = i;
                }
            }
        }
        return pos;
    }

    public int[] getD() {
        return d;
    }

    public void setD(int[] d) {
        this.d = d;
    }

    public Grafo<Ciudades> getGra() {
        return gra;
    }

    public void setGra(Grafo<Ciudades> gra) {
        this.gra = gra;
    }

    public int getVi() {
        return vi;
    }

    public void setVi(int vi) {
        this.vi = vi;
    }

    public ArrayList<Integer> getVisitar() {
        return visitar;
    }

    public void setVisitar(ArrayList<Integer> visitar) {
        this.visitar = visitar;
    }
    
   
}