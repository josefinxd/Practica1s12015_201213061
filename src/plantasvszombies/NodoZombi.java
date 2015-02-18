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
public class NodoZombi {
    private String campo;
    private NodoPlanta siguiente;
    
    public NodoZombi(String campo){
        this.campo=campo;
        this.siguiente=null;
    }
    
    public NodoZombi(){
        this.campo="";
        this.siguiente=null;
    }
    
    public String getCampo(){
        return campo;        
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
