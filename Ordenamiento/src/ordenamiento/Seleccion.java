
package ordenamiento;

import java.util.Scanner;


public class Seleccion {
   
    public static void main(String[] args) {
      long inicio = System.nanoTime();
      int nElementos;
      Scanner entrada = new Scanner(System.in);
      //System.out.println("INGRESE CANTIDAD DE DATOS: ");
      nElementos =100000;
      int v[] = new int[nElementos];
      for (int i = 0; i<v.length; i++) {
            v[i]=(int) (Math.random()*1000);
      }
      String lis="";
      for (int i = 0; i < v.length; i++) {
            int j = v[i];
            lis+=" "+j;
      }
      System.out.println("Des: "+lis);
      for (int i = 0; i <v.length; i++) {
            int menor=v[i];
            int x=i;
            for (int j = i+1; j < v.length; j++) {
                if(v[j]<menor){
                    menor=v[j];
                    x=j;
                }
                
            }
            int T=v[i];
            v[i]=v[x];
            v[x]=T;
        }
      lis="";
      for (int i = 0; i < v.length; i++) {
            int j = v[i];
            lis+=" "+j;
      }
      System.out.println("Ord: "+lis);
      long fin = System.nanoTime();
      double dif = (double) (fin-inicio)*1.0e-9;
      System.out.println("El programa dura "+dif +" segundos.");
        
    }
}
