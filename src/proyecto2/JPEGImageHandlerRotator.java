/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.WritableRaster;
import java.io.File;
import javax.imageio.ImageIO;

/**
 *
 * @author José Alvarado
 */
public class JPEGImageHandlerRotator extends ImageHandler {
    String nombre;
    BufferedImage jpg = null;
    BufferedImage bmp = null;
    File bmpTemporal;
    byte[] filebytes;
    public JPEGImageHandlerRotator(String filename) {
        super(filename);
        int indiceInicial = super.getFileName().lastIndexOf("\\") + 1;
        int indiceFinal = super.getFileName().lastIndexOf(".");       
        this.nombre = super.getFileName().substring(indiceInicial, indiceFinal);           
    }
 
    static BufferedImage deepCopy(BufferedImage bi) {
     ColorModel cm = bi.getColorModel();
     boolean isAlphaPremultiplied = cm.isAlphaPremultiplied();
     WritableRaster raster = bi.copyData(null);
     return new BufferedImage(cm, raster, isAlphaPremultiplied, null);
    }    

    @Override
    public void readFile() throws Exception {
        jpg = ImageIO.read(EditorState.imageSelected);
        bmpTemporal =  new File("C:/Users/josed/Downloads/bmpTemporal.bmp");
        ImageIO.write(jpg, "bmp", bmpTemporal); 
        bmp = ImageIO.read(bmpTemporal);
    }

    @Override
    public void generateFiles() throws Exception {
        BufferedImage bmpCopy1 = deepCopy(bmp);
        for (int x = 0; x < bmp.getWidth(); x++) {
            for (int y = 0; y < (int)(bmp.getHeight()/2); y++) {  
                Color colorActual = new Color(bmp.getRGB(x, y), true); 
                Color colorChange = new Color(bmp.getRGB(x, bmp.getHeight()-y -1), true);
                Color resplado = new Color(bmp.getRGB(x, y), true); 
                bmpCopy1.setRGB(x, y, colorChange.getRGB());
                bmpCopy1.setRGB(x, bmp.getHeight()-y -1, resplado.getRGB()); 
            }
        }
        ImageIO.write(bmpCopy1, "jpg", new File("C:/Users/josed/Downloads/Temporal/Hrotation-" + nombre + ".jpg"));     
        
        BufferedImage bmpCopy2= deepCopy(bmp);
        for (int x = 0; x < (int)(bmp.getWidth()/2); x++) {
            for (int y = 0; y < bmp.getHeight(); y++) {  
                Color colorActual = new Color(bmp.getRGB(x, y), true); 
                Color colorChange = new Color(bmp.getRGB(bmp.getWidth() - x -1, y), true);
                Color resplado = new Color(bmp.getRGB(x, y), true); 
                bmpCopy2.setRGB(x, y, colorChange.getRGB());
                bmpCopy2.setRGB(bmp.getWidth() - x -1, y, resplado.getRGB()); 
            }
        }
        ImageIO.write(bmpCopy2, "jpg", new File("C:/Users/josed/Downloads/Temporal/Vrotation-" + nombre + ".jpg"));           
        bmpTemporal.delete();
        
        Convertidor.nFotosCargadas++;
        Convertidor.texto += "\n" + "Imagen: " +  nombre + "  ->  Filtro: JEPEG Rotation";
        Convertidor.cargar();        
    }
    
    
}
