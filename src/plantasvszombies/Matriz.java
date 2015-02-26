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
public class Matriz {
    private Nodo primerNodo;
    int filas, columnas;
    
    public Matriz(int filas, int columnas){
        this.primerNodo=new Nodo("1");
        this.filas=filas;
        this.columnas=columnas;
        
        Nodo aux= primerNodo;
        for(int i=0;i<columnas-1;i++){
            aux.setSiguiente(new Nodo("1"));
            aux.getSiguiente().setAnterior(aux);
            aux=aux.getSiguiente();            
        }
        aux=primerNodo;
        for(int j=0;j<filas-1;j++){
            aux.setAbajo(new Nodo("2"));
            aux.getAbajo().setArriba(aux);
            aux=aux.getAbajo();
        }
        aux=primerNodo;
        for(int i=0;i<filas-1;i++){
            Nodo aux2=aux;
            for(int j=0;j<columnas-1;j++){
                aux2.getAbajo().setSiguiente(new Nodo("3"));
                aux2.getAbajo().getSiguiente().setAnterior(aux2.getAbajo());
                aux2.getSiguiente().setAbajo(aux2.getAbajo().getSiguiente());
                aux2.getSiguiente().getAbajo().setArriba(aux2.getSiguiente());
                
                aux2=aux2.getSiguiente();
            }
            aux=aux.getAbajo();
        }
    }
    
    public void setFilasColumnas(JPanel panel){
        panel.setLayout(new GridLayout(filas, columnas));
        Nodo aux =primerNodo;
        for(int i=0;aux!=null;i++){
            Nodo aux2=aux;
            for(int j=0;aux2!=null;j++){
                aux2.fila =i+1;
                aux2.columna=j+1;
                aux2.setText(aux2.fila+","+aux2.columna);
                final String texto=aux2.getText();
                aux2.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JOptionPane.showMessageDialog(null, "Alguno de los campos esta vacio"+ texto); 
                    }
                });
                panel.add(aux2);
                aux2=aux2.getSiguiente();
            }
            aux=aux.getAbajo();
        }  
    }
    
    public void imprimir(){
        String cadena="";
        String enlace="";
        
        
        try{
            PrintStream ps=new PrintStream(new FileOutputStream("C:\\Program Files (x86)\\Graphviz2.38\\bin\\cola.dot"));
            cadena="digraph G{ \n node[shape = record]; \n rankidir = LR;\n {\n  \n ";
            enlace="";
            Nodo aux2;
            int cont=0;
            Nodo aux= primerNodo;            
                for(int i=0;i<columnas-1;i++){
                    aux.setSiguiente(new Nodo("1"));
                    aux.getSiguiente().setAnterior(aux);
                    cadena=cadena+"nodos"+cont+("[label=\""+aux.getDato()+"];\n");
                    aux=aux.getSiguiente();            
                }
                aux=primerNodo;
                for(int j=0;j<filas-1;j++){
                    aux.setAbajo(new Nodo("2"));
                    aux.getAbajo().setArriba(aux);
                    aux=aux.getAbajo();
                }
                aux=primerNodo;
                for(int i=0;i<filas-1;i++){
                    aux2=aux;
                    for(int j=0;j<columnas-1;j++){
                        aux2.getAbajo().setSiguiente(new Nodo("3"));
                        aux2.getAbajo().getSiguiente().setAnterior(aux2.getAbajo());
                        aux2.getSiguiente().setAbajo(aux2.getAbajo().getSiguiente());
                        aux2.getSiguiente().getAbajo().setArriba(aux2.getSiguiente());

                        aux2=aux2.getSiguiente();
                    }
                    aux=aux.getAbajo();
                }               
                           
                aux = aux.getSiguiente();
                cont++;
                   
            
            cadena=cadena+enlace+"}\n } ";
            ps.println(cadena);        
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
             
    }    
}
 