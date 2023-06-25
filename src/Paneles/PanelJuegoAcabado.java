/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Paneles;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLayeredPane;


public class PanelJuegoAcabado extends JLayeredPane{
    JButton Boton;
    public PanelJuegoAcabado(){
    this.setLayout(new GridLayout(1,1));
    AgregarBoton();
    
    }
    
       @Override
    public void paintComponent(Graphics g)
    {
        Dimension Tam=getSize();
        ImageIcon Imagen=new ImageIcon(new ImageIcon(getClass().getResource("/Fondos/Juego ganado.png")).getImage());
        g.drawImage(Imagen.getImage(),0,0,Tam.width,Tam.height,null);
        
    }
    
    public void AgregarBoton(){
    Boton=new JButton();
     Boton.setContentAreaFilled(false);
        Boton.setBorderPainted(false);
    this.add(Boton);
    
    
    }

    public JButton getBoton() {
        return Boton;
    }
    
}
