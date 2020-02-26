
package letras.com;

import java.io.Serializable;


public class platosTipicos implements Serializable{
    private String nombre;
    

    public platosTipicos() {
    }

    public platosTipicos(String nombre) {
        this.nombre = nombre;
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
