
package datos;

import java.util.Comparator;


public class TaxiPlacaSort implements Comparator<Object>{

    @Override
    public int compare(Object t, Object t1) {
        Taxi a1= (Taxi) t;
        Taxi a2= (Taxi) t1;
        return(a1.getPlaca().compareTo(a2.getPlaca()));
    }
    
}
