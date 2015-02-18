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
public class NodoPlanta {
    private String nombre;
    private String campo;
    private NodoPlanta siguiente;
    
    public NodoPlanta(String nombre, String campo){
        this.nombre=nombre;       
        this.campo=campo;
        this.siguiente=null;
    }
    
    public NodoPlanta(){
        this.nombre="";
        this.campo="";
        this.siguiente=null;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public String getCampo(){
        return campo;        
    }
    
    public void setNombre(String nombre){
        this.nombre=nombre;
    }
    
    public void setCampo(String campo ){
        this.campo=campo;
    }
    
    public NodoPlanta getSiguiente(){
        return siguiente;
    }
    
    public void setSiguiente(NodoPlanta siguiente){
        this.siguiente=siguiente;
    }
}
