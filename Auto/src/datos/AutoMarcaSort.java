
package datos;

import java.util.Comparator;

public class AutoMarcaSort implements Comparator<Object>{

    @Override
    public int compare(Object t, Object t1) {
        Auto a1= (Auto) t;
        Auto a2= (Auto) t1;
        return(a1.getMarca().compareTo(a2.getMarca()));
    }
    
}
