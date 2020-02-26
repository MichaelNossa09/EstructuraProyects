/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package datos;

/**
 *
 * @author ESTUDIANTE
 */
public class Floyd {
    private int f[][];
    private int r[][];
    private final Grafo<Integer> g;

    public Floyd(Grafo<Integer> g) {
        int n= g.orden();
        f=new int [n][n];
        r=new int [n][n];
        this.g=g;
        inicializar();
    }
    
    

    private void inicializar() {
        for (int i = 0; i < f.length; i++) {
            for (int j = 0; j < f.length; j++) {
                r[i][j]=-1;
                f[i][j]=g.obtArista(i, j);
            }
        }
    }
    
    public void caminoMinimo(){
        for (int k = 0; k < g.orden(); k++) {
            for (int i = 0; i <g.orden(); i++) {
                for (int j = 0; j < g.orden(); j++) {
                    int valor = f[i][k]+f[k][j];
                    if (valor<f[i][j]) {
                        f[i][j]=valor;
                        r[i][j]=k;
                    }
                }
            }
        }
    }
    
    public int costoMinimo(int vi, int vf){
        return f[vi][vf];
    }
    
    public void ruta(int vi, int vf){
        int k=r[vi][vf];
        if (k!=-1) {
            ruta(vi,k);
            System.out.println(k);
            ruta(k, vf);
        }
    }
    
    public static void main(String[] args) {
        
        Grafo<Integer> gra = new GrafoMat<>();
        gra.insVertice(0);
        gra.insVertice(1);
        gra.insVertice(3);
        gra.insVertice(2);
        
        gra.insArista(0, 1, 2);
        gra.insArista(0, 2, 7);
        
        gra.insArista(1, 3, 5);
        gra.insArista(1, 2, 1);
        
        gra.insArista(2, 3, 1);
       
        Floyd y = new Floyd(gra);
        y.caminoMinimo();
        System.out.println(""+ y.costoMinimo(0, 3));
        
    }
    
}
