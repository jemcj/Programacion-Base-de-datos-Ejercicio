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

import guerradejardin.DO.TopoCombateDO;
import guerradejardin.model.CrudModel;
import guerradejardin.utils.Db;

public class TopoCombateDAO extends CrudModel {
    
    private Connection con;
    private String table;
    private List<String> columns;

    public TopoCombateDAO () {
        this.con = Db.conectar();
        this.table = "TopoCombate";
        this.columns = Arrays.asList("nombre" ,"apodoGuerra" ,"modelo" ,"fuerzaExcavacion" ,"agudezaOlfativa" ,"horasSueno" ,"tiempoTierraEnOjos");
    }

    public List<Map<String, Object>> filtrar (String campo, Object valor){

        String query = "SELECT * FROM " + table + " WHERE " + campo + " = ?";

        List<Map<String, Object>> lista = new ArrayList<>();

        try (PreparedStatement stmt = con.prepareStatement(query)) {
            
            stmt.setObject(1, valor);

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
        } catch (Exception e) {
            System.out.println("ERROR\n");
            e.printStackTrace();
        }

        return lista;

    }

    public List<Map<String, Object>> buscar (String campo, String comparador, String texto){

        String query = "SELECT * FROM " + table + " WHERE " + campo + " " + comparador + " = ?";

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

    public ArrayList<TopoCombateDO> cargarToposConTierraEnOjos(int idGnomo){

        String query = "SELECT * FROM TopoCombate WHERE tiempoTierraEnOjos > 0 AND GnomoAnciano_id = ?";

        ArrayList<TopoCombateDO> toposValidos = new ArrayList<>();

        try (PreparedStatement stmt = con.prepareStatement(query)) {

            stmt.setInt(1, idGnomo);

            try (ResultSet rs = stmt.executeQuery()) {

                while (rs.next()) {

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

                    toposValidos.add(topo);
                    
                }

            }
            
        } catch (SQLException e) {
            System.out.println("ERROR\n");
            e.printStackTrace();
        }

        return toposValidos;

    }

    public ArrayList<TopoCombateDO> cargarToposDescansados(){

        String query = "SELECT * FROM TopoCombate";

        ArrayList<TopoCombateDO> toposValidos = new ArrayList<>();

        try (PreparedStatement stmt = con.prepareStatement(query)) {

            try (ResultSet rs = stmt.executeQuery()) {

                while (rs.next()) {

                    if (rs.getInt("horasSueno") >= 8) {

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

                        toposValidos.add(topo);
                        
                    }
                    
                }

            }
            
        } catch (SQLException e) {
            System.out.println("ERROR\n");
            e.printStackTrace();
        }

        return toposValidos;

    }

    public double calcularPromedioFuerzaExcavacion(int idGnomo){

        double fuerzaPromedio = 0;

        String query = "SELECT fuerzaExcavacion FROM TopoCombate WHERE GnomoAnciano_id = ?";

        double contador = 0;
        double fuerzaSumada = 0;

        try (PreparedStatement stmt = con.prepareStatement(query)) {

            stmt.setInt(1, idGnomo);

            try (ResultSet rs = stmt.executeQuery()) {

                while (rs.next()) {
                    contador += 1;
                    fuerzaSumada += rs.getInt("fuerzaExcavacion");
                }

            }
            
        } catch (SQLException e) {
            System.out.println("ERROR\n");
            e.printStackTrace();
        }

        fuerzaPromedio = fuerzaSumada / contador;
        return fuerzaPromedio;

    }

    public ArrayList<TopoCombateDO> cargarToposPaginando(int numElem, int numPag){

        String query = "SELECT * FROM TopoCombate LIMIT ? OFFSET ?;";

        ArrayList<TopoCombateDO> topos = new ArrayList<>();

        try (PreparedStatement stmt = con.prepareStatement(query)) {

            stmt.setInt(1, numElem);
            stmt.setInt(2, ((numPag - 1) * numElem));

            try (ResultSet rs = stmt.executeQuery()) {

                while (rs.next()) {

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

                    topos.add(topo);
                    
                }

            }
            
        } catch (SQLException e) {
            System.out.println("ERROR\n");
            e.printStackTrace();
        }

        return topos;
        
    }

}
