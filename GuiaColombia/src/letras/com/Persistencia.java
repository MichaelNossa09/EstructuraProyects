
package letras.com;

import datos.Grafo;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;


public class Persistencia implements Serializable{
    
    public void guardar(Grafo<Ciudades> x) throws FileNotFoundException, IOException{
             ObjectOutputStream ob = new ObjectOutputStream(new FileOutputStream("Grafo.txt"));
             ob.writeObject(x);
             ob.close();
         }
         public Grafo<Ciudades> recuperarGrafo(String nombre) throws FileNotFoundException, IOException, ClassNotFoundException{
             ObjectInputStream ob= new ObjectInputStream(new FileInputStream(nombre));
             Grafo<Ciudades> gra = (Grafo<Ciudades>) ob.readObject();
             ob.close();
             return gra;
        }
}
