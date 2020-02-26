
package datos;


public class Taxi {
    private String placa;
    private String modelo;
    private String conductor;
    private String estado;
    private int carreras;

    public Taxi() {
    }

    public Taxi(String placa, String modelo, String conductor, String estado, int carreras) {
        this.placa = placa;
        this.modelo = modelo;
        this.conductor = conductor;
        this.estado = estado;
        this.carreras = carreras;        
    }

    public int getCarreras() {
        return carreras;
    }

    public void setCarreras(int carreras) {
        this.carreras = carreras;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    

    public String getConductor() {
        return conductor;
    }

    public void setConductor(String conductor) {
        this.conductor = conductor;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

   
    @Override
    public String toString() {
        return "\nTaxi"+"\nPlaca: "+placa+"\nModelo: "+modelo+"\nConductor: "+conductor+"\nEstado: "+estado+"\nCarreras: "+carreras;
    }
    
    
}
