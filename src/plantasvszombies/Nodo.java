/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package plantasvszombies;

/**
 *
 * @author icon
 */
public class Nodo {

    private String dato;
    private Nodo siguiente;
    private Nodo anterior;
    
    public Nodo(String dato){
        this.dato = dato;
        this.siguiente = null;
        this.anterior = null;
    }
    
    public Nodo(){
        this.dato = null;
        this.siguiente = null;
        this.anterior = null;
    }
    
    public String getDato() {
        return dato;
    }

    public void setDato(String dato) {
        this.dato = dato;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }

    public Nodo getAnterior() {
        return anterior;
    }

    public void setAnterior(Nodo anterior) {
        this.anterior = anterior;
    }
    
}





























