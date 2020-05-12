/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2;
import java.io.Serializable;
import javax.swing.ImageIcon;

/**
 *
 * @author José Alvarado
 */
public class NodoImagen implements Serializable {
    private ImageIcon value;
    private NodoImagen next;
    private NodoImagen previous;

    public NodoImagen(ImageIcon icon, NodoImagen next, NodoImagen previous) {
        this.value = icon;
        this.next = next;
        this.previous = previous;
    }
    
    public NodoImagen(ImageIcon  icon) {
        this(icon, null, null);    
    }   

    public ImageIcon  getValue() {
        return value;
    }

    public void setValue(ImageIcon  value) {
        this.value = value;
    }

    public NodoImagen getNext() {
        return next;
    }

    public void setNext(NodoImagen next) {
        this.next = next;
    }

    public NodoImagen getPrevious() {
        return previous;
    }

    public void setPrevious(NodoImagen previous) {
        this.previous = previous;
    }

    
    
}
