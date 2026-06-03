package guerradejardin.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import guerradejardin.DO.GnomoAncianoDO;
import guerradejardin.DO.TopoCombateDO;
import guerradejardin.model.CrudModel;
import guerradejardin.utils.Db;

public class GnomoAncianoDAO extends CrudModel {
    
    private Connection con;
    private String table;
    private List<String> columns;


    public GnomoAncianoDAO() {
        this.con = Db.conectar();
        this.table = "GnomoAnciano";
        this.columns = Arrays.asList("nombre", "apodoGuerra", "edad", "alturaBarba", "nivelCascarrabias", "energiaRefunfuno");
    }

    public List<Map<String, Object>> filtrar (String campo, Object valor){

        String query = "SELECT * FROM " + table + " WHERE " + campo + " = ?;";

        List<Map<String, Object>> lista = new ArrayList<>();

        try (PreparedStatement stmt = con.prepareStatement(query)) {

            stmt.setObject(1, valor);

            try (ResultSet rs = stmt.executeQuery()) {

                while (rs.next()){

                    Map<String, Object> fila = new HashMap<>();

                    fila.put("id", rs.getObject("id"));

                    for (String col : columns){
                        fila.put(col, rs.getObject(col));
                    }

                    lista.add(fila);

                }
            }

        } catch (SQLException e) {
            System.out.println("ERROR\n");
            e.printStackTrace();
        }

        return lista;

    }

    public List<Map<String, Object>> buscar (String campo, String comparador, String texto){

        String query = "SELECT * FROM " + table + " WHERE " + campo + " " + comparador + " ?";

        List<Map<String, Object>> lista = new ArrayList<>();

        try (PreparedStatement stmt = con.prepareStatement(query)) {

            stmt.setObject(1, texto);

            try (ResultSet rs = stmt.executeQuery()) {

                while (rs.next()) {

                    Map<String, Object> fila = new HashMap<>();

                    fila.put("id", rs.getObject("id"));

                    for (String col : columns) {
                        fila.put(col, rs.getObject(col));
                    }

                    lista.add(fila);

                }

            }

        } catch (SQLException e) {
            System.out.println("ERROR\n");
            e.printStackTrace();
        }

        return lista;

    }

    public ArrayList<TopoCombateDO> cargarTopos(int idGnomo){

        String query = "SELECT * FROM TopoCombate WHERE GnomoAnciano_id = ?;";

        ArrayList<TopoCombateDO> toposIDGnomo = new ArrayList<>();

        try (PreparedStatement stmt = con.prepareStatement(query)) {

            stmt.setInt(1, idGnomo);

            try (ResultSet rs = stmt.executeQuery()){

                while (rs.next()){

                    TopoCombateDO topo = new TopoCombateDO();
                    topo.setId(rs.getInt("id"));
                    topo.setNombre(rs.getString("nombre"));
                    topo.setApodoGuerra(rs.getString("apodoGuerra"));
                    topo.setModelo(rs.getString("modelo"));
                    topo.setFuerzaExcavacion(rs.getInt("fuerzaExcavacion"));
                    topo.setAgudezaOlfativa(rs.getString("agudezaOlfativa"));
                    topo.setHorasSueno(rs.getInt("horasSueno"));
                    topo.setTiempoTierraEnOjos(rs.getInt("tiempoTierraEnOjos"));
                    topo.setGnomoAnciano_id(rs.getInt("GnomoAnciano_id"));
                    topo.setCaracolGigante_id(rs.getInt("CaracolGigante_id"));

                    toposIDGnomo.add(topo);

                }

            }
            
        } catch (SQLException e) {
            System.out.println("ERROR\n");
            e.printStackTrace();
        }

        return toposIDGnomo;

    }

    public int calcularEnergiaRefunfugnoTotal(){

        int energiaTotal = -1;

        String query = "SELECT SUM(energiaRefunfuno) AS suma FROM GnomoAnciano WHERE nivelCascarrabias > 5";

        try (PreparedStatement stmt = con.prepareStatement(query)) {

            try (ResultSet rs = stmt.executeQuery(query)){

                while (rs.next()) {
                    energiaTotal = rs.getInt("suma");
                }

            }
            
            
        } catch (SQLException e) {
            System.out.println("ERROR\n");
            e.printStackTrace();
        }

        return energiaTotal;

    }
    // ORDER BY nivelCascarrabias DESC

    public GnomoAncianoDO obtenerGnomoMasCascarrabias(){

        String query = "SELECT * FROM GnomoAnciano";

        GnomoAncianoDO gnomoCascarrabias = new GnomoAncianoDO();
        ArrayList<GnomoAncianoDO> gnomos = new ArrayList<>();
        

        try (PreparedStatement stmt = con.prepareStatement(query)) {

            try (ResultSet rs = stmt.executeQuery(query)){

                while (rs.next()){
                    GnomoAncianoDO gnomo = new GnomoAncianoDO();
                    gnomo.setId(rs.getInt("id"));
                    gnomo.setNombre(rs.getString("nombre"));
                    gnomo.setApodoGuerra(rs.getString("apodoGuerra"));
                    gnomo.setEdad(rs.getInt("edad"));
                    gnomo.setAlturaBarba(rs.getDouble("alturaBarba"));
                    gnomo.setNivelCascarrabias(rs.getInt("nivelCascarrabias"));
                    gnomo.setEnergiaRefunfuno(rs.getInt("energiaRefunfuno"));

                    gnomos.add(gnomo);
                }

                int nivel = 0;
                int maximo = 0;

                for (GnomoAncianoDO gnomoAnciano : gnomos) {

                    nivel = gnomoAnciano.getNivelCascarrabias();

                    if (nivel > maximo){

                        maximo = nivel;

                        gnomoCascarrabias = gnomoAnciano;

                    }

                }

            }
            
            
        } catch (SQLException e) {
            System.out.println("ERROR\n");
            e.printStackTrace();
        }

        return gnomoCascarrabias;

    }

    public String generarInformeGnomos(){

        String query = "SELECT * FROM GnomoAnciano";
        int totalGnomos = 0;
        int totalEnergia = 0;

        StringBuilder informeSB = new StringBuilder();

        ArrayList<GnomoAncianoDO> gnomos = new ArrayList<>();

        try (PreparedStatement stmt = con.prepareStatement(query)) {

            try (ResultSet rs = stmt.executeQuery()){

                while (rs.next()){
                    GnomoAncianoDO gnomo = new GnomoAncianoDO();
                    gnomo.setId(rs.getInt("id"));
                    gnomo.setNombre(rs.getString("nombre"));
                    gnomo.setApodoGuerra(rs.getString("apodoGuerra"));
                    gnomo.setEdad(rs.getInt("edad"));
                    gnomo.setAlturaBarba(rs.getDouble("alturaBarba"));
                    gnomo.setNivelCascarrabias(rs.getInt("nivelCascarrabias"));
                    gnomo.setEnergiaRefunfuno(rs.getInt("energiaRefunfuno"));

                    gnomos.add(gnomo);
                }

                int nomo = 1;

                for (GnomoAncianoDO gnomo : gnomos) {
                    
                    informeSB.append(nomo + ". [" + gnomo.getNombre() + "] - Apodo: [" + gnomo.getApodoGuerra() + "] - Energia: [" + gnomo.getEnergiaRefunfuno() + "]\n");
                    nomo += 1;
                    totalGnomos += 1;
                    totalEnergia += gnomo.getEnergiaRefunfuno();

                }

            }
            
            
        } catch (SQLException e) {
            System.out.println("ERROR\n");
            e.printStackTrace();
        }

        StringBuilder informefinal = new StringBuilder();
        informefinal.append("=== INFORME DE GNOMOS ANCIANOS ===\nTotal: " + totalGnomos + " gnomos\n--------------------\n");
        informefinal.append(informeSB);
        informefinal.append("--------------------\nEnergia total del ejercito: " + totalEnergia);
        return informefinal.toString();

    }

}
