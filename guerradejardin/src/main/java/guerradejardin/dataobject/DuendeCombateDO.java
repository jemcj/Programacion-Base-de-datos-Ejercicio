package guerradejardin.dataobject;

public class DuendeCombateDO {
    
    private int id;
    private String nombre; 
    private String apodoGuerra;
    private String modelo;
    private int agilidad;
    private int nivelSarcasmo;
    private int horasSombra;
    private int tiempoBrilloCegador;
    private int HadaMadrina_id;
    private int CaracolGigante_id;

    public DuendeCombateDO(int id, String nombre, String apodoGuerra, String modelo, int agilidad,  int nivelSarcasmo, int horasSombra, int tiempoBrilloCegador, int HadaMadrina_id, int CaracolGigante_id) {
        this.id = id;
        this.nombre = nombre;
        this.apodoGuerra = apodoGuerra;
        this.modelo = modelo;
        this.agilidad = agilidad;
        this.nivelSarcasmo = nivelSarcasmo;
        this.horasSombra = horasSombra;
        this.tiempoBrilloCegador = tiempoBrilloCegador;
        this.HadaMadrina_id = HadaMadrina_id;
        this.CaracolGigante_id = CaracolGigante_id;
    }

    public DuendeCombateDO() {
        this.id = 0;
        this.nombre = "";
        this.apodoGuerra = "";
        this.modelo = "";
        this.agilidad = 0;
        this.nivelSarcasmo = 0;
        this.horasSombra = 0;
        this.tiempoBrilloCegador = 0;
        this.HadaMadrina_id = 0;
        this.CaracolGigante_id = 0;
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

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAgilidad() {
        return agilidad;
    }

    public void setAgilidad(int agilidad) {
        this.agilidad = agilidad;
    }

    public int getNivelSarcasmo() {
        return nivelSarcasmo;
    }

    public void setNivelSarcasmo(int nivelSarcasmo) {
        this.nivelSarcasmo = nivelSarcasmo;
    }

    public int getHorasSombra() {
        return horasSombra;
    }

    public void setHorasSombra(int horasSombra) {
        this.horasSombra = horasSombra;
    }

    public int getTiempoBrilloCegador() {
        return tiempoBrilloCegador;
    }

    public void setTiempoBrilloCegador(int tiempoBrilloCegador) {
        this.tiempoBrilloCegador = tiempoBrilloCegador;
    }

    public int getHadaMadrina_id() {
        return HadaMadrina_id;
    }

    public void setHadaMadrina_id(int hadaMadrina_id) {
        HadaMadrina_id = hadaMadrina_id;
    }

    public int getCaracolGigante_id() {
        return CaracolGigante_id;
    }

    public void setCaracolGigante_id(int caracolGigante_id) {
        CaracolGigante_id = caracolGigante_id;
    }

    @Override
    public String toString() {
        String string = "ID: " + getId() + "\n";
        string += "Nombre: " + getNombre() + "\n";
        string += "Apodo: " + getApodoGuerra() + "\n";
        string += "Modelo: " + getModelo() + "\n";
        string += "Agilidad: " + getAgilidad() + "\n";
        string += "Nivel de Sarcasmo: " + getNivelSarcasmo() + "\n";
        string += "Horas de Sombra: " + getHorasSombra() + "\n";
        string += "Tiempo de Brillo Cegador: " + getTiempoBrilloCegador();
        return string;
    }

}
