
package proyecto2;

import java.io.Serializable;

/**
 *
 * @author José Alvarado
 */
public class Categoria implements Serializable {
    public String nombre;
    public ListaImagenes imagenes = new ListaImagenes(); 
    
    public Categoria(String nombre) {
        this.nombre = nombre;
    }
}
 
