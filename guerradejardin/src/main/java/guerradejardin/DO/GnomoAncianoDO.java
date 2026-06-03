package guerradejardin.DO;

public class GnomoAncianoDO {
    
    private int id;
    private String nombre;
    private String apodoGuerra;
    private int edad;
    private Double alturaBarba;
    private int nivelCascarrabias;
    private int energiaRefunfuno;

    public GnomoAncianoDO(int id, String nombre, String apodoGuerra, int edad, Double alturaBarba, int nivelCascarrabias, int energiaRefunfuno) {
        this.id = id;
        this.nombre = nombre;
        this.apodoGuerra = apodoGuerra;
        this.edad = edad;
        this.alturaBarba = alturaBarba;
        this.nivelCascarrabias = nivelCascarrabias;
        this.energiaRefunfuno = energiaRefunfuno;
    }

    public GnomoAncianoDO() {
        this.id = 0;
        this.nombre = "";
        this.apodoGuerra = "";
        this.edad = 0;
        this.alturaBarba = 0.0;
        this.nivelCascarrabias = 0;
        this.energiaRefunfuno = 0;
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

    public Double getAlturaBarba() {
        return alturaBarba;
    }

    public void setAlturaBarba(Double alturaBarba) {
        this.alturaBarba = alturaBarba;
    }

    public int getNivelCascarrabias() {
        return nivelCascarrabias;
    }

    public void setNivelCascarrabias(int nivelCascarrabias) {
        this.nivelCascarrabias = nivelCascarrabias;
    }

    public int getEnergiaRefunfuno() {
        return energiaRefunfuno;
    }

    public void setEnergiaRefunfuno(int energiaRefunfuno) {
        this.energiaRefunfuno = energiaRefunfuno;
    }

    @Override
    public String toString() {
        String string = "ID: " + getId() + "\n";
        string += "Nombre: " + getNombre() + "\n";
        string += "Apodo: " + getApodoGuerra() + "\n";
        string += "Edad: " + getEdad() + "\n";
        string += "Altura de la barba: " + getAlturaBarba() + "\n";
        string += "Nivel de Cascarrabias: " + getNivelCascarrabias() + "\n";
        string += "Energia de Refunfuño: " + getEnergiaRefunfuno();
        return string;
    }

}
