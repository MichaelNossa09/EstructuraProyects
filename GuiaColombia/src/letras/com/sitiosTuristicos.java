
package letras.com;

import java.io.Serializable;

public class sitiosTuristicos implements Serializable{
    private String nombre;

    public sitiosTuristicos(String nombre) {
        this.nombre = nombre;
        
    }

    public sitiosTuristicos() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "[ "+nombre+" ]";
    }

   
}
