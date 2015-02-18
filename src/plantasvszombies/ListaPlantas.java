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
public class ListaPlantas {
    private NodoPlanta primerNodo;
    
    public ListaPlantas(){
        this.primerNodo = null;
    }
    
    public void add(String nombre, String campo){
        NodoPlanta nuevo = new NodoPlanta(nombre, campo);
        if(primerNodo == null){
            primerNodo = nuevo; 
            return;
        }
        
        NodoPlanta aux = primerNodo;
        while(aux != null){
            if(aux.getSiguiente()== null){
                aux.setSiguiente(nuevo); 
                return;
            }
            aux = aux.getSiguiente();
        }
    }
        
        public String popCola(){
            NodoPlanta aux = primerNodo;
            primerNodo = primerNodo.getSiguiente();
            return aux.getCampo();
        }
    
    public void imprimir(){
        NodoPlanta aux = primerNodo;
        while(aux != null){
            System.out.println("Nombre: "+aux.getNombre()+" Dato: " + aux.getCampo());
            aux = aux.getSiguiente();
        }
    }    
}
