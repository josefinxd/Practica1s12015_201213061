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
    public NodoJugadores primerNodo;
    public static String cadena="";
    public static String enlace=""; 
    
    
    public ListaPlantas(){
        this.primerNodo = null;
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
    
    public int size(){
        int tamaño=0;
        NodoJugadores aux = primerNodo;
        while(aux!=null){
            aux=aux.getSiguiente();
            tamaño++;
        }
        return tamaño;
    }
    
    public String getObjeto(int j){
        NodoJugadores aux = primerNodo;
        String cadena=null;
        for(int i=0;i<j;i++){
                aux=aux.getSiguiente();
        } 
        cadena=aux.getImg()+","+aux.getNombre()+","
               +aux.getAtk()+","+aux.getDef()+","+aux.getTipo();          
        return cadena;
    }
    
    public void imprimir(){
        NodoJugadores aux = primerNodo;
        cadena="digraph G{ \n node[shape = record]; \n rankidir = UD;\n {\n rank = same; \n Plantas;\n ";
        enlace="Plantas -> nodo0\n ";
        NodoJugadores aux2;
        int cont =0;
        while(aux != null){
            System.out.println("Dato: " + aux.getImg()+", "+aux.getNombre()+", "
                    +aux.getAtk()+", "+aux.getDef()+", "+aux.getTipo());
            cadena=cadena+("nodo"+cont+"[label=\""+ aux.getImg()+".png, "+aux.getNombre()+"\\l"
                    +aux.getAtk()+", "+aux.getDef()+", "+aux.getTipo()+"\"];\n");
            aux2=aux.getSiguiente();
            if(aux2!= null){
                enlace=enlace+("nodo"+cont+" -> ")+("nodo"+(cont+1)+";\n");
            }            
            aux = aux.getSiguiente(); 
            cont++;
        }
        cadena=cadena+enlace+"};\n ";
    }
}
