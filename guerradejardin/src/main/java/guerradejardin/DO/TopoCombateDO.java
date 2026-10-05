package guerradejardin.DO;

public class TopoCombateDO {
    
    private int id;
    private String nombre;
    private String apodoGuerra;
    private String modelo;
    private int fuerzaExcavacion;
    private String agudezaOlfativa;
    private int horasSueno;
    private int tiempoTierraEnOjos;
    private int GnomoAnciano_id;
    private int CaracolGigante_id;

    public TopoCombateDO(int id, String nombre, String apodoGuerra, String modelo, int fuerzaExcavacion, String agudezaOlfativa, int horasSueno, int tiempoTierraEnOjos, int GnomoAnciano_id, int CaracolGigante_id) {
        this.id = id;
        this.nombre = nombre;
        this.apodoGuerra = apodoGuerra;
        this.modelo = modelo;
        this.fuerzaExcavacion = fuerzaExcavacion;
        this.agudezaOlfativa = agudezaOlfativa;
        this.horasSueno = horasSueno;
        this.tiempoTierraEnOjos = tiempoTierraEnOjos;
        this.GnomoAnciano_id = GnomoAnciano_id;
        this.CaracolGigante_id = CaracolGigante_id;
    }

    public TopoCombateDO() {
        this.id = 0;
        this.nombre = "";
        this.apodoGuerra = "";
        this.modelo = "";
        this.fuerzaExcavacion = 0;
        this.agudezaOlfativa = "";
        this.horasSueno = 0;
        this.tiempoTierraEnOjos = 0;
        this.GnomoAnciano_id = 0;
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

    public int getFuerzaExcavacion() {
        return fuerzaExcavacion;
    }

    public void setFuerzaExcavacion(int fuerzaExcavacion) {
        this.fuerzaExcavacion = fuerzaExcavacion;
    }

    public String getAgudezaOlfativa() {
        return agudezaOlfativa;
    }

    public void setAgudezaOlfativa(String agudezaOlfativa) {
        this.agudezaOlfativa = agudezaOlfativa;
    }

    public int getHorasSueno() {
        return horasSueno;
    }

    public void setHorasSueno(int horasSueno) {
        this.horasSueno = horasSueno;
    }

    public int getTiempoTierraEnOjos() {
        return tiempoTierraEnOjos;
    }

    public void setTiempoTierraEnOjos(int tiempoTierraEnOjos) {
        this.tiempoTierraEnOjos = tiempoTierraEnOjos;
    }

    public int getGnomoAnciano_id() {
        return GnomoAnciano_id;
    }

    public void setGnomoAnciano_id(int gnomoAnciano_id) {
        GnomoAnciano_id = gnomoAnciano_id;
    }

    public int getCaracolGigante_id() {
        return CaracolGigante_id;
    }

    public void setCaracolGigante_id(int caracolGigante_id) {
        CaracolGigante_id = caracolGigante_id;
    }

    /**
     * 
     * Devuelve una representación en cadena del los datos del topo de combate.
     * 
     */
    @Override
    public String toString() {
        String string = "ID: " + getId() + "\n";
        string += "Nombre: " + getNombre() + "\n";
        string += "Apodo: " + getApodoGuerra() + "\n";
        string += "Modelo: " + getModelo() + "\n";
        string += "Fuerza de excavación: " + getFuerzaExcavacion() + "\n";
        string += "Agudeza olfativa: " + getAgudezaOlfativa() + "\n";
        string += "Horas de Sueño: " + getHorasSueno() + "\n";
        string += "Tiempo de tierra en ojos: " + getTiempoTierraEnOjos();
        return string;
    }

}
