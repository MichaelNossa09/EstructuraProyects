/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

/**
 *
 * @author Jorge Mario
 */
public class Arista {
    private Nodo origin;
    private Nodo destination;
    private double tiempo;
 
    public Arista(Nodo origin, Nodo destination, double tiempo) {
        this.origin = origin;
        this.destination = destination;
        this.tiempo = tiempo;
    }
 
    public Nodo getOrigin() {
        return origin;
    }
 
    public void setOrigin(Nodo origin) {
        this.origin = origin;
    }
 
    public Nodo getDestination() {
        return destination;
    }
 
    public void setDestination(Nodo destination) {
        this.destination = destination;
    }
 
    public double getTiempo() {
        return tiempo;
    }
 
    public void setTiempo(double tiempo) {
        this.tiempo = tiempo;
    }
 
    @Override
    public String toString() {
        return "\n Arista [Origen=" + origin.getCiudad() + ", destination=" + destination.getCiudad() + ", Tiempo="
                + tiempo + "]";
    }
}
