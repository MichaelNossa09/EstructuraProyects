
package TallerDeArboles;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class Persistencia{
         public void guardar(Materias x) throws FileNotFoundException, IOException{
             ObjectOutputStream ob = new ObjectOutputStream(new FileOutputStream("Archivo.txt"));
             ob.writeObject(x);
             ob.close();
         }
         public Materias recuperarMaterias(String nom) throws FileNotFoundException, IOException, ClassNotFoundException{
             ObjectInputStream ob= new ObjectInputStream(new FileInputStream(nom));
             Materias ar = (Materias) ob.readObject();
             ob.close();
             return ar;
        }
  }
