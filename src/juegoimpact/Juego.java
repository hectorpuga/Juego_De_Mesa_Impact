package juegoimpact;

import Paneles.PanelDerrota;
import Paneles.PanelGanador;
import Paneles.PanelJuegoAcabado;
import PanelesInstrucciones.Instruccion1;
import Paneles.PanelTablero;
import PanelesInstrucciones.Instruccion2;
import PanelesInstrucciones.Instruccion3;
import PanelesInstrucciones.Instruccion4;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.Stack;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

public class Juego extends JFrame {

    JProgressBar Jugador1 = new JProgressBar(0, 28000);
    JProgressBar Jugador2 = new JProgressBar(0, 33500);
    JProgressBar Jugador3 = new JProgressBar(0, 25000);
    JProgressBar Jugador4 = new JProgressBar(0, 49000);
    JProgressBar Maestro1 = new JProgressBar(0, 57000);
    PanelGanador Victoria = new PanelGanador();
    PanelJuegoAcabado JuegoGanado = new PanelJuegoAcabado();
    int Eleccion, Eleccion2;

    int Arreglo[]={2,1,2,2,2,3,2,3,2,2,2,2,3};
    int y = 614, x = 596;
    Random Cambio = new Random();
    JLabel Pieza;
    Stack<JPanel> Instrucciones = new Stack();
    int anterior;
    int numeroAnterior;
    boolean verdad = true, verdad2 = false, verdad3 = false, verdad4 = false, verdad5 = false, verdad6 = false, verdad7 = false;

    public PanelTablero getTablero() {
        return Tablero;
    }

    PanelInicio Inicio = new PanelInicio();
    PanelTablero Tablero = new PanelTablero();
    PanelJefe1 Jefe1 = new PanelJefe1();
    PanelJefe2 Jefe2 = new PanelJefe2();
    PanelJefe3 Jefe3 = new PanelJefe3();
    PanelJefeFinal Jefe4 = new PanelJefeFinal();
    Instruccion1 Instrucciones1 = new Instruccion1();
    Instruccion2 Instrucciones2 = new Instruccion2();
    Instruccion3 Instrucciones3 = new Instruccion3();
    Instruccion4 Instrucciones4 = new Instruccion4();
  

    Main main = new Main();
    PanelDerrota Derrota = new PanelDerrota();

    public Juego() {

        setMinimumSize(new Dimension(1380, 744));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        InicializacionComponentes();

    }

    public void InicializacionComponentes() {

        PanelInicio();
        Cambio();
        CambioAnterior();
        DadoAleatorio();
        Ganar();
        CreacionBarras();

    }

    public void PanelInicio() {

        this.getContentPane().add(Inicio);
    }
    int i = 0;
    boolean h = true;
    JPanel ant = null;
    int ContadorDado;

    public void DadoAleatorio() {

        Pieza = new JLabel();
        Pieza.setBounds(596, 615, 85, 73);
        ImageIcon ImagenEquipo = new ImageIcon("Equipo.png");
        Pieza.setIcon(new ImageIcon(ImagenEquipo.getImage().getScaledInstance(Pieza.getWidth(), Pieza.getHeight(), Image.SCALE_SMOOTH)));

        Tablero.add(Pieza, 2, 0);

        ActionListener accion = (ActionEvent e) -> {

            int Dato = 0;

            int ValorFinal = 0;

            int NumeroAleatorio =Arreglo[i++];
            ContadorDado += NumeroAleatorio;
            ImageIcon Imagen = new ImageIcon(NumeroAleatorio + ".png");
            Tablero.getDado().setIcon(new ImageIcon(Imagen.getImage().getScaledInstance(Tablero.getDado().getWidth(), Tablero.getDado().getHeight(), Image.SCALE_SMOOTH)));

            if (verdad) {

                Dato = NumeroAleatorio * 75;
                for (int j = 1; j <= Dato; j++) {

                    if (y > 92) {
                        Pieza.setBounds(x, (y--) - (NumeroAleatorio), 85, 75);
                        if (j == Dato && h == true) {

                            Tablero.Roberto();
                            h = false;
                        }

                    } else {
                        JOptionPane.showMessageDialog(null, "Pelea Con La Jefa Rosita!!!");

                        Tablero.setVisible(false);
                        Jefe1.setVisible(true);

                        this.getContentPane().add(Jefe1);
                        ContadorDado = 7;

                        Mando();

                        verdad = false;
                        verdad2 = true;
                        break;
                    }
                }

            }
            if (verdad2) {

                if (verdad3) {
                    Dato = NumeroAleatorio * 82;
                    for (int j = 1; j <= Dato; j++) {

                        if (x > 23) {
                            Pieza.setBounds(x--, y, 85, 73);

                        } else {
                            JOptionPane.showMessageDialog(null, "Pelea Con La Jefa Veronica!!!");
                            Tablero.setVisible(false);
                            Jefe2.setVisible(true);
                            this.getContentPane().add(Jefe2);
                            ContadorDado = 14;
                            Mando2();

                            verdad2 = false;
                            verdad4 = true;

                            break;
                        }
                    }

                }

                verdad3 = true;

            }

            if (verdad4) {

                if (verdad5) {
                    Dato = NumeroAleatorio * 75;

                    for (int j = 1; j <= Dato; j++) {

                        if (y < 614) {
                            Pieza.setBounds(x, y++, 85, 75);
                        } else {
                            JOptionPane.showMessageDialog(null, "Pelea Con El Jefe Almazan!!!");

                            Tablero.setVisible(false);
                            Jefe3.setVisible(true);
                            this.getContentPane().add(Jefe3);
                            ContadorDado = 21;
                            Mando3();

                            verdad4 = false;
                            verdad6 = true;

                            break;
                        }

                    }
                }
                verdad5 = true;

            }

            if (verdad6) {

                if (verdad7) {
                    Dato = NumeroAleatorio * 82;
                    for (int j = 1; j <= Dato; j++) {

                        if (x < 596) {
                            Pieza.setBounds(x++, y, 85, 75);
                        } else {

                            JOptionPane.showMessageDialog(null, "Pelea Final Con El Jefe Roberto !!!");

                            Tablero.setVisible(false);
                            Jefe4.setVisible(true);
                            this.getContentPane().add(Jefe4);
                            ContadorDado = 28;
                            Mando4();
                            break;
                        }
                    }

                }
                verdad7 = true;

            }

            if (ContadorDado <= 2 || ContadorDado == 5 || ContadorDado == 8 || ContadorDado == 10 || ContadorDado == 12 || ContadorDado == 15 || ContadorDado == 19) {
                Eleccion = Integer.parseInt(JOptionPane.showInputDialog("Elige una Ventaja\n1.-AUMENTAR VIDA 5000 PUNTOS\n2.-AUMENTAR PROBABILIDAD DE CRITICO UN 25%\n3.-AUMENTAR PROBABILIDAD EVADIR ATAQUE UN 20%"
                        + "\n" + "4.-AUMENTAR DAÑO BASE EN 200 PUNTOS\n5.-AUMENTAR DEFENSA 400 PUNTOS"));

                Eleccion2 = Integer.parseInt(JOptionPane.showInputDialog("Elige Jugador\n1.-Puga\n2.-Budarth"
                        + "\n" + "3.-Valverde\n4.-Hector"));

                switch (Eleccion) {

                    case 1:
                        Tablero.ventajaUno(Eleccion2);
                        if (ContadorDado < 7) {

                            Jefe1.ventajaUno(Eleccion2);

                        }

                        if (ContadorDado < 14 && ContadorDado > 7) {
                            Jefe2.ventajaUno(Eleccion2);
                        }

                        if (ContadorDado < 21 && ContadorDado > 14) {

                            Jefe3.ventajaUno(Eleccion2);

                        }

                        break;
                    case 2:

                        Tablero.ventajaDos(Eleccion2);
                        if (ContadorDado < 7) {

                            Jefe1.ventajaDos(Eleccion2);

                        }
                        if (ContadorDado < 14 && ContadorDado > 7) {

                            Jefe2.ventajaDos(Eleccion2);
                        }

                        if (ContadorDado < 21 && ContadorDado > 14) {

                            Jefe3.ventajaDos(Eleccion2);

                        }

                        break;
                    case 3:

                        Tablero.ventajaTres(Eleccion2);
                        if (ContadorDado < 7) {

                            Jefe1.ventajaTres(Eleccion2);

                        }
                        if (ContadorDado < 14 && ContadorDado > 7) {
                            Jefe2.ventajaTres(Eleccion2);

                        }

                        if (ContadorDado < 21 && ContadorDado > 14) {

                            Jefe3.ventajaTres(Eleccion2);

                        }
                        break;
                    case 4:
                        Tablero.ventajaCuatro(Eleccion2);
                        if (ContadorDado < 7) {

                            Jefe1.ventajaCuatro(Eleccion2);

                        }
                        if (ContadorDado < 14 && ContadorDado > 7) {

                            Jefe2.ventajaCuatro(Eleccion2);
                        }

                        if (ContadorDado < 21 && ContadorDado > 14) {

                            Jefe3.ventajaCuatro(Eleccion2);

                        }
                        break;
                    case 5:
                        Tablero.ventajaCinco(Eleccion2);
                        if (ContadorDado < 7) {

                            Jefe1.ventajaCinco(Eleccion2);

                        }

                        if (ContadorDado < 14 && ContadorDado > 7) {
                            Jefe2.ventajaCinco(Eleccion2);
                        }

                        if (ContadorDado < 21 && ContadorDado > 14) {

                            Jefe3.ventajaCinco(Eleccion2);

                        }
                        break;

                }

            }

            if (ContadorDado == 3 || ContadorDado == 6 || ContadorDado == 9 || ContadorDado == 13 || ContadorDado == 12 || ContadorDado == 17 || ContadorDado == 18 || ContadorDado == 23 || ContadorDado == 22 || ContadorDado == 23 || ContadorDado == 25 || ContadorDado == 27) {

                JOptionPane.showMessageDialog(this, "Usted a recibido daño");

                if (ContadorDado < 7) {
                    Tablero.desventajaUno();
                    Jefe1.desventajaUno();

                }

                if (ContadorDado < 14 && ContadorDado > 7) {
                    Tablero.desventajaDos();
                    Jefe2.desventajaDos();
                }

                if (ContadorDado < 21 && ContadorDado > 14) {

                    Tablero.desventajaTres();
                    Jefe3.desventajaTres();

                }

                if (ContadorDado < 24 && ContadorDado > 21) {

                    Tablero.desventajaCuatro();
                    Jefe4.desventajaCuatro();

                }

            }

            if (ContadorDado == 4 || ContadorDado == 11 || ContadorDado == 16 || ContadorDado == 20 || ContadorDado == 24 || ContadorDado == 26) {
                JOptionPane.showMessageDialog(this, "MiniBatalla De Practica!!!");

            }

        };
        Tablero.getBotonDado().addActionListener(accion);

    }

    public void Cambio() {

        ActionListener CambioATablero = (ActionEvent ae) -> {

            Inicio.setVisible(false);
            Tablero.setVisible(true);
            this.getContentPane().add(Tablero);

        };
        Inicio.getBotonInicio().addActionListener(CambioATablero);

        ActionListener CambioAInstrucciones = (ActionEvent ae) -> {

            Inicio.setVisible(false);
            Instrucciones1.setVisible(true);
            this.getContentPane().add(Instrucciones1);
            Instrucciones.push(Inicio);

        };
        Inicio.getInstrucciones().addActionListener(CambioAInstrucciones);

        ActionListener CambioAInstrucciones2 = (ActionEvent ae) -> {

            Instrucciones1.setVisible(false);
            Instrucciones2.setVisible(true);
            this.getContentPane().add(Instrucciones2);
            Instrucciones.push(Instrucciones1);

        };

        Instrucciones1.getSiguiente().addActionListener(CambioAInstrucciones2);

        ActionListener CambioAInstrucciones3 = (ActionEvent ae) -> {

            Instrucciones2.setVisible(false);
            Instrucciones3.setVisible(true);
            this.getContentPane().add(Instrucciones3);
            Instrucciones.push(Instrucciones2);

        };

        Instrucciones2.getSiguiente().addActionListener(CambioAInstrucciones3);

        ActionListener CambioAInstrucciones4 = (ActionEvent ae) -> {

            Instrucciones3.setVisible(false);
            Instrucciones4.setVisible(true);
            this.getContentPane().add(Instrucciones4);
            Instrucciones.push(Instrucciones3);

        };

        Instrucciones3.getSiguiente().addActionListener(CambioAInstrucciones4);

        ActionListener CambioAInstrucciones5 = (ActionEvent ae) -> {

            Instrucciones4.setVisible(false);
            Instrucciones1.setVisible(true);
            this.getContentPane().add(Instrucciones1);
            for (int i = 0; i < 3; i++) {
                Instrucciones.pop();
            }

        };

        Instrucciones4.getSiguiente().addActionListener(CambioAInstrucciones5);
    }

    public void CambioAnterior() {

        ActionListener CambioAntesInicio = (ActionEvent ae) -> {
            ant = Instrucciones.pop();

            Instrucciones1.setVisible(false);
            ant.setVisible(true);
            this.getContentPane().add(ant);

        };

        Instrucciones1.getAnterior().addActionListener(CambioAntesInicio);

        ActionListener CambioAntesInstrucciones1 = (ActionEvent ae) -> {
            ant = Instrucciones.pop();
            Instrucciones2.setVisible(false);
            ant.setVisible(true);
            this.getContentPane().add(ant);

        };

        Instrucciones2.getAnterior().addActionListener(CambioAntesInstrucciones1);

        ActionListener CambioAntesInstrucciones2 = (ActionEvent ae) -> {
            ant = Instrucciones.pop();
            Instrucciones3.setVisible(false);
            ant.setVisible(true);
            this.getContentPane().add(ant);

        };

        Instrucciones3.getAnterior().addActionListener(CambioAntesInstrucciones2);

        ActionListener CambioAntesInstrucciones3 = (ActionEvent ae) -> {
            ant = Instrucciones.pop();
            Instrucciones4.setVisible(false);
            ant.setVisible(true);
            this.getContentPane().add(ant);

        };

        Instrucciones4.getAnterior().addActionListener(CambioAntesInstrucciones3);
    }

    int Turnito = 0;
    String Anterior;

    public void Ganar() {

        ActionListener Accion = (ActionEvent ae) -> {
            Victoria.setVisible(false);
            Tablero.setVisible(true);
            this.getContentPane().add(Tablero);
        };
        Victoria.getBoton().addActionListener(Accion);
        ActionListener Accion1 = (ActionEvent ae) -> {
           
           
         
            Derrota.setVisible(false);
            Reinicio();
            
    
            
        };
        Derrota.getBoton().addActionListener(Accion1);

        ActionListener ReinicioJuego = (ActionEvent ae) -> {
           
           
            JuegoGanado.setVisible(false);
            Reinicio();
            
    
        };
        JuegoGanado.getBoton().addActionListener(ReinicioJuego);
    }
    
    public void Mando() {

        ActionListener accion = (ActionEvent ae) -> {

            switch (Turnito) {
                case 0:
                    //EL ALUMNO EN TURNO ES DE TIPO APLICADO
                    if (Jefe1.sigueVivoAlumnoAplicado()) {
                        int anterioVida = (int) Jefe1.getMaestroActual().getVida();
                        Jefe1.setDaño(Jefe1.getAlumnos()[0].ataque());

                        Anterior = Jefe1.getSucesos().getText();
                        Jefe1.getMaestroActual().evadir(Jefe1.getDaño());
                        Jefe1.getSucesos().setText(Anterior + Jefe1.getAlumnos()[0].getInstruccion() + Jefe1.getMaestroActual().getInstruccion());

                        int counter = anterioVida;
                        if (anterioVida != (int) Jefe1.getMaestroActual().getVida()) {

                            while (counter >= (int) Jefe1.getMaestroActual().getVida()) {
                                counter--;

                                Jefe1.getMaestro1B().setValue(counter);

                            }

                        }
                    }
                    break;
                case 1:
                    //EL ALUMNO EN TURNO ES DE TIPO RECURSADOR
                    if (Jefe1.sigueVivoAlumnoRecursador()) {
                        int anterioVida = (int) Jefe1.getMaestroActual().getVida();
                        Jefe1.setDaño(Jefe1.getAlumnos()[1].ataque());
                        Jefe1.getMaestroActual().evadir(Jefe1.getDaño());

                        Anterior = Jefe1.getSucesos().getText();
                        Jefe1.getMaestroActual().evadir(Jefe1.getDaño());
                        Jefe1.getSucesos().setText(Anterior + Jefe1.getAlumnos()[1].getInstruccion() + Jefe1.getMaestroActual().getInstruccion());
                        int counter = anterioVida;
                        if (anterioVida != (int) Jefe1.getMaestroActual().getVida()) {

                            while (counter >= (int) Jefe1.getMaestroActual().getVida()) {
                                counter--;

                                Jefe1.getMaestro1B().setValue(counter);

                            }

                        }

                    }
                    break;
                case 2:
                    //EL ALUMNO EN TURNO ES DE TIPO DEPORTISTA
                    if (Jefe1.sigueVivoAlumnoDeportista()) {
                        int anterioVida = (int) Jefe1.getMaestroActual().getVida();
                        Jefe1.setDaño(Jefe1.getAlumnos()[2].ataque());
                        Jefe1.getMaestroActual().evadir(Jefe1.getDaño());
                        Anterior = Jefe1.getSucesos().getText();
                        Jefe1.getMaestroActual().evadir(Jefe1.getDaño());
                        Jefe1.getSucesos().setText(Anterior + Jefe1.getAlumnos()[2].getInstruccion() + Jefe1.getMaestroActual().getInstruccion());

                        int counter = anterioVida;
                        if (anterioVida != (int) Jefe1.getMaestroActual().getVida()) {

                            while (counter >= (int) Jefe1.getMaestroActual().getVida()) {
                                counter--;

                                Jefe1.getMaestro1B().setValue(counter);

                            }

                        }

                    }
                    break;
                case 3:
                    //EL ALUMNO EN TURNO ES DE TIPO APOYO
                    if (Jefe1.sigueVivoAlumnoApoyo()) {
                        int anterioVida = (int) Jefe1.getMaestroActual().getVida();
                        Jefe1.setDaño(Jefe1.getAlumnos()[3].ataque());
                        Jefe1.getMaestroActual().evadir(Jefe1.getDaño());
                        Anterior = Jefe1.getSucesos().getText();
                        Jefe1.getMaestroActual().evadir(Jefe1.getDaño());
                        Jefe1.getSucesos().setText(Anterior + Jefe1.getAlumnos()[3].getInstruccion() + Jefe1.getMaestroActual().getInstruccion());

                        int counter = anterioVida;
                        if (anterioVida != (int) Jefe1.getMaestroActual().getVida()) {

                            while (counter >= (int) Jefe1.getMaestroActual().getVida()) {
                                counter--;

                                Jefe1.getMaestro1B().setValue(counter);

                            }
                        }

                    }
                    break;
            }
            if (!Jefe1.sigueVivoElMaestroActual()) {
                Jefe1.setVisible(false);
                Victoria.setVisible(true);
                this.getContentPane().add(Victoria);

                Tablero.setAlumnos(Jefe1.getAlumnos());
                Jefe2.Hola(Jefe1.getAlumnos());
                Jefe2.barras(Jefe1.getJugador1B().getValue(), Jefe1.getJugador2B().getValue(), Jefe1.getJugador3B().getValue(), Jefe1.getJugador4B().getValue());
                ActualizacionEstadisticaDespuesDePelea();

            }

            Turnito++;
            if (Turnito == 4) {
                AtaquesMaestro();
                Anterior = Jefe1.getSucesos().getText();
                Jefe1.getSucesos().setText(Anterior + Jefe1.getMaestroActual().getInstruccion());

                Turnito = 0;
            }
            if (Jefe1.getNumeroDeMaestro() == 0) {
                ActualizandoEstadisticasMaestro();
            }

        };
        Jefe1.getAtaque().addActionListener(accion);

        ActionListener accion2 = (ActionEvent ae) -> {
            switch (Turnito) {
                case 0:
                    //EL ALUMNO EN TURNO ES DE TIPO APLICADO
                    if (Jefe1.sigueVivoAlumnoAplicado()) {

                        Anterior = Jefe1.getSucesos().getText();
                        Jefe1.getSucesos().setText(Anterior +"Puga realizo un ataque especial, "+Jefe1.getAlumnos()[0].getObjPoderEspecial().getDescripcion()+"\n");
                        Jefe1.getAlumnos()[0].poderEspecialDeAlumnoAplicado(Jefe1.getAlumnos()[1], Jefe1.getAlumnos()[2]);
                        ActualizandoEstadisticasEstudiantes();

                    }
                    break;
                case 1:
                    //EL ALUMNO EN TURNO ES DE TIPO RECURSADOR
                    if (Jefe1.sigueVivoAlumnoRecursador()) {

                          Anterior = Jefe1.getSucesos().getText();
                        Jefe1.getSucesos().setText(Anterior +"Burdath realizo un ataque especial, "+Jefe1.getAlumnos()[1].getObjPoderEspecial().getDescripcion()+"\n");
                        Jefe1.getAlumnos()[1].poderEspecialDeAlumnoRecursador();
                        ActualizandoEstadisticasEstudiantes();

                    }
                    break;
                case 2:
                    //EL ALUMNO EN TURNO ES DE TIPO DEPORTISTA
                    if (Jefe1.sigueVivoAlumnoDeportista()) {

                        
                         Anterior = Jefe1.getSucesos().getText();
                        Jefe1.getSucesos().setText(Anterior +"Valverde realizo un ataque especial, "+Jefe1.getAlumnos()[2].getObjPoderEspecial().getDescripcion()+"\n");
                        Jefe1.getAlumnos()[2].poderEspecialDeAlumnoDeportista();
                        ActualizandoEstadisticasEstudiantes();

                    }
                    break;
                case 3:
                    //EL ALUMNO EN TURNO ES DE TIPO APOYO getObjPoderEspecial
                    if (Jefe1.sigueVivoAlumnoApoyo()) {

                         Anterior = Jefe1.getSucesos().getText();
                        Jefe1.getSucesos().setText(Anterior +"Hector realizo un ataque especial, "+Jefe1.getAlumnos()[3].getObjPoderEspecial().getDescripcion()+"\n");
                        int anterioVida = (int) Jefe1.getAlumnos()[0].getVida();
                        int anterioVida1 = (int) Jefe1.getAlumnos()[1].getVida();
                        int anterioVida2 = (int) Jefe1.getAlumnos()[2].getVida();
                        int anterioVida3 = (int) Jefe1.getAlumnos()[3].getVida();

                        Jefe1.getAlumnos()[3].poderEspecialDeAlumnoApoyo(Jefe1.getAlumnos()[0], Jefe1.getAlumnos()[1], Jefe1.getAlumnos()[2]);
                        ActualizandoEstadisticasEstudiantes();
                        if (Jefe1.getJugador1B().getValue() != Jefe1.getJugador1B().getMaximum()) {

                            int counter = anterioVida;
                            while (counter <= (int) Jefe1.getAlumnos()[0].getVida()) {
                                counter++;
                                Jefe1.getJugador1B().setValue(counter);
                                Jugador1.setValue(counter);
                            }

                        }

                        if (Jefe1.getJugador2B().getValue() != Jefe1.getJugador2B().getMaximum()) {

                            int counter = anterioVida1;
                            while (counter <= (int) Jefe1.getAlumnos()[1].getVida()) {
                                counter++;
                                Jefe1.getJugador2B().setValue(counter);
                                Jugador2.setValue(counter);
                            }
                        }
                        if (Jefe1.getJugador3B().getValue() != Jefe1.getJugador3B().getMaximum()) {

                            int counter = anterioVida2;
                            while (counter <= (int) Jefe1.getAlumnos()[2].getVida()) {
                                counter++;
                                Jefe1.getJugador3B().setValue(counter);
                                Jugador3.setValue(counter);
                            }

                        }

                        if (Jefe1.getJugador4B().getValue() <= Jefe1.getJugador4B().getMaximum() || Jefe1.getJugador4B().getValue() > Jefe1.getJugador4B().getMaximum()) {

                            int counter = anterioVida3;
                            while (counter >= (int) Jefe1.getAlumnos()[3].getVida()) {
                                counter--;
                                Jefe1.getJugador4B().setValue(counter);
                                Jugador4.setValue(counter);
                            }

                        }

                    }

            }
            if (!Jefe1.sigueVivoElMaestroActual()) {
                Jefe1.setVisible(false);
                Victoria.setVisible(true);
                this.getContentPane().add(Victoria);

            }

            Turnito++;

            if (Jefe1.getNumeroDeMaestro() == 0) {
                ActualizandoEstadisticasMaestro();
            }
            if (Turnito == 4) {
                AtaquesMaestro();
                Turnito = 0;
            }

        };
        Jefe1.getEspecial().addActionListener(accion2);

    }

    public void AtaquesMaestro() {

        if (Jefe1.sigueVivoElMaestroActual()) {
            Jefe1.setResultado(Jefe1.getRndm().nextInt((Jefe1.getMaximo() - Jefe1.getMinimo()) + 1) + Jefe1.getMinimo());

            if (Jefe1.getResultado() == 1) {
                int anterioVida = (int) Jefe1.getAlumnos()[0].getVida();
                Jefe1.setDaño(Jefe1.getMaestroActual().ataque());

                if (Jefe1.getAlumnos()[0].evadir(Jefe1.getDaño())) {

                    ActualizandoEstadisticasEstudiantes();

                    int counter = anterioVida;
                    if (anterioVida != (int) Jefe1.getAlumnos()[0].getVida()) {

                        while (counter >= (int) Jefe1.getAlumnos()[0].getVida()) {
                            counter--;

                            Jefe1.getJugador1B().setValue(counter);
                            Jugador1.setValue(counter);

                        }
                    }
                }
                anterioVida = (int) Jefe1.getAlumnos()[1].getVida();
                if (Jefe1.getAlumnos()[1].evadir(Jefe1.getDaño())) {
                    ActualizandoEstadisticasEstudiantes();

                    int counter = anterioVida;
                    if (anterioVida != (int) Jefe1.getAlumnos()[1].getVida()) {

                        while (counter >= (int) Jefe1.getAlumnos()[1].getVida()) {
                            counter--;

                            Jefe1.getJugador2B().setValue(counter);
                            Jugador2.setValue(counter);

                        }
                    }
                }
                anterioVida = (int) Jefe1.getAlumnos()[2].getVida();
                if (Jefe1.getAlumnos()[2].evadir(Jefe1.getDaño())) {
                    ActualizandoEstadisticasEstudiantes();

                    int counter = anterioVida;
                    if (anterioVida != (int) Jefe1.getAlumnos()[2].getVida()) {

                        while (counter >= (int) Jefe1.getAlumnos()[2].getVida()) {
                            counter--;

                            Jefe1.getJugador3B().setValue(counter);
                            Jugador3.setValue(counter);

                        }

                    }
                }
                anterioVida = (int) Jefe1.getAlumnos()[3].getVida();
                if (Jefe1.getAlumnos()[3].evadir(Jefe1.getDaño())) {
                    ActualizandoEstadisticasEstudiantes();

                    int counter = anterioVida;
                    if (anterioVida != (int) Jefe1.getAlumnos()[3].getVida()) {

                        while (counter >= (int) Jefe1.getAlumnos()[3].getVida()) {
                            counter--;

                            Jefe1.getJugador4B().setValue(counter);
                            Jugador4.setValue(counter);

                        }
                    }
                }

            } else {

                 Anterior = Jefe1.getSucesos().getText();
                        Jefe1.getSucesos().setText(Anterior +"Rosita realizo un ataque especial, "+Jefe1.getMaestroActual().getObjPoderEspecial().getDescripcion()+"\n");
                Jefe1.getMaestroActual().poderEspecialDeMaestroFacil(Jefe1.getAlumnos()[0], Jefe1.getAlumnos()[1], Jefe1.getAlumnos()[2], Jefe1.getAlumnos()[3], 0);

                
                if (Jefe1.getNumeroDeMaestro() == 0) {
                    ActualizandoEstadisticasMaestro();
                }

            }
            if (!Jefe1.sigueVivoAlgunAlumno()) {
                Jefe1.setVisible(false);
                Derrota.setVisible(true);
                this.getContentPane().add(Derrota);
                ActualizacionEstadisticaDespuesDePelea();
            }
        } 
    }
    public void ActualizandoEstadisticasEstudiantes() {

        Jefe1.getJugador1()[0].setText(Integer.toString((int) Jefe1.getAlumnos()[0].getVida()));
        Jefe1.getJugador1()[1].setText(Integer.toString((int) Jefe1.getAlumnos()[0].getDefensa()));
        Jefe1.getJugador1()[2].setText(Integer.toString((int) Jefe1.getAlumnos()[0].getDañoBase()));
        Jefe1.getJugador1()[3].setText(Integer.toString((int) Jefe1.getAlumnos()[0].getDañoCritico()));
        Jefe1.getJugador1()[4].setText(Integer.toString((int) Jefe1.getAlumnos()[0].getProbabilidadCritico()));
        Jefe1.getJugador1()[5].setText(Integer.toString((int) Jefe1.getAlumnos()[0].getProbabilidadEvadirAtaque()));
        Jefe1.getJugador1()[6].setText(Integer.toString((int) Jefe1.getAlumnos()[0].getExperiencia()));
      
        if ((int) Jefe1.getAlumnos()[0].getVida() > Jefe1.getJugador1B().getMaximum()) {
            Jefe1.getJugador1B().setMaximum((int) Jefe1.getAlumnos()[0].getVida());
            Jugador1.setValue(Jugador1.getMaximum());

        }
        

        Jefe1.getJugador2()[0].setText(Integer.toString((int) Jefe1.getAlumnos()[1].getVida()));
        Jefe1.getJugador2()[1].setText(Integer.toString((int) Jefe1.getAlumnos()[1].getDefensa()));
        Jefe1.getJugador2()[2].setText(Integer.toString((int) Jefe1.getAlumnos()[1].getDañoBase()));
        Jefe1.getJugador2()[3].setText(Integer.toString((int) Jefe1.getAlumnos()[1].getDañoCritico()));
        Jefe1.getJugador2()[4].setText(Integer.toString((int) Jefe1.getAlumnos()[1].getProbabilidadCritico()));
        Jefe1.getJugador2()[5].setText(Integer.toString((int) Jefe1.getAlumnos()[1].getProbabilidadEvadirAtaque()));
        Jefe1.getJugador2()[6].setText(Integer.toString((int) Jefe1.getAlumnos()[1].getExperiencia()));
        if ((int) Jefe1.getAlumnos()[1].getVida() > Jefe1.getJugador2B().getMaximum()) {
            Jefe1.getJugador2B().setMaximum((int) Jefe1.getAlumnos()[1].getVida());
            Jugador2.setValue(Jugador2.getMaximum());

        }

        Jefe1.getJugador3()[0].setText(Integer.toString((int) Jefe1.getAlumnos()[2].getVida()));
        Jefe1.getJugador3()[1].setText(Integer.toString((int) Jefe1.getAlumnos()[2].getDefensa()));
        Jefe1.getJugador3()[2].setText(Integer.toString((int) Jefe1.getAlumnos()[2].getDañoBase()));
        Jefe1.getJugador3()[3].setText(Integer.toString((int) Jefe1.getAlumnos()[2].getDañoCritico()));
        Jefe1.getJugador3()[4].setText(Integer.toString((int) Jefe1.getAlumnos()[2].getProbabilidadCritico()));
        Jefe1.getJugador3()[5].setText(Integer.toString((int) Jefe1.getAlumnos()[2].getProbabilidadEvadirAtaque()));
        Jefe1.getJugador3()[6].setText(Integer.toString((int) Jefe1.getAlumnos()[2].getExperiencia()));

        if ((int) Jefe1.getAlumnos()[2].getVida() > Jefe1.getJugador3B().getMaximum()) {
            Jefe1.getJugador3B().setMaximum((int) Jefe1.getAlumnos()[2].getVida());
            Jugador3.setValue(Jugador3.getMaximum());

        }

        Jefe1.getJugador4()[0].setText(Integer.toString((int) Jefe1.getAlumnos()[3].getVida()));
        Jefe1.getJugador4()[1].setText(Integer.toString((int) Jefe1.getAlumnos()[3].getDefensa()));
        Jefe1.getJugador4()[2].setText(Integer.toString((int) Jefe1.getAlumnos()[3].getDañoBase()));
        Jefe1.getJugador4()[3].setText(Integer.toString((int) Jefe1.getAlumnos()[3].getDañoCritico()));
        Jefe1.getJugador4()[4].setText(Integer.toString((int) Jefe1.getAlumnos()[3].getProbabilidadCritico()));
        Jefe1.getJugador4()[5].setText(Integer.toString((int) Jefe1.getAlumnos()[3].getProbabilidadEvadirAtaque()));
        Jefe1.getJugador4()[6].setText(Integer.toString((int) Jefe1.getAlumnos()[3].getExperiencia()));

        if ((int) Jefe1.getAlumnos()[3].getVida() > Jefe1.getJugador4B().getMaximum()) {
            Jefe1.getJugador4B().setMaximum((int) Jefe1.getAlumnos()[3].getVida());
            Jugador4.setValue(Jugador4.getMaximum());

        }
    }

 public void CreacionBarras() {

        Jugador1.setValue(Jefe1.getJugador1B().getValue());
        Jugador1.setString("");
        Jugador1.setBounds(835, 106, 152, 10);
        Jugador1.setForeground(Color.red);
        Jugador1.setBackground(Color.black);
        Tablero.add(Jugador1, 2, 0);

        Jugador2.setValue(Jefe1.getJugador2B().getValue());
        Jugador2.setString("");
        Jugador2.setBounds(1137, 106, 152, 10);
        Jugador2.setForeground(Color.red);
        Jugador2.setBackground(Color.black);
        Tablero.add(Jugador2, 2, 0);

        Jugador3.setValue(Jefe1.getJugador3B().getValue());
        Jugador3.setString("");
        Jugador3.setBounds(835, 312, 152, 10);
        Jugador3.setForeground(Color.red);
        Jugador3.setBackground(Color.black);
        Tablero.add(Jugador3, 2, 0);

        Jugador4.setValue(Jefe1.getJugador4B().getValue());
        Jugador4.setString("");
        Jugador4.setBounds(1137, 312, 152, 10);
        Jugador4.setForeground(Color.red);
        Jugador4.setBackground(Color.black);
        Tablero.add(Jugador4, 2, 0);

    }

    public void ActualizacionEstadisticaDespuesDePelea() {
        Tablero.setAlumnos(Jefe1.getAlumnos());

        Tablero.getJugador1()[0].setText(Integer.toString((int) Tablero.getAlumnos()[0].getVida()));
        Tablero.getJugador1()[1].setText(Integer.toString((int) Tablero.getAlumnos()[0].getDefensa()));
        Tablero.getJugador1()[2].setText(Integer.toString((int) Tablero.getAlumnos()[0].getDañoBase()));
        Tablero.getJugador1()[3].setText(Integer.toString((int) Tablero.getAlumnos()[0].getDañoCritico()));
        Tablero.getJugador1()[4].setText(Integer.toString((int) Tablero.getAlumnos()[0].getProbabilidadCritico()));
        Tablero.getJugador1()[5].setText(Integer.toString((int) Tablero.getAlumnos()[0].getProbabilidadEvadirAtaque()));
        Tablero.getJugador1()[6].setText(Integer.toString((int) Tablero.getAlumnos()[0].getExperiencia()));

        Tablero.getJugador2()[0].setText(Integer.toString((int) Tablero.getAlumnos()[1].getVida()));
        Tablero.getJugador2()[1].setText(Integer.toString((int) Tablero.getAlumnos()[1].getDefensa()));
        Tablero.getJugador2()[2].setText(Integer.toString((int) Tablero.getAlumnos()[1].getDañoBase()));
        Tablero.getJugador2()[3].setText(Integer.toString((int) Tablero.getAlumnos()[1].getDañoCritico()));
        Tablero.getJugador2()[4].setText(Integer.toString((int) Tablero.getAlumnos()[1].getProbabilidadCritico()));
        Tablero.getJugador2()[5].setText(Integer.toString((int) Tablero.getAlumnos()[1].getProbabilidadEvadirAtaque()));
        Tablero.getJugador2()[6].setText(Integer.toString((int) Tablero.getAlumnos()[1].getExperiencia()));

        Tablero.getJugador3()[0].setText(Integer.toString((int) Tablero.getAlumnos()[2].getVida()));
        Tablero.getJugador3()[1].setText(Integer.toString((int) Tablero.getAlumnos()[2].getDefensa()));
        Tablero.getJugador3()[2].setText(Integer.toString((int) Tablero.getAlumnos()[2].getDañoBase()));
        Tablero.getJugador3()[3].setText(Integer.toString((int) Tablero.getAlumnos()[2].getDañoCritico()));
        Tablero.getJugador3()[4].setText(Integer.toString((int) Tablero.getAlumnos()[2].getProbabilidadCritico()));
        Tablero.getJugador3()[5].setText(Integer.toString((int) Tablero.getAlumnos()[2].getProbabilidadEvadirAtaque()));
        Tablero.getJugador3()[6].setText(Integer.toString((int) Tablero.getAlumnos()[2].getExperiencia()));

        Tablero.getJugador4()[0].setText(Integer.toString((int) Tablero.getAlumnos()[3].getVida()));
        Tablero.getJugador4()[1].setText(Integer.toString((int) Tablero.getAlumnos()[3].getDefensa()));
        Tablero.getJugador4()[2].setText(Integer.toString((int) Tablero.getAlumnos()[3].getDañoBase()));
        Tablero.getJugador4()[3].setText(Integer.toString((int) Tablero.getAlumnos()[3].getDañoCritico()));
        Tablero.getJugador4()[4].setText(Integer.toString((int) Tablero.getAlumnos()[3].getProbabilidadCritico()));
        Tablero.getJugador4()[5].setText(Integer.toString((int) Tablero.getAlumnos()[3].getProbabilidadEvadirAtaque()));
        Tablero.getJugador4()[6].setText(Integer.toString((int) Tablero.getAlumnos()[3].getExperiencia()));

    }
    
    
    
  
      public void ActualizandoEstadisticasMaestro() {

        Jefe1.getMaestro1()[0].setText(Integer.toString((int) Jefe1.getMaestroActual().getVida()));
        Jefe1.getMaestro1()[1].setText(Integer.toString((int) Jefe1.getMaestroActual().getDefensa()));
        Jefe1.getMaestro1()[2].setText(Integer.toString((int) Jefe1.getMaestroActual().getDañoBase()));
        Jefe1.getMaestro1()[3].setText(Integer.toString((int) Jefe1.getMaestroActual().getDañoCritico()));
        Jefe1.getMaestro1()[4].setText(Integer.toString((int) Jefe1.getMaestroActual().getProbabilidadCritico()));
        Jefe1.getMaestro1()[5].setText(Integer.toString((int) Jefe1.getMaestroActual().getProbabilidadEvadirAtaque()));
        Jefe1.getMaestro1()[6].setText(Integer.toString((int) Jefe1.getMaestroActual().getExperiencia()));
    }
      
      
      

    public void Mando2() {

        ActionListener accion = (ActionEvent ae) -> {

            switch (Turnito) {
                case 0:
                    //EL ALUMNO EN TURNO ES DE TIPO APLICADO
                    if (Jefe2.sigueVivoAlumnoAplicado()) {
                        int anterioVida = (int) Jefe2.getMaestroActual().getVida();
                        Jefe2.setDaño(Jefe2.getAlumnos()[0].ataque());

                        Anterior = Jefe2.getSucesos().getText();
                        Jefe2.getMaestroActual().evadir(Jefe2.getDaño());
                        Jefe2.getSucesos().setText(Anterior + Jefe2.getAlumnos()[0].getInstruccion() + Jefe2.getMaestroActual().getInstruccion());

                        int counter = anterioVida;
                        if (anterioVida != (int) Jefe2.getMaestroActual().getVida()) {

                            while (counter >= (int) Jefe2.getMaestroActual().getVida()) {
                                counter--;

                                Jefe2.getMaestro2B().setValue(counter);

                            }

                        }
                    }
                    break;
                case 1:
                    //EL ALUMNO EN TURNO ES DE TIPO RECURSADOR
                    if (Jefe2.sigueVivoAlumnoRecursador()) {
                        int anterioVida = (int) Jefe2.getMaestroActual().getVida();
                        Jefe2.setDaño(Jefe2.getAlumnos()[1].ataque());
                        Jefe2.getMaestroActual().evadir(Jefe2.getDaño());

                        Anterior = Jefe2.getSucesos().getText();
                        Jefe2.getMaestroActual().evadir(Jefe2.getDaño());
                        Jefe2.getSucesos().setText(Anterior + Jefe2.getAlumnos()[1].getInstruccion() + Jefe2.getMaestroActual().getInstruccion());
                        int counter = anterioVida;
                        if (anterioVida != (int) Jefe2.getMaestroActual().getVida()) {

                            while (counter >= (int) Jefe2.getMaestroActual().getVida()) {
                                counter--;

                                Jefe2.getMaestro2B().setValue(counter);

                            }

                        }

                    }
                    break;
                case 2:
                    //EL ALUMNO EN TURNO ES DE TIPO DEPORTISTA
                    if (Jefe1.sigueVivoAlumnoDeportista()) {
                        int anterioVida = (int) Jefe2.getMaestroActual().getVida();
                        Jefe2.setDaño(Jefe2.getAlumnos()[2].ataque());
                        Jefe2.getMaestroActual().evadir(Jefe2.getDaño());
                        Anterior = Jefe2.getSucesos().getText();
                        Jefe2.getMaestroActual().evadir(Jefe2.getDaño());
                        Jefe2.getSucesos().setText(Anterior + Jefe2.getAlumnos()[2].getInstruccion() + Jefe2.getMaestroActual().getInstruccion());

                        int counter = anterioVida;
                        if (anterioVida != (int) Jefe2.getMaestroActual().getVida()) {

                            while (counter >= (int) Jefe2.getMaestroActual().getVida()) {
                                counter--;

                                Jefe2.getMaestro2B().setValue(counter);

                            }

                        }

                    }
                    break;
                case 3:
                    //EL ALUMNO EN TURNO ES DE TIPO APOYO
                    if (Jefe2.sigueVivoAlumnoApoyo()) {
                        int anterioVida = (int) Jefe2.getMaestroActual().getVida();
                        Jefe2.setDaño(Jefe2.getAlumnos()[3].ataque());
                        Jefe2.getMaestroActual().evadir(Jefe2.getDaño());
                        Anterior = Jefe2.getSucesos().getText();
                        Jefe2.getMaestroActual().evadir(Jefe2.getDaño());
                        Jefe2.getSucesos().setText(Anterior + Jefe2.getAlumnos()[3].getInstruccion() + Jefe2.getMaestroActual().getInstruccion());

                        int counter = anterioVida;
                        if (anterioVida != (int) Jefe2.getMaestroActual().getVida()) {

                            while (counter >= (int) Jefe2.getMaestroActual().getVida()) {
                                counter--;

                                Jefe2.getMaestro2B().setValue(counter);

                            }
                        }

                    }
                    break;
            }
            if (!Jefe2.sigueVivoElMaestroActual()) {
                Jefe2.setVisible(false);
                Victoria.setVisible(true);
                this.getContentPane().add(Victoria);

                Tablero.setAlumnos(Jefe2.getAlumnos());
                Jefe3.Hola(Jefe2.getAlumnos());
                Jefe3.barras(Jefe2.getJugador1B().getValue(), Jefe2.getJugador2B().getValue(), Jefe2.getJugador3B().getValue(), Jefe2.getJugador4B().getValue());
                ActualizacionEstadisticaDespuesDePelea2();

            }

            Turnito++;
            if (Turnito == 4) {
                AtaquesMaestro2();
                Anterior = Jefe2.getSucesos().getText();
                Jefe2.getSucesos().setText(Anterior + Jefe2.getMaestroActual().getInstruccion());

                Turnito = 0;
            }
            if (Jefe2.getNumeroDeMaestro() == 1) {
                ActualizandoEstadisticasMaestro2();
            }

        };
        Jefe2.getAtaque().addActionListener(accion);

        ActionListener accion2 = (ActionEvent ae) -> {
            switch (Turnito) {
                case 0:
                    //EL ALUMNO EN TURNO ES DE TIPO APLICADO
                    if (Jefe2.sigueVivoAlumnoAplicado()) {

                   
                         Anterior = Jefe2.getSucesos().getText();
                        Jefe2.getSucesos().setText(Anterior +"Puga realizo un ataque especial, "+Jefe2.getAlumnos()[0].getObjPoderEspecial().getDescripcion()+"\n");
                     
                        Jefe2.getAlumnos()[0].poderEspecialDeAlumnoAplicado(Jefe2.getAlumnos()[1], Jefe2.getAlumnos()[2]);
                        ActualizandoEstadisticasEstudiantes2();

                    }
                    break;
                case 1:
                    //EL ALUMNO EN TURNO ES DE TIPO RECURSADOR
                    if (Jefe2.sigueVivoAlumnoRecursador()) {

                         Anterior = Jefe2.getSucesos().getText();
                        Jefe2.getSucesos().setText(Anterior +"Budarth realizo un ataque especial, "+Jefe2.getAlumnos()[1].getObjPoderEspecial().getDescripcion()+"\n");
                        
                        Jefe2.getAlumnos()[1].poderEspecialDeAlumnoRecursador();
                        ActualizandoEstadisticasEstudiantes2();

                    }
                    break;
                case 2:
                    //EL ALUMNO EN TURNO ES DE TIPO DEPORTISTA
                    if (Jefe2.sigueVivoAlumnoDeportista()) {

                        
                        Anterior = Jefe2.getSucesos().getText();
                        Jefe2.getSucesos().setText(Anterior +"Valverde realizo un ataque especial, "+Jefe2.getAlumnos()[2].getObjPoderEspecial().getDescripcion()+"\n");
                        
                        Jefe2.getAlumnos()[2].poderEspecialDeAlumnoDeportista();
                        ActualizandoEstadisticasEstudiantes2();

                    }
                    break;
                case 3:
                    //EL ALUMNO EN TURNO ES DE TIPO APOYO getObjPoderEspecial
                    if (Jefe1.sigueVivoAlumnoApoyo()) {

                         Anterior = Jefe2.getSucesos().getText();
                        Jefe2.getSucesos().setText(Anterior +"Hector realizo un ataque especial, "+Jefe2.getAlumnos()[3].getObjPoderEspecial().getDescripcion()+"\n");
                        
                        int anterioVida = (int) Jefe2.getAlumnos()[0].getVida();
                        int anterioVida1 = (int) Jefe2.getAlumnos()[1].getVida();
                        int anterioVida2 = (int) Jefe2.getAlumnos()[2].getVida();
                        int anterioVida3 = (int) Jefe2.getAlumnos()[3].getVida();

                        Jefe2.getAlumnos()[3].poderEspecialDeAlumnoApoyo(Jefe2.getAlumnos()[0], Jefe2.getAlumnos()[1], Jefe2.getAlumnos()[2]);
                        ActualizandoEstadisticasEstudiantes2();
                        if (Jefe2.getJugador1B().getValue() != Jefe2.getJugador1B().getMaximum()) {

                            int counter = anterioVida;
                            while (counter <= (int) Jefe2.getAlumnos()[0].getVida()) {
                                counter++;
                                Jefe2.getJugador1B().setValue(counter);
                                Jugador1.setValue(counter);
                            }

                        }

                        if (Jefe2.getJugador2B().getValue() != Jefe2.getJugador2B().getMaximum()) {

                            int counter = anterioVida1;
                            while (counter <= (int) Jefe2.getAlumnos()[1].getVida()) {
                                counter++;
                                Jefe2.getJugador2B().setValue(counter);
                                Jugador2.setValue(counter);
                            }
                        }
                        if (Jefe2.getJugador3B().getValue() != Jefe2.getJugador3B().getMaximum()) {

                            int counter = anterioVida2;
                            while (counter <= (int) Jefe2.getAlumnos()[2].getVida()) {
                                counter++;
                                Jefe2.getJugador3B().setValue(counter);
                                Jugador3.setValue(counter);
                            }

                        }

                        if (Jefe2.getJugador4B().getValue() <= Jefe2.getJugador4B().getMaximum() || Jefe2.getJugador4B().getValue() > Jefe2.getJugador4B().getMaximum()) {

                            int counter = anterioVida3;
                            while (counter >= (int) Jefe2.getAlumnos()[3].getVida()) {
                                counter--;
                                Jefe2.getJugador4B().setValue(counter);
                                Jugador4.setValue(counter);
                            }

                        }

                    }

            }
            if (!Jefe2.sigueVivoElMaestroActual()) {
                Jefe2.setVisible(false);
                Victoria.setVisible(true);
                this.getContentPane().add(Victoria);

            }

            Turnito++;

            if (Jefe2.getNumeroDeMaestro() == 1) {
                ActualizandoEstadisticasMaestro2();
            }
            if (Turnito == 4) {
                AtaquesMaestro2();
                Turnito = 0;
            }

        };
        Jefe2.getEspecial().addActionListener(accion2);

    }

    public void AtaquesMaestro2() {

        if (Jefe2.sigueVivoElMaestroActual()) {
            Jefe2.setResultado(Jefe2.getRndm().nextInt((Jefe2.getMaximo() - Jefe2.getMinimo()) + 1) + Jefe2.getMinimo());

            if (Jefe2.getResultado() == 1) {
                int anterioVida = (int) Jefe2.getAlumnos()[0].getVida();
                Jefe2.setDaño(Jefe2.getMaestroActual().ataque());

                if (Jefe2.getAlumnos()[0].evadir(Jefe2.getDaño())) {

                    ActualizandoEstadisticasEstudiantes2();

                    int counter = anterioVida;
                    if (anterioVida != (int) Jefe2.getAlumnos()[0].getVida()) {

                        while (counter >= (int) Jefe2.getAlumnos()[0].getVida()) {
                            counter--;

                            Jefe2.getJugador1B().setValue(counter);
                            Jugador1.setValue(counter);

                        }
                    }
                }
                anterioVida = (int) Jefe2.getAlumnos()[1].getVida();
                if (Jefe2.getAlumnos()[1].evadir(Jefe2.getDaño())) {
                    ActualizandoEstadisticasEstudiantes2();

                    int counter = anterioVida;
                    if (anterioVida != (int) Jefe2.getAlumnos()[1].getVida()) {

                        while (counter >= (int) Jefe2.getAlumnos()[1].getVida()) {
                            counter--;

                            Jefe2.getJugador2B().setValue(counter);
                            Jugador2.setValue(counter);

                        }
                    }
                }
                anterioVida = (int) Jefe2.getAlumnos()[2].getVida();
                if (Jefe2.getAlumnos()[2].evadir(Jefe2.getDaño())) {
                    ActualizandoEstadisticasEstudiantes2();

                    int counter = anterioVida;
                    if (anterioVida != (int) Jefe2.getAlumnos()[2].getVida()) {

                        while (counter >= (int) Jefe2.getAlumnos()[2].getVida()) {
                            counter--;

                            Jefe2.getJugador3B().setValue(counter);
                            Jugador3.setValue(counter);

                        }

                    }
                }
                anterioVida = (int) Jefe2.getAlumnos()[3].getVida();
                if (Jefe2.getAlumnos()[3].evadir(Jefe2.getDaño())) {
                    ActualizandoEstadisticasEstudiantes2();

                    int counter = anterioVida;
                    if (anterioVida != (int) Jefe2.getAlumnos()[3].getVida()) {

                        while (counter >= (int) Jefe2.getAlumnos()[3].getVida()) {
                            counter--;

                            Jefe2.getJugador4B().setValue(counter);
                            Jugador4.setValue(counter);

                        }
                    }
                }

            } else {

                 Anterior = Jefe2.getSucesos().getText();
                        Jefe2.getSucesos().setText(Anterior +"Veronica realizo un ataque especial, "+Jefe2.getMaestroActual().getObjPoderEspecial().getDescripcion()+"\n");
                Jefe2.getMaestroActual().poderEspecialDeMaestroMedio(Jefe1.getAlumnos()[0], Jefe2.getAlumnos()[1], Jefe2.getAlumnos()[2], Jefe2.getAlumnos()[3], 0);

                if (Jefe2.getNumeroDeMaestro() == 1) {
                    ActualizandoEstadisticasMaestro2();
                }

            }
            if (!Jefe2.sigueVivoAlgunAlumno()) {
                Jefe2.setVisible(false);
                Derrota.setVisible(true);
                this.getContentPane().add(Derrota);
                ActualizacionEstadisticaDespuesDePelea2();
            }
        }
    }

    
    public void ActualizandoEstadisticasEstudiantes2() {

        Jefe2.getJugador1()[0].setText(Integer.toString((int) Jefe2.getAlumnos()[0].getVida()));
        Jefe2.getJugador1()[1].setText(Integer.toString((int) Jefe2.getAlumnos()[0].getDefensa()));
        Jefe2.getJugador1()[2].setText(Integer.toString((int) Jefe2.getAlumnos()[0].getDañoBase()));
        Jefe2.getJugador1()[3].setText(Integer.toString((int) Jefe2.getAlumnos()[0].getDañoCritico()));
        Jefe2.getJugador1()[4].setText(Integer.toString((int) Jefe2.getAlumnos()[0].getProbabilidadCritico()));
        Jefe2.getJugador1()[5].setText(Integer.toString((int) Jefe2.getAlumnos()[0].getProbabilidadEvadirAtaque()));
        Jefe2.getJugador1()[6].setText(Integer.toString((int) Jefe2.getAlumnos()[0].getExperiencia()));
        if ((int) Jefe2.getAlumnos()[0].getVida() > Jefe2.getJugador1B().getMaximum()) {
            Jefe2.getJugador1B().setMaximum((int) Jefe2.getAlumnos()[0].getVida());
            Jugador1.setValue(Jugador1.getMaximum());

        }

        Jefe2.getJugador2()[0].setText(Integer.toString((int) Jefe2.getAlumnos()[1].getVida()));
        Jefe2.getJugador2()[1].setText(Integer.toString((int) Jefe2.getAlumnos()[1].getDefensa()));
        Jefe2.getJugador2()[2].setText(Integer.toString((int) Jefe2.getAlumnos()[1].getDañoBase()));
        Jefe2.getJugador2()[3].setText(Integer.toString((int) Jefe2.getAlumnos()[1].getDañoCritico()));
        Jefe2.getJugador2()[4].setText(Integer.toString((int) Jefe2.getAlumnos()[1].getProbabilidadCritico()));
        Jefe2.getJugador2()[5].setText(Integer.toString((int) Jefe2.getAlumnos()[1].getProbabilidadEvadirAtaque()));
        Jefe2.getJugador2()[6].setText(Integer.toString((int) Jefe2.getAlumnos()[1].getExperiencia()));
        if ((int) Jefe2.getAlumnos()[1].getVida() > Jefe2.getJugador2B().getMaximum()) {
            Jefe2.getJugador2B().setMaximum((int) Jefe2.getAlumnos()[1].getVida());
            Jugador2.setValue(Jugador2.getMaximum());

        }

        Jefe2.getJugador3()[0].setText(Integer.toString((int) Jefe2.getAlumnos()[2].getVida()));
        Jefe2.getJugador3()[1].setText(Integer.toString((int) Jefe2.getAlumnos()[2].getDefensa()));
        Jefe2.getJugador3()[2].setText(Integer.toString((int) Jefe2.getAlumnos()[2].getDañoBase()));
        Jefe2.getJugador3()[3].setText(Integer.toString((int) Jefe2.getAlumnos()[2].getDañoCritico()));
        Jefe2.getJugador3()[4].setText(Integer.toString((int) Jefe2.getAlumnos()[2].getProbabilidadCritico()));
        Jefe2.getJugador3()[5].setText(Integer.toString((int) Jefe2.getAlumnos()[2].getProbabilidadEvadirAtaque()));
        Jefe2.getJugador3()[6].setText(Integer.toString((int) Jefe2.getAlumnos()[2].getExperiencia()));

        if ((int) Jefe2.getAlumnos()[2].getVida() > Jefe2.getJugador3B().getMaximum()) {
            Jefe2.getJugador3B().setMaximum((int) Jefe2.getAlumnos()[2].getVida());
            Jugador3.setValue(Jugador3.getMaximum());

        }

        Jefe2.getJugador4()[0].setText(Integer.toString((int) Jefe2.getAlumnos()[3].getVida()));
        Jefe2.getJugador4()[1].setText(Integer.toString((int) Jefe2.getAlumnos()[3].getDefensa()));
        Jefe2.getJugador4()[2].setText(Integer.toString((int) Jefe2.getAlumnos()[3].getDañoBase()));
        Jefe2.getJugador4()[3].setText(Integer.toString((int) Jefe2.getAlumnos()[3].getDañoCritico()));
        Jefe2.getJugador4()[4].setText(Integer.toString((int) Jefe2.getAlumnos()[3].getProbabilidadCritico()));
        Jefe2.getJugador4()[5].setText(Integer.toString((int) Jefe2.getAlumnos()[3].getProbabilidadEvadirAtaque()));
        Jefe2.getJugador4()[6].setText(Integer.toString((int) Jefe2.getAlumnos()[3].getExperiencia()));

        if ((int) Jefe2.getAlumnos()[3].getVida() > Jefe2.getJugador4B().getMaximum()) {
            Jefe2.getJugador4B().setMaximum((int) Jefe2.getAlumnos()[3].getVida());
            Jugador4.setValue(Jugador4.getMaximum());

        }
    }

    public void ActualizacionEstadisticaDespuesDePelea2() {
        Tablero.setAlumnos(Jefe2.getAlumnos());

        Tablero.getJugador1()[0].setText(Integer.toString((int) Tablero.getAlumnos()[0].getVida()));
        Tablero.getJugador1()[1].setText(Integer.toString((int) Tablero.getAlumnos()[0].getDefensa()));
        Tablero.getJugador1()[2].setText(Integer.toString((int) Tablero.getAlumnos()[0].getDañoBase()));
        Tablero.getJugador1()[3].setText(Integer.toString((int) Tablero.getAlumnos()[0].getDañoCritico()));
        Tablero.getJugador1()[4].setText(Integer.toString((int) Tablero.getAlumnos()[0].getProbabilidadCritico()));
        Tablero.getJugador1()[5].setText(Integer.toString((int) Tablero.getAlumnos()[0].getProbabilidadEvadirAtaque()));
        Tablero.getJugador1()[6].setText(Integer.toString((int) Tablero.getAlumnos()[0].getExperiencia()));

        Tablero.getJugador2()[0].setText(Integer.toString((int) Tablero.getAlumnos()[1].getVida()));
        Tablero.getJugador2()[1].setText(Integer.toString((int) Tablero.getAlumnos()[1].getDefensa()));
        Tablero.getJugador2()[2].setText(Integer.toString((int) Tablero.getAlumnos()[1].getDañoBase()));
        Tablero.getJugador2()[3].setText(Integer.toString((int) Tablero.getAlumnos()[1].getDañoCritico()));
        Tablero.getJugador2()[4].setText(Integer.toString((int) Tablero.getAlumnos()[1].getProbabilidadCritico()));
        Tablero.getJugador2()[5].setText(Integer.toString((int) Tablero.getAlumnos()[1].getProbabilidadEvadirAtaque()));
        Tablero.getJugador2()[6].setText(Integer.toString((int) Tablero.getAlumnos()[1].getExperiencia()));

        Tablero.getJugador3()[0].setText(Integer.toString((int) Tablero.getAlumnos()[2].getVida()));
        Tablero.getJugador3()[1].setText(Integer.toString((int) Tablero.getAlumnos()[2].getDefensa()));
        Tablero.getJugador3()[2].setText(Integer.toString((int) Tablero.getAlumnos()[2].getDañoBase()));
        Tablero.getJugador3()[3].setText(Integer.toString((int) Tablero.getAlumnos()[2].getDañoCritico()));
        Tablero.getJugador3()[4].setText(Integer.toString((int) Tablero.getAlumnos()[2].getProbabilidadCritico()));
        Tablero.getJugador3()[5].setText(Integer.toString((int) Tablero.getAlumnos()[2].getProbabilidadEvadirAtaque()));
        Tablero.getJugador3()[6].setText(Integer.toString((int) Tablero.getAlumnos()[2].getExperiencia()));

        Tablero.getJugador4()[0].setText(Integer.toString((int) Tablero.getAlumnos()[3].getVida()));
        Tablero.getJugador4()[1].setText(Integer.toString((int) Tablero.getAlumnos()[3].getDefensa()));
        Tablero.getJugador4()[2].setText(Integer.toString((int) Tablero.getAlumnos()[3].getDañoBase()));
        Tablero.getJugador4()[3].setText(Integer.toString((int) Tablero.getAlumnos()[3].getDañoCritico()));
        Tablero.getJugador4()[4].setText(Integer.toString((int) Tablero.getAlumnos()[3].getProbabilidadCritico()));
        Tablero.getJugador4()[5].setText(Integer.toString((int) Tablero.getAlumnos()[3].getProbabilidadEvadirAtaque()));
        Tablero.getJugador4()[6].setText(Integer.toString((int) Tablero.getAlumnos()[3].getExperiencia()));

    }


    public void ActualizandoEstadisticasMaestro2() {

        Jefe2.getMaestro1()[0].setText(Integer.toString((int) Jefe2.getMaestroActual().getVida()));
        Jefe2.getMaestro1()[1].setText(Integer.toString((int) Jefe2.getMaestroActual().getDefensa()));
        Jefe2.getMaestro1()[2].setText(Integer.toString((int) Jefe2.getMaestroActual().getDañoBase()));
        Jefe2.getMaestro1()[3].setText(Integer.toString((int) Jefe2.getMaestroActual().getDañoCritico()));
        Jefe2.getMaestro1()[4].setText(Integer.toString((int) Jefe2.getMaestroActual().getProbabilidadCritico()));
        Jefe2.getMaestro1()[5].setText(Integer.toString((int) Jefe2.getMaestroActual().getProbabilidadEvadirAtaque()));
        Jefe2.getMaestro1()[6].setText(Integer.toString((int) Jefe2.getMaestroActual().getExperiencia()));
    }


    public void CreacionBarras2() {

        Jugador1.setValue(Jefe2.getJugador1B().getValue());

        Jugador2.setValue(Jefe2.getJugador2B().getValue());

        Jugador3.setValue(Jefe2.getJugador3B().getValue());

        Jugador4.setValue(Jefe2.getJugador4B().getValue());

    }

 
    
    
    
    
    
    
    
    
    
    public void Mando3() {

        ActionListener accion = (ActionEvent ae) -> {

            switch (Turnito) {
                case 0:
                    //EL ALUMNO EN TURNO ES DE TIPO APLICADO
                    if (Jefe3.sigueVivoAlumnoAplicado()) {
                        int anterioVida = (int) Jefe3.getMaestroActual().getVida();
                        Jefe3.setDaño(Jefe3.getAlumnos()[0].ataque());

                        Anterior = Jefe3.getSucesos().getText();
                        Jefe3.getMaestroActual().evadir(Jefe3.getDaño());
                        Jefe3.getSucesos().setText(Anterior + Jefe3.getAlumnos()[0].getInstruccion() + Jefe3.getMaestroActual().getInstruccion());

                        int counter = anterioVida;
                        if (anterioVida != (int) Jefe3.getMaestroActual().getVida()) {

                            while (counter >= (int) Jefe3.getMaestroActual().getVida()) {
                                counter--;

                                Jefe3.getMaestro3B().setValue(counter);

                            }

                        }
                    }
                    break;
                case 1:
                    //EL ALUMNO EN TURNO ES DE TIPO RECURSADOR
                    if (Jefe3.sigueVivoAlumnoRecursador()) {
                        int anterioVida = (int) Jefe3.getMaestroActual().getVida();
                        Jefe3.setDaño(Jefe3.getAlumnos()[1].ataque());
                        Jefe3.getMaestroActual().evadir(Jefe3.getDaño());

                        Anterior = Jefe3.getSucesos().getText();
                        Jefe3.getMaestroActual().evadir(Jefe3.getDaño());
                        Jefe3.getSucesos().setText(Anterior + Jefe3.getAlumnos()[1].getInstruccion() + Jefe3.getMaestroActual().getInstruccion());
                        int counter = anterioVida;
                        if (anterioVida != (int) Jefe3.getMaestroActual().getVida()) {

                            while (counter >= (int) Jefe3.getMaestroActual().getVida()) {
                                counter--;

                                Jefe3.getMaestro3B().setValue(counter);

                            }

                        }

                    }
                    break;
                case 2:
                    //EL ALUMNO EN TURNO ES DE TIPO DEPORTISTA
                    if (Jefe3.sigueVivoAlumnoDeportista()) {
                        int anterioVida = (int) Jefe3.getMaestroActual().getVida();
                        Jefe3.setDaño(Jefe3.getAlumnos()[2].ataque());
                        Jefe3.getMaestroActual().evadir(Jefe3.getDaño());
                        Anterior = Jefe3.getSucesos().getText();
                        Jefe3.getMaestroActual().evadir(Jefe3.getDaño());
                        Jefe3.getSucesos().setText(Anterior + Jefe3.getAlumnos()[2].getInstruccion() + Jefe3.getMaestroActual().getInstruccion());

                        int counter = anterioVida;
                        if (anterioVida != (int) Jefe3.getMaestroActual().getVida()) {

                            while (counter >= (int) Jefe3.getMaestroActual().getVida()) {
                                counter--;

                                Jefe3.getMaestro3B().setValue(counter);

                            }

                        }

                    }
                    break;
                case 3:
                    //EL ALUMNO EN TURNO ES DE TIPO APOYO
                    if (Jefe3.sigueVivoAlumnoApoyo()) {
                        int anterioVida = (int) Jefe3.getMaestroActual().getVida();
                        Jefe3.setDaño(Jefe3.getAlumnos()[3].ataque());
                        Jefe3.getMaestroActual().evadir(Jefe3.getDaño());
                        Anterior = Jefe3.getSucesos().getText();
                        Jefe3.getMaestroActual().evadir(Jefe3.getDaño());
                        Jefe3.getSucesos().setText(Anterior + Jefe3.getAlumnos()[3].getInstruccion() + Jefe3.getMaestroActual().getInstruccion());

                        int counter = anterioVida;
                        if (anterioVida != (int) Jefe3.getMaestroActual().getVida()) {

                            while (counter >= (int) Jefe3.getMaestroActual().getVida()) {
                                counter--;

                                Jefe3.getMaestro3B().setValue(counter);

                            }
                        }

                    }
                    break;
            }
            if (!Jefe3.sigueVivoElMaestroActual()) {
                Jefe3.setVisible(false);
                Victoria.setVisible(true);
                this.getContentPane().add(Victoria);

                Tablero.setAlumnos(Jefe3.getAlumnos());
                Jefe4.Hola(Jefe3.getAlumnos());
                Jefe4.barras(Jefe3.getJugador1B().getValue(), Jefe3.getJugador2B().getValue(), Jefe3.getJugador3B().getValue(), Jefe3.getJugador4B().getValue());
                ActualizacionEstadisticaDespuesDePelea3();

            }

            Turnito++;
            if (Turnito == 4) {
                AtaquesMaestro3();
                Anterior = Jefe3.getSucesos().getText();
                Jefe3.getSucesos().setText(Anterior + Jefe3.getMaestroActual().getInstruccion());

                Turnito = 0;
            }
            if (Jefe3.getNumeroDeMaestro() == 2) {
                ActualizandoEstadisticasMaestro3();
            }

        };
        Jefe3.getAtaque().addActionListener(accion);

        ActionListener accion2 = (ActionEvent ae) -> {
            switch (Turnito) {
                case 0:
                    //EL ALUMNO EN TURNO ES DE TIPO APLICADO
                    if (Jefe3.sigueVivoAlumnoAplicado()) {

                         Anterior = Jefe3.getSucesos().getText();
                        Jefe3.getSucesos().setText(Anterior +"Puga realizo un ataque especial, "+Jefe3.getAlumnos()[0].getObjPoderEspecial().getDescripcion()+"\n");
                        Jefe3.getAlumnos()[0].poderEspecialDeAlumnoAplicado(Jefe3.getAlumnos()[1], Jefe3.getAlumnos()[2]);
                        ActualizandoEstadisticasEstudiantes3();

                    }
                    break;
                case 1:
                    //EL ALUMNO EN TURNO ES DE TIPO RECURSADOR
                    if (Jefe3.sigueVivoAlumnoRecursador()) {

                         Anterior = Jefe3.getSucesos().getText();
                        Jefe3.getSucesos().setText(Anterior +"Budarth realizo un ataque especial, "+Jefe3.getAlumnos()[1].getObjPoderEspecial().getDescripcion()+"\n");
                        Jefe3.getAlumnos()[1].poderEspecialDeAlumnoRecursador();
                        ActualizandoEstadisticasEstudiantes3();

                    }
                    break;
                case 2:
                    //EL ALUMNO EN TURNO ES DE TIPO DEPORTISTA
                    if (Jefe3.sigueVivoAlumnoDeportista()) {

                         Anterior = Jefe3.getSucesos().getText();
                        Jefe3.getSucesos().setText(Anterior +"Valverde realizo un ataque especial, "+Jefe3.getAlumnos()[2].getObjPoderEspecial().getDescripcion()+"\n");
                        Jefe3.getAlumnos()[2].poderEspecialDeAlumnoDeportista();
                        ActualizandoEstadisticasEstudiantes3();

                    }
                    break;
                case 3:
                    //EL ALUMNO EN TURNO ES DE TIPO APOYO getObjPoderEspecial
                    if (Jefe3.sigueVivoAlumnoApoyo()) {

                         Anterior = Jefe3.getSucesos().getText();
                        Jefe3.getSucesos().setText(Anterior +"Hector realizo un ataque especial, "+Jefe1.getAlumnos()[3].getObjPoderEspecial().getDescripcion()+"\n");
                       
                        int anterioVida = (int) Jefe3.getAlumnos()[0].getVida();
                        int anterioVida1 = (int) Jefe3.getAlumnos()[1].getVida();
                        int anterioVida2 = (int) Jefe3.getAlumnos()[2].getVida();
                        int anterioVida3 = (int) Jefe3.getAlumnos()[3].getVida();

                        Jefe3.getAlumnos()[3].poderEspecialDeAlumnoApoyo(Jefe3.getAlumnos()[0], Jefe3.getAlumnos()[1], Jefe3.getAlumnos()[2]);
                        ActualizandoEstadisticasEstudiantes3();
                        if (Jefe3.getJugador1B().getValue() != Jefe3.getJugador1B().getMaximum()) {

                            int counter = anterioVida;
                            while (counter <= (int) Jefe3.getAlumnos()[0].getVida()) {
                                counter++;
                                Jefe3.getJugador1B().setValue(counter);
                                Jugador3.setValue(counter);
                            }

                        }

                        if (Jefe3.getJugador2B().getValue() != Jefe3.getJugador2B().getMaximum()) {

                            int counter = anterioVida1;
                            while (counter <= (int) Jefe3.getAlumnos()[1].getVida()) {
                                counter++;
                                Jefe3.getJugador2B().setValue(counter);
                                Jugador2.setValue(counter);
                            }
                        }
                        if (Jefe3.getJugador3B().getValue() != Jefe3.getJugador3B().getMaximum()) {

                            int counter = anterioVida2;
                            while (counter <= (int) Jefe3.getAlumnos()[2].getVida()) {
                                counter++;
                                Jefe3.getJugador3B().setValue(counter);
                                Jugador3.setValue(counter);
                            }

                        }

                        if (Jefe3.getJugador4B().getValue() <= Jefe3.getJugador4B().getMaximum() || Jefe3.getJugador4B().getValue() > Jefe3.getJugador4B().getMaximum()) {

                            int counter = anterioVida3;
                            while (counter >= (int) Jefe3.getAlumnos()[3].getVida()) {
                                counter--;
                                Jefe3.getJugador4B().setValue(counter);
                                Jugador4.setValue(counter);
                            }

                        }

                    }

            }
            if (!Jefe3.sigueVivoElMaestroActual()) {
                Jefe3.setVisible(false);
                Victoria.setVisible(true);
                this.getContentPane().add(Victoria);

            }

            Turnito++;

            if (Jefe3.getNumeroDeMaestro() == 2) {
                ActualizandoEstadisticasMaestro3();
            }
            if (Turnito == 4) {
                AtaquesMaestro3();
                Turnito = 0;
            }

        };
        Jefe3.getEspecial().addActionListener(accion2);

    }

    public void AtaquesMaestro3() {

        if (Jefe3.sigueVivoElMaestroActual()) {
            Jefe3.setResultado(Jefe3.getRndm().nextInt((Jefe3.getMaximo() - Jefe3.getMinimo()) + 1) + Jefe3.getMinimo());

            if (Jefe3.getResultado() == 1) {
                int anterioVida = (int) Jefe3.getAlumnos()[0].getVida();
                Jefe3.setDaño(Jefe3.getMaestroActual().ataque());

                if (Jefe3.getAlumnos()[0].evadir(Jefe3.getDaño())) {

                    ActualizandoEstadisticasEstudiantes3();

                    int counter = anterioVida;
                    if (anterioVida != (int) Jefe3.getAlumnos()[0].getVida()) {

                        while (counter >= (int) Jefe3.getAlumnos()[0].getVida()) {
                            counter--;

                            Jefe3.getJugador1B().setValue(counter);
                            Jugador1.setValue(counter);

                        }
                    }
                }
                anterioVida = (int) Jefe3.getAlumnos()[1].getVida();
                if (Jefe3.getAlumnos()[1].evadir(Jefe3.getDaño())) {
                    ActualizandoEstadisticasEstudiantes3();

                    int counter = anterioVida;
                    if (anterioVida != (int) Jefe3.getAlumnos()[1].getVida()) {

                        while (counter >= (int) Jefe3.getAlumnos()[1].getVida()) {
                            counter--;

                            Jefe3.getJugador2B().setValue(counter);
                            Jugador2.setValue(counter);

                        }
                    }
                }
                anterioVida = (int) Jefe3.getAlumnos()[2].getVida();
                if (Jefe3.getAlumnos()[2].evadir(Jefe3.getDaño())) {
                    ActualizandoEstadisticasEstudiantes3();

                    int counter = anterioVida;
                    if (anterioVida != (int) Jefe3.getAlumnos()[2].getVida()) {

                        while (counter >= (int) Jefe3.getAlumnos()[2].getVida()) {
                            counter--;

                            Jefe3.getJugador3B().setValue(counter);
                            Jugador3.setValue(counter);

                        }

                    }
                }
                anterioVida = (int) Jefe3.getAlumnos()[3].getVida();
                if (Jefe3.getAlumnos()[3].evadir(Jefe3.getDaño())) {
                    ActualizandoEstadisticasEstudiantes3();

                    int counter = anterioVida;
                    if (anterioVida != (int) Jefe3.getAlumnos()[3].getVida()) {

                        while (counter >= (int) Jefe3.getAlumnos()[3].getVida()) {
                            counter--;

                            Jefe3.getJugador4B().setValue(counter);
                            Jugador4.setValue(counter);

                        }
                    }
                }

            } else {

                 Anterior = Jefe3.getSucesos().getText();
                        Jefe3.getSucesos().setText(Anterior +"Almazan realizo un ataque especial, "+Jefe3.getMaestroActual().getObjPoderEspecial().getDescripcion()+"\n");
                Jefe3.getMaestroActual().poderEspecialDeMaestroDificil(Jefe3.getAlumnos()[0], Jefe3.getAlumnos()[1], Jefe3.getAlumnos()[2], Jefe3.getAlumnos()[3], 0);

                if (Jefe3.getNumeroDeMaestro() == 2) {
                    ActualizandoEstadisticasMaestro3();
                }

            }
            if (!Jefe3.sigueVivoAlgunAlumno()) {
                Jefe3.setVisible(false);
                Derrota.setVisible(true);
                this.getContentPane().add(Derrota);
                ActualizacionEstadisticaDespuesDePelea3();
            }
        } 
        
    }

    
    public void ActualizandoEstadisticasEstudiantes3() {

        Jefe3.getJugador1()[0].setText(Integer.toString((int) Jefe3.getAlumnos()[0].getVida()));
        Jefe3.getJugador1()[1].setText(Integer.toString((int) Jefe3.getAlumnos()[0].getDefensa()));
        Jefe3.getJugador1()[2].setText(Integer.toString((int) Jefe3.getAlumnos()[0].getDañoBase()));
        Jefe3.getJugador1()[3].setText(Integer.toString((int) Jefe3.getAlumnos()[0].getDañoCritico()));
        Jefe3.getJugador1()[4].setText(Integer.toString((int) Jefe3.getAlumnos()[0].getProbabilidadCritico()));
        Jefe3.getJugador1()[5].setText(Integer.toString((int) Jefe3.getAlumnos()[0].getProbabilidadEvadirAtaque()));
        Jefe3.getJugador1()[6].setText(Integer.toString((int) Jefe3.getAlumnos()[0].getExperiencia()));
        if ((int) Jefe3.getAlumnos()[0].getVida() > Jefe3.getJugador1B().getMaximum()) {
            Jefe3.getJugador1B().setMaximum((int) Jefe3.getAlumnos()[0].getVida());
            Jugador1.setValue(Jugador1.getMaximum());

        }

        Jefe3.getJugador2()[0].setText(Integer.toString((int) Jefe3.getAlumnos()[1].getVida()));
        Jefe3.getJugador2()[1].setText(Integer.toString((int) Jefe3.getAlumnos()[1].getDefensa()));
        Jefe3.getJugador2()[2].setText(Integer.toString((int) Jefe3.getAlumnos()[1].getDañoBase()));
        Jefe3.getJugador2()[3].setText(Integer.toString((int) Jefe3.getAlumnos()[1].getDañoCritico()));
        Jefe3.getJugador2()[4].setText(Integer.toString((int) Jefe3.getAlumnos()[1].getProbabilidadCritico()));
        Jefe3.getJugador2()[5].setText(Integer.toString((int) Jefe3.getAlumnos()[1].getProbabilidadEvadirAtaque()));
        Jefe3.getJugador2()[6].setText(Integer.toString((int) Jefe3.getAlumnos()[1].getExperiencia()));
        if ((int) Jefe3.getAlumnos()[1].getVida() > Jefe3.getJugador2B().getMaximum()) {
            Jefe3.getJugador2B().setMaximum((int) Jefe3.getAlumnos()[1].getVida());
            Jugador2.setValue(Jugador2.getMaximum());

        }

        Jefe3.getJugador3()[0].setText(Integer.toString((int) Jefe3.getAlumnos()[2].getVida()));
        Jefe3.getJugador3()[1].setText(Integer.toString((int) Jefe3.getAlumnos()[2].getDefensa()));
        Jefe3.getJugador3()[2].setText(Integer.toString((int) Jefe3.getAlumnos()[2].getDañoBase()));
        Jefe3.getJugador3()[3].setText(Integer.toString((int) Jefe3.getAlumnos()[2].getDañoCritico()));
        Jefe3.getJugador3()[4].setText(Integer.toString((int) Jefe3.getAlumnos()[2].getProbabilidadCritico()));
        Jefe3.getJugador3()[5].setText(Integer.toString((int) Jefe3.getAlumnos()[2].getProbabilidadEvadirAtaque()));
        Jefe3.getJugador3()[6].setText(Integer.toString((int) Jefe3.getAlumnos()[2].getExperiencia()));

        if ((int) Jefe3.getAlumnos()[2].getVida() > Jefe3.getJugador3B().getMaximum()) {
            Jefe3.getJugador3B().setMaximum((int) Jefe3.getAlumnos()[2].getVida());
            Jugador3.setValue(Jugador3.getMaximum());

        }

        Jefe3.getJugador4()[0].setText(Integer.toString((int) Jefe3.getAlumnos()[3].getVida()));
        Jefe3.getJugador4()[1].setText(Integer.toString((int) Jefe3.getAlumnos()[3].getDefensa()));
        Jefe3.getJugador4()[2].setText(Integer.toString((int) Jefe3.getAlumnos()[3].getDañoBase()));
        Jefe3.getJugador4()[3].setText(Integer.toString((int) Jefe3.getAlumnos()[3].getDañoCritico()));
        Jefe3.getJugador4()[4].setText(Integer.toString((int) Jefe3.getAlumnos()[3].getProbabilidadCritico()));
        Jefe3.getJugador4()[5].setText(Integer.toString((int) Jefe3.getAlumnos()[3].getProbabilidadEvadirAtaque()));
        Jefe3.getJugador4()[6].setText(Integer.toString((int) Jefe3.getAlumnos()[3].getExperiencia()));

        if ((int) Jefe3.getAlumnos()[3].getVida() > Jefe3.getJugador4B().getMaximum()) {
            Jefe3.getJugador4B().setMaximum((int) Jefe3.getAlumnos()[3].getVida());
            Jugador4.setValue(Jugador4.getMaximum());

        }
    }

    public void ActualizacionEstadisticaDespuesDePelea3() {
        Tablero.setAlumnos(Jefe3.getAlumnos());

        Tablero.getJugador1()[0].setText(Integer.toString((int) Tablero.getAlumnos()[0].getVida()));
        Tablero.getJugador1()[1].setText(Integer.toString((int) Tablero.getAlumnos()[0].getDefensa()));
        Tablero.getJugador1()[2].setText(Integer.toString((int) Tablero.getAlumnos()[0].getDañoBase()));
        Tablero.getJugador1()[3].setText(Integer.toString((int) Tablero.getAlumnos()[0].getDañoCritico()));
        Tablero.getJugador1()[4].setText(Integer.toString((int) Tablero.getAlumnos()[0].getProbabilidadCritico()));
        Tablero.getJugador1()[5].setText(Integer.toString((int) Tablero.getAlumnos()[0].getProbabilidadEvadirAtaque()));
        Tablero.getJugador1()[6].setText(Integer.toString((int) Tablero.getAlumnos()[0].getExperiencia()));

        Tablero.getJugador2()[0].setText(Integer.toString((int) Tablero.getAlumnos()[1].getVida()));
        Tablero.getJugador2()[1].setText(Integer.toString((int) Tablero.getAlumnos()[1].getDefensa()));
        Tablero.getJugador2()[2].setText(Integer.toString((int) Tablero.getAlumnos()[1].getDañoBase()));
        Tablero.getJugador2()[3].setText(Integer.toString((int) Tablero.getAlumnos()[1].getDañoCritico()));
        Tablero.getJugador2()[4].setText(Integer.toString((int) Tablero.getAlumnos()[1].getProbabilidadCritico()));
        Tablero.getJugador2()[5].setText(Integer.toString((int) Tablero.getAlumnos()[1].getProbabilidadEvadirAtaque()));
        Tablero.getJugador2()[6].setText(Integer.toString((int) Tablero.getAlumnos()[1].getExperiencia()));

        Tablero.getJugador3()[0].setText(Integer.toString((int) Tablero.getAlumnos()[2].getVida()));
        Tablero.getJugador3()[1].setText(Integer.toString((int) Tablero.getAlumnos()[2].getDefensa()));
        Tablero.getJugador3()[2].setText(Integer.toString((int) Tablero.getAlumnos()[2].getDañoBase()));
        Tablero.getJugador3()[3].setText(Integer.toString((int) Tablero.getAlumnos()[2].getDañoCritico()));
        Tablero.getJugador3()[4].setText(Integer.toString((int) Tablero.getAlumnos()[2].getProbabilidadCritico()));
        Tablero.getJugador3()[5].setText(Integer.toString((int) Tablero.getAlumnos()[2].getProbabilidadEvadirAtaque()));
        Tablero.getJugador3()[6].setText(Integer.toString((int) Tablero.getAlumnos()[2].getExperiencia()));

        Tablero.getJugador4()[0].setText(Integer.toString((int) Tablero.getAlumnos()[3].getVida()));
        Tablero.getJugador4()[1].setText(Integer.toString((int) Tablero.getAlumnos()[3].getDefensa()));
        Tablero.getJugador4()[2].setText(Integer.toString((int) Tablero.getAlumnos()[3].getDañoBase()));
        Tablero.getJugador4()[3].setText(Integer.toString((int) Tablero.getAlumnos()[3].getDañoCritico()));
        Tablero.getJugador4()[4].setText(Integer.toString((int) Tablero.getAlumnos()[3].getProbabilidadCritico()));
        Tablero.getJugador4()[5].setText(Integer.toString((int) Tablero.getAlumnos()[3].getProbabilidadEvadirAtaque()));
        Tablero.getJugador4()[6].setText(Integer.toString((int) Tablero.getAlumnos()[3].getExperiencia()));

    }


    public void ActualizandoEstadisticasMaestro3() {

        Jefe3.getMaestro1()[0].setText(Integer.toString((int) Jefe3.getMaestroActual().getVida()));
        Jefe3.getMaestro1()[1].setText(Integer.toString((int) Jefe3.getMaestroActual().getDefensa()));
        Jefe3.getMaestro1()[2].setText(Integer.toString((int) Jefe3.getMaestroActual().getDañoBase()));
        Jefe3.getMaestro1()[3].setText(Integer.toString((int) Jefe3.getMaestroActual().getDañoCritico()));
        Jefe3.getMaestro1()[4].setText(Integer.toString((int) Jefe3.getMaestroActual().getProbabilidadCritico()));
        Jefe3.getMaestro1()[5].setText(Integer.toString((int) Jefe3.getMaestroActual().getProbabilidadEvadirAtaque()));
        Jefe3.getMaestro1()[6].setText(Integer.toString((int) Jefe3.getMaestroActual().getExperiencia()));
    }


    public void CreacionBarras3() {

        Jugador1.setValue(Jefe3.getJugador1B().getValue());

        Jugador2.setValue(Jefe3.getJugador2B().getValue());

        Jugador3.setValue(Jefe3.getJugador3B().getValue());

        Jugador4.setValue(Jefe3.getJugador4B().getValue());

    }

    
    public void Mando4() {

        ActionListener accion = (ActionEvent ae) -> {

            switch (Turnito) {
                case 0:
                    //EL ALUMNO EN TURNO ES DE TIPO APLICADO
                    if (Jefe4.sigueVivoAlumnoAplicado()) {
                        int anterioVida = (int) Jefe4.getMaestroActual().getVida();
                        Jefe4.setDaño(Jefe4.getAlumnos()[0].ataque());

                        Anterior = Jefe4.getSucesos().getText();
                        Jefe4.getMaestroActual().evadir(Jefe4.getDaño());
                        Jefe4.getSucesos().setText(Anterior + Jefe4.getAlumnos()[0].getInstruccion() + Jefe4.getMaestroActual().getInstruccion());

                        int counter = anterioVida;
                        if (anterioVida != (int) Jefe4.getMaestroActual().getVida()) {

                            while (counter >= (int) Jefe4.getMaestroActual().getVida()) {
                                counter--;

                                Jefe4.getMaestro4B().setValue(counter);

                            }

                        }
                    }
                    break;
                case 1:
                    //EL ALUMNO EN TURNO ES DE TIPO RECURSADOR
                    if (Jefe4.sigueVivoAlumnoRecursador()) {
                        int anterioVida = (int) Jefe4.getMaestroActual().getVida();
                        Jefe4.setDaño(Jefe4.getAlumnos()[1].ataque());
                        Jefe4.getMaestroActual().evadir(Jefe4.getDaño());

                        Anterior = Jefe4.getSucesos().getText();
                        Jefe4.getMaestroActual().evadir(Jefe4.getDaño());
                        Jefe4.getSucesos().setText(Anterior + Jefe4.getAlumnos()[1].getInstruccion() + Jefe4.getMaestroActual().getInstruccion());
                        int counter = anterioVida;
                        if (anterioVida != (int) Jefe4.getMaestroActual().getVida()) {

                            while (counter >= (int) Jefe4.getMaestroActual().getVida()) {
                                counter--;

                                Jefe4.getMaestro4B().setValue(counter);

                            }

                        }

                    }
                    break;
                case 2:
                    //EL ALUMNO EN TURNO ES DE TIPO DEPORTISTA
                    if (Jefe4.sigueVivoAlumnoDeportista()) {
                        int anterioVida = (int) Jefe4.getMaestroActual().getVida();
                        Jefe4.setDaño(Jefe4.getAlumnos()[2].ataque());
                        Jefe4.getMaestroActual().evadir(Jefe4.getDaño());
                        Anterior = Jefe4.getSucesos().getText();
                        Jefe4.getMaestroActual().evadir(Jefe4.getDaño());
                        Jefe4.getSucesos().setText(Anterior + Jefe4.getAlumnos()[2].getInstruccion() + Jefe4.getMaestroActual().getInstruccion());

                        int counter = anterioVida;
                        if (anterioVida != (int) Jefe4.getMaestroActual().getVida()) {

                            while (counter >= (int) Jefe4.getMaestroActual().getVida()) {
                                counter--;

                                Jefe4.getMaestro4B().setValue(counter);

                            }

                        }

                    }
                    break;
                case 3:
                    //EL ALUMNO EN TURNO ES DE TIPO APOYO
                    if (Jefe4.sigueVivoAlumnoApoyo()) {
                        int anterioVida = (int) Jefe4.getMaestroActual().getVida();
                        Jefe4.setDaño(Jefe4.getAlumnos()[3].ataque());
                        Jefe4.getMaestroActual().evadir(Jefe4.getDaño());
                        Anterior = Jefe4.getSucesos().getText();
                        Jefe4.getMaestroActual().evadir(Jefe4.getDaño());
                        Jefe4.getSucesos().setText(Anterior + Jefe4.getAlumnos()[3].getInstruccion() + Jefe4.getMaestroActual().getInstruccion());

                        int counter = anterioVida;
                        if (anterioVida != (int) Jefe4.getMaestroActual().getVida()) {

                            while (counter >= (int) Jefe4.getMaestroActual().getVida()) {
                                counter--;

                                Jefe4.getMaestro4B().setValue(counter);

                            }
                        }

                    }
                    break;
            }
            if (!Jefe4.sigueVivoElMaestroActual()) {
                Jefe4.setVisible(false);
                JuegoGanado.setVisible(true);
                this.getContentPane().add(JuegoGanado);

            }

            Turnito++;
            if (Turnito == 4) {
                AtaquesMaestro4();
                Anterior = Jefe4.getSucesos().getText();
                Jefe4.getSucesos().setText(Anterior + Jefe4.getMaestroActual().getInstruccion());

                Turnito = 0;
            }
            if (Jefe4.getNumeroDeMaestro() == 3) {
                ActualizandoEstadisticasMaestro4();
            }

        };
        Jefe4.getAtaque().addActionListener(accion);

        ActionListener accion2 = (ActionEvent ae) -> {
            switch (Turnito) {
                case 0:
                    //EL ALUMNO EN TURNO ES DE TIPO APLICADO
                    if (Jefe4.sigueVivoAlumnoAplicado()) {

                         Anterior = Jefe4.getSucesos().getText();
                        Jefe4.getSucesos().setText(Anterior +"Puga realizo un ataque especial, "+Jefe4.getAlumnos()[0].getObjPoderEspecial().getDescripcion()+"\n");
                        Jefe4.getAlumnos()[0].poderEspecialDeAlumnoAplicado(Jefe4.getAlumnos()[1], Jefe4.getAlumnos()[2]);
                        ActualizandoEstadisticasEstudiantes4();

                    }
                    break;
                case 1:
                    //EL ALUMNO EN TURNO ES DE TIPO RECURSADOR
                    if (Jefe4.sigueVivoAlumnoRecursador()) {

                         Anterior = Jefe4.getSucesos().getText();
                        Jefe4.getSucesos().setText(Anterior +"Budarth realizo un ataque especial, "+Jefe4.getAlumnos()[1].getObjPoderEspecial().getDescripcion()+"\n");
                        Jefe4.getAlumnos()[1].poderEspecialDeAlumnoRecursador();
                        ActualizandoEstadisticasEstudiantes4();

                    }
                    break;
                case 2:
                    //EL ALUMNO EN TURNO ES DE TIPO DEPORTISTA
                    if (Jefe4.sigueVivoAlumnoDeportista()) {

                         Anterior = Jefe4.getSucesos().getText();
                        Jefe4.getSucesos().setText(Anterior +"Valverde realizo un ataque especial, "+Jefe4.getAlumnos()[2].getObjPoderEspecial().getDescripcion()+"\n");
                        Jefe4.getAlumnos()[2].poderEspecialDeAlumnoDeportista();
                        ActualizandoEstadisticasEstudiantes4();

                    }
                    break;
                case 3:
                    //EL ALUMNO EN TURNO ES DE TIPO APOYO getObjPoderEspecial
                    if (Jefe4.sigueVivoAlumnoApoyo()) {

                         Anterior = Jefe4.getSucesos().getText();
                        Jefe4.getSucesos().setText(Anterior +"Hector realizo un ataque especial, "+Jefe4.getAlumnos()[3].getObjPoderEspecial().getDescripcion()+"\n");
                       
                        int anterioVida = (int) Jefe4.getAlumnos()[0].getVida();
                        int anterioVida1 = (int) Jefe4.getAlumnos()[1].getVida();
                        int anterioVida2 = (int) Jefe4.getAlumnos()[2].getVida();
                        int anterioVida3 = (int) Jefe4.getAlumnos()[3].getVida();

                        Jefe4.getAlumnos()[3].poderEspecialDeAlumnoApoyo(Jefe4.getAlumnos()[0], Jefe4.getAlumnos()[1], Jefe4.getAlumnos()[2]);
                        ActualizandoEstadisticasEstudiantes4();
                        if (Jefe4.getJugador1B().getValue() != Jefe4.getJugador1B().getMaximum()) {

                            int counter = anterioVida;
                            while (counter <= (int) Jefe4.getAlumnos()[0].getVida()) {
                                counter++;
                                Jefe4.getJugador1B().setValue(counter);
                                Jugador4.setValue(counter);
                            }

                        }

                        if (Jefe4.getJugador2B().getValue() != Jefe4.getJugador2B().getMaximum()) {

                            int counter = anterioVida1;
                            while (counter <= (int) Jefe4.getAlumnos()[1].getVida()) {
                                counter++;
                                Jefe4.getJugador2B().setValue(counter);
                                Jugador2.setValue(counter);
                            }
                        }
                        if (Jefe4.getJugador3B().getValue() != Jefe4.getJugador3B().getMaximum()) {

                            int counter = anterioVida2;
                            while (counter <= (int) Jefe4.getAlumnos()[2].getVida()) {
                                counter++;
                                Jefe4.getJugador3B().setValue(counter);
                                Jugador3.setValue(counter);
                            }

                        }

                        if (Jefe4.getJugador4B().getValue() <= Jefe4.getJugador4B().getMaximum() || Jefe4.getJugador4B().getValue() > Jefe4.getJugador4B().getMaximum()) {

                            int counter = anterioVida3;
                            while (counter >= (int) Jefe4.getAlumnos()[3].getVida()) {
                                counter--;
                                Jefe4.getJugador4B().setValue(counter);
                                Jugador4.setValue(counter);
                            }

                        }

                    }

            }
            if (!Jefe4.sigueVivoElMaestroActual()) {
                Jefe4.setVisible(false);
               JuegoGanado.setVisible(true);
                this.getContentPane().add(JuegoGanado);

            }

            Turnito++;

            if (Jefe4.getNumeroDeMaestro() == 3) {
                ActualizandoEstadisticasMaestro4();
            }
            if (Turnito == 4) {
                AtaquesMaestro4();
                Turnito = 0;
            }

        };
        Jefe4.getEspecial().addActionListener(accion2);

    }

    public void AtaquesMaestro4() {

        if (Jefe4.sigueVivoElMaestroActual()) {
            Jefe4.setResultado(Jefe4.getRndm().nextInt((Jefe4.getMaximo() - Jefe4.getMinimo()) + 1) + Jefe4.getMinimo());

            if (Jefe4.getResultado() == 1) {
                int anterioVida = (int) Jefe4.getAlumnos()[0].getVida();
                Jefe4.setDaño(Jefe4.getMaestroActual().ataque());

                if (Jefe4.getAlumnos()[0].evadir(Jefe4.getDaño())) {

                    ActualizandoEstadisticasEstudiantes3();

                    int counter = anterioVida;
                    if (anterioVida != (int) Jefe4.getAlumnos()[0].getVida()) {

                        while (counter >= (int) Jefe4.getAlumnos()[0].getVida()) {
                            counter--;

                            Jefe4.getJugador1B().setValue(counter);
                            Jugador1.setValue(counter);

                        }
                    }
                }
                anterioVida = (int) Jefe4.getAlumnos()[1].getVida();
                if (Jefe4.getAlumnos()[1].evadir(Jefe4.getDaño())) {
                    ActualizandoEstadisticasEstudiantes4();

                    int counter = anterioVida;
                    if (anterioVida != (int) Jefe4.getAlumnos()[1].getVida()) {

                        while (counter >= (int) Jefe4.getAlumnos()[1].getVida()) {
                            counter--;

                            Jefe4.getJugador2B().setValue(counter);
                            Jugador2.setValue(counter);

                        }
                    }
                }
                anterioVida = (int) Jefe4.getAlumnos()[2].getVida();
                if (Jefe4.getAlumnos()[2].evadir(Jefe4.getDaño())) {
                    ActualizandoEstadisticasEstudiantes4();

                    int counter = anterioVida;
                    if (anterioVida != (int) Jefe4.getAlumnos()[2].getVida()) {

                        while (counter >= (int) Jefe4.getAlumnos()[2].getVida()) {
                            counter--;

                            Jefe4.getJugador3B().setValue(counter);
                            Jugador4.setValue(counter);

                        }

                    }
                }
                anterioVida = (int) Jefe4.getAlumnos()[3].getVida();
                if (Jefe4.getAlumnos()[3].evadir(Jefe4.getDaño())) {
                    ActualizandoEstadisticasEstudiantes4();

                    int counter = anterioVida;
                    if (anterioVida != (int) Jefe4.getAlumnos()[3].getVida()) {

                        while (counter >= (int) Jefe4.getAlumnos()[3].getVida()) {
                            counter--;

                            Jefe4.getJugador4B().setValue(counter);
                            Jugador4.setValue(counter);

                        }
                    }
                }

            } else {

              
                
                 Anterior = Jefe4.getSucesos().getText();
                        Jefe4.getSucesos().setText(Anterior +"Roberto realizo un ataque especial, "+Jefe4.getMaestroActual().getObjPoderEspecial().getDescripcion()+"\n");
                System.out.println(Jefe4.getMaestroActual().getObjPoderEspecial().getDescripcion());
                            Jefe4.setResultado(Jefe4.getRndm().nextInt((3 - 1) + 1) + 1);
                            switch (Jefe4.getResultado()) {
                                case 1:
                                    Jefe4.getMaestroActual().poderEspecialDeMaestroFacil(Jefe4.getAlumnos()[0], Jefe4.getAlumnos()[1], Jefe4.getAlumnos()[2], Jefe4.getAlumnos()[3], 5);
                                    break;
                                case 2:
                                    Jefe4.getMaestroActual().poderEspecialDeMaestroMedio(Jefe4.getAlumnos()[0], Jefe4.getAlumnos()[1], Jefe4.getAlumnos()[2], Jefe4.getAlumnos()[3], 10);
                                    break;
                                case 3:
                                    Jefe4.getMaestroActual().poderEspecialDeMaestroDificil(Jefe4.getAlumnos()[0], Jefe4.getAlumnos()[1], Jefe4.getAlumnos()[2], Jefe4.getAlumnos()[3], 5);
                                    break;
                            }
                if (Jefe4.getNumeroDeMaestro() == 3) {
                    ActualizandoEstadisticasMaestro4();
                }

            }
            if (!Jefe4.sigueVivoAlgunAlumno()) {
                Jefe4.setVisible(false);
                Derrota.setVisible(true);
                this.getContentPane().add(Derrota);
                ActualizacionEstadisticaDespuesDePelea4();
            }
        } 
        
    }

    
    public void ActualizandoEstadisticasEstudiantes4() {

        Jefe4.getJugador1()[0].setText(Integer.toString((int) Jefe4.getAlumnos()[0].getVida()));
        Jefe4.getJugador1()[1].setText(Integer.toString((int) Jefe4.getAlumnos()[0].getDefensa()));
        Jefe4.getJugador1()[2].setText(Integer.toString((int) Jefe4.getAlumnos()[0].getDañoBase()));
        Jefe4.getJugador1()[3].setText(Integer.toString((int) Jefe4.getAlumnos()[0].getDañoCritico()));
        Jefe4.getJugador1()[4].setText(Integer.toString((int) Jefe4.getAlumnos()[0].getProbabilidadCritico()));
        Jefe4.getJugador1()[5].setText(Integer.toString((int) Jefe4.getAlumnos()[0].getProbabilidadEvadirAtaque()));
        Jefe4.getJugador1()[6].setText(Integer.toString((int) Jefe4.getAlumnos()[0].getExperiencia()));
        if ((int) Jefe4.getAlumnos()[0].getVida() > Jefe4.getJugador1B().getMaximum()) {
            Jefe4.getJugador1B().setMaximum((int) Jefe4.getAlumnos()[0].getVida());
            Jugador1.setValue(Jugador1.getMaximum());

        }

        Jefe4.getJugador2()[0].setText(Integer.toString((int) Jefe4.getAlumnos()[1].getVida()));
        Jefe4.getJugador2()[1].setText(Integer.toString((int) Jefe4.getAlumnos()[1].getDefensa()));
        Jefe4.getJugador2()[2].setText(Integer.toString((int) Jefe4.getAlumnos()[1].getDañoBase()));
        Jefe4.getJugador2()[3].setText(Integer.toString((int) Jefe4.getAlumnos()[1].getDañoCritico()));
        Jefe4.getJugador2()[4].setText(Integer.toString((int) Jefe4.getAlumnos()[1].getProbabilidadCritico()));
        Jefe4.getJugador2()[5].setText(Integer.toString((int) Jefe4.getAlumnos()[1].getProbabilidadEvadirAtaque()));
        Jefe4.getJugador2()[6].setText(Integer.toString((int) Jefe4.getAlumnos()[1].getExperiencia()));
        if ((int) Jefe4.getAlumnos()[1].getVida() > Jefe4.getJugador2B().getMaximum()) {
            Jefe4.getJugador2B().setMaximum((int) Jefe4.getAlumnos()[1].getVida());
            Jugador2.setValue(Jugador2.getMaximum());

        }

        Jefe4.getJugador3()[0].setText(Integer.toString((int) Jefe4.getAlumnos()[2].getVida()));
        Jefe4.getJugador3()[1].setText(Integer.toString((int) Jefe4.getAlumnos()[2].getDefensa()));
        Jefe4.getJugador3()[2].setText(Integer.toString((int) Jefe4.getAlumnos()[2].getDañoBase()));
        Jefe4.getJugador3()[3].setText(Integer.toString((int) Jefe4.getAlumnos()[2].getDañoCritico()));
        Jefe4.getJugador3()[4].setText(Integer.toString((int) Jefe4.getAlumnos()[2].getProbabilidadCritico()));
        Jefe4.getJugador3()[5].setText(Integer.toString((int) Jefe4.getAlumnos()[2].getProbabilidadEvadirAtaque()));
        Jefe4.getJugador3()[6].setText(Integer.toString((int) Jefe4.getAlumnos()[2].getExperiencia()));

        if ((int) Jefe4.getAlumnos()[2].getVida() > Jefe4.getJugador3B().getMaximum()) {
            Jefe4.getJugador3B().setMaximum((int) Jefe4.getAlumnos()[2].getVida());
            Jugador3.setValue(Jugador3.getMaximum());

        }

        Jefe4.getJugador4()[0].setText(Integer.toString((int) Jefe4.getAlumnos()[3].getVida()));
        Jefe4.getJugador4()[1].setText(Integer.toString((int) Jefe4.getAlumnos()[3].getDefensa()));
        Jefe4.getJugador4()[2].setText(Integer.toString((int) Jefe4.getAlumnos()[3].getDañoBase()));
        Jefe4.getJugador4()[3].setText(Integer.toString((int) Jefe4.getAlumnos()[3].getDañoCritico()));
        Jefe4.getJugador4()[4].setText(Integer.toString((int) Jefe4.getAlumnos()[3].getProbabilidadCritico()));
        Jefe4.getJugador4()[5].setText(Integer.toString((int) Jefe4.getAlumnos()[3].getProbabilidadEvadirAtaque()));
        Jefe4.getJugador4()[6].setText(Integer.toString((int) Jefe4.getAlumnos()[3].getExperiencia()));

        if ((int) Jefe4.getAlumnos()[3].getVida() > Jefe4.getJugador4B().getMaximum()) {
            Jefe4.getJugador4B().setMaximum((int) Jefe4.getAlumnos()[3].getVida());
            Jugador4.setValue(Jugador4.getMaximum());
        }
    }

    public void ActualizacionEstadisticaDespuesDePelea4() {
        Tablero.setAlumnos(Jefe4.getAlumnos());

        Tablero.getJugador1()[0].setText(Integer.toString((int) Tablero.getAlumnos()[0].getVida()));
        Tablero.getJugador1()[1].setText(Integer.toString((int) Tablero.getAlumnos()[0].getDefensa()));
        Tablero.getJugador1()[2].setText(Integer.toString((int) Tablero.getAlumnos()[0].getDañoBase()));
        Tablero.getJugador1()[3].setText(Integer.toString((int) Tablero.getAlumnos()[0].getDañoCritico()));
        Tablero.getJugador1()[4].setText(Integer.toString((int) Tablero.getAlumnos()[0].getProbabilidadCritico()));
        Tablero.getJugador1()[5].setText(Integer.toString((int) Tablero.getAlumnos()[0].getProbabilidadEvadirAtaque()));
        Tablero.getJugador1()[6].setText(Integer.toString((int) Tablero.getAlumnos()[0].getExperiencia()));

        Tablero.getJugador2()[0].setText(Integer.toString((int) Tablero.getAlumnos()[1].getVida()));
        Tablero.getJugador2()[1].setText(Integer.toString((int) Tablero.getAlumnos()[1].getDefensa()));
        Tablero.getJugador2()[2].setText(Integer.toString((int) Tablero.getAlumnos()[1].getDañoBase()));
        Tablero.getJugador2()[3].setText(Integer.toString((int) Tablero.getAlumnos()[1].getDañoCritico()));
        Tablero.getJugador2()[4].setText(Integer.toString((int) Tablero.getAlumnos()[1].getProbabilidadCritico()));
        Tablero.getJugador2()[5].setText(Integer.toString((int) Tablero.getAlumnos()[1].getProbabilidadEvadirAtaque()));
        Tablero.getJugador2()[6].setText(Integer.toString((int) Tablero.getAlumnos()[1].getExperiencia()));

        Tablero.getJugador3()[0].setText(Integer.toString((int) Tablero.getAlumnos()[2].getVida()));
        Tablero.getJugador3()[1].setText(Integer.toString((int) Tablero.getAlumnos()[2].getDefensa()));
        Tablero.getJugador3()[2].setText(Integer.toString((int) Tablero.getAlumnos()[2].getDañoBase()));
        Tablero.getJugador3()[3].setText(Integer.toString((int) Tablero.getAlumnos()[2].getDañoCritico()));
        Tablero.getJugador3()[4].setText(Integer.toString((int) Tablero.getAlumnos()[2].getProbabilidadCritico()));
        Tablero.getJugador3()[5].setText(Integer.toString((int) Tablero.getAlumnos()[2].getProbabilidadEvadirAtaque()));
        Tablero.getJugador3()[6].setText(Integer.toString((int) Tablero.getAlumnos()[2].getExperiencia()));

        Tablero.getJugador4()[0].setText(Integer.toString((int) Tablero.getAlumnos()[3].getVida()));
        Tablero.getJugador4()[1].setText(Integer.toString((int) Tablero.getAlumnos()[3].getDefensa()));
        Tablero.getJugador4()[2].setText(Integer.toString((int) Tablero.getAlumnos()[3].getDañoBase()));
        Tablero.getJugador4()[3].setText(Integer.toString((int) Tablero.getAlumnos()[3].getDañoCritico()));
        Tablero.getJugador4()[4].setText(Integer.toString((int) Tablero.getAlumnos()[3].getProbabilidadCritico()));
        Tablero.getJugador4()[5].setText(Integer.toString((int) Tablero.getAlumnos()[3].getProbabilidadEvadirAtaque()));
        Tablero.getJugador4()[6].setText(Integer.toString((int) Tablero.getAlumnos()[3].getExperiencia()));

    }


    public void ActualizandoEstadisticasMaestro4() {

        Jefe4.getMaestro1()[0].setText(Integer.toString((int) Jefe4.getMaestroActual().getVida()));
        Jefe4.getMaestro1()[1].setText(Integer.toString((int) Jefe4.getMaestroActual().getDefensa()));
        Jefe4.getMaestro1()[2].setText(Integer.toString((int) Jefe4.getMaestroActual().getDañoBase()));
        Jefe4.getMaestro1()[3].setText(Integer.toString((int) Jefe4.getMaestroActual().getDañoCritico()));
        Jefe4.getMaestro1()[4].setText(Integer.toString((int) Jefe4.getMaestroActual().getProbabilidadCritico()));
        Jefe4.getMaestro1()[5].setText(Integer.toString((int) Jefe4.getMaestroActual().getProbabilidadEvadirAtaque()));
        Jefe4.getMaestro1()[6].setText(Integer.toString((int) Jefe4.getMaestroActual().getExperiencia()));
    }


    public void CreacionBarras4() {

        Jugador1.setValue(Jefe4.getJugador1B().getValue());

        Jugador2.setValue(Jefe4.getJugador2B().getValue());

        Jugador3.setValue(Jefe4.getJugador3B().getValue());

        Jugador4.setValue(Jefe4.getJugador4B().getValue());

    }
 
public void Reinicio(){
            this.Jugador1 = new JProgressBar(0, 28000);
            this.Jugador2 = new JProgressBar(0, 33500);
            this.Jugador3 = new JProgressBar(0, 25000);
            this.Jugador4 = new JProgressBar(0, 49000);
            this.Maestro1 = new JProgressBar(0, 57000);
            this.Victoria = new PanelGanador();
            this.JuegoGanado = new PanelJuegoAcabado();
            this.Eleccion = 0;
            this.Eleccion2 = 0;

            this.y = 614;

            this.x = 596;
            this.Cambio = new Random();
            this.Pieza=new JLabel();
            this. anterior=0;
            this. numeroAnterior=0;
             this.verdad = true;
             this.verdad2 = false;
             this.verdad3 = false; 
             this.verdad4 = false; 
             this.verdad5 = false;
             this.verdad6 = false;
             this.verdad7 = false;

    
this.h = true;
this.ContadorDado=0;
this. i = 0;
    this.ant = null;
   this. Turnito = 0;
    this. Anterior="";


   

    this. Inicio = new PanelInicio();
    this. Tablero = new PanelTablero();
    this. Jefe1 = new PanelJefe1();
    this. Jefe2 = new PanelJefe2();
    this. Jefe3 = new PanelJefe3();
    this. Jefe4 = new PanelJefeFinal();
    this. Instrucciones1 = new Instruccion1();
    this. Instrucciones2 = new Instruccion2();
    this. Instrucciones3 = new Instruccion3();
    this. Instrucciones4 = new Instruccion4();
    this. Derrota = new PanelDerrota();
     
    this.getContentPane().add(Inicio);
    InicializacionComponentes();
}
}
