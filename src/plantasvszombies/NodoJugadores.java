/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package plantasvszombies;

/**
 *
 * @author Jose Angel
 */
public class NodoJugadores {
    private String img;
    private String nombre;
    private int atk;
    private int def;
    private String tipo;    
    private NodoJugadores siguiente;
    private NodoJugadores anterior;
    
    public NodoJugadores(String img, String nombre, int atk, int def, String tipo){
        this.img=img;
        this.nombre=nombre;
        this.atk=atk;
        this.def=def;
        this.tipo=tipo;
        this.siguiente = null;
    }   
    
    public NodoJugadores(){
        this.img=null;
        this.nombre=null;
        this.atk=0;
        this.def=0;
        this.siguiente = null;
        this.anterior = null;
    }   
   
    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
    
    public String getNombre() {
        return img;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public int getAtk() {
        return atk;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }
    
    public int getDef() {
        return def;
    }

    public void setDef(int def) {
        this.def = def;
    }  
    
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    public NodoJugadores getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoJugadores siguiente) {
        this.siguiente = siguiente;
    }

    public NodoJugadores getAnterior() {
        return anterior;
    }

    public void setAnterior(NodoJugadores anterior) {
        this.anterior = anterior;
    }
}
