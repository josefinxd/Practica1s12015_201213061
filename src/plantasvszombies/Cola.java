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
public class Cola {
    ListaPlantas listaPlantas;
    NodoJugadores primerNodo;
    
    public Cola(){
        this.primerNodo=null;
    }
    
    public void add(String img, String nombre, int atk, int def, String tipo){
        NodoJugadores nuevo = new NodoJugadores(img, nombre, atk, def, tipo);
        if(primerNodo == null){
            primerNodo = nuevo; 
            return;
        }
        
        NodoJugadores aux = primerNodo;
        while(aux != null){
            if(aux.getSiguiente()== null){
                aux.setSiguiente(nuevo); 
                return;
            }
            aux = aux.getSiguiente();
        }
    }
    
    public NodoJugadores popCola(){
        NodoJugadores aux = primerNodo;
        primerNodo = primerNodo.getSiguiente();
        return aux;
    }
    
    public void imprimir(){
        NodoJugadores aux = primerNodo;
        while(aux != null){
            System.out.println("Dato: " + aux.getImg()+", "+aux.getNombre()+", "
                    +aux.getAtk()+", "+aux.getDef()+", "+aux.getTipo());
            aux = aux.getSiguiente();
        }
    }
}
