
package datos;

import java.util.ArrayList;
import java.util.List;


public class Nodo {
    private String ciudad;
    private List<Arista> aristas;
 
    public Nodo(String ciudad) {
        this.ciudad = ciudad;
    }
 
    public String getCiudad() {
        return ciudad;
    }
 
    public void setCity(String ciudad) {
        this.ciudad = ciudad;
    }
 
    public List<Arista> getArista() {
        return aristas;
    }
 
    public void addArista(Arista arista) {
        if (aristas == null) {
            aristas = new ArrayList<>();
        }
        aristas.add(arista);
    }
 
    @Override
    public String toString() {
        return "\n \tNodo [ciudad=" + ciudad + ", Aristas=" + aristas + "]";
    }
}
