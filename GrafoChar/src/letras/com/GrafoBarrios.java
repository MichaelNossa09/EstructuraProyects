
package letras.com;

import datos.Grafo;
import datos.GrafoMat;

public class GrafoBarrios {
    public Grafo<String> crear(){
        Grafo<String> gra = new GrafoMat<>();
        gra.insVertice("Los Almendros");
        gra.insVertice("Ciudadela");
        gra.insVertice("Pescaito");
        gra.insVertice("Centro");
        gra.insVertice("Los Olivos");
        gra.insVertice("LA U");
        gra.insArista(0, 1, 2000);
        gra.insArista(0, 2, 1000);
        gra.insArista(0, 4, 600);
        
        
        gra.insArista(1, 0, 2000);
        gra.insArista(1, 3, 1400);
        gra.insArista(1, 5, 500);
        
        gra.insArista(2, 0, 1000);
        gra.insArista(2, 3, 500);
        
        gra.insArista(3, 2, 500);
        gra.insArista(3, 1, 1400);
        
        gra.insArista(4, 0, 600);
        
        gra.insArista(5, 1, 500);
        
        return gra;
    }
    
    public static void main(String[] args) {
        GrafoBarrios ob = new GrafoBarrios();
        Grafo<String> crear = ob.crear();
        System.out.println(""+crear.mostrar());
    }
}
