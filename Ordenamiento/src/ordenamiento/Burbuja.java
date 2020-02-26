
package ordenamiento;

import java.util.Scanner;


public class Burbuja {
       
    public static void main(String[] args) {
        long inicio = System.nanoTime();
        Scanner entrada = new Scanner(System.in);
        int nElementos;
       // System.out.println("INGRESE NUMERO DE ELEMENTOS: ");
        nElementos=100000;
        int v[] = new int[nElementos];
        for(int i=0;i<nElementos;i++){
            v[i] = (int) (Math.random()*1000);
        }
        String lis="";
        for (int i = 0; i < v.length; i++) {
            int j = v[i];
            lis+=" "+j;
        }
        System.out.println("Des: "+lis);
        for(int i =0;i<nElementos;i++){
            for(int j=0;j<nElementos-1;j++){
                if(v[j]>v[j+1]){
                    int T = v[j];
                    v[j]=v[j+1];
                    v[j+1] = T;
                }
            }
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
