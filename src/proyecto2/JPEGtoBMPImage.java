/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2;

import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

/**
 *
 * @author José Alvarado
 */
public class JPEGtoBMPImage extends ImageHandler {

    BufferedImage image = null;

    public JPEGtoBMPImage(String filename) {
        super(filename);
    }

    @Override
    public void readFile() throws Exception {
        File file = new File(super.getFileName());
        image = ImageIO.read(file);
    }

    @Override
    public void generateFiles() throws Exception {
        int indiceInicial = super.getFileName().lastIndexOf("\\") + 1;
        int indiceFinal = super.getFileName().lastIndexOf(".");
        ImageIO.write(image, "bmp", new File("C:/Users/josed/Downloads/Temporal/coverted-" + super.getFileName().substring(indiceInicial, indiceFinal) + ".bmp"));
        Convertidor.nFotosCargadas++;
        Convertidor.texto += "\n" + "Imagen: " + super.getFileName().substring(indiceInicial, indiceFinal) + "  ->  Filtro: JPEG a BMP";
        Convertidor.cargar();        
    }  

}

