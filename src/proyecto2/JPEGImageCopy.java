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
public class JPEGImageCopy extends ImageHandler {

    BufferedImage image = null;

    public JPEGImageCopy(String filename) {
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
        File file =  new File("C:/Users/josed/Downloads/copia-" + super.getFileName().substring(indiceInicial, indiceFinal) + ".bmp");
        ImageIO.write(image, "bmp", file);
        BmpHandlerCopy copiador = new BmpHandlerCopy(file.toString());
        copiador.readFile();
        copiador.generateFiles();
        file.delete();
        
        Convertidor.nFotosCargadas++;
        Convertidor.texto += "\n" + "Imagen: " + super.getFileName().substring(indiceInicial, indiceFinal) + "  ->  Filtro: JPEG Copy";
        Convertidor.cargar();            
    }

}
