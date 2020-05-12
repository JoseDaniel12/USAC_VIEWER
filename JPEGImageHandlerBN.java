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
    BufferedImage jpg = null;
    BufferedImage bmp = null;
    File bmpTemporal;
    byte[] filebytes;
    public JPEGImageHandlerBN(String filename) {
        super(filename);
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
        for (int x = 0; x < bmp.getWidth(); x++) {
            for (int y = 0; y < bmp.getHeight(); y++) {  
                Color color = new Color(bmp.getRGB(x, y), true); 
                int promedio = (color.getBlue() + color.getGreen() + color.getRed())/3;
                Color newColor = new Color(promedio, promedio, promedio);
                bmp.setRGB(x, y, newColor.getRGB());
            }
        }
        ImageIO.write(bmp, "jpg", new File("C:/Users/josed/Downloads/bn.jpg"));           
        bmpTemporal.delete();      
    }
    
}
