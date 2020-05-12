package proyecto2;

import java.io.Serializable;

/**
 *
 * @author José Alvarado
 */
public class Usuario implements Serializable {
    public String nombre;
    public ListaCategorias categorias = new ListaCategorias();
    
    public Usuario(String nombre) {
        this.nombre = nombre;
        this.categorias.add(new Categoria("General"));
    }
}
