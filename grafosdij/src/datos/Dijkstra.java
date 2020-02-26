/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import java.util.ArrayList;

/**
 *
 * @author ESTUDIANTE
 */
public class Dijkstra {

    private int d[];
    Grafo<Integer> g;
    private int vi;
    ArrayList<Integer> visitar = new ArrayList<>();

    public void Dijkstra(Grafo<Integer> g, int vi) {
        this.g = g;
        this.vi = vi;
        d = new int[g.orden()];
        for (int i = 0; i < d.length; i++) {
            d[i] = g.obtArista(vi, i);
        }

    }

    public void Cminimo() {
        visitar.add(vi);
        for (int i = 0; i < d.length; i++) {
            int m = menor();
            visitar.add(m);
            for (int j = 0; j < g.orden(); j++) {
                d[j] = minimo(d[j], d[m] + g.obtArista(m, j));
            }
        }
    }

    int minimo(int a, int b) {
        if (a < b) {
            return a;
        }
        return b;
    }

    int menor() {
        int min = 9999, pos = -1;
        for (int i = 0; i < g.orden(); i++) {
            if (!visitar.contains(i)) {
                int menor = 0;
                if (d[i] < menor) {
                    menor = d[i];
                    pos = i;
                }
            }
        }
        return pos;
    }

    public static void main(String[] args) {
        Grafo<Integer> gra = new GrafoMat<>();
        gra.insVertice(0);
        gra.insVertice(1);
        gra.insVertice(2);
        gra.insVertice(3);

        gra.insArista(0, 1, 2);
        gra.insArista(0, 2, 7);

        gra.insArista(1, 3, 5);
        gra.insArista(1, 2, 1);

        gra.insArista(2, 3, 1);
        Dijkstra obj = new Dijkstra();
        obj.Cminimo();
    }

}
