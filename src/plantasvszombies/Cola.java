/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package plantasvszombies;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.PrintStream;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Jose Angel
 */
public class Cola {
    ListaPlantas listaPlantas;
    NodoJugadores primerNodoc;
    int fila;
    
    public Cola(){
        this.primerNodoc=null;
    }
    
    public void add(String img, String nombre, int atk, int def, String tipo, JPanel panel){
        NodoJugadores nuevo = new NodoJugadores(img, nombre, atk, def, tipo);
        panel.removeAll();
        if(primerNodoc == null){
            primerNodoc = nuevo;
            fila +=1;
                primerNodoc.setText(Integer.toString(fila));
                final String texto=primerNodoc.getText();
                System.out.println(texto);
                primerNodoc.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JOptionPane.showMessageDialog(null, "Alguno de los campos esta vacio"+ texto); 
                    }
                });
            return;
        }
        
        NodoJugadores aux = primerNodoc;
        panel.add(aux);
        while(aux != null){
            if(aux.getSiguiente()== null){
                aux.setSiguiente(nuevo); 
                fila +=1;
                aux.setText(Integer.toString(fila));
                final String texto=aux.getText();
                System.out.println(texto);
                aux.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(null, "Alguno de los campos esta vacio"+ texto); 
                }
            });
            return;
            }            
            aux = aux.getSiguiente();
        }        
    }
    
    public int size(){
        int tamaño=0;
        NodoJugadores aux = primerNodoc;
        while(aux!=null){
            aux=aux.getSiguiente();
            tamaño++;
        }
        return tamaño;
    }
    
    public NodoJugadores popCola(){
        NodoJugadores aux = primerNodoc;
        primerNodoc = primerNodoc.getSiguiente();
        return aux;
    }
    
    public void imprimir(){
        String cadena="";
        String enlace="";
        NodoJugadores aux = primerNodoc;
        
        try{
            PrintStream ps=new PrintStream(new FileOutputStream("C:\\Program Files (x86)\\Graphviz2.38\\bin\\cola.dot"));
            cadena="digraph G{ \n node[shape = record]; \n rankidir = LR;\n {\n  Plantas;\n ";
            enlace="Plantas -> nodos0; [dir=back]\n ";
            NodoJugadores aux2;
            int cont=0;
            while(aux != null){
                System.out.println("Dato: " + aux.getImg()+", "+aux.getNombre()+", "
                    +aux.getAtk()+", "+aux.getDef()+", "+aux.getTipo());
                cadena=cadena+"nodos"+cont+("[label=\""+ aux.getImg()+".png, "+aux.getNombre()+"\\l"
                    +aux.getAtk()+", "+aux.getDef()+", "+aux.getTipo()+"\"];\n");
                aux2=aux.getSiguiente();
                if(aux2!= null){
                    enlace=enlace+("nodos"+cont+" -> nodos"+(cont+1)+" [dir=back];\n");
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
