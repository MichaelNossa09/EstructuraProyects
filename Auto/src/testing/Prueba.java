
package testing;

import datos.Auto;
import datos.AutoMarcaSort;
import datos.Concesionario;

import java.util.Collections;


public class Prueba {
    public static void main(String[] args) {
        Concesionario con = new Concesionario();
        con.addAuto(new Auto("TZU 520", "KIA", 2000));
        con.addAuto(new Auto("TZU 420", "RENAULT", 2000));
        con.addAuto(new Auto("TZU 320", "PINTO", 2000));
        con.addAuto(new Auto("TZU 220", "LAMBORGUINI", 2000));
        System.out.println(" "+con.listar());
        
        Collections.sort(con.getAutos(), new AutoMarcaSort());
        System.out.println("------------------");
        System.out.println(" "+con.listar());
    }
    
}
