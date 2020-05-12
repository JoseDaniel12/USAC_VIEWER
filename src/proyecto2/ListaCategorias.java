/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2;

/**
 *
 * @author José Alvarado
 */
public class ListaCategorias extends EstructuraDeDatos{
    NodoCategoria cabeza;
    NodoCategoria end;
    
    public void listarNombres() {
        NodoCategoria aux = cabeza;
        if (index > 0) {
           for (int i = 0; i < index; i++) {
               System.out.print(aux.getValue().nombre + " -> ");
               aux = aux.getNext();
           }        
        }
        System.out.print("\n");
    }    
    
    @Override
    public int getSize() {
        return index;
    }    
    
    @Override
    public void add(Object e) {
        Categoria categoria = (Categoria)e;
        if (index != 0) {
            end = new NodoCategoria(categoria, null, end);  
            end.getPrevious().setNext(end);
        } else {
            cabeza = end = new NodoCategoria(categoria);
        }
        index++;
    }

    @Override
    public void delete(Object e) {   
        String categoryName = e.toString();
        NodoCategoria aux = cabeza; 
        if (find(categoryName) != null) {
            if (cabeza.getValue().nombre.equals(categoryName)) {
                cabeza = cabeza.getNext();
                cabeza.setPrevious(null);
            } else if (end.getValue().nombre.equals(categoryName)) {
                end.getPrevious().setNext(null);
            } else {
                while(!aux.getNext().getValue().nombre.equals(categoryName)) {
                    aux = aux.getNext();
                }
                aux.getNext().getNext().setPrevious(aux);
                aux.setNext(aux.getNext().getNext());             
            }
            index--;   
        }
    }   
    
    @Override
    public Object peek() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object find(Object e) {
        String categoryName = e.toString();
        NodoCategoria aux = cabeza;
        if (index > 0) {
           for (int i = 0; i < index; i++) {
               if (aux.getValue().nombre.equals(categoryName)) {
                   return aux.getValue();
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

    @Override
    public Object get(int i) {
        NodoCategoria aux = cabeza;
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
    
}
