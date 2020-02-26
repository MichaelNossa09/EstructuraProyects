package datos;


import datos.Auto;
import java.util.ArrayList;


public class Concesionario {
    
    private ArrayList<Auto> autos = new ArrayList<>();

    public Concesionario() {
        autos=new ArrayList<>();
    }
    public void addAuto(Auto a){
        autos.add(a);
    }
    public String listar(){
        String lis="";
        for(Auto auto : autos) {
            lis+=" "+auto.toString()+"\n";
        }
        return lis;
    }

    public ArrayList<Auto> getAutos() {
        return autos;
    }
    
    
    
}
