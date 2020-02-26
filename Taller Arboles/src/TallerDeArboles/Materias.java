
package TallerDeArboles;

import java.io.Serializable;
import javax.swing.JOptionPane;


public class Materias implements Serializable{
    
    private int codigo;
    private String nombre;
    private int creditos;
    private float nota;
    private int periodo;

    public Materias() {
    }

    public Materias(String nombre, float nota) {
        this.nombre = nombre;
        this.nota = nota;
    }

    public Materias(String nombre) {
        this.nombre = nombre;
    }

   
    
    public Materias(int codigo) {
        this.codigo = codigo;
    }

    public Materias(int codigo, String nombre, int creditos, float nota, int periodo) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.creditos = creditos;
        this.nota = nota;
        this.periodo = periodo;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        if(codigo>0){
            this.codigo = codigo;
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos){
        if(creditos>=0){
            this.creditos = creditos;
        }
     }

    public float getNota() {
        return nota;
    }

    public void setNota(float nota){
        if(nota >= 0 ){
            this.nota = nota;
        }
    }

    public int getPeriodo() {
        return periodo;
    }

    public void setPeriodo(int periodo){
            this.periodo = periodo;
        
    }
    
    
}
