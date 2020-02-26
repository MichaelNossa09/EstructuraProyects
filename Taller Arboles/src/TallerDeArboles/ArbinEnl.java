
package TallerDeArboles;

import java.io.Serializable;


public class ArbinEnl<E> implements Arbin<E>,Serializable{
    
    private E dato;
    private Arbin<E> izq;
    private Arbin<E> der;

    public ArbinEnl(E dato) {
        this.dato = dato;
    }
    
    @Override
    public E obtener() {
       return dato;
    }

    @Override
    public Arbin<E> der() {
       return der;
    }

    @Override
    public Arbin<E> izq() {
       return izq;
    }

    @Override
    public void enlDer(Arbin<E> x) {
       der = x;
    }

    @Override
    public void enlIzq(Arbin<E> x) {
       izq = x;
    }

    @Override
    public void modificar(E x) {
       dato = x;
    }
    
}
