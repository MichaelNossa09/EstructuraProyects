
package datos;


public class MapaRepresentacion {
    public static Grafo getCiudades() {
        Nodo mamatoco = new Nodo("Mamatoco");
        Nodo once = new Nodo("Once Noviembre");
        Nodo cantilito = new Nodo("Cantilito");
        Nodo timayui = new Nodo("timayui");
        Nodo aleja = new Nodo("Urb. Andrea Carolina");
 
        mamatoco.addArista(new Arista(mamatoco,once , 10));
        mamatoco.addArista(new Arista(mamatoco, cantilito, 10));
        mamatoco.addArista(new Arista(mamatoco, aleja, 15));
 
        cantilito.addArista(new Arista(cantilito, timayui, 20));
        
        
 
        Grafo grafo = new Grafo();
        grafo.addNodo(mamatoco);
        grafo.addNodo(once);
        grafo.addNodo(cantilito);
        
        return grafo;
    }
 
    public static void main(String[] args) {
        Grafo grafo = getCiudades();
        System.out.println(grafo);
    }
}
