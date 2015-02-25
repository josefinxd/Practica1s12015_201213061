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
public class ListaZombis {
    public NodoJugadores primerNodo;
    public static String cadenas="";
    public static String enlaces="";
    
    
    public ListaZombis(){
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
        
        try{
            PrintStream ps=new PrintStream(new FileOutputStream("C:\\Program Files (x86)\\Graphviz2.38\\bin\\catalogos.dot"));
            cadenas=ListaPlantas.cadena+"{ \n rank = same; \n Zombis;\n ";
            enlaces="Zombis -> nodos0\n ";
            NodoJugadores aux2;
            int cont=0;
            while(aux != null){
                System.out.println("Dato: " + aux.getImg()+", "+aux.getNombre()+", "
                    +aux.getAtk()+", "+aux.getDef()+", "+aux.getTipo());
                cadenas=cadenas+"nodos"+cont+("[label=\""+ aux.getImg()+", "+aux.getNombre()+"\\l"
                    +aux.getAtk()+", "+aux.getDef()+", "+aux.getTipo()+"\"];\n");
                aux2=aux.getSiguiente();
                if(aux2!= null){
                    enlaces=enlaces+("nodos"+cont+" -> nodos"+(cont+1)+";\n");
                }            
                aux = aux.getSiguiente();
                cont++;
            }
            cadenas=cadenas+enlaces+"}; \n } ";
            ps.println(cadenas);        
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
