package proyecto2;

import java.io.Serializable;

/**
 *
 * @author José Alvarado
 */
public class NodoCategoria implements Serializable {
    private Categoria value;
    private NodoCategoria previous;
    private NodoCategoria next;
    

    public NodoCategoria(Categoria categoria, NodoCategoria next, NodoCategoria previous) {
        this.value = categoria;
        this.next = next;
        this.previous = previous;
    }
    
    public NodoCategoria(Categoria categoria) {
        this(categoria, null, null);
            
    }
    
    public Categoria getValue() {
        return value;
    }
    
    public void setValue(Categoria valor) {
        this.value = valor;
    }
    

    public NodoCategoria getPrevious() {
        return previous;
    }

    public void setPrevious(NodoCategoria previous) {
        this.previous = previous;
    }    
    

    public NodoCategoria getNext() {
        return next;
    }

    public void setNext(NodoCategoria siguiente) {
        this.next = siguiente;
    }       
}
