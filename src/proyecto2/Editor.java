/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2;

import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author José Alvarado
 */
public class Editor extends javax.swing.JFrame {

    /**
     * Creates new form Editor
     */
    public Editor() {
        initComponents();
        File directorio = new File("C:/Users/josed/Downloads/Temporal");
        if (!directorio.exists()) {
            directorio.mkdir();
        }
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                funcionEliminarCarpeta1(new File("C:/Users/josed/Downloads/Temporal")); 
            }
        });  
    }

    private static void funcionEliminarCarpeta1(File pArchivo) {
        if (!pArchivo.exists()) { return; }
        if (pArchivo.isDirectory()) {
            for (File f : pArchivo.listFiles()) {
                funcionEliminarCarpeta1(f);  }
        }
        pArchivo.delete();
    }     
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        RojoVerdeAzulSepia = new javax.swing.JCheckBox();
        CopiaJPEG = new javax.swing.JCheckBox();
        JPEGaBMPyViceversa = new javax.swing.JCheckBox();
        ModificarImagen = new javax.swing.JCheckBox();
        BlancoyNegro = new javax.swing.JCheckBox();
        SeleccionarImagen = new javax.swing.JButton();
        Ejecutar = new javax.swing.JButton();
        Volver = new javax.swing.JButton();
        ImageName = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        RojoVerdeAzulSepia.setText("Rojo Verde Azul Sepia");

        CopiaJPEG.setText("copia JPEG");

        JPEGaBMPyViceversa.setText("JPEG a BMP y viceversa");

        ModificarImagen.setText("Modificar Imagen");

        BlancoyNegro.setText("Blanco y  Negro");

        SeleccionarImagen.setText("Seleccionar Imagen");
        SeleccionarImagen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SeleccionarImagenActionPerformed(evt);
            }
        });

        Ejecutar.setText("Ejecutar");
        Ejecutar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EjecutarActionPerformed(evt);
            }
        });

        Volver.setText("Volver");
        Volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VolverActionPerformed(evt);
            }
        });

        ImageName.setText("Nombre Foto");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ImageName)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(RojoVerdeAzulSepia)
                            .addComponent(CopiaJPEG)
                            .addComponent(JPEGaBMPyViceversa)
                            .addComponent(ModificarImagen)
                            .addComponent(BlancoyNegro))
                        .addGap(176, 176, 176)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Volver, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(SeleccionarImagen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Ejecutar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addContainerGap(51, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(ImageName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(SeleccionarImagen)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Ejecutar)
                        .addGap(42, 42, 42)
                        .addComponent(Volver))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(JPEGaBMPyViceversa)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CopiaJPEG)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(RojoVerdeAzulSepia)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ModificarImagen)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BlancoyNegro)))
                .addGap(18, 41, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SeleccionarImagenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SeleccionarImagenActionPerformed
        Toolkit tool = Toolkit.getDefaultToolkit();
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter extensionFilter = new FileNameExtensionFilter("Seleccioanar imagen", "jpg", "bmp");
        chooser.setFileFilter(extensionFilter);
        File file = null;
        if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            file = chooser.getSelectedFile();
            EditorState.imageSelected = file;
            ImageName.setText(file.toString());
        }


    }//GEN-LAST:event_SeleccionarImagenActionPerformed

    private void EjecutarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EjecutarActionPerformed
        EditorState.opciones[0] = JPEGaBMPyViceversa.isSelected();
        EditorState.opciones[1] = CopiaJPEG.isSelected();
        EditorState.opciones[2] = RojoVerdeAzulSepia.isSelected();
        EditorState.opciones[3] = ModificarImagen.isSelected();
        EditorState.opciones[4] = BlancoyNegro.isSelected();
       
        Thread jpgToBMP = new Thread(new RunHandlerThread(new JPEGtoBMPImage(EditorState.imageSelected.toString())));
        Thread bmpToJPEG = new Thread(new RunHandlerThread(new BMPtoJPEGImage(EditorState.imageSelected.toString())));
        Thread copiaJPEG = new Thread(new RunHandlerThread(new JPEGImageCopy(EditorState.imageSelected.toString())));
        Thread jpegcolors = new Thread(new RunHandlerThread(new JPEGImageHandlerColors(EditorState.imageSelected.toString())));
        Thread transform = new Thread(new RunHandlerThread(new JPEGImageHandlerRotator(EditorState.imageSelected.toString())));
        Thread blancoNegro = new Thread(new RunHandlerThread(new JPEGImageHandlerBN(EditorState.imageSelected.toString())));
        
        if (EditorState.opciones[0] == true) {
            String extension = "";
            int pos = EditorState.imageSelected.toString().lastIndexOf('.');
            extension =  EditorState.imageSelected.toString().substring(pos + 1); 
            if ("jpg".equals(extension)) {              
              jpgToBMP.start();
            } else {
                bmpToJPEG.start();
            }
        }
        
        if (EditorState.opciones[1] == true) {
            copiaJPEG.start();
        }
        
        if (EditorState.opciones[2] == true) {
            jpegcolors.start();
        }
        
        if (EditorState.opciones[3] == true) {
            transform.start();
        }
        
        if (EditorState.opciones[4] == true) {
            blancoNegro.start();
        }
    }//GEN-LAST:event_EjecutarActionPerformed

    private void VolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VolverActionPerformed
        Principal ventana = new Principal();
        ventana.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_VolverActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Editor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Editor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Editor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Editor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Editor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox BlancoyNegro;
    private javax.swing.JCheckBox CopiaJPEG;
    private javax.swing.JButton Ejecutar;
    private javax.swing.JLabel ImageName;
    private javax.swing.JCheckBox JPEGaBMPyViceversa;
    private javax.swing.JCheckBox ModificarImagen;
    private javax.swing.JCheckBox RojoVerdeAzulSepia;
    private javax.swing.JButton SeleccionarImagen;
    private javax.swing.JButton Volver;
    // End of variables declaration//GEN-END:variables
}
