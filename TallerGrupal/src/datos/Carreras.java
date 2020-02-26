
package datos;

import java.util.ArrayList;

public class Carreras {
    private ArrayList<Taxi> taxi;
    private String direccion;
    private int valor;

    public Carreras(ArrayList<Taxi> taxi, String direccion, int valor) {
        this.taxi = taxi;
        this.direccion = direccion;
        this.valor = valor;
    }

    public ArrayList<Taxi> getTaxi() {
        return taxi;
    }

    public void setTaxi(ArrayList<Taxi> taxi) {
        this.taxi = taxi;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

   
}
