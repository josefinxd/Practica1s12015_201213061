/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package plantasvszombies;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
        Nodo aux =primerNodo;
        for(int i=0;aux!=null;i++){
            Nodo aux2=aux;
            for(int j=0;aux2!=null;j++){
                System.out.print((i+1)+","+(j+1));
                aux2=aux2.getSiguiente();
            }
            System.out.println();
            aux=aux.getAbajo();
        }        
    }    
}
 