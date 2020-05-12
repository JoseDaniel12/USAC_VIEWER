/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.imageio.ImageIO;

/**
 *
 * @author José Alvarado
 */
public class Pruebas {

    public static void main(String a[]) {
        try {
            System.out.println("Enter image name\n");
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            String imageName = bf.readLine();
            File input = new File(imageName);
            BufferedImage image = ImageIO.read(input);
            System.out.println("Enter the output image name(.bmp):\n");
            String imageName1 = bf.readLine();
            File output = new File(imageName1);
            ImageIO.write(image, "bmp", output);
            System.out.println("Your image has been converted successfully");
        } catch (FileNotFoundException e) {
            System.out.println("Error:" + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error:" + e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
