package Logica;

import java.util.Random;

public class Alumno extends Persona{
    Categoria objCategoria = new Categoria();
    PoderEspecial objPoderEspecial = new PoderEspecial();
    String Instruccion="";
    

    public class PoderEspecial {
        String nombre;
        String descripcion;

        public PoderEspecial() {
            this.nombre = "";
            this.descripcion = "";
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public String getDescripcion() {
            return descripcion;
        }

        public void setDescripcion(String descripcion) {
            this.descripcion = descripcion;
        }
    }

    public Alumno() {
        super("", 0, 0, 0, 0, 0, 0, 0);
        objCategoria.setNombre("");
        objCategoria.setDescripcion("");
        objPoderEspecial.setNombre("");
        objPoderEspecial.setDescripcion("");
    }

    public Alumno(String nombre, double vida, double defensa, double dañoBase, double dañoCritico, double probabilidadCritico,
                  double probabilidadEvadirAtaque, double experiencia) {
        
        super(nombre, vida, defensa, dañoBase, dañoCritico, probabilidadCritico, probabilidadEvadirAtaque, experiencia);
    }

    public Alumno(String nombre, double vida, double defensa, double dañoBase, double dañoCritico, double probabilidadCritico,
                  double probabilidadEvadirAtaque, double experiencia, String nombreCategoria, String descripcionCategoria,
                  String nombrePoderEspecial, String descripcionPoderEspecial) {
        super(nombre, vida, defensa, dañoBase, dañoCritico, probabilidadCritico, probabilidadEvadirAtaque, experiencia);
        objCategoria.nombre = nombreCategoria;
        objCategoria.descripcion = descripcionCategoria;
        objPoderEspecial.nombre = nombrePoderEspecial;
        objPoderEspecial.descripcion = descripcionPoderEspecial;
    }

    public static Alumno Aplicado(String nombre, double vida, double defensa, double dañoBase, double dañoCritico, double probabilidadCritico,
                                  double probabilidadEvadirAtaque, double experiencia) {
        Alumno objAlumno = new Alumno(nombre, vida, defensa, dañoBase, dañoCritico, probabilidadCritico, probabilidadEvadirAtaque,
                experiencia);
        objAlumno.objCategoria.nombre = "Aplicado";
        objAlumno.objCategoria.descripcion = "Rol que tiene estadísticas generales más altas que los demás roles.";
        objAlumno.objPoderEspecial.nombre = "Estudiar toda la semana";
        objAlumno.objPoderEspecial.descripcion = "Poder que le permite al jugador auto-curar a el equipo en relacion" +
                " a su ataque total base, pero reduce el ataque de si mismo un 15%, al usar esta habilidad los alumnos" +
                " de tipo apoyo no pueden ser objetivo de dicho poder especial para recibir curación ";
        return objAlumno;
    }

    public static Alumno Recursador(String nombre, double vida, double defensa, double dañoBase, double dañoCritico, double probabilidadCritico,
                                    double probabilidadEvadirAtaque, double experiencia) {
        Alumno objAlumno = new Alumno(nombre, vida, defensa, dañoBase, dañoCritico, probabilidadCritico, probabilidadEvadirAtaque,
                experiencia);
        objAlumno.objCategoria.nombre = "Recursador";
        objAlumno.objCategoria.descripcion = "Rol con experiencia en el juego haciéndolo ser un personaje adecuado para ser el tanque del equipo.";
        objAlumno.objPoderEspecial.nombre = "Eso lo vi en…";
        objAlumno.objPoderEspecial.descripcion = "Poder que le permite aumentar su defensa en un 35%, pero reduce su vida base en 10%";
        return objAlumno;
    }

    public static Alumno Deportista(String nombre, double vida, double defensa, double dañoBase, double dañoCritico, double probabilidadCritico,
                                    double probabilidadEvadirAtaque, double experiencia) {
        Alumno objAlumno = new Alumno(nombre, vida, defensa, dañoBase, dañoCritico, probabilidadCritico, probabilidadEvadirAtaque,
                experiencia);
        objAlumno.objCategoria.nombre = "Deportista";
        objAlumno.objCategoria.descripcion = "Rol que se caracteriza por ser el daño del equipo ya que este siempre hace ejercicio y por ende, está en forma.";
        objAlumno.objPoderEspecial.nombre = "¡Pásala, estoy sólo!”";
        objAlumno.objPoderEspecial.descripcion = "Poder que le permite subir su daño base en 20% y aumenta su evasión a 15% pero al usarlo su defensa " +
                "base baja un 20%";
        return objAlumno;
    }

    public static Alumno Apoyo(String nombre, double vida, double defensa, double dañoBase, double dañoCritico, double probabilidadCritico,
                               double probabilidadEvadirAtaque, double experiencia) {
        Alumno objAlumno = new Alumno(nombre, vida, defensa, dañoBase, dañoCritico, probabilidadCritico, probabilidadEvadirAtaque,
                experiencia);
        objAlumno.objCategoria.nombre = "Deportista";
        objAlumno.objCategoria.descripcion = "Rol que se representa como el curandero del grupo, permite mantener sanos a sus compañeros y de igual forma les " +
                "da estadísticas temporales.";
        objAlumno.objPoderEspecial.nombre = "No te lo paso, pero si quieres te explico”";
        objAlumno.objPoderEspecial.descripcion = "Poder de grupo que permite a el apoyo a dar 5% de estadísticas generales a todo el grupo pero este usuario " +
                "pierde 10% de su vida, el jugador no se beneficia de dicho apoyo";
        return objAlumno;
    }

    public void poderEspecialDeAlumnoAplicado(Alumno recursador, Alumno deportista) {
        double vidaAdicional = this.getDañoBase();
        this.setVida(this.getVida() + vidaAdicional);
        recursador.setVida(recursador.getVida() + vidaAdicional);
        deportista.setVida(deportista.getVida() + vidaAdicional);
        this.setDañoBase(porcentaje(this.getDañoBase(), 85));
    }

    public void poderEspecialDeAlumnoRecursador() {
        this.setDefensa(this.getDefensa() + porcentaje(this.getDefensa(), 35));
        this.setVida(this.getVida() - porcentaje(this.getVida(), 10));
    }

    public void poderEspecialDeAlumnoDeportista() {
        this.setDañoBase(this.getDañoBase() + porcentaje(this.getDañoBase(), 20));
        this.setProbabilidadEvadirAtaque(this.getProbabilidadEvadirAtaque() + porcentaje(this.getProbabilidadEvadirAtaque(), 15));
        this.setDefensa(this.getDefensa() - porcentaje(this.getDefensa(), 20));
    }

    public void poderEspecialDeAlumnoApoyo(Alumno aplicado, Alumno recursador, Alumno deportista) {
        aplicado.setVida(aplicado.getVida()+porcentaje(aplicado.getVida(),5));
        aplicado.setDefensa(aplicado.getDefensa()+porcentaje(aplicado.getDefensa(),5));
        aplicado.setDañoBase(aplicado.getDañoBase()+porcentaje(aplicado.getDañoBase(),5));
        aplicado.setDañoCritico(aplicado.getDañoCritico()+porcentaje(aplicado.getDañoCritico(),5));
        aplicado.setProbabilidadCritico(aplicado.getProbabilidadCritico()+porcentaje(aplicado.getProbabilidadCritico(),5));
        aplicado.setProbabilidadEvadirAtaque(aplicado.getProbabilidadEvadirAtaque()+porcentaje(aplicado.getProbabilidadEvadirAtaque(),5));

        recursador.setVida(recursador.getVida()+porcentaje(recursador.getVida(),5));
        recursador.setDefensa(recursador.getDefensa()+porcentaje(recursador.getDefensa(),5));
        recursador.setDañoBase(recursador.getDañoBase()+porcentaje(recursador.getDañoBase(),5));
        recursador.setDañoCritico(recursador.getDañoCritico()+porcentaje(recursador.getDañoCritico(),5));
        recursador.setProbabilidadCritico(recursador.getProbabilidadCritico()+porcentaje(recursador.getProbabilidadCritico(),5));
        recursador.setProbabilidadEvadirAtaque(recursador.getProbabilidadEvadirAtaque()+porcentaje(recursador.getProbabilidadEvadirAtaque(),5));

        deportista.setVida(deportista.getVida()+porcentaje(deportista.getVida(),5));
        deportista.setDefensa(deportista.getDefensa()+porcentaje(deportista.getDefensa(),5));
        deportista.setDañoBase(deportista.getDañoBase()+porcentaje(deportista.getDañoBase(),5));
        deportista.setDañoCritico(deportista.getDañoCritico()+porcentaje(deportista.getDañoCritico(),5));
        deportista.setProbabilidadCritico(deportista.getProbabilidadCritico()+porcentaje(deportista.getProbabilidadCritico(),5));
        deportista.setProbabilidadEvadirAtaque(deportista.getProbabilidadEvadirAtaque()+porcentaje(deportista.getProbabilidadEvadirAtaque(),5));

        this.setVida(this.getVida() - porcentaje(this.getVida(), 10));
    }

    public double porcentaje(double valor, int porcentaje) {
        return ((valor / 100) * porcentaje);
    }

    public boolean seEvadeAtaque() {
        Random rd = new Random();
        int numeroAleatorio = rd.nextInt(100) + 1;
        if (this.getProbabilidadEvadirAtaque() >= numeroAleatorio) {
            return true;
        } else {
            return false;
        }
    }

    public boolean daGolpeCritico() {
        Random rd = new Random();
        int numeroAleatorio = rd.nextInt(100) + 1;
        if (this.getProbabilidadCritico() >= numeroAleatorio) {
            return true;
        } else {
            return false;
        }
    }

    public double ataque() {
        double dañoBase = this.getDañoBase();
        double dañoCritico = this.getDañoCritico();
        double ataque = 0;

        if (this.daGolpeCritico()) {
            Instruccion=this.getNombre() + ": Realizo un golpe critico de " + (dañoBase + dañoCritico+"\n");
            System.out.println(this.getNombre() + ": Realizo un golpe critico de " + (dañoBase + dañoCritico));
            ataque = dañoBase + dañoCritico;
        } else {
             Instruccion=this.getNombre() + ": Realizo un golpe basico de " + (dañoBase)+"\n";
            System.out.println(this.getNombre() + ": Realizo un golpe basico de " + (dañoBase));
            ataque = dañoBase;
            
        }
        return ataque;
    }

    public boolean evadir(double ataque) {
        if (seEvadeAtaque()) {
            Instruccion=this.getNombre() + ": ha evadido el ataque con exito";
            System.out.println(this.getNombre() + ": ha evadido el ataque con exito");
        } else if(this.getDefensa()>=ataque){
            Instruccion=this.getNombre() + ": ha logrado protegerse de el ataque con exito";
            System.out.println(this.getNombre() + ": ha logrado protegerse de el ataque con exito");
            this.setDefensa(this.getDefensa()-100);
        }else {
            Instruccion=this.getNombre() + ": no ha logrado evadir el ataque";
            System.out.println(this.getNombre() + ": no ha logrado evadir el ataque");
            this.setVida(this.getVida() - ataque);
            if (this.getVida() < 0) {
                this.setVida(0);
            }
            return true;
        }
        return false;
    }

   

    public String getInstruccion() {
        return Instruccion;
    }

    public PoderEspecial getObjPoderEspecial() {
        return objPoderEspecial;
    }
   
    
}
