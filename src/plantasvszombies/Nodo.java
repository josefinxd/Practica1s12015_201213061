/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package plantasvszombies;

import javax.swing.JButton;

/**
 *
 * @author icon
 */
public class Nodo extends JButton{

    private String dato;
    public int fila;
    public int columna;
    private Nodo siguiente;
    private Nodo anterior;
    private Nodo abajo;
    private Nodo arriba;
    
    public Nodo(String dato){
        this.dato = dato;
        this.siguiente = null;
        this.anterior = null;
        this.abajo=null;
        this.arriba=null;
    }
    
    public Nodo(){
        this.dato = null;
        this.siguiente = null;
        this.anterior = null;
        this.abajo=null;
        this.arriba=null;        
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
    
    public Nodo getAbajo(){
        return abajo;
    }
    
    public void setAbajo(Nodo abajo){
        this.abajo=abajo;
    }
    
    public Nodo getArriba(){
        return arriba;
    }
    
    public void setArriba(Nodo arriba){
        this.arriba=arriba;
    }
}





























