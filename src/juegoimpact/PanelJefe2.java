/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegoimpact;

import Logica.Alumno;
import Logica.Maestro;
import Paneles.PanelTablero;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


/**
 *
 * @author HECTOR
 */
public class PanelJefe2 extends JLayeredPane {
  
    JLabel Batalla;
    int MaximoNumero=28000;
    int ActualNumero=28000;
    int turno = 0;
    JProgressBar Jugador1B=new JProgressBar(0,28000);
   JProgressBar Jugador2B=new JProgressBar(0,33500);
   JProgressBar Jugador3B=new JProgressBar(0,25000);
   JProgressBar Jugador4B=new JProgressBar(0,49000);
   JProgressBar Maestro2B=new JProgressBar(0,57000);
   JTextArea Sucesos;
    
    PanelTablero Tablero=new PanelTablero();

      Random rndm = new Random();
        //(NUMEROS ALEATORIOS)
        int maximo = 2;
        int minimo = 1;
        //VARIABLES GLOBALES
        double daño;
        int resultado = 0, numeroDeMaestro = 1;
    JButton Ataque,Especial;
   JLabel Jugador1[]=new JLabel[7];
   JLabel Jugador2[]=new JLabel[7];
   JLabel Jugador3[]=new JLabel[7];
   JLabel Jugador4[]=new JLabel[7];
   JLabel Maestro1[]=new JLabel[7];
   Alumno alumnos[] = Tablero.getAlumnos();
   Alumno objAlumno;
   Maestro maestros[] = new Maestro[4];
   Maestro maestroActual = null;
   
   
     public PanelJefe2(){
     this.setLayout(null);
     Batalla();
     Botones();
 
 CajaSucesos();
   
  
     }
       @Override
    public void paintComponent(Graphics g)
    {
        Dimension Tam=getSize();
        ImageIcon Imagen=new ImageIcon(new ImageIcon(getClass().getResource("/Fondos/Jefe 2.jpg")).getImage());
        g.drawImage(Imagen.getImage(),0,0,Tam.width,Tam.height,null);
        
    }
    
   
    
    public void Batalla() {
 ImageIcon Imagen=new ImageIcon("J2.png");
        Batalla = new JLabel();
         Batalla.setBounds(0, 0, 1380, 700);
        Batalla.setIcon(new ImageIcon(Imagen.getImage().getScaledInstance(1500,800,Image.SCALE_SMOOTH)));
        this.add(Batalla,1,0);
    }
    
    public void Botones(){
    Ataque=new JButton();
    Ataque.setBounds(616, 560, 288, 50);
    Ataque.setContentAreaFilled(false);
    Ataque.setBorderPainted(false);
    this.add(Ataque,2,0);
    
    Especial=new JButton();
    Especial.setBounds(956, 560, 288, 50);
    Especial.setContentAreaFilled(false);
    Especial.setBorderPainted(false);
    this.add(Especial,2,0);
  
    }
    
    public void creacionLabel(){
   
      maestros[1] = Maestro.Medio("Verónica", 57000, 2400, 2700, 1800, 40, 15, 2750);
      maestroActual = maestros[numeroDeMaestro];
      
        String Dato="";
        int Lugar=145;
        
        for (int i = 0; i < 7; i++) {
            if(i==0){
            
            Dato=Integer.toString((int)alumnos[0].getVida());
            }
            else if(i==1){
                Lugar=150;
            
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
            Jugador1[i].setBounds(Lugar,97+(19*i), 50, 15);
            this.add(Jugador1[i],2,0);
            }
            else{
            Jugador1[i].setText(Dato);
            Jugador1[i].setBounds(305,97+(19*(i-4)), 50, 15);
            this.add(Jugador1[i],2,0);
            
            }
            
            
            
        }
        for (int i = 0; i < 7; i++) {
            
             if(i==0){
            Lugar=145;
            Dato=Integer.toString((int)alumnos[1].getVida());
            }
            else if(i==1){
                Lugar=150;
            
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
            Jugador2[i].setBounds(Lugar,272+(19*i), 50, 15);
            this.add(Jugador2[i],2,0);
            }
            else{
            Jugador2[i].setText(Dato);
            Jugador2[i].setBounds(310,272+(19*(i-4)), 30, 15);
            this.add(Jugador2[i],2,0);
            
            }
            
            
            
        }
         for (int i = 0; i < 7; i++) {
              if(i==0){
            Lugar=145;
            Dato=Integer.toString((int)alumnos[2].getVida());
            }
            else if(i==1){
                Lugar=150;
            
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
            Jugador3[i].setBounds(Lugar,447+(19*i), 50, 15);
            this.add(Jugador3[i],2,0);
            }
            else{
            Jugador3[i].setText(Dato);
            Jugador3[i].setBounds(310,447+(19*(i-4)), 50, 15);
            this.add(Jugador3[i],2,0);
            
            }
            
              
            
        }
         for (int i = 0; i < 7; i++) {
              if(i==0){
            Lugar=145;
            Dato=Integer.toString((int)alumnos[3].getVida());
            }
            else if(i==1){
                Lugar=150;
            
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
            Jugador4[i].setBounds(Lugar,622+(19*i), 50, 15);
            this.add(Jugador4[i],2,0);
            }
            else{
            Jugador4[i].setText(Dato);
            Jugador4[i].setBounds(310,622+(19*(i-4)), 30, 15);
            this.add(Jugador4[i],2,0);
            
            }
            
              
            
        }
         
         for (int i = 0; i < 7; i++) {
            if(i==0){
           Lugar=1180;
            Dato=Integer.toString((int)maestros[1].getVida());
            }
            else if(i==1){
            
            Dato=Integer.toString((int)maestros[1].getDefensa());
            }
             else if(i==2){
            
            Dato=Integer.toString((int)maestros[1].getDañoBase());
            }
             else if(i==3){
            
            Dato=Integer.toString((int)maestros[1].getDañoCritico());
            }
             else if(i==4){
            
            Dato=Integer.toString((int)maestros[1].getProbabilidadCritico());
            Lugar=1190;
            }
             else if(i==5){
            Dato=Integer.toString((int)maestros[1].getProbabilidadEvadirAtaque());
            }
             else if(i==6){
            Lugar=1180;
            Dato=Integer.toString((int)maestros[1].getExperiencia());
            }
            
              Maestro1[i]=new JLabel();
          
           if(i<4){
          
            Maestro1[i].setText(Dato);
            Maestro1[i].setBounds(Lugar,100+(25*i), 50, 15);
            this.add(Maestro1[i],2,0);
            }
            else{
            Maestro1[i].setText(Dato);
            Maestro1[i].setBounds(Lugar,120+(26*i), 30, 15);
            this.add(Maestro1[i],2,0);
            }
              
            
        }
    
   
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

    public  boolean sigueVivoElMaestroActual() {
        return (maestroActual.getVida() > 0);
    }

    public static double porcentaje(double valor, int porcentaje) {
        return ((valor / 100) * porcentaje);
    }

    //VENTAJAS
     public  void ventajaUno(int n) {
        
        //AUMENTAR VIDA 5000 PUNTOS
        System.out.println("entre");
        switch(n){
            case 1:
        if (sigueVivoAlumnoAplicado()) {
            alumnos[0].setVida(alumnos[0].getVida());
        }
        break;
        case 2:
        if (sigueVivoAlumnoRecursador()) {
            alumnos[1].setVida(alumnos[1].getVida() );
        }
        break;
        case 3:
        if (sigueVivoAlumnoDeportista()) {
            alumnos[2].setVida(alumnos[2].getVida() );
        }
        break;
        case 4:
        if (sigueVivoAlumnoApoyo()) {
            alumnos[3].setVida(alumnos[3].getVida());
        }
        break;
        }
        for(int i=0; i<7; i++){
        
         Jugador1[i].setVisible(false);
          Jugador2[i].setVisible(false);
           Jugador3[i].setVisible(false);
            Jugador4[i].setVisible(false);
            Maestro1[i].setVisible(false);
        }
       
        
       
       
       creacionLabel(); 
    }

   
    public  void ventajaDos(int n) {
        //AUMENTAR PROBABILIDAD DE CRITICO UN 25%
        
        
         switch(n){
            case 1:
        if (sigueVivoAlumnoAplicado()) {
            alumnos[0].setProbabilidadCritico(alumnos[0].getProbabilidadCritico());
        }
        break;
        case 2:
        if (sigueVivoAlumnoRecursador()) {
            alumnos[1].setProbabilidadCritico(alumnos[1].getProbabilidadCritico());
        }
        break;
        case 3:
        if (sigueVivoAlumnoDeportista()) {
            alumnos[2].setProbabilidadCritico(alumnos[2].getProbabilidadCritico());
        }
        break;
        case 4:
        if (sigueVivoAlumnoApoyo()) {
            alumnos[3].setProbabilidadCritico(alumnos[3].getProbabilidadCritico());
        }
        break;
        }
       
        
           for(int i=0; i<7; i++){
        
         Jugador1[i].setVisible(false);
          Jugador2[i].setVisible(false);
           Jugador3[i].setVisible(false);
            Jugador4[i].setVisible(false);
            Maestro1[i].setVisible(false);
          
           }
       
       creacionLabel(); 
    }

    public  void ventajaTres(int n) {
        //AUMENTAR PROBABILIDAD EVADIR ATAQUE UN 20%
        
        switch(n){
            case 1:
        if (sigueVivoAlumnoAplicado()) {
            alumnos[0].setProbabilidadEvadirAtaque(alumnos[0].getProbabilidadEvadirAtaque());
        }
        break;
        case 2:
       if (sigueVivoAlumnoRecursador()) {
            alumnos[1].setProbabilidadEvadirAtaque(alumnos[1].getProbabilidadEvadirAtaque());
        }
        break;
        case 3:
        if (sigueVivoAlumnoDeportista()) {
            alumnos[2].setProbabilidadEvadirAtaque(alumnos[2].getProbabilidadEvadirAtaque());
        }
        break;
        case 4:
       
        if (sigueVivoAlumnoApoyo()) {
            alumnos[3].setProbabilidadEvadirAtaque(alumnos[3].getProbabilidadEvadirAtaque());
        }
        break;
        }
        
       
         for(int i=0; i<7; i++){
        
         Jugador1[i].setVisible(false);
          Jugador2[i].setVisible(false);
           Jugador3[i].setVisible(false);
            Jugador4[i].setVisible(false);
            Maestro1[i].setVisible(false);
          
           }
       
       creacionLabel(); 
    }

    public  void ventajaCuatro(int n) {
        //AUMENTAR DAÑO BASE EN 200 PUNTOS
        
        switch(n){
            case 1:
        if (sigueVivoAlumnoAplicado()) {
            alumnos[0].setDañoBase(alumnos[0].getDañoBase());
        }
        break;
        case 2:
        if (sigueVivoAlumnoRecursador()) {
            alumnos[1].setDañoBase(alumnos[1].getDañoBase());
        }
        break;
        case 3:
         if (sigueVivoAlumnoDeportista()) {
            alumnos[2].setDañoBase(alumnos[2].getDañoBase());
        }
        break;
        case 4:
        
        if (sigueVivoAlumnoApoyo()) {
            alumnos[3].setDañoBase(alumnos[3].getDañoBase());
        }
        break;
        }
        
        
        
       
        
         for(int i=0; i<7; i++){
        
         Jugador1[i].setVisible(false);
          Jugador2[i].setVisible(false);
           Jugador3[i].setVisible(false);
            Jugador4[i].setVisible(false);
            Maestro1[i].setVisible(false);
          
           }
       
       creacionLabel(); 
    }

    public  void ventajaCinco(int n) {
        //AUMENTAR DEFENSA 400 PUNTOS
        
        switch(n){
            case 1:
         if (sigueVivoAlumnoAplicado()) {
            alumnos[0].setDefensa(alumnos[0].getDefensa());
        }
        break;
        case 2:
       if (sigueVivoAlumnoRecursador()) {
            alumnos[1].setDefensa(alumnos[1].getDefensa());
        }
        break;
        case 3:
         if (sigueVivoAlumnoDeportista()) {
            alumnos[2].setDefensa(alumnos[2].getDefensa());
        }
        break;
        case 4:
        if (sigueVivoAlumnoApoyo()) {
            alumnos[3].setDefensa(alumnos[3].getDefensa());
        }
        break;
        }
        
        
         for(int i=0; i<7; i++){
        
         Jugador1[i].setVisible(false);
          Jugador2[i].setVisible(false);
           Jugador3[i].setVisible(false);
            Jugador4[i].setVisible(false);
            Maestro1[i].setVisible(false);
          
           }
       
       creacionLabel(); 
    }

    //DESVENTAJAS
   public  void desventajaUno() {
        //DISMINUIR VIDA 3000 PUNTOS
        if (sigueVivoAlumnoAplicado()) {
            alumnos[0].setVida(alumnos[0].getVida());
        }
        if (sigueVivoAlumnoRecursador()) {
            alumnos[1].setVida(alumnos[1].getVida());
        }
        if (sigueVivoAlumnoDeportista()) {
            alumnos[2].setVida(alumnos[2].getVida());
        }
        if (sigueVivoAlumnoApoyo()) {
            alumnos[3].setVida(alumnos[3].getVida());
        }
       
      
        
        
         for(int i=0; i<7; i++){
        
         Jugador1[i].setVisible(false);
          Jugador2[i].setVisible(false);
           Jugador3[i].setVisible(false);
            Jugador4[i].setVisible(false);
            Maestro1[i].setVisible(false);
          
           }
       
       creacionLabel(); 
        
    }

    public void desventajaDos() {
        //DISMINUIR PROBABILIDAD DE CRITICO UN 5%
        if (sigueVivoAlumnoAplicado()) {
            alumnos[0].setProbabilidadCritico(alumnos[0].getProbabilidadCritico());
        }
        if (sigueVivoAlumnoRecursador()) {
            alumnos[1].setProbabilidadCritico(alumnos[1].getProbabilidadCritico());
        }
        if (sigueVivoAlumnoDeportista()) {
            alumnos[2].setProbabilidadCritico(alumnos[2].getProbabilidadCritico());
        }
        if (sigueVivoAlumnoApoyo()) {
            alumnos[3].setProbabilidadCritico(alumnos[3].getProbabilidadCritico());
        }
        for(int i=0; i<7; i++){
        
         Jugador1[i].setVisible(false);
          Jugador2[i].setVisible(false);
           Jugador3[i].setVisible(false);
            Jugador4[i].setVisible(false);
            Maestro1[i].setVisible(false);
          
           }
       
       creacionLabel(); 
        
    }

    public void desventajaTres() {
        //DISMINUIR DAÑO BASE EN 100 PUNTOS
        if (sigueVivoAlumnoApoyo()) {
            alumnos[0].setDañoBase(alumnos[0].getDañoBase());
        }
        if (sigueVivoAlumnoRecursador()) {
            alumnos[1].setDañoBase(alumnos[1].getDañoBase());
        }
        if (sigueVivoAlumnoDeportista()) {
            alumnos[2].setDañoBase(alumnos[2].getDañoBase());
        }
        if (sigueVivoAlumnoApoyo()) {
            alumnos[3].setDañoBase(alumnos[3].getDañoBase());
        }
        for(int i=0; i<7; i++){
        
         Jugador1[i].setVisible(false);
          Jugador2[i].setVisible(false);
           Jugador3[i].setVisible(false);
            Jugador4[i].setVisible(false);
            Maestro1[i].setVisible(false);
          
           }
       
       creacionLabel(); 
    }

    public  void desventajaCuatro() {
        //DISMINUIR DEFENSA EN 200 PUNTOS
        if (sigueVivoAlumnoAplicado()) {
            alumnos[0].setDefensa(alumnos[0].getDefensa());
        }
        if (sigueVivoAlumnoRecursador()) {
            alumnos[1].setDefensa(alumnos[1].getDefensa());
        }
        if (sigueVivoAlumnoDeportista()) {
            alumnos[2].setDefensa(alumnos[2].getDefensa());
        }
        if (sigueVivoAlumnoApoyo()) {
            alumnos[3].setDefensa(alumnos[3].getDefensa());
        }
        for(int i=0; i<7; i++){
        
         Jugador1[i].setVisible(false);
          Jugador2[i].setVisible(false);
           Jugador3[i].setVisible(false);
            Jugador4[i].setVisible(false);
            Maestro1[i].setVisible(false);
          
           }
       
       creacionLabel(); 
    }

    public int getNumeroDeMaestro() {
        return numeroDeMaestro;
    }

    public void setMaestroActual(Maestro maestroActual) {
        this.maestroActual = maestroActual;
    }

    public JLabel[] getMaestro1() {
        return Maestro1;
    }

    public void setMaestro1(JLabel[] Maestro1) {
        this.Maestro1 = Maestro1;
    }

    public Alumno getObjAlumno() {
        return objAlumno;
    }

    public void setObjAlumno(Alumno objAlumno) {
        this.objAlumno = objAlumno;
    }

    public Maestro[] getMaestros() {
        return maestros;
    }

    public void setMaestros(Maestro[] maestros) {
        this.maestros = maestros;
    }

    public void setNumeroDeMaestro(int numeroDeMaestro) {
        this.numeroDeMaestro = numeroDeMaestro;
    }

    public void desventajaCinco() {
        //DISMINUIR DAÑO CRITICO EN 300 PUNTOS
        if (sigueVivoAlumnoAplicado()) {
            alumnos[0].setDañoCritico(alumnos[0].getDañoCritico() - 300);
        }
        if (sigueVivoAlumnoRecursador()) {
            alumnos[1].setDañoCritico(alumnos[1].getDañoCritico() - 300);
        }
        if (sigueVivoAlumnoDeportista()) {
            alumnos[2].setDañoCritico(alumnos[2].getDañoCritico() - 300);
        }
        if (sigueVivoAlumnoApoyo()) {
            alumnos[3].setDañoCritico(alumnos[3].getDañoCritico() - 300);
        }
    }

     public void CreacionBarras(){
       Jugador1B.setString("");
        Jugador1B.setBounds(144, 24, 164, 11);
        Jugador1B.setForeground(Color.red);
        Jugador1B.setBackground(Color.black);
        Jugador1B.setBorderPainted(false);
        add(Jugador1B,2,0);
        
   
       Jugador2B.setString("");
        Jugador2B.setBounds(144, 199, 164, 11);
        Jugador2B.setForeground(Color.red);
        Jugador2B.setBackground(Color.black);
        Jugador2B.setBorderPainted(false);
        add(Jugador2B,2,0);
        
       
        Jugador3B.setString("");
        Jugador3B.setBounds(144, 375, 164, 11);
        Jugador3B.setForeground(Color.red);
        Jugador3B.setBackground(Color.black);
        Jugador3B.setBorderPainted(false);
        add(Jugador3B,2,0);
        
       
        Jugador4B.setString("");
        Jugador4B.setBounds(144, 550, 164, 11);
        Jugador4B.setForeground(Color.red);
        Jugador4B.setBackground(Color.black);
        Jugador4B.setBorderPainted(false);
       add(Jugador4B,2,0);
        
        Maestro2B.setValue(57000);
        Maestro2B.setString("");
        Maestro2B.setBounds(762, 103, 164, 11);
        Maestro2B.setForeground(Color.red);
        Maestro2B.setBackground(Color.black);
        Maestro2B.setBorderPainted(false);
        add(Maestro2B,2,0);
       
       
   }

    public JTextArea getSucesos() {
        return Sucesos;
    }
    public void CajaSucesos(){
    Sucesos=new JTextArea();
    Sucesos.setLineWrap(true);
    JScrollPane sp=new  JScrollPane(Sucesos,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    sp.setBounds(640,403, 620, 100);
    this.add(sp,2,0);
    }

    public void setSucesos(JTextArea Sucesos) {
        this.Sucesos = Sucesos;
    }
    
    
    
    public Alumno[] getAlumnos() {
        return alumnos;
    }

    public Maestro getMaestroActual() {
        return maestroActual;
    }

    public double getDaño() {
        return daño;
    }

    public void setDaño(double daño) {
        this.daño = daño;
    }

    public JButton getAtaque() {
        return Ataque;
    }

    public JButton getEspecial() {
        return Especial;
    }

    public int getResultado() {
        return resultado;
    }

    public void setResultado(int resultado) {
        this.resultado = resultado;
    }

    public int getMaximo() {
        return maximo;
    }

    public void setMaximo(int maximo) {
        this.maximo = maximo;
    }

    public int getMinimo() {
        return minimo;
    }

    public void setMinimo(int minimo) {
        this.minimo = minimo;
    }

    public Random getRndm() {
        return rndm;
    }

    public void setRndm(Random rndm) {
        this.rndm = rndm;
    }

    public JLabel[] getJugador1() {
        return Jugador1;
    }

    public JLabel[] getJugador2() {
        return Jugador2;
    }

    public JLabel[] getJugador3() {
        return Jugador3;
    }

    public JLabel[] getJugador4() {
        return Jugador4;
    }

  
    public int getActualNumero() {
        return ActualNumero;
    }

    public void setActualNumero(int ActualNumero) {
        this.ActualNumero = ActualNumero;
    }

    public int getMaximoNumero() {
        return MaximoNumero;
    }

    public void setMaximoNumero(int MaximoNumero) {
        this.MaximoNumero = MaximoNumero;
    }

    public JProgressBar getJugador1B() {
        return Jugador1B;
    }

    public void setJugador1B(JProgressBar Jugador1B) {
        this.Jugador1B = Jugador1B;
    }

    public JProgressBar getJugador2B() {
        return Jugador2B;
    }

    public void setJugador2B(JProgressBar Jugador2B) {
        this.Jugador2B = Jugador2B;
    }

    public JProgressBar getJugador3B() {
        return Jugador3B;
    }

    public void setJugador3B(JProgressBar Jugador3B) {
        this.Jugador3B = Jugador3B;
    }

    public JProgressBar getJugador4B() {
        return Jugador4B;
    }

    public void setJugador4B(JProgressBar Jugador4B) {
        this.Jugador4B = Jugador4B;
    }

    public JProgressBar getMaestro2B() {
        return Maestro2B;
    }

    public void setMaestro2B(JProgressBar Maestro2B) {
        this.Maestro2B = Maestro2B;
    }

    public PanelTablero getTablero() {
        return Tablero;
    }

    public void setTablero(PanelTablero Tablero) {
        this.Tablero = Tablero;
    }
    
    public void Hola(Alumno alumnos[]){
    
      this.alumnos=alumnos;
       creacionLabel();
        
    }
public void barras(int uno,int dos, int tres, int cuatro){
   
this.Jugador1B.setValue(uno);
this.Jugador2B.setValue(dos);
this.Jugador3B.setValue(tres);
this.Jugador4B.setValue(cuatro);
CreacionBarras(); 

}

  
   
}
