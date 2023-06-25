package Logica;
import java.util.Random;
public class Maestro extends Persona {
    Categoria objCategoria = new Categoria();
    PoderEspecial objPoderEspecial = new PoderEspecial();
String Instruccion;

    public Categoria getObjCategoria() {
        return objCategoria;
    }

    public PoderEspecial getObjPoderEspecial() {
        return objPoderEspecial;
    }

    public String getInstruccion() {
        return Instruccion;
    }

    public void setInstruccion(String Instruccion) {
        this.Instruccion = Instruccion;
    }

    public Maestro() {
        super("", 0, 0, 0, 0, 0, 0, 0);
        objCategoria.setNombre("");
        objCategoria.setDescripcion("");
        objPoderEspecial.setNombre("");
        objPoderEspecial.setDescripcion("");
    }

    public Maestro(String nombre, double vida, double defensa, double dañoBase, double dañoCritico, double probabilidadCritico,
                   double probabilidadEvadirAtaque, double experiencia) {
        super(nombre, vida, defensa, dañoBase, dañoCritico, probabilidadCritico, probabilidadEvadirAtaque, experiencia);
    }

    public Maestro(String nombre, double vida, double defensa, double dañoBase, double dañoCritico, double probabilidadCritico,
                   double probabilidadEvadirAtaque, double experiencia, String nombreCategoria, String descripcionCategoria,
                   String nombrePoderEspecial, String descripcionPoderEspecial) {
        super(nombre, vida, defensa, dañoBase, dañoCritico, probabilidadCritico, probabilidadEvadirAtaque, experiencia);
        objCategoria.nombre = nombreCategoria;
        objCategoria.descripcion = descripcionCategoria;
        objPoderEspecial.nombre = nombrePoderEspecial;
        objPoderEspecial.descripcion = descripcionPoderEspecial;
    }

    public static Maestro Facil(String nombre, double vida, double defensa, double dañoBase, double dañoCritico, double probabilidadCritico,
                                double probabilidadEvadirAtaque, double experiencia) {
        Maestro objMaestro = new Maestro(nombre, vida, defensa, dañoBase, dañoCritico, probabilidadCritico, probabilidadEvadirAtaque,
                experiencia);
        objMaestro.objCategoria.nombre = "Maestro";
        objMaestro.objCategoria.descripcion = "Sin especificar";
        objMaestro.objPoderEspecial.nombre = "¿Me escuchan, jóvenes?";
        objMaestro.objPoderEspecial.descripcion = "Poder que permite al jefe en usar la confusión hacia los héroes/" +
                "compañeros reduciendo su evasión en un 15%";
        return objMaestro;
    }

    public static Maestro Medio(String nombre, double vida, double defensa, double dañoBase, double dañoCritico, double probabilidadCritico,
                                double probabilidadEvadirAtaque, double experiencia) {
        Maestro objMaestro = new Maestro(nombre, vida, defensa, dañoBase, dañoCritico, probabilidadCritico, probabilidadEvadirAtaque,
                experiencia);
        objMaestro.objCategoria.nombre = "Maestro";
        objMaestro.objCategoria.descripcion = "Sin especificar";
        objMaestro.objPoderEspecial.nombre = "Les encargo una tareíta";
        objMaestro.objPoderEspecial.descripcion = "Poder que le permite al jefe invocar un súbdito de nombre “tarea” " +
                "la cual explota inmediatamente, dañando a los jugadores con 10% de su vida.";
        return objMaestro;
    }

    public static Maestro Dificil(String nombre, double vida, double defensa, double dañoBase, double dañoCritico, double probabilidadCritico,
                                  double probabilidadEvadirAtaque, double experiencia) {
        Maestro objMaestro = new Maestro(nombre, vida, defensa, dañoBase, dañoCritico, probabilidadCritico, probabilidadEvadirAtaque,
                experiencia);
        objMaestro.objCategoria.nombre = "Maestro";
        objMaestro.objCategoria.descripcion = "Sin especificar";
        objMaestro.objPoderEspecial.nombre = "*Música de fondo*”";
        objMaestro.objPoderEspecial.descripcion = "Poder que le permite al jefe en el momento de ejecutar su poder especial, " +
                "reducir inmediatamente las estadísticas generales de los alumnos en un 15%.";
        return objMaestro;
    }

    public static Maestro Experto(String nombre, double vida, double defensa, double dañoBase, double dañoCritico, double probabilidadCritico,
                                  double probabilidadEvadirAtaque, double experiencia) {
        Maestro objMaestro = new Maestro(nombre, vida, defensa, dañoBase, dañoCritico, probabilidadCritico, probabilidadEvadirAtaque,
                experiencia);
        objMaestro.objCategoria.nombre = "Maestro";
        objMaestro.objCategoria.descripcion = "Sin especificar";
        objMaestro.objPoderEspecial.nombre = "¡Ay, por favor!";
        objMaestro.objPoderEspecial.descripcion = "Reutiliza el poder de los otros jefes pero aumentando sus estadísticas " +
                "hacia los alumnos";
        return objMaestro;
    }

    public void poderEspecialDeMaestroDificil(Alumno aplicado, Alumno recursador, Alumno deportista, Alumno apoyo,int aumentoPorcentual) {
        aplicado.setVida(aplicado.getVida()-porcentaje(aplicado.getVida(),15+aumentoPorcentual));
        aplicado.setDefensa(aplicado.getDefensa()-porcentaje(aplicado.getDefensa(),15+aumentoPorcentual));
        aplicado.setDañoBase(aplicado.getDañoBase()-porcentaje(aplicado.getDañoBase(),15+aumentoPorcentual));
        aplicado.setDañoCritico(aplicado.getDañoCritico()-porcentaje(aplicado.getDañoCritico(),15+aumentoPorcentual));
        aplicado.setProbabilidadCritico(aplicado.getProbabilidadCritico()-porcentaje(aplicado.getProbabilidadCritico(),15+aumentoPorcentual));
        aplicado.setProbabilidadEvadirAtaque(aplicado.getProbabilidadEvadirAtaque()-porcentaje(aplicado.getProbabilidadEvadirAtaque(),15+aumentoPorcentual));

        recursador.setVida(recursador.getVida()-porcentaje(recursador.getVida(),15+aumentoPorcentual));
        recursador.setDefensa(recursador.getDefensa()-porcentaje(recursador.getDefensa(),15+aumentoPorcentual));
        recursador.setDañoBase(recursador.getDañoBase()-porcentaje(recursador.getDañoBase(),15+aumentoPorcentual));
        recursador.setDañoCritico(recursador.getDañoCritico()-porcentaje(recursador.getDañoCritico(),15+aumentoPorcentual));
        recursador.setProbabilidadCritico(recursador.getProbabilidadCritico()-porcentaje(recursador.getProbabilidadCritico(),15+aumentoPorcentual));
        recursador.setProbabilidadEvadirAtaque(recursador.getProbabilidadEvadirAtaque()-porcentaje(recursador.getProbabilidadEvadirAtaque(),15+aumentoPorcentual));

        deportista.setVida(deportista.getVida()-porcentaje(deportista.getVida(),15+aumentoPorcentual));
        deportista.setDefensa(deportista.getDefensa()-porcentaje(deportista.getDefensa(),15+aumentoPorcentual));
        deportista.setDañoBase(deportista.getDañoBase()-porcentaje(deportista.getDañoBase(),15+aumentoPorcentual));
        deportista.setDañoCritico(deportista.getDañoCritico()-porcentaje(deportista.getDañoCritico(),15+aumentoPorcentual));
        deportista.setProbabilidadCritico(deportista.getProbabilidadCritico()-porcentaje(deportista.getProbabilidadCritico(),15+aumentoPorcentual));
        deportista.setProbabilidadEvadirAtaque(deportista.getProbabilidadEvadirAtaque()-porcentaje(deportista.getProbabilidadEvadirAtaque(),15+aumentoPorcentual));

        apoyo.setVida(apoyo.getVida()-porcentaje(apoyo.getVida(),15+aumentoPorcentual));
        apoyo.setDefensa(apoyo.getDefensa()-porcentaje(apoyo.getDefensa(),15+aumentoPorcentual));
        apoyo.setDañoBase(apoyo.getDañoBase()-porcentaje(apoyo.getDañoBase(),15+aumentoPorcentual));
        apoyo.setDañoCritico(apoyo.getDañoCritico()-porcentaje(apoyo.getDañoCritico(),15+aumentoPorcentual));
        apoyo.setProbabilidadCritico(apoyo.getProbabilidadCritico()-porcentaje(apoyo.getProbabilidadCritico(),15+aumentoPorcentual));
        apoyo.setProbabilidadEvadirAtaque(apoyo.getProbabilidadEvadirAtaque()-porcentaje(apoyo.getProbabilidadEvadirAtaque(),15+aumentoPorcentual));
    }

    public void poderEspecialDeMaestroMedio(Alumno aplicado, Alumno recursador, Alumno deportista, Alumno apoyo,int aumentoPorcentual) {
        aplicado.setVida(aplicado.getVida()-porcentaje(aplicado.getVida(),10+aumentoPorcentual));
        recursador.setVida(recursador.getVida()-porcentaje(recursador.getVida(),10+aumentoPorcentual));
        deportista.setVida(deportista.getVida()-porcentaje(deportista.getVida(),10+aumentoPorcentual));
        apoyo.setVida(apoyo.getVida()-porcentaje(apoyo.getVida(),10+aumentoPorcentual));
    }

    public void poderEspecialDeMaestroFacil(Alumno aplicado, Alumno recursador, Alumno deportista, Alumno apoyo,int aumentoPorcentual) {
        aplicado.setProbabilidadEvadirAtaque(aplicado.getProbabilidadEvadirAtaque()-porcentaje(aplicado.getProbabilidadEvadirAtaque(),15+aumentoPorcentual));
        recursador.setProbabilidadEvadirAtaque(recursador.getProbabilidadEvadirAtaque()-porcentaje(recursador.getProbabilidadEvadirAtaque(),15+aumentoPorcentual));
        deportista.setProbabilidadEvadirAtaque(deportista.getProbabilidadEvadirAtaque()-porcentaje(deportista.getProbabilidadEvadirAtaque(),15+aumentoPorcentual));
        apoyo.setProbabilidadEvadirAtaque(apoyo.getProbabilidadEvadirAtaque()-porcentaje(apoyo.getProbabilidadEvadirAtaque(),15+aumentoPorcentual));
    }

    private double porcentaje(double valor, int porcentaje) {
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
            Instruccion=this.getNombre() + ": Realizo un golpe critico de " + (dañoBase + dañoCritico)+"\n";
            System.out.println(this.getNombre() + ": Realizo un golpe critico de " + (dañoBase + dañoCritico));
            ataque = dañoBase + dañoCritico;
        } else {
            Instruccion=this.getNombre() + ": Realizo un golpe basico de " + (dañoBase)+"\n";
            System.out.println(this.getNombre() + ": Realizo un golpe basico de " + (dañoBase));
            ataque = dañoBase;
        }
        return ataque;
    }

    public void evadir(double ataque) {
        if (seEvadeAtaque()) {
            Instruccion=this.getNombre() + ": ha evadido el ataque con exito"+"\n";
            System.out.println(this.getNombre() + ": ha evadido el ataque con exito");
        } else if(this.getDefensa()>=ataque){
            Instruccion=this.getNombre() + ": ha logrado protegerse de el ataque con exito"+"\n";
            System.out.println(this.getNombre() + ": ha logrado protegerse de el ataque con exito");
            this.setDefensa(this.getDefensa()-100);
        }else {
            Instruccion=this.getNombre() + ": no ha logrado evadir el ataque"+"\n";
            System.out.println(this.getNombre() + ": no ha logrado evadir el ataque");
            this.setVida(this.getVida() - ataque);
            if (this.getVida() < 0) {
                this.setVida(0);
            }
        }
    }

   
}
