package guerradejardin.dataobject;

public class HadaMadrinaDO {
    
    private int id;
    private String nombre;
    private String apodoGuerra;
    private int edad;
    private String envergaduraAlas;
    private int nivelPasivoAgresividad;
    private Double polvoPurpurina;

    public HadaMadrinaDO(int id, String nombre, String apodoGuerra, int edad, String envergaduraAlas, int nivelPasivoAgresividad, Double polvoPurpurina) {
        this.id = id;
        this.nombre = nombre;
        this.apodoGuerra = apodoGuerra;
        this.edad = edad;
        this.envergaduraAlas = envergaduraAlas;
        this.nivelPasivoAgresividad = nivelPasivoAgresividad;
        this.polvoPurpurina = polvoPurpurina;
    }

    public HadaMadrinaDO() {
        this.id = 0;
        this.nombre = "";
        this.apodoGuerra = "";
        this.edad = 0;
        this.envergaduraAlas = "";
        this.nivelPasivoAgresividad = 0;
        this.polvoPurpurina = 0.0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApodoGuerra() {
        return apodoGuerra;
    }

    public void setApodoGuerra(String apodoGuerra) {
        this.apodoGuerra = apodoGuerra;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getEnvergaduraAlas() {
        return envergaduraAlas;
    }

    public void setEnvergaduraAlas(String envergaduraAlas) {
        this.envergaduraAlas = envergaduraAlas;
    }

    public int getNivelPasivoAgresividad() {
        return nivelPasivoAgresividad;
    }

    public void setNivelPasivoAgresividad(int nivelPasivoAgresividad) {
        this.nivelPasivoAgresividad = nivelPasivoAgresividad;
    }

    public Double getPolvoPurpurina() {
        return polvoPurpurina;
    }

    public void setPolvoPurpurina(Double polvoPurpurina) {
        this.polvoPurpurina = polvoPurpurina;
    }

    @Override
    public String toString() {
        String string = "ID: " + getId() + "\n";
        string += "Nombre: " + getNombre() + "\n";
        string += "Apodo: " + getApodoGuerra() + "\n";
        string += "Edad: " + getEdad() + "\n";
        string += "Envergadura de las alas: " + getEnvergaduraAlas() + "\n";
        string += "Nivel de pasivoagresividad: " + getNivelPasivoAgresividad() + "\n";
        string += "Polvo Purpurina: " + getPolvoPurpurina();
        return string;
    }

}
