/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2;

import javax.swing.ImageIcon;

/**
 *
 * @author José Alvarado
 */
public class ListaImagenes extends EstructuraDeDatos {
    NodoImagen cabeza;
    NodoImagen end;    

    public void listarNombres() {
        NodoImagen aux = cabeza;
        if (index > 0) {
           for (int i = 0; i < index; i++) {
               System.out.print("imagen" + (i+1) + " -> ");
               aux = aux.getNext();
           }        
        }
        System.out.print("\n");
    }        
    
    public int getIndex(Object e) {
        ImageIcon icon = (ImageIcon)e;
        NodoImagen aux = cabeza;
        if (index > 0) {
           for (int i = 0; i < index; i++) {
               if (aux.getValue() == icon) {
                   return (i+1);
               }
               aux = aux.getNext();
           }        
        }  
        return 0;       
    }
    
    @Override
    public void add(Object e) {
        ImageIcon  icon = (ImageIcon)e;
        if (index != 0) {
            end  = new NodoImagen(icon, cabeza, end);
            end.getPrevious().setNext(end);
        } else {
            NodoImagen newNodo  = new NodoImagen(icon);
            cabeza = newNodo;
            cabeza.setNext(cabeza);
            cabeza.setPrevious(end);
            end = newNodo;
        }
        index++;
    }

    @Override
    public Object peek() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object find(Object e) {
        ImageIcon icon = (ImageIcon)e;
        NodoImagen aux = cabeza;
        if (index > 0) {
           for (int i = 0; i < index; i++) {
               if (aux.getValue() == icon) {
                   return aux.getNext().getValue();
               }
               aux = aux.getNext();
           }        
        }  
        return null;        
    }

    @Override
    public Object getNext() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public Object getNext(ImageIcon icon) {
        NodoImagen aux = cabeza;
        if (index > 0) {
           for (int i = 0; i < index; i++) {
               if (aux.getValue() == icon) {
                   return aux.getNext().getValue();
               }
               aux = aux.getNext();
           }        
        }  
        return null;  
    }
    
    public Object getPrevious(ImageIcon icon) {
        NodoImagen aux = cabeza;
        if (index > 0) {
           for (int i = 0; i < index; i++) {
               if (aux.getNext().getValue() == icon) {
                   return aux.getValue();
               }
               aux = aux.getNext();
           }        
        }  
        return null; 
    }

    @Override
    public int getSize() {
        return index;
    }

    @Override
    public Object get(int i) {
        NodoImagen aux = cabeza;
        if (i >= 0 && i < index) {
            for (int c = 0; c < i; c++) {
                aux = aux.getNext();
            } 
            return aux.getValue();
        }  
        return null;     
    }

    @Override
    public Object pop() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Object e) {
        ImageIcon icon = (ImageIcon)e;
        NodoImagen aux = cabeza; 
        if (find(icon) != null) {
            if (cabeza.getValue() == icon) {
                cabeza = cabeza.getNext();
                cabeza.setPrevious(end);
                end.setNext(cabeza);
            } else if (end.getValue() == icon) {
                end.getPrevious().setNext(cabeza);
            } else {
                while(aux.getNext().getValue() != icon) {
                    aux = aux.getNext();
                }
                aux.getNext().getNext().setPrevious(aux);
                aux.setNext(aux.getNext().getNext());             
            }
            index--;   
        }    
    }
    
}
