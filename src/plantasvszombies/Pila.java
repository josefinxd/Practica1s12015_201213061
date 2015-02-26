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
public class Pila {
    ListaZombis listaZombis;
    NodoJugadores primerNodop;
    
    public Pila(){
        this.primerNodop=null;
    }
    
    public void add(String img, String nombre, int atk, int def, String tipo){
        NodoJugadores nuevo = new NodoJugadores(img, nombre, atk, def, tipo);
        if(primerNodop == null){
            primerNodop = nuevo; 
            return;
        }
        
        NodoJugadores aux = primerNodop;
        while(aux != null){
            if(aux.getSiguiente()== null){
                aux.setSiguiente(nuevo); 
                return;
            }
            aux = aux.getSiguiente();
        }
    }
    
    public NodoJugadores popCola(){
        NodoJugadores aux = primerNodop;
        primerNodop = primerNodop.getSiguiente();
        return aux;
    }
    
    public void imprimir(){
        String cadena="";
        String enlace="";
        NodoJugadores aux = primerNodop;
        
        try{
            PrintStream ps=new PrintStream(new FileOutputStream("C:\\Program Files (x86)\\Graphviz2.38\\bin\\pila.dot"));
            cadena="digraph G{ \n node[shape = record]; \n rankidir = LR;\n {\n  ";
            enlace="";
            NodoJugadores aux2;
            int cont=0;
            while(aux != null){
                System.out.println("Dato: " + aux.getImg()+", "+aux.getNombre()+", "
                    +aux.getAtk()+", "+aux.getDef()+", "+aux.getTipo());
                cadena=cadena+"nodos"+cont+("[label=\""+ aux.getImg()+".png, "+aux.getNombre()+"\\l"
                    +aux.getAtk()+", "+aux.getDef()+", "+aux.getTipo()+"\"];\n");
                aux2=aux.getSiguiente();
                if(aux2!= null){
                    enlace=enlace+("nodos"+cont+" -> nodos"+(cont+1)+";\n");
                }            
                aux = aux.getSiguiente();
                cont++;
            }
            cadena=cadena+enlace+"}\n } ";
            ps.println(cadena);        
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
}

