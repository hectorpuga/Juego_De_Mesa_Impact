/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegoimpact;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import juegoimpact.Juego;

/**
 *
 * @author HECTOR
 */
public class PanelInicio extends JPanel {
    
    JButton BotonInicio;
    JButton Instrucciones;
   
    
   public PanelInicio(){
   this.setLayout(null);
   BotonCambio();
   
    }
    
     @Override
    public void paintComponent(Graphics g)
    {
        Dimension Tam=getSize();
        ImageIcon Imagen=new ImageIcon(new ImageIcon(getClass().getResource("/Fondos/Inicio.png")).getImage());
        g.drawImage(Imagen.getImage(),0,0,Tam.width,Tam.height,null);
        
    }
    
     public void BotonCambio() {

        BotonInicio = new JButton();
        BotonInicio.setBounds(550, 550, 266, 50);
        BotonInicio.setContentAreaFilled(false);
        BotonInicio.setBorderPainted(false);
        this.add(BotonInicio);
        
        Instrucciones = new JButton();
        Instrucciones.setBounds(550, 606, 266, 50);
        Instrucciones.setContentAreaFilled(false);
        Instrucciones.setBorderPainted(false);
        this.add(Instrucciones);
    }

    public JButton getBotonInicio() {
        return BotonInicio;
    }

    public void setBotonInicio(JButton BotonInicio) {
        this.BotonInicio = BotonInicio;
    }

    public JButton getInstrucciones() {
        return Instrucciones;
    }

    public void setInstrucciones(JButton Instrucciones) {
        this.Instrucciones = Instrucciones;
    }
    
    
    

    
}
