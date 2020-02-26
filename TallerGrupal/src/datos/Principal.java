
package datos;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class Principal {
    public static int cc;
    public static int valor=0;
    static int cont=0;
    static ArrayList<Taxi> taxi = new ArrayList<>();
    static ArrayList<Conductor> cond = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int op;
        do{
        System.out.println("MENU:");
        System.out.println("1. INGRESAR TAXI.");
        System.out.println("2. INGRESAR CONDUCTOR.");
        System.out.println("3. MOSTRAR TAXIS.");
        System.out.println("4. MOSTRAR CONDUCTORES.");
        System.out.println("5. ASIGNAR CONDUCTOR.");
        System.out.println("6. DESASIGNAR CONDUCTOR.");
        System.out.println("7. ORDENAR TAXIS POR PLACA.");
        System.out.println("8. ORDENAR CONDUCTORES POR CEDULA.");
        System.out.println("9. BUSCAR CONDUCTOR POR NOMBRE."); 
        System.out.println("10.BUSCAR TAXI POR PLACA.");
        System.out.println("11.OCUPAR UN TAXI.");
        System.out.println("12.DESOCUPAR UN TAXI.");
        System.out.println("0. SALIR");
        op=sc.nextInt();
        switch(op){
            case 1:
                InsertarTaxi();
                break;
            case 2:
                InsertarConductor();
                break;
            case 3:
                MostrarTaxis();
                break;
            case 4:
                MostrarCond();
                break;
            case 5:          
                AsignarConductor();
                break;
            case 6:
                DesasignarConductor();
                break;
            case 7:
                Collections.sort(taxi, new TaxiPlacaSort());
                break;
            case 8:
                SeleccionConduc(cond);
                break;
            case 9:
                sc.nextLine();
                System.out.println("INGRESE NOMBRE DEL CONDUCTOR: ");
                String nombre = sc.nextLine();
                BuscarCond(nombre);
                break;
            case 10:
                sc.nextLine();
                System.out.println("INGRESE PLACA DEL TAXI A BUSCAR");
                String placa=sc.nextLine();
                if(busquedaBinaria(taxi, placa)!=-1){
                    System.out.println("SE ENCONTRO");
                }else{
                    System.out.println("NO SE ENCONTRO");
                }
                break;
            case 11:  
                AsignarCarrera(taxi);
                break;
            case 12:
                DesasignarCarrera(taxi);
                break;
        }
        }while(op!=0);
    }
    public static void InsertarTaxi(){
        sc.nextLine();
        System.out.println("INGRESE PLACA:");
        String placa = sc.nextLine();
        System.out.println("INGRESE MODELO:");
        String modelo=sc.next();
        taxi.add(new Taxi(placa,modelo,"","Desocupado",0));
    }
    public static void InsertarConductor(){
        System.out.println("INGRESE NOMBRE: ");
        String nombre = sc.next();
        sc.nextLine();
        System.out.println("INGRESE APELLIDO:");
        String apellido = sc.next();
        System.out.println("INGRESE NUMERO DE IDENTIFICACION: ");
        int cc = sc.nextInt();
        cond.add(new Conductor(nombre, apellido, cc));
    }
    public static void MostrarTaxis(){
        System.out.println("\n"+taxi);
    }
    public static void MostrarCond(){
        System.out.println("\n"+cond);
    }
    public static void AsignarConductor(){
        String conductor="";
        System.out.println(""+cond);
        System.out.println("INGRESE NUMERO DE IDENTIFICACION DE CONDUCTOR A ASIGNAR:");
        int cc = sc.nextInt();
        for(int i=0;i<cond.size();i++){
                if(cond.get(i).getCedula() == cc){
                 conductor=cond.get(i).getNombre();
             }
        }
        System.out.println(""+taxi);
        sc.nextLine();
        System.out.println("INGRESE PLACA DE TAXI A ASIGNARLE:");
        String placa = sc.nextLine();
        boolean sw=true;
        for(int i=0;i<taxi.size();i++){
            if(taxi.get(i).getConductor().equals(conductor)){
                System.out.println("Este Conductor No Esta Disponible");
                sw=false;
            }
        }
        while(sw==true){
            for(int i=0;i<taxi.size();i++){
                if(taxi.get(i).getPlaca().equals(placa)){
                String modelo=taxi.get(i).getModelo();
                if(taxi.get(i).getConductor() == ""){
                    int carreras=taxi.get(i).getCarreras();
                    taxi.set(i, new Taxi(placa, modelo, conductor,"Desocupado",carreras));
                    sw=false;
                }else{
                    System.out.println("Ya tiene conductor asignado.");
                    sw=false;
                }
            }
        }
    }
    }
    public static void DesasignarConductor(){
        System.out.println(""+taxi);
        sc.nextLine();
        System.out.println("INGRESE PLACA DEL TAXI DEL CONDUCTOR A QUITAR: ");
        String placa = sc.nextLine();
        for(int i =0;i<taxi.size();i++){
            String modelo = taxi.get(i).getModelo();
            if(taxi.get(i).getPlaca().equals(placa)){
                int carreras = taxi.get(i).getCarreras();
                   taxi.set(i, new Taxi(placa, modelo, "","Desocupado",carreras));
                   break;
            }
            
      }
    }
    public static void SeleccionConduc(ArrayList<Conductor> cond){
        ArrayList<Conductor> menor = new ArrayList<>();
        ArrayList<Conductor> t = new ArrayList<>();
        for(int i =0;i<cond.size();i++){
            menor.add(cond.get(i));
            int x=i;
            for(int j=i+1;j<cond.size();j++){
                if(cond.get(j).getCedula()<menor.get(i).getCedula()){
                    menor.set(i,cond.get(j));
                    x=j;
                }
            }
            t.add(cond.get(i));
            cond.set(i, cond.get(x));
            cond.set(x, t.get(i));
        }
    }
    public static void BuscarCond(String nombre){
        boolean sw=false;
        for(int i =0;i<cond.size();i++){
            if(cond.get(i).getNombre().equals(nombre)){
                sw=true;
            }
        }
        if(sw==false){
            System.out.println("NO SE ENCONTRO.");
        }else{
            System.out.println("CONDUCTOR ENCONTRADO.");
        }
    }
    public static int busquedaBinaria(ArrayList<Taxi> taxi, String placa) {
    
    int izquierda = 0, derecha = taxi.size() - 1;
 
    while (izquierda <= derecha) {
        int centro = (int) Math.floor((izquierda + derecha) / 2);
        String elementoDelCentro = taxi.get(centro).getPlaca();
        int resultadoDeLaComparacion = placa.compareTo(elementoDelCentro);
        if (resultadoDeLaComparacion == 0) {
            return centro;
        }
        if (resultadoDeLaComparacion < 0) {
            derecha = centro - 1;
        } else {
            izquierda = centro + 1;
        }
    }
    return -1;
}
    public static void AsignarCarrera(ArrayList<Taxi> taxi){
        String estado="Desocupado";
        System.out.println(""+taxi);
        sc.nextLine();
        System.out.println("INGRESE PLACA DEL TAXI A ASIGNARLE UNA CARRERA");
        String placa = sc.nextLine();
        for(int i=0;i<taxi.size();i++){
            int car = taxi.get(i).getCarreras();
            if(taxi.get(i).getPlaca().equals(placa)){
              if(taxi.get(i).getConductor() == ""){
                  System.out.println("PRIMERO ASIGNELE UN CONDUCTOR.");
              }else{
                if(taxi.get(i).getEstado().equals("Ocupado")){
                    System.out.println("Error, Taxi ocupado.");
                }
                if(taxi.get(i).getEstado().equals("Desocupado")){
                String modelo = taxi.get(i).getModelo();
                String conductor = taxi.get(i).getConductor();
                System.out.println("DIGITE VALOR DE LA CARRERA: ");
                valor +=sc.nextInt();
                sc.nextLine();
                System.out.println("INGRESE DIRECCION: ");
                String direccion=sc.nextLine(); 
                taxi.set(i, new Taxi(placa, modelo, conductor, "Ocupado", car));
                
               }
           }
          }
        }
        
    }
    public static void DesasignarCarrera(ArrayList<Taxi> taxi){
        System.out.println(""+taxi);
        sc.nextLine();
        System.out.println("INGRESE PLACA DEL TAXI A DESOCUPAR");
        String placa = sc.nextLine();
        for(int i=0;i<taxi.size();i++){
            int car = taxi.get(i).getCarreras() + 1;
            if(taxi.get(i).getPlaca().equals(placa)){
                if(taxi.get(i).getEstado().equals("Desocupado")){
                    System.out.println("No es posible desocupar un taxi no ocupado.");
                }
                if(taxi.get(i).getEstado().equals("Ocupado")){
                    String modelo=taxi.get(i).getModelo();
                    String conduc = taxi.get(i).getConductor();
                    taxi.set(i, new Taxi(placa, modelo, conduc, "Desocupado", car));
                }
            }
        }
    }
}
