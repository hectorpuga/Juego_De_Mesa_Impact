
package Paneles;

import Logica.Alumno;
import Logica.Maestro;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;


public class PanelTablero extends JLayeredPane {
    
 JButton BotonDado;
 JLabel J1,J2,J3,J4,J5;
 JLabel R;
  JLabel Dado;
  Alumno alumnos[] = new Alumno[4];
    JLabel Jugador1[]=new JLabel[7];
   JLabel Jugador2[]=new JLabel[7];
   JLabel Jugador3[]=new JLabel[7];
   JLabel Jugador4[]=new JLabel[7];
   JLabel Maestro1[]=new JLabel[7]; 
   
    public PanelTablero(){
    
        this.setLayout(null);
        BotonDado();
        alumnos[0] = Alumno.Aplicado("Puga", 28000, 1600, 2200, 1460, 40, 26, 0);
      alumnos[1] = Alumno.Recursador("Budarth", 28000, 1800, 2000, 1330, 50, 30, 0);
      alumnos[2] = Alumno.Deportista("Valverde", 28000, 1400, 2100, 1400, 36, 24, 0);
      alumnos[3] = Alumno.Apoyo("Héctor", 28000, 1200, 1650, 1100, 28, 34, 0);
        creacionLabel();
        
    }
    
     @Override
    public void paintComponent(Graphics g)
    {
        Dimension Tam=getSize();
        ImageIcon Imagen=new ImageIcon(new ImageIcon(getClass().getResource("/Fondos/Tablero.png")).getImage());
        g.drawImage(Imagen.getImage(),0,0,Tam.width,Tam.height,null);
    }
    
   

    public void Roberto() {
        R = new JLabel();
        ImageIcon Imagen=new ImageIcon("Roberto.png");
        R.setBounds(596, 613, 82, 74);
        R.setIcon(new ImageIcon(Imagen.getImage().getScaledInstance(R.getWidth(),R.getHeight(),Image.SCALE_SMOOTH)));
        this.add(R,1,0);}
    
    
    
     public void BotonDado() {
        Dado = new JLabel();
        Dado.setBounds(255, 340, 190, 150);
       

        this.add(Dado);

        BotonDado = new JButton();
        BotonDado.setBounds(257, 530, 190, 50);
        BotonDado.setContentAreaFilled(false);
        BotonDado.setBorderPainted(false);
        this.add(BotonDado);
    }

    public JButton getBotonDado() {
        return BotonDado;
    }

    public JLabel getDado() {
        return Dado;
    }
     
     
    
public void creacionLabel(){
      
    
    J1=new JLabel();
    J2=new JLabel();
    J3=new JLabel();
    J4=new JLabel();
    J5=new JLabel();
    
    J1.setText("Aplicado");
    J1.setBounds(845,146,100, 15);
    this.add(J1);
    
    J2.setText("Recursador");
    J2.setBounds(1145,146,100, 15);
    this.add(J2);
    
    J3.setText("Deportista");
    J3.setBounds(1145,350,100, 15);
    this.add(J3);
    
     J4.setText("Apoyo");
    J4.setBounds(845,350,100, 15);
    this.add(J4);
    
    
    
        String Dato="";
        int Lugar=833;
        
        for (int i = 0; i < 7; i++) {
            if(i==0){
            
            Dato=Integer.toString((int)alumnos[0].getVida());
            }
            else if(i==1){
                Lugar=840;
            
            Dato=Integer.toString((int)alumnos[0].getDefensa());
            }
             else if(i==2){
            
            Dato=Integer.toString((int)alumnos[0].getDañoBase());
            }
             else if(i==3){
            
            Dato=Integer.toString((int)alumnos[0].getDañoCritico());
            }
             else if(i==4){
            
            Dato=Integer.toString((int)alumnos[0].getProbabilidadCritico());
            }
             else if(i==5){
            
            Dato=Integer.toString((int)alumnos[0].getProbabilidadEvadirAtaque());
            }
             else if(i==6){
            
            Dato=Integer.toString((int)alumnos[0].getExperiencia());
            }
            
            Jugador1[i]=new JLabel();
          
            if(i<4){
            Jugador1[i].setText(Dato);
            Jugador1[i].setBounds(Lugar,170+(16*i), 50, 15);
            this.add(Jugador1[i],2,0);
            }
            else{
            Jugador1[i].setText(Dato);
            Jugador1[i].setBounds(Lugar+(140),170+(16*(i-4)), 50, 15);
            this.add(Jugador1[i],2,0);
            
            }
                
        }
        for (int i = 0; i < 7; i++) {
            
             if(i==0){
            Lugar=1133;
            Dato=Integer.toString((int)alumnos[1].getVida());
            }
            else if(i==1){
                Lugar=1140;
            
            Dato=Integer.toString((int)alumnos[1].getDefensa());
            }
             else if(i==2){
            
            Dato=Integer.toString((int)alumnos[1].getDañoBase());
            }
             else if(i==3){
            
            Dato=Integer.toString((int)alumnos[1].getDañoCritico());
            }
             else if(i==4){
            
            Dato=Integer.toString((int)alumnos[1].getProbabilidadCritico());
            }
             else if(i==5){
            
            Dato=Integer.toString((int)alumnos[1].getProbabilidadEvadirAtaque());
            }
             else if(i==6){
            
            Dato=Integer.toString((int)alumnos[1].getExperiencia());
            }
            
            
            Jugador2[i]=new JLabel();
          
            if(i<4){
            Jugador2[i].setText(Dato);
            Jugador2[i].setBounds(Lugar,170+(16*i), 50, 15);
            this.add(Jugador2[i],2,0);
            }
            else{
            Jugador2[i].setText(Dato);
            Jugador2[i].setBounds(Lugar+(140),170+(16*(i-4)), 30, 15);
            this.add(Jugador2[i],2,0);
            
            }
            
            
            
        }
         for (int i = 0; i < 7; i++) {
              if(i==0){
            Lugar=833;
            Dato=Integer.toString((int)alumnos[2].getVida());
            }
            else if(i==1){
                Lugar=840;
            
            Dato=Integer.toString((int)alumnos[2].getDefensa());
            }
             else if(i==2){
            
            Dato=Integer.toString((int)alumnos[2].getDañoBase());
            }
             else if(i==3){
            
            Dato=Integer.toString((int)alumnos[2].getDañoCritico());
            }
             else if(i==4){
            
            Dato=Integer.toString((int)alumnos[2].getProbabilidadCritico());
            }
             else if(i==5){
            
            Dato=Integer.toString((int)alumnos[2].getProbabilidadEvadirAtaque());
            }
             else if(i==6){
            
            Dato=Integer.toString((int)alumnos[2].getExperiencia());
            }
            
            
            Jugador3[i]=new JLabel();
          
            if(i<4){
            Jugador3[i].setText(Dato);
            Jugador3[i].setBounds(Lugar,375+(16*i), 50, 15);
            this.add(Jugador3[i],2,0);
            }
            else{
            Jugador3[i].setText(Dato);
            Jugador3[i].setBounds(Lugar+140,375+(16*(i-4)), 50, 15);
            this.add(Jugador3[i],2,0);
            
            }
            
              
            
        }
         for (int i = 0; i < 7; i++) {
             
       
      
              if(i==0){
            Lugar=1133;
            Dato=Integer.toString((int)alumnos[3].getVida());
            }
            else if(i==1){
                Lugar=1140;
            
            Dato=Integer.toString((int)alumnos[3].getDefensa());
            }
             else if(i==2){
            
            Dato=Integer.toString((int)alumnos[3].getDañoBase());
            }
             else if(i==3){
            
            Dato=Integer.toString((int)alumnos[3].getDañoCritico());
            }
             else if(i==4){
            
            Dato=Integer.toString((int)alumnos[3].getProbabilidadCritico());
            }
             else if(i==5){
            
            Dato=Integer.toString((int)alumnos[3].getProbabilidadEvadirAtaque());
            }
             else if(i==6){
            
            Dato=Integer.toString((int)alumnos[3].getExperiencia());
            }
            
            
            Jugador4[i]=new JLabel();
          
            if(i<4){
            Jugador4[i].setText(Dato);
            Jugador4[i].setBounds(Lugar,375+(16*i), 50, 15);
            this.add(Jugador4[i],2,0);
            }
            else{
            Jugador4[i].setText(Dato);
            Jugador4[i].setBounds(Lugar+140,375+(16*(i-4)), 30, 15);
            this.add(Jugador4[i],2,0);
            
            }
            
              
            
        }
        
    }

 public  void ventajaUno(int n) {
        
        //AUMENTAR VIDA 5000 PUNTOS
        
        switch(n){
            case 1:
        if (sigueVivoAlumnoAplicado()) {
            alumnos[0].setVida(alumnos[0].getVida() + 5000);
        }
        break;
        case 2:
        if (sigueVivoAlumnoRecursador()) {
            alumnos[1].setVida(alumnos[1].getVida() + 5000);
        }
        break;
        case 3:
        if (sigueVivoAlumnoDeportista()) {
            alumnos[2].setVida(alumnos[2].getVida() + 5000);
        }
        break;
        case 4:
        if (sigueVivoAlumnoApoyo()) {
            alumnos[3].setVida(alumnos[3].getVida() + 5000);
        }
        break;
        }
        for(int i=0; i<7; i++){
        
         Jugador1[i].setVisible(false);
          Jugador2[i].setVisible(false);
           Jugador3[i].setVisible(false);
            Jugador4[i].setVisible(false);
           
        }
       
       creacionLabel(); 
    }
 
 
    public  void ventajaDos(int n) {
        //AUMENTAR PROBABILIDAD DE CRITICO UN 25%
        
        
         switch(n){
            case 1:
        if (sigueVivoAlumnoAplicado()) {
            alumnos[0].setProbabilidadCritico(alumnos[0].getProbabilidadCritico() + 25);
        }
        break;
        case 2:
        if (sigueVivoAlumnoRecursador()) {
            alumnos[1].setProbabilidadCritico(alumnos[1].getProbabilidadCritico() + 25);
        }
        break;
        case 3:
        if (sigueVivoAlumnoDeportista()) {
            alumnos[2].setProbabilidadCritico(alumnos[2].getProbabilidadCritico() + 25);
        }
        break;
        case 4:
        if (sigueVivoAlumnoApoyo()) {
            alumnos[3].setProbabilidadCritico(alumnos[3].getProbabilidadCritico() + 25);
        }
        break;
        }
       
        
           for(int i=0; i<7; i++){
        
         Jugador1[i].setVisible(false);
          Jugador2[i].setVisible(false);
           Jugador3[i].setVisible(false);
            Jugador4[i].setVisible(false);
           
          
           }
       
       creacionLabel(); 
    }

    public  void ventajaTres(int n) {
        //AUMENTAR PROBABILIDAD EVADIR ATAQUE UN 20%
        
        switch(n){
            case 1:
        if (sigueVivoAlumnoAplicado()) {
            alumnos[0].setProbabilidadEvadirAtaque(alumnos[0].getProbabilidadEvadirAtaque() + 20);
        }
        break;
        case 2:
       if (sigueVivoAlumnoRecursador()) {
            alumnos[1].setProbabilidadEvadirAtaque(alumnos[1].getProbabilidadEvadirAtaque() + 20);
        }
        break;
        case 3:
        if (sigueVivoAlumnoDeportista()) {
            alumnos[2].setProbabilidadEvadirAtaque(alumnos[2].getProbabilidadEvadirAtaque() + 20);
        }
        break;
        case 4:
       
        if (sigueVivoAlumnoApoyo()) {
            alumnos[3].setProbabilidadEvadirAtaque(alumnos[3].getProbabilidadEvadirAtaque() + 20);
        }
        break;
        }
        
       
         for(int i=0; i<7; i++){
        
         Jugador1[i].setVisible(false);
          Jugador2[i].setVisible(false);
           Jugador3[i].setVisible(false);
            Jugador4[i].setVisible(false);
            
          
           }
       
       creacionLabel(); 
    }

    public  void ventajaCuatro(int n) {
        //AUMENTAR DAÑO BASE EN 200 PUNTOS
        
        switch(n){
            case 1:
        if (sigueVivoAlumnoAplicado()) {
            alumnos[0].setDañoBase(alumnos[0].getDañoBase() + 200);
        }
        break;
        case 2:
        if (sigueVivoAlumnoRecursador()) {
            alumnos[1].setDañoBase(alumnos[1].getDañoBase() + 200);
        }
        break;
        case 3:
         if (sigueVivoAlumnoDeportista()) {
            alumnos[2].setDañoBase(alumnos[2].getDañoBase() + 200);
        }
        break;
        case 4:
        
        if (sigueVivoAlumnoApoyo()) {
            alumnos[3].setDañoBase(alumnos[3].getDañoBase() + 200);
        }
        break;
        }
        
        
        
       
        
         for(int i=0; i<7; i++){
        
         Jugador1[i].setVisible(false);
          Jugador2[i].setVisible(false);
           Jugador3[i].setVisible(false);
            Jugador4[i].setVisible(false);
           
          
           }
       
       creacionLabel(); 
    }

    public  void ventajaCinco(int n) {
        //AUMENTAR DEFENSA 400 PUNTOS
        
        switch(n){
            case 1:
         if (sigueVivoAlumnoAplicado()) {
            alumnos[0].setDefensa(alumnos[0].getDefensa() + 400);
        }
        break;
        case 2:
       if (sigueVivoAlumnoRecursador()) {
            alumnos[1].setDefensa(alumnos[1].getDefensa() + 400);
        }
        break;
        case 3:
         if (sigueVivoAlumnoDeportista()) {
            alumnos[2].setDefensa(alumnos[2].getDefensa() + 400);
        }
        break;
        case 4:
        if (sigueVivoAlumnoApoyo()) {
            alumnos[3].setDefensa(alumnos[3].getDefensa() + 400);
        }
        break;
        }
        
        
         for(int i=0; i<7; i++){
        
         Jugador1[i].setVisible(false);
          Jugador2[i].setVisible(false);
           Jugador3[i].setVisible(false);
            Jugador4[i].setVisible(false);
            
          
           }
       
       creacionLabel(); 
    }

    public  void desventajaUno() {
        //DISMINUIR VIDA 3000 PUNTOS
        if (sigueVivoAlumnoAplicado()) {
            alumnos[0].setVida(alumnos[0].getVida() - 3000);
        }
        if (sigueVivoAlumnoRecursador()) {
            alumnos[1].setVida(alumnos[1].getVida() - 3000);
        }
        if (sigueVivoAlumnoDeportista()) {
            alumnos[2].setVida(alumnos[2].getVida() - 3000);
        }
        if (sigueVivoAlumnoApoyo()) {
            alumnos[3].setVida(alumnos[3].getVida() - 3000);
        }
       
      
        
        
         for(int i=0; i<7; i++){
        
         Jugador1[i].setVisible(false);
          Jugador2[i].setVisible(false);
           Jugador3[i].setVisible(false);
            Jugador4[i].setVisible(false);
           
          
           }
       
       creacionLabel(); 
        
    }

    public void desventajaDos() {
        //DISMINUIR PROBABILIDAD DE CRITICO UN 5%
        if (sigueVivoAlumnoAplicado()) {
            alumnos[0].setProbabilidadCritico(alumnos[0].getProbabilidadCritico() - 5);
        }
        if (sigueVivoAlumnoRecursador()) {
            alumnos[1].setProbabilidadCritico(alumnos[1].getProbabilidadCritico() - 5);
        }
        if (sigueVivoAlumnoDeportista()) {
            alumnos[2].setProbabilidadCritico(alumnos[2].getProbabilidadCritico() - 5);
        }
        if (sigueVivoAlumnoApoyo()) {
            alumnos[3].setProbabilidadCritico(alumnos[3].getProbabilidadCritico() - 5);
        }
        for(int i=0; i<7; i++){
        
         Jugador1[i].setVisible(false);
          Jugador2[i].setVisible(false);
           Jugador3[i].setVisible(false);
            Jugador4[i].setVisible(false);
           
          
           }
       
       creacionLabel(); 
        
    }

    public void desventajaTres() {
        //DISMINUIR DAÑO BASE EN 100 PUNTOS
        if (sigueVivoAlumnoApoyo()) {
            alumnos[0].setDañoBase(alumnos[0].getDañoBase() - 100);
        }
        if (sigueVivoAlumnoRecursador()) {
            alumnos[1].setDañoBase(alumnos[1].getDañoBase() - 100);
        }
        if (sigueVivoAlumnoDeportista()) {
            alumnos[2].setDañoBase(alumnos[2].getDañoBase() - 100);
        }
        if (sigueVivoAlumnoApoyo()) {
            alumnos[3].setDañoBase(alumnos[3].getDañoBase() - 100);
        }
        for(int i=0; i<7; i++){
        
         Jugador1[i].setVisible(false);
          Jugador2[i].setVisible(false);
           Jugador3[i].setVisible(false);
            Jugador4[i].setVisible(false);
          
           }
       
       creacionLabel(); 
    }

    public  void desventajaCuatro() {
        //DISMINUIR DEFENSA EN 200 PUNTOS
        if (sigueVivoAlumnoAplicado()) {
            alumnos[0].setDefensa(alumnos[0].getDefensa() - 200);
        }
        if (sigueVivoAlumnoRecursador()) {
            alumnos[1].setDefensa(alumnos[1].getDefensa() - 200);
        }
        if (sigueVivoAlumnoDeportista()) {
            alumnos[2].setDefensa(alumnos[2].getDefensa() - 200);
        }
        if (sigueVivoAlumnoApoyo()) {
            alumnos[3].setDefensa(alumnos[3].getDefensa() - 200);
        }
        for(int i=0; i<7; i++){
        
         Jugador1[i].setVisible(false);
          Jugador2[i].setVisible(false);
           Jugador3[i].setVisible(false);
            Jugador4[i].setVisible(false);
          
           }
       
       creacionLabel(); 
    }
    
 
  public  boolean sigueVivoAlgunAlumno() {
        return (alumnos[0].getVida() > 0 || alumnos[1].getVida() > 0 || alumnos[2].getVida() > 0 || alumnos[3].getVida() > 0);
    }

    public  boolean sigueVivoAlumnoAplicado() {
        return (alumnos[0].getVida() > 0);
    }

    public  boolean sigueVivoAlumnoRecursador() {
        return (alumnos[1].getVida() > 0);
    }

    public  boolean sigueVivoAlumnoDeportista() {
        return (alumnos[2].getVida() > 0);
    }

    public  boolean sigueVivoAlumnoApoyo() {
        return (alumnos[3].getVida() > 0);
    }

   

    public static double porcentaje(double valor, int porcentaje) {
        return ((valor / 100) * porcentaje);
    }

    public Alumno[] getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(Alumno[] alumnos) {
        this.alumnos = alumnos;
        
    }

    public JLabel getR() {
        return R;
    }

    public void setR(JLabel R) {
        this.R = R;
    }

    public JLabel[] getJugador1() {
        return Jugador1;
    }

    public void setJugador1(JLabel[] Jugador1) {
        this.Jugador1 = Jugador1;
    }

    public JLabel[] getJugador2() {
        return Jugador2;
    }

    public void setJugador2(JLabel[] Jugador2) {
        this.Jugador2 = Jugador2;
    }

    public JLabel[] getJugador3() {
        return Jugador3;
    }

    public void setJugador3(JLabel[] Jugador3) {
        this.Jugador3 = Jugador3;
    }

    public JLabel[] getJugador4() {
        return Jugador4;
    }

    public void setJugador4(JLabel[] Jugador4) {
        this.Jugador4 = Jugador4;
    }

    public JLabel[] getMaestro1() {
        return Maestro1;
    }

    public void setMaestro1(JLabel[] Maestro1) {
        this.Maestro1 = Maestro1;
    }
    
    
    
    
}
