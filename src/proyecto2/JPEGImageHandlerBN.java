/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

/**
 *
 * @author José Alvarado
 */
public class JPEGImageHandlerBN extends ImageHandler {
    String nombre;
    BufferedImage jpg = null;
    BufferedImage bmp = null;
    File bmpTemporal;
    byte[] filebytes;
    public JPEGImageHandlerBN(String filename) {
        super(filename);
        int indiceInicial = super.getFileName().lastIndexOf("\\") + 1;
        int indiceFinal = super.getFileName().lastIndexOf(".");       
        this.nombre = super.getFileName().substring(indiceInicial, indiceFinal);        
    }

    @Override
    public void readFile() throws Exception {
        File file = new File(super.getFileName());
        jpg = ImageIO.read(file);
        bmpTemporal =  new File("C:/Users/josed/Downloads/bmpTemporal.bmp");
        ImageIO.write(jpg, "bmp", bmpTemporal); 
        bmp = ImageIO.read(bmpTemporal);
    }

    @Override
    public void generateFiles() throws Exception {
        for (int x = 0; x < bmp.getWidth(); x++) {
            for (int y = 0; y < bmp.getHeight(); y++) {  
                Color color = new Color(bmp.getRGB(x, y), true); 
                int promedio = (color.getBlue() + color.getGreen() + color.getRed())/3;
                Color newColor = new Color(promedio, promedio, promedio);
                bmp.setRGB(x, y, newColor.getRGB());
            }
        }
        ImageIO.write(bmp, "jpg", new File("C:/Users/josed/Downloads/Temporal/BN-" + nombre + ".jpg"));           
        bmpTemporal.delete();
        Convertidor.nFotosCargadas++;
        Convertidor.texto += "\n" + "Imagen: " +  nombre + "  ->  Filtro: Blanco y Negro";
        Convertidor.cargar();
    }
    
}
