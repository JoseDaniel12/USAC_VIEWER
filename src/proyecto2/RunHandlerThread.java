/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2;

/**
 *
 * @author José Alvarado
 */
public class RunHandlerThread implements Runnable{
    ImageHandler imgh;
    public RunHandlerThread(ImageHandler imgh) {
        this.imgh = imgh;
    }
    
    @Override
    public void run(){ 
        try {
            JPEGHandler.runHandler(imgh);
        } catch (Exception e) {
        }
    }
}
