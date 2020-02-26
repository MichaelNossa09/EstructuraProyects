
package ordenamiento;

import java.util.Scanner;


public class Insercion {
    
    
    public static void main(String[] args) {
        long inicio = System.nanoTime();
        Scanner entrada = new Scanner(System.in);
        int nElementos, pos;
       // System.out.println("INGRESE NUMERO DE ELEMENETOS: ");
        nElementos = 100000;
        int v[] = new int[nElementos];
        for(int i=0;i<v.length;i++){
            v[i] = (int) (Math.random() * 1000);
        }
        String lis="";
        for(int i=0;i<v.length;i++){
            int j=v[i];
            lis+=" "+j;
        }
        System.out.println("Des: "+lis);
        
        for(int i=0;i<nElementos;i++){
            pos = i;
            int T = v[i];
            
            while((pos>0) && (v[pos-1])>T){
                v[pos] = v[pos-1];
                pos--;
            }
            v[pos] = T;
        }
        lis="";
        for(int i=0;i<v.length;i++){
            int j=v[i];
            lis+=" "+j;
        }
        System.out.println("Ord: "+lis);
        
        long fin = System.nanoTime();
        double dif = (double) (fin-inicio)*1.0e-9;
        System.out.println("El programa dura "+dif +" segundos.");
        
    }
            
    
    
    
    
    
    
}
