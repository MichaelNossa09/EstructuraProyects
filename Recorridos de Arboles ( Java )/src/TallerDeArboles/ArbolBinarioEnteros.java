package TallerDeArboles;

import TallerDeArboles.Materias;
import TallerDeArboles.Persistencia;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;
import javax.swing.JOptionPane;
/*
  MICHAEL NOSSA
  JORGE DIAZ 
  GRUPO 1 
  ESTRUCTURA DE DATOS II.
   

RESULTADOS: 
1. Calculo                 4        350            1
2. Calculo Integral        4        500            2 
3. Estadistica l           3        250            2
4. Algebra Lineal          3        290            2 
5. Catedra                 2        450            3
6. Razonamiento            2        298            1


Promedio Ponderado = 362.0
Numero de Materias Perdidas = 3
Mejores materias: Calculo Integral, Catedra, Calculo, Algebra Lineal y Razonamiento.
*/
public class ArbolBinarioEnteros implements Serializable {
    private Arbin<Materias> raiz;
    static ArrayList<Materias> materias= new ArrayList<>();
    static ArrayList<Materias> mejores = new ArrayList<>();
    static public int cont=0;
    static public float creditoss=0;
    static public float suma=0;
    static public float promedio=0;
   static public int materiasPerdidas=0;
  //  static public String[] nombres;
  //  static public float nota =  0;
    public Arbin<Materias> getRaiz() {
        return raiz;
    }
    
    public void insertar(Materias x){
        
        if(raiz==null){
            raiz=new ArbinEnl<>(x);
        }else{
            insertar(raiz, x);
        }
        
        
    }
    private void insertar(Arbin<Materias> r, Materias x){
         if(x.getCodigo()<r.obtener().getCodigo()){
            if(r.izq()==null){
                r.enlIzq(new ArbinEnl<>(x));
            }else{
                insertar(r.izq(), x);
            }
        }else{
            if(r.der()==null){
                r.enlDer(new ArbinEnl<>(x));
            }else{
                insertar(r.der(), x);
            }
        
        }
    }
    String res = "";
    public String listar(){
        res="ASIGNATURAS:";
        inorden(raiz);
        return res;
    }
    private void inorden(Arbin<Materias> r){
      
        if(r!=null){
            inorden(r.izq());
            res+="\n - "+r.obtener().getNombre();
            inorden(r.der());
        }
    }
    public static void main(String[] args) throws IOException, FileNotFoundException, ClassNotFoundException{
        ArbolBinarioEnteros arbol = new ArbolBinarioEnteros();
        Materias m = new Materias();
        Scanner sc = new Scanner(System.in);
        Persistencia p = new Persistencia();
        String menu= "MENÚ : \n1. Insertar \n2. Listar  \n3. Buscar \n4. Eliminar \n5.PromedioPonderado \n 6.MateriasPerdidas \n 7.Semestre Actual "
                + "\n 8. Mejores 5 Notas \n 9. Salir";
        salir:do{
              
              String opcion = JOptionPane.showInputDialog(menu);
              int op = Integer.parseInt(opcion);
          switch(op){
                  case 1: 
                         boolean f = true;
                         String codigo = JOptionPane.showInputDialog("INGRESE CODIGO DE LA MATERIA:");
                         int cod = Integer.parseInt(codigo);
                         String nombre = JOptionPane.showInputDialog("INGRESE NOMBRE DE LA MATERIA : ");
                         String creditos = JOptionPane.showInputDialog("INGRESE CREDITOS DE LA MATERIA : ");
                         int cred = Integer.parseInt(creditos);
                         String nota = JOptionPane.showInputDialog("INGRESE NOTA DE LA MATERIA : ");
                         float not = Float.parseFloat(nota);
                         String periodo = JOptionPane.showInputDialog("INGRESE SEMESTRE DE LA MATERIA: ");
                         int semestre = Integer.parseInt(periodo);
                         materias.add(new Materias(nombre, not));
                         Materias e1 = new Materias(cod, nombre, cred, not, semestre);
                         for(int i=1; i<materias.size();i++){
                             if(materias.get(i-1).getNombre().equals(nombre)){
                                JOptionPane.showMessageDialog(null,"YA EXISTE ESTA MATERIA");
                                f=false;
                             }
                         }
                         if(f==true){
                             if(cod>0 && cred>0 && not>0 && semestre>0 ){   
                            arbol.insertar(e1);
                         }else{
                             JOptionPane.showMessageDialog(null,"INGRESE DATOS VALIDOS.");
                         }
                         }
                         break;
                  case 2:
                        String x =  arbol.listar();
                        JOptionPane.showMessageDialog(null, x);
                        break;
                  case 3:
                        String materia = JOptionPane.showInputDialog("INGRESE CODIGO DE LA MATERIA: ");   
                        int mate = Integer.parseInt(materia);
                        JOptionPane.showMessageDialog(null, arbol.busqueda(arbol.getRaiz(), new Materias(mate)));
                      break;
                  case 4:String elim = JOptionPane.showInputDialog("INGRESE CODIGO DE LA MATERIA: ");
                        int codi = Integer.parseInt(elim);
                         arbol.eliminar(arbol.getRaiz(), new Materias(codi));          
                      break;
                  case 5:
                      arbol.promedioPonderado(arbol.getRaiz());
                      JOptionPane.showMessageDialog(null, "El promedio es: "+promedio);
                      //IGUALAMOS TODO A 0 PARA NO PRESENTAR PROBLEMAS AL DARLE AL CASO 5 NUEVAMENTE O AL INSERTAR/ELIMINAR UNA NUEVA MATERIA.
                      promedio=0;
                      suma=0;
                      creditoss=0;
                      break;
                  case 6:
                      //IGUALAMOS TODO A 0 PARA NO PRESENTAR PROBLEMAS AL DARLE AL CASO 6 NUEVAMENTE O AL INSERTAR/ELIMINAR UNA NUEVA MATERIA.
                       arbol.materiasPerdidas(arbol.getRaiz());
                       JOptionPane.showMessageDialog(null, "La cantidad de materias perdidas es: "+materiasPerdidas);
                       materiasPerdidas = 0;
                       cont = 0;
                       break;
                  case 7:
                      arbol.semetre(arbol.getRaiz());
                      suma=0;
                      break;
                  case 8:
                      JOptionPane.showMessageDialog(null ,"MEJORES 5 MATERIAS: ");
                      arbol.ordenar();
                      materias.removeAll(mejores);
                      break;
                  case 9: 
                      p.guardar(m);
                      break salir;
               }
    
        }while(true);
        
        
    }
     public boolean busqueda(Arbin<Materias> r,Materias x){
         if(r==null){
             return false;
         }else{
             if(r.obtener().getCodigo()==x.getCodigo()){
                 return true;
             }else{
                 if(x.getCodigo()<r.obtener().getCodigo()){
                     return busqueda(r.izq(),x);
                 }else{
                     return busqueda(r.der(), x);
                 }
             }
         }
     }
     public Arbin<Materias> mayor(Arbin<Materias> r){
         if(r.der()!=null){
             return mayor(r.der());
         }else{
             return r;
         }
     }
     public void eliminar(Materias x){
         if(busqueda(raiz, x)){
             raiz = eliminar(raiz, x);
         }
     }
     private Arbin<Materias> eliminar(Arbin<Materias> r, Materias x){
         if(x.getCodigo()==r.obtener().getCodigo()){
             return borrar(r,x);
         }else{
             if(x.getCodigo()<r.obtener().getCodigo()){
                 r.enlIzq(eliminar(r.izq(), x));
             }else{
                 r.enlDer(eliminar(r.der(), x));
             }
             return r;
         }
     }
     private Arbin<Materias> borrar(Arbin<Materias> r, Materias x){
         if(r.izq()==null && r.der()==null){
             return null;
         }else{
             if(r.izq()==null){
                 return r.der();
             }else{
                 if(r.der()==null){
                     return r.izq();
                 }else{
                     Arbin<Materias> remp = mayor(r.izq());
                     r.modificar(remp.obtener());
                     r.enlIzq(eliminar(r.izq(), remp.obtener()));
                     return r;
                     
                 }
             }
         }
     }
     private void sumar(Arbin<Materias> r){
         // Se suman los creditos y el valor de la nota * el credito para poder sacar el ponderado
         if(r!=null){
             suma = suma + r.obtener().getNota() * r.obtener().getCreditos();
             creditoss = creditoss + r.obtener().getCreditos();
            sumar(r.izq());
            sumar(r.der());
         }
     }
     public void promedioPonderado(Arbin<Materias> r){
        //Se llama la función y se realiza la operacion para poder mostrar 
        sumar(r);
        if(r!=null){             
            if(suma>=0 && creditoss>=0){
                promedio = suma/creditoss;
            } 
         }  
   }
     private void sumarMateriasPerdidas(Arbin<Materias> r){
         //Sumamos la cantidad de materias con nota menor a 300
         if(r!=null){
             if(r.obtener().getNota()>0 && r.obtener().getNota()<300){
                 cont = cont + 1;
             }
             sumarMateriasPerdidas(r.izq());
             sumarMateriasPerdidas(r.der());
         }
     }
     public void materiasPerdidas(Arbin<Materias> r){
         //Llamamos la función y le damos el valor a la variable para poder mostrar
         sumarMateriasPerdidas(r);
         if(r!=null){
            if(cont >= 0 ){
                materiasPerdidas = cont;
            }
         }
     
     }
     private void contarCreditos(Arbin<Materias> r){
         //Contamos la cantidad de creditos ingresados en total
         if(r!=null){
             suma = suma + r.obtener().getCreditos();
             contarCreditos(r.izq());
             contarCreditos(r.der());
         }
     }
     public void semetre(Arbin<Materias> r){
         //Comparamos la cantidad de creditos y dependiendo la cantidad, indica el semestre cursando
         contarCreditos(r);
         if(r!=null){
             if(suma >0 && suma<=16){
                 JOptionPane.showMessageDialog(null, "Primer Semestre");
             }
             if(suma >16 && suma <=32){
                 JOptionPane.showMessageDialog(null, "Segundo Semestre");
             }
             if(suma >32 && suma <=48){
                 JOptionPane.showMessageDialog(null, "Tercer Semestre");
             }
             if(suma >48 && suma <=64){
                 JOptionPane.showMessageDialog(null, "Cuarto Semestre");
             }
             if(suma >64 && suma<=80){
                 JOptionPane.showMessageDialog(null, "Quinto Semestre");
             }
             if(suma >80 && suma <=96){
                 JOptionPane.showMessageDialog(null, "Sexto Semestre");
             }
             if(suma >96 && suma <=112){
                 JOptionPane.showMessageDialog(null, "Séptimo Semestre");
             }
             if(suma >112 && suma <=128){
                 JOptionPane.showMessageDialog(null, "Octavo Semestre");
             }
             if(suma >128 && suma <=144){
                 JOptionPane.showMessageDialog(null, "Noveno Semestre");
             }
             if(suma >144 && suma <=160){
                 JOptionPane.showMessageDialog(null, "Décimo Semestre");
             }
             
         }
     }
     public void ordenar(){
         if(materias.size()!=0){
         String aux;
         
         for(int i=0; i<materias.size();i++){
                for(int j=i+1;j<materias.size();j++){
                    if(materias.get(i).getNota()<materias.get(j).getNota()){
                        aux = materias.get(i).getNombre();
                        materias.get(i).setNombre(materias.get(j).getNombre());
                        materias.get(j).setNombre(aux);
                        mejores.add(new Materias(materias.get(i).getNombre()));
                    }
                }
         }
         for(int i=0; i<5;i++){
             JOptionPane.showMessageDialog(null, mejores.get(i).getNombre());
         }
         
         
         
     }
     }
   
    
}
     