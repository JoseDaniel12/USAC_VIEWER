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
public class ColaImagen extends EstructuraDeDatos {
    private NodoImagenCola frente;
    
    
    public void listar() {
        NodoImagenCola aux = frente;
        for (int i = 0; i < index; i++) {
            System.out.println(aux.getValue().nombre);
            aux = aux.getNext();
        }
    }

    @Override
    public void add(Object e) {
        Imagen imagen = (Imagen)e;
        if (index == 0) {
            frente = new NodoImagenCola(imagen, null, null);
        } else {
            NodoImagenCola newNodo = new NodoImagenCola(imagen);
            NodoImagenCola aux = frente;
            for (int i = 0; i < index - 1; i++) {
                aux = aux.getNext();
            }
            aux.setNext(newNodo);
            frente.setTofinal(newNodo);
            
        }
        index++;
    }

    @Override
    public Object peek() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object find(Object e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object getNext() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getSize() {
       return index;
    }

    @Override
    public Object get(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override 
    public Object pop() {
        Imagen imgEliminada = frente.getValue();
        if (index ==  1) {
            frente = null;
        } else if (index > 1) {           
            frente.getNext().setTofinal(frente.getTofinal());
            frente = frente.getNext();
            
        }
        index--;
        return imgEliminada;
    }

    @Override
    public void delete(Object e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
