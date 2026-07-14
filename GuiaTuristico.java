package model;

public class GuiaTuristico implements Registrable {
    private String nombre;
    private String idioma;

    public GuiaTuristico(String nombre, String idioma) {
        this.nombre = nombre;
        this.idioma = idioma;
    }

    public String getNombre() { return nombre; }
    public String getIdioma() { return idioma; }

    @Override
    public String mostrarResumen() {
        return "Guía Turístico: " + nombre + " (Idioma: " + idioma + ")";
    }
}
