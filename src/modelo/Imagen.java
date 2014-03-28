/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

/**
 *
 * @author CFManuel
 */
public class Imagen extends javax.swing.JPanel {

    public Imagen(String url,int ancho, int alto) {
        _direccion = url;
        this.setSize(ancho, alto); //se selecciona el tamaño del panel
    }

//Se crea un método cuyo parámetro debe ser un objeto Graphics
    public void paint(Graphics grafico) {
        Dimension height = getSize();

//Se selecciona la imagen que tenemos en el paquete de la //ruta del programa

        ImageIcon Img = new ImageIcon(getClass().getResource(_direccion));
        
        Image imgEscalada = Img.getImage().getScaledInstance(this.getWidth(),this.getHeight(), Image.SCALE_SMOOTH);
                    ImageIcon iconoEscalado = new ImageIcon(imgEscalada);

//se dibuja la imagen que tenemos en el paquete Images //dentro de un panel
        grafico.drawImage(iconoEscalado.getImage(), 0, 0, height.width, height.height, null);

        setOpaque(false);
        super.paintComponent(grafico);
    }
    
    private String _direccion = null;
}
