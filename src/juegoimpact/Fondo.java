/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegoimpact;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JLayeredPane;

public class Fondo extends JLayeredPane{
    
    
    @Override
    public void paintComponent(Graphics g)
    {
        Dimension Tam=getSize();
        ImageIcon Imagen=new ImageIcon(new ImageIcon(getClass().getResource("/Fondo/Tablero.png")).getImage());
        g.drawImage(Imagen.getImage(),0,0,Tam.width,Tam.height,null);
        
    }
    
}
