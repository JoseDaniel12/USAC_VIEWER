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
public class JPEGImageHandlerColors extends ImageHandler {
    String nombre;
    BufferedImage jpg = null;
    BufferedImage bmp = null;
    File bmpTemporal;
    public JPEGImageHandlerColors(String filename) {
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
        BufferedImage bmpCopy1 = bmp;
        for (int x = 0; x < bmp.getWidth(); x++) {
            for (int y = 0; y < bmp.getHeight(); y++) {
                int rgb = bmp.getRGB(x, y);
                Color color = new Color(rgb, true); 
                Color newColor = new Color(color.getRed(), 0, 0);
                bmpCopy1.setRGB(x, y, newColor.getRGB());
            }
        }
        ImageIO.write(bmpCopy1, "jpg", new File("C:/Users/josed/Downloads/Temporal/Red-" + nombre + ".jpg")); 
        
        BufferedImage bmpCopy2 = bmp;
        for (int x = 0; x < bmp.getWidth(); x++) {
            for (int y = 0; y < bmp.getHeight(); y++) {
                int rgb = bmp.getRGB(x, y);
                Color color = new Color(rgb, true); 
                Color newColor = new Color(0, color.getRed(), 0);
                bmpCopy2.setRGB(x, y, newColor.getRGB());
            }
        }
        ImageIO.write(bmpCopy2, "jpg", new File("C:/Users/josed/Downloads/Temporal/Green-" + nombre + ".jpg")); 
        
        BufferedImage bmpCopy3 = bmp;
        for (int x = 0; x < bmp.getWidth(); x++) {
            for (int y = 0; y < bmp.getHeight(); y++) {
                int rgb = bmp.getRGB(x, y);
                Color color = new Color(rgb, true); 
                Color newColor = new Color(0, 0, color.getGreen());
                bmpCopy3.setRGB(x, y, newColor.getRGB());
            }
        }
        ImageIO.write(bmpCopy3, "jpg", new File("C:/Users/josed/Downloads/Temporal/Blue-" + nombre + ".jpg"));  
        
        BufferedImage bmpCopy4 = bmp;
        for (int x = 0; x < bmp.getWidth(); x++) {
            for (int y = 0; y < bmp.getHeight(); y++) {
                int rgb = bmp.getRGB(x, y);
                Color color = new Color(rgb, true); 
                
                Color newColor = new Color((int)(0.4*color.getBlue()),(int)(0.23*color.getBlue()),(int)(0.16*color.getBlue()));
                bmpCopy4.setRGB(x, y, newColor.getRGB());
            }
        }
        ImageIO.write(bmpCopy4, "jpg", new File("C:/Users/josed/Downloads/Temporal/Sepia-" + nombre + ".jpg"));                    
        bmpTemporal.delete();
        
        Convertidor.nFotosCargadas++;
        Convertidor.texto += "\n" + "Imagen: " +  nombre + "  ->  Filtro: Colors";
        Convertidor.cargar();        
        
    }
    
}
