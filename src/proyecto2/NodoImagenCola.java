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
public class NodoImagenCola {
    private Imagen value;
    private NodoImagenCola next;
    private NodoImagenCola tofinal;
    
     public NodoImagenCola(Imagen imagen, NodoImagenCola next, NodoImagenCola tofinal) {
        this.value = imagen;
        this.next = next;
        this.tofinal = tofinal;
    }
    
    public NodoImagenCola(Imagen imagen) {
        this(imagen, null, null);
    }   

    public Imagen getValue() {
        return value;
    }

    public void setValue(Imagen value) {
        this.value = value;
    }

    public NodoImagenCola getNext() {
        return next;
    }

    public void setNext(NodoImagenCola next) {
        this.next = next;
    }

    public NodoImagenCola getTofinal() {
        return tofinal;
    }

    public void setTofinal(NodoImagenCola tofinal) {
        this.tofinal = tofinal;
    }
    


    
    
}
