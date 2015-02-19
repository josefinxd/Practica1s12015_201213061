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
public class ListaPlantas {
    private NodoPlanta primerNodo;
    public static String cadena="";
    public static String enlace="";
    
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
        cadena="digraph G{ \n rankidir = LR;\n node[shape = record]; \n rankidir = UD;\n {  rank = same; \n Plantas;\n ";
        enlace="Plantas -> nodo0\n ";
        NodoPlanta aux2;
        int cont =0;
        while(aux != null){
            System.out.println("Nombre: "+aux.getNombre().trim()+" Dato: " + aux.getCampo().trim());
            cadena=cadena+("nodo"+cont+"[label=\""+aux.getNombre().trim()+" "+aux.getCampo().trim()+"\"];\n");
            aux2=aux.getSiguiente();
            if(aux2!= null){
                enlace=enlace+("nodo"+cont+" -> ")+("nodo"+(cont+1)+";\n");
            }            
            aux = aux.getSiguiente(); 
            cont++;
        }
        cadena=cadena+enlace+"};";
    }    
}
