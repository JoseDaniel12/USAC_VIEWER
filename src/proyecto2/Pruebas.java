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
public class Pruebas implements Runnable {

    public static void main(String a[]) {
        Thread hilo = new Thread(new Pruebas());
        hilo.start();
        
        while (hilo.isAlive()) {
            System.out.println("alive");
        }
        System.out.println("dead");

    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("AAAAAAAAAAA");
        }
    }
    

}
