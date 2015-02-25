/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package plantasvszombies;

import java.io.FileOutputStream;
import java.io.PrintStream;

/**
 *
 * @author Jose Angel
 */
public class JugadorPlantas {
    private NodoJugador primerNodo;
    public static String cadena="";
    public static String enlace="";
    
    public JugadorPlantas(){
        this.primerNodo = null;
    }
    
    public void add(String nombre, String campo){
        NodoJugador nuevo = new NodoJugador(nombre, campo);
        if(primerNodo == null){
            primerNodo = nuevo; 
            return;
        }
        
        NodoJugador aux = primerNodo;
        while(aux != null){
            if(aux.getSiguiente()== null){
                aux.setSiguiente(nuevo); 
                return;
            }
            aux = aux.getSiguiente();
        }
    }
        
        public String popCola(){
            NodoJugador aux = primerNodo;
            primerNodo = primerNodo.getSiguiente();
            return aux.getCampo();
        }
    
    public void imprimir(){
        NodoJugador aux = primerNodo;
        cadena="digraph G{ \n node[shape = record]; \n rankidir = UD;\n {\n rank = same; \n Plantas;\n ";
        enlace="Plantas -> nodo0\n ";
        NodoJugador aux2;
        int cont =0;
        while(aux != null){
            System.out.println("Nombre: "+aux.getNombre().trim()+" Dato: " + aux.getCampo().trim());
            cadena=cadena+("nodo"+cont+"[label=\""+aux.getNombre().trim()+"\\l"+aux.getCampo().trim()+"\"];\n");
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
