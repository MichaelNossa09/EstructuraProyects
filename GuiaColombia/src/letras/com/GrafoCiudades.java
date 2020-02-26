
package letras.com;

import datos.Grafo;
import datos.GrafoMat;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
 
public class GrafoCiudades implements Interface, Serializable{
    static Persistencia p = new Persistencia();
    static int inf=9999999;
    static Grafo<Ciudades> gra = new GrafoMat<>();
    static Scanner entrada = new Scanner(System.in);
    static ArrayList<Integer> visitado = new ArrayList<>();
    static ArrayList<String> suc= new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
   // static GrafoCiudades c = new GrafoCiudades();
    public Grafo<Ciudades> crear() {
       
        h.add(new hoteles("Irotama Resort","Km 14 via cienaga"));
        h.add(new hoteles("Hotel Boutique Don Pepe", "Calle 16 # 1C-92"));
        r.add(new restaurantes("Ouzo", "Kra 3 # 19-29"));
        r.add(new restaurantes("LamArt", "Kra 3 # 16-36"));
        sT.add(new sitiosTuristicos("Parque Tayrona"));
        sT.add(new sitiosTuristicos("Acuario y Museo del Mar"));
        sT.add(new sitiosTuristicos("TAGANGA"));
        pT.add(new platosTipicos("Cayeye"));
        pT.add(new platosTipicos("Coctel de Camarón"));
        pT.add(new platosTipicos("Pescado frito con Patacón"));
        gra.insVertice(new Ciudades("Santa Marta", h, r, sT, pT ));
        h1.add(new hoteles("GHL Collection", "Calle 107 #50-69"));
        h1.add(new hoteles("Crowne Plaza", "Kra 57 # 99A-65"));
        r1.add(new restaurantes("Mailia ", "Kra 48 # 74-71"));
        r1.add(new restaurantes("Varadero", "Kra 51B #79-97"));
        sT1.add(new sitiosTuristicos("Zoologico de Barranquilla"));
        sT1.add(new sitiosTuristicos("Museo del Caribe"));
        sT1.add(new sitiosTuristicos("Castillo de San Antonio de Salgar"));
        pT1.add(new platosTipicos("Arroz de lisa"));
        pT1.add(new platosTipicos("Enyucado"));
        pT1.add(new platosTipicos("Bollo de Yuca"));
        gra.insVertice(new Ciudades("Barranquilla", h1, r1, sT1, pT1));
        h2.add(new hoteles("Hotel Casa San Agustín", "Calle de la Universidad 36-44 Centro Historico"));
        h2.add(new hoteles("Hotel Quadrifolio", "Calle del cuartel(Kra 5) # 36-118"));
        r2.add(new restaurantes("InterContinental", "Kra 1 # 51"));
        r2.add(new restaurantes("Di Silvio Trattoria Getsemani", "Calle 29 ## 9A-08"));
        sT2.add(new sitiosTuristicos("Castillo de San Felipe de Barajas"));
        sT2.add(new sitiosTuristicos("Palacio de la Inquisicion"));
        sT2.add(new sitiosTuristicos("Plaza de Las Bóvedas"));
        pT2.add(new platosTipicos("Pie de coco"));
        pT2.add(new platosTipicos("Bagre Frito"));
        pT2.add(new platosTipicos("Posta Negra"));
        gra.insVertice(new Ciudades("Cartagena", h2, r2, sT2, pT2));
        h3.add(new hoteles("Marriot Hotel", "Calle 1A Sur #43A-83"));
        h3.add(new hoteles("Hotel Intercontinental Medellin", "Calle 16 28-81"));
        r3.add(new restaurantes("Mercado del Rio", "Calle 24 #48-28"));
        r3.add(new restaurantes("Barbaro Cocina Primitiva", "Kra 76 #73B-39"));
        sT3.add(new sitiosTuristicos("Museo del Castillo"));
        sT3.add(new sitiosTuristicos("Metrocable de Meddelín"));
        sT3.add(new sitiosTuristicos("Plaza de la Libertad"));
        pT3.add(new platosTipicos("Bandeja Paisa"));
        pT3.add(new platosTipicos("Morcilla Antioqueña"));
        pT3.add(new platosTipicos("Fríjoles con Pezuña"));
        gra.insVertice(new Ciudades("Medellin", h3, r3, sT3, pT3));
        
        
        gra.insArista(0, 1, 2);
        gra.insArista(0, 2, 5);
        gra.insArista(0, 3, 15);
        gra.insArista(1, 0, 2);
        gra.insArista(1, 2, 2);
        gra.insArista(1, 3, 13);
        
        //gra.insArista(2, 0, 4);
        gra.insArista(2, 1, 2);
        gra.insArista(2, 3, 12);
       
        gra.insArista(3, 1, 13);
        gra.insArista(3, 2, 12);
        
        return gra;
   
    }
    
    public void insertarVertice(){
        ArrayList<hoteles> x = new ArrayList<>();
        ArrayList<restaurantes> xR = new ArrayList<>();
        ArrayList<sitiosTuristicos> xST = new ArrayList<>();
        ArrayList<platosTipicos> xPT = new ArrayList<>();
        String nombreC,nombre,direccion;
        System.out.println("INGRESE NOMBRE DE LA CIUDAD:");
        nombreC = entrada.next();
        System.out.println("INGRESE 5 HOTELES IMPORTANTES DE: "+nombreC);
        for(int i=0; i<5;i++){
            System.out.println("INGRESE NOMBRE DEL HOTEL: "+i);
            nombre = entrada.next();
            System.out.println("INGRESE DIRECCION DEL HOTEL: ");
            direccion = entrada.next();
            x.add(new hoteles(nombre, direccion));
        }
        System.out.println("INGRESE 5 RESTAURANTES DE: "+nombreC);
        for(int y= 0; y<5; y++){
            System.out.println("INGRESE NOMBRE DEL RESTAURANTE: "+y);
            nombre=entrada.next();
            System.out.println("INGRESE DIRECCION DEL RESTAURANTE: ");
            direccion=entrada.next();
            xR.add(new restaurantes(nombre, direccion));
        }
        System.out.println("INGRESE 5 SITIOS TURISTICOS DE: "+nombreC);
        for(int j = 0; j<5;j++){
            System.out.println("INGRESE NOMBRE DEL SITIO TURISTICO: "+j);
            nombre=entrada.next();
            xST.add(new sitiosTuristicos(nombre));
        }
        System.out.println("INGRESE 5 PLATOS TIPICOS DE: "+nombreC);
        for(int h=0; h<5; h++){
            System.out.println("INGRESE NOMBRE DEL PLATO: "+h);
            nombre=entrada.next();
            xPT.add(new platosTipicos(nombre));
        }
        gra.insVertice(new Ciudades(nombreC, x, xR, xST, xPT));
        
    }
    public void insertarDestino(Grafo<Ciudades> gra){
        String nombreS, nombreL;
        int tiempo;
        
        entrada.nextLine();
        System.out.println("INGRESE CIUDAD DE ORIGEN: ");
        nombreS = entrada.nextLine();
        System.out.println("INGRESE CIUDAD DE DESTINO: ");
        nombreL= entrada.nextLine();
        System.out.println("INGRESE TIEMPO DE DURACION EN BUS: ");
        tiempo=entrada.nextInt();
        boolean f=false;
        for(int i = 0 ; i <gra.orden();i++){
            if(gra.obtVertice(i).getNombre().equals(nombreS)){
                for(int j = 0 ; j <gra.orden();j++){
                    if(gra.obtVertice(j).getNombre().equals(nombreL)){
                        gra.insArista(i, j, tiempo);
                        f=true;
                    }
                }
            }
             
        }
        if(f==true){
            System.out.println("INSERTADO");
        }
       
    }
    public void eliminarDestino(Grafo<Ciudades> gra){
        String nombreS, nombreL;
        entrada.nextLine();
        System.out.println("INGRESE CIUDAD DE ORIGEN:");
        nombreS=entrada.nextLine();
        System.out.println("INGRESE CIUDAD DE DESTINO:");
        nombreL=entrada.nextLine();
        boolean x =false;
        for(int i = 0 ; i <gra.orden();i++){
            if(gra.obtVertice(i).getNombre().equals(nombreS)){
                for(int j=0;j<gra.orden();j++){
                    if(gra.obtVertice(j).getNombre().equals(nombreL)){
                        gra.elimArista(i, j);
                        x=true;
                    }
                }
            }
        }
        if(x==true){
            System.out.println("ELIMINADO");
        }
    }
    
    public static void main(String[] args) throws IOException, FileNotFoundException, ClassNotFoundException{
        GrafoCiudades ob = new GrafoCiudades();
        Dijkstra x = new Dijkstra();
        Grafo<Ciudades> crear = ob.crear();
        int op;
        do{
            System.out.println("MENU:");
            System.out.println("1. AGREGAR DESTINO.");
            System.out.println("2. ELIMINAR DESTINO.");
            System.out.println("3. MOSTRAR");
            System.out.println("4. CONOCER TIEMPO DE ORIGEN A DESTINO:");
            System.out.println("5. RECORRIDO SIN IMPORTAR COSTO:");
            System.out.println("6. CAMINO MINIMO:");
            System.out.println("7. GUARDAR DATOS");
            System.out.println("8. RECUPERAR DATOS");
            System.out.println("9. SALIR");
            op=entrada.nextInt();
            
            switch(op){
                case 1: ob.insertarDestino(gra);
                break;
                case 2: ob.eliminarDestino(gra);
                break;
                case 3:{
                ob.mostrar(gra);      
                break;
                }
                case 4: ob.mostrarTiempo(gra);
                break;
                case 5:
                    System.out.println("INGRESE CIUDAD ORIGEN: ");
                    String origen = sc.nextLine();
                    int vi=0;
                    for(int i=0;i<gra.orden();i++){
                        if(gra.obtVertice(i).getNombre().equals(origen)){
                            vi=i;
                        }
                    }
                    ob.dfs(gra, vi);
                    System.out.println(" "+visitado);
                    break;
                case 6:
                    int v=0;
                    System.out.println("HOLA");
                    System.out.println("INGRESE CIUDAD ORIGEN:");
                    origen = sc.nextLine();
                    for(int i=0;i<gra.orden();i++){
                        if(gra.obtVertice(i).getNombre().equals(origen)){
                            v=i;
                        }
                    }
                    x.Dijkstra(gra, v);
                    x.Cminimo();
                    break;
                case 7:
                    p.guardar(gra);
                    break;
                case 8: 
                    gra = p.recuperarGrafo("Grafo.txt");
                    System.out.println("RECUPERADO.");
                    break;
                case 9:
                    break;
            }
            
        }while(op!=9);
       
        //System.out.println("INGRESE VALOR");
        //int vi=sc.nextInt();
       // System.out.println("DFS");
       // ob.dfs(crear, vi);
       // visitado.removeAll(visitado);
        //System.out.println("BFS");
       // ob.bfs(crear, vi);
        
    }
    
    public void mostrarTiempo(Grafo<Ciudades> gra){
        String origen, destino;
        int tiempo=0;
        entrada.nextLine();
        System.out.println("INGRESE ORIGEN: ");
        origen=entrada.nextLine();
        System.out.println("INGRESE DESTINO: ");
        destino=entrada.nextLine();
        for(int i=0;i<gra.orden();i++){
            if(gra.obtVertice(i).getNombre().equals(origen)){
                for(int j=0;j<gra.orden();j++){
                    if(gra.obtVertice(j).getNombre().equals(destino)){
                        if(gra.obtArista(i, j)!=inf && gra.obtArista(i, j)!=0){
                            System.out.println("EL TIEMPO ES DE: "+gra.obtArista(i, j)+" HORAS APROXIMADAMENTE.");
                            System.out.println("DATOS A TENER EN CUENTA: "+gra.obtVertice(j));
                           
                     }
        }
                        }
                    }
                }
            }
        
    
    public void mostrar(Grafo<Ciudades> gra){
        
        for(int i=0; i<gra.orden();i++){
            System.out.println(""+gra.obtVertice(i).getNombre());
            System.out.println(""+gra.obtVertice(i).getC());
            System.out.println(""+gra.obtVertice(i).getR());
            System.out.println(""+gra.obtVertice(i).getsT());
            System.out.println(""+gra.obtVertice(i).getpT());
            System.out.println("SUS DESTINOS SON: ");
            System.out.println(""+gra.sucesores(i));
            System.out.println("\n");
        }
        
        
        
        
    }
   public static int posi(Grafo<Ciudades> gra, Ciudades x){
       
       for(int i = 0; i<gra.orden();i++){
           if(gra.obtVertice(i)== x){
               return i;
           }
       }
       return -1;
   }   
    
   public void dfs(Grafo<Ciudades> gra, int  vi){
    
       visitado.add(vi);
       ArrayList<Ciudades> sucesores = gra.sucesores(vi);
       for(Ciudades x : sucesores) {
           int pos = posi(gra, x);
           if(!visitado.contains(pos)){
               dfs(gra, pos);
       }  
     }
   }
       
       
 /*      
    
  public void bfs(Grafo<Integer> g, int vi){
        LinkedList<Integer> cola = new LinkedList<>();
        cola.addLast(vi);
       // visitado.add(vi);
        while(!cola.isEmpty()){
            int x = cola.removeFirst();
            System.out.println(x);
            ArrayList<Integer> suc = g.sucesores(x);
            for (Integer s : suc) {
                if(!visitado.contains(s)){
                    cola.addLast(s);
         //           visitado.add(s);
                }
            }
        }
    }
*/
}

