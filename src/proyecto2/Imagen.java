/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2;

import java.io.File;
import java.io.Serializable;
import javax.swing.ImageIcon;

/**
 *
 * @author José Alvarado
 */
public class Imagen implements Serializable {
    public String nombre;
    public String path;
    public ImageIcon icon = null;
    public Imagen(String nombre, ImageIcon icon, String path) {
        this.nombre = nombre;
        this.icon = icon;
        this.path = path;       
    }
}
