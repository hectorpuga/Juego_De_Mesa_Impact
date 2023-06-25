
package PanelesInstrucciones;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;


public class Instruccion1 extends JPanel {
   
    JButton Anterior;
    JButton Siguiente;
    String Imagenes="1.jpg";
    public Instruccion1(){
    this.setLayout(null);
    
    BotonCambio();
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
     
   
}
