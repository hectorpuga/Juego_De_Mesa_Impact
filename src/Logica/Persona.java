package Logica;

public class Persona {
    String nombre;
    double vida;
    double defensa;
    double dañoBase;
    double dañoCritico;
    double probabilidadCritico;

    double probabilidadEvadirAtaque;
    double experiencia;

    public Persona() {
        nombre="";
        vida=0;
        defensa=0;
        dañoBase=0;
        dañoCritico=0;
        probabilidadCritico=0;

        probabilidadEvadirAtaque=0;
        experiencia=0;
    }

    public Persona(String nombre, double vida, double defensa, double dañoBase, double dañoCritico, double probabilidadCritico, double probabilidadEvadirAtaque, double experiencia) {
        this.nombre=nombre;
        this.vida=vida;
        this.defensa=defensa;
        this.dañoBase=dañoBase;
        this.dañoCritico=dañoCritico;
        this.probabilidadCritico=probabilidadCritico;

        this.probabilidadEvadirAtaque=probabilidadEvadirAtaque;
        this.experiencia=experiencia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getVida() {
        return vida;
    }

    public void setVida(double vida) {
        this.vida = vida;
    }

    public double getDefensa() {
        return defensa;
    }

    public void setDefensa(double defensa) {
        this.defensa = defensa;
    }

    public double getDañoBase() {
        return dañoBase;
    }

    public void setDañoBase(double dañoBase) {
        this.dañoBase = dañoBase;
    }

    public double getDañoCritico() {
        return dañoCritico;
    }

    public void setDañoCritico(double dañoCritico) {
        this.dañoCritico = dañoCritico;
    }

    public double getProbabilidadCritico() {
        return probabilidadCritico;
    }

    public void setProbabilidadCritico(double probabilidadCritico) {
        this.probabilidadCritico = probabilidadCritico;
    }

    public double getProbabilidadEvadirAtaque() {
        return probabilidadEvadirAtaque;
    }

    public void setProbabilidadEvadirAtaque(double probabilidadEvadirAtaque) {
        this.probabilidadEvadirAtaque = probabilidadEvadirAtaque;
    }

    public double getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(double experiencia) {
        this.experiencia = experiencia;
    }
}
