/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PanelesInstrucciones;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author HECTOR
 */
public class Instruccion4 extends JPanel{
     JButton Anterior;
    JButton Siguiente;
    String Imagenes="4.jpg";
    public Instruccion4(){
    this.setLayout(null);
    
    BotonCambio();
  
    }
    
      @Override
    public void paintComponent(Graphics g)
    {
        Dimension Tam=getSize();
        ImageIcon Imagen=new ImageIcon(new ImageIcon(getClass().getResource("/ImageInstrucciones/"+Imagenes)).getImage());
        g.drawImage(Imagen.getImage(),0,0,Tam.width,Tam.height,null);
        
    }
    
     public void BotonCambio() {
        Anterior = new JButton();
        Anterior.setBounds(322, 154, 39, 50);
        Anterior.setContentAreaFilled(false);
        Anterior.setBorderPainted(false);
        this.add(Anterior);
        Siguiente = new JButton();
        Siguiente.setBounds(1002, 154, 39, 50);
        Siguiente.setContentAreaFilled(false);
        Siguiente.setBorderPainted(false);
        this.add(Siguiente);     
     }

    public JButton getAnterior() {
        return Anterior;
    }

    public void setAnterior(JButton Anterior) {
        this.Anterior = Anterior;
    }

    public JButton getSiguiente() {
        return Siguiente;
    }

    public void setSiguiente(JButton Siguiente) {
        this.Siguiente = Siguiente;
    }
     
  
    
}
