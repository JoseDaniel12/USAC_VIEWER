/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2;

import java.io.Serializable;

/**
 *
 * @author José Alvarado
 */
public class NodoUsuario implements Serializable {
    private Usuario value;
    private NodoUsuario next;

    public NodoUsuario() {
        this.value = null;
        this.next = null;
    }
    
    // retorna el usuario que esta almacenado en el nodo
    public Usuario getValue() {
        return value;
    }
    
    // asigna un un Usuario al nodo
    public void setValue(Usuario valor) {
        this.value = valor;
    }


    public NodoUsuario getNext() {
        return next;
    }

    public void setNext(NodoUsuario siguiente) {
        this.next = siguiente;
    }   
}