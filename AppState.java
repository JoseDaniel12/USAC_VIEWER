/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import javax.swing.ImageIcon;

/**
 *
 * @author José Alvarado
 */
public class AppState {
    public static ListaUsuarios usuarios = new ListaUsuarios();
    public static String actualUser = "";
    public static String actualCategory = "General";
    public static ImageIcon actualImage;

    public static void serializar() {
        try {
            ObjectOutputStream escribiendo_fichero = new ObjectOutputStream(new FileOutputStream("C:/Users/josed/Downloads/lista.txt"));
            escribiendo_fichero.writeObject(AppState.usuarios);
            escribiendo_fichero.close();
        } catch(Exception e) {
            //pass
        }          
    }
    
}
