
package TallerDeArboles;

import java.io.Serializable;


public interface Arbin<E> extends Serializable {
    // E generic
    E obtener();
    Arbin<E> der();
    Arbin<E> izq();
    void enlDer(Arbin<E> x);
    void enlIzq(Arbin<E> x);
    void modificar(E x);
}
