
package letras.com;
import java.io.Serializable;


public class hoteles implements Serializable{
    private String nombre;
    private String dirrecion;

    public hoteles() {
    }

    public hoteles(String nombre, String dirrecion) {
        this.nombre = nombre;
        this.dirrecion = dirrecion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDirrecion() {
        return dirrecion;
    }

    public void setDirrecion(String dirrecion) {
        this.dirrecion = dirrecion;
    }

    @Override
    public String toString() {
        return "[ "+nombre+ ", Dirrecion:" + dirrecion+" ]";
    }

    
    
    
}
