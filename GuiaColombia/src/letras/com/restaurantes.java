
package letras.com;

import java.io.Serializable;


public class restaurantes implements Serializable{
    private String nombre;
    private String direccion;

    public restaurantes() {
    }

    public restaurantes(String nombre, String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "[ "+nombre+ ", Direccion:" + direccion+"]";
    }

    
    
    
}
