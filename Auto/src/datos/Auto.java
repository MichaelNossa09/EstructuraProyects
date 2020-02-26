package datos;


public class Auto {
    private String placa;
    private String marca;
    private float costo;

    public Auto(String placa, String marca, float costo) {
        this.placa = placa;
        this.marca = marca;
        this.costo = costo;
    }
    
    
  
    public String getPlaca() {
        return placa;
    }

  
    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public float getCosto() {
        return costo;
    }

    public void setCosto(float costo) {
        this.costo = costo;
    }

    @Override
    public String toString() {
        return "\nAuto:" + "\nPlaca:" + placa + "\nMarca:" + marca + "\nCosto:" + costo;
    }
    
    
    
}
