/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 * @author ESTUDIANTE
 */
public class Recorrido {
    
    static ArrayList<Integer> visitado= new ArrayList<>();
    public void dfs(Grafo<Integer> g, int vi){
        System.out.println(vi);
        visitado.add(vi);
        ArrayList<Integer> suc = g.sucesores(vi);
        for (Integer x : suc) {
            if (!visitado.contains(x)) {
                dfs(g,x);
            }
        }
        
    }
    
    public void bfs(Grafo<Integer>g,int vi){
        LinkedList<Integer> cola = new LinkedList<>();
        cola.addLast(vi);
        visitado.add(vi);
        while(!cola.isEmpty()){
            int x = cola.removeFirst();
            System.out.println(x);
            ArrayList<Integer> suc = g.sucesores(x);
            for (Integer s : suc) {
                if (!visitado.contains(s)) {
                    cola.addLast(s);
                    visitado.add(s);
                }
            }
        }
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
        
        Recorrido obj = new Recorrido();
        System.out.println("Bfs");
        obj.bfs(gra, 1);
        visitado.removeAll(visitado);
        System.out.println("");
        System.out.println("Dfs");
        obj.dfs(gra, 2);
       
        
    }
}
