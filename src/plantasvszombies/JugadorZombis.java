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
public class JugadorZombis {
    private NodoJugador primerNodo;
    public String cadenas="";
    public String enlaces="";
    
    public JugadorZombis(){
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
        
        try{
            PrintStream ps=new PrintStream(new FileOutputStream("C:\\Program Files (x86)\\Graphviz2.38\\bin\\jugadores.dot"));
            cadenas=JugadorPlantas.cadena+"{ \n rank = same; \n Zombis;\n ";
            enlaces="Zombis -> nodos0\n ";
            NodoJugador aux2;
            int cont=0;
            while(aux != null){
                System.out.println("Nombre: "+aux.getNombre().trim()+" Dato: " + aux.getCampo().trim());
                cadenas=cadenas+"nodos"+cont+("[label=\""+aux.getNombre().trim()+"\\l"+aux.getCampo().trim()+"\"];\n");
                aux2=aux.getSiguiente();
                if(aux2!= null){
                    enlaces=enlaces+("nodos"+cont+" -> nodos"+(cont+1)+";\n");
                }            
                aux = aux.getSiguiente();
                cont++;
            }
            cadenas=cadenas+enlaces+"};\n Jugador -> Plantas; \n Plantas -> Zombis; \n } ";
            ps.println(cadenas);        
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }    
}
