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

import guerradejardin.DO.DuendeCombateDO;
import guerradejardin.DO.HadaMadrinaDO;
import guerradejardin.model.CrudModel;
import guerradejardin.utils.Db;

public class HadaMadrinaDAO extends CrudModel {
    
    private Connection con;
    private String table;
    private List<String> colums;

    public HadaMadrinaDAO () {
        this.con = Db.conectar();
        this.table = "HadaMadrina";
        this.colums = Arrays.asList("nombre" , "apodoGuerra" , "edad" , "envergaduraAlas" , "nivelPasivoAgresividad" , "polvoPurpurina");
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

                        for (String col : colums) {
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

        String query = "SELECT * FROM " + table + " WHERE " + campo + " " + comparador + " ?";

        List<Map<String, Object>> lista = new ArrayList<>();

        try (PreparedStatement stmt = con.prepareStatement(query)) {

            stmt.setObject(1, texto);

            try (ResultSet rs = stmt.executeQuery()) {

                while (rs.next()) {

                    Map<String, Object> fila = new HashMap<>();

                    fila.put("id", rs.getObject("id"));

                    for (String col : colums) {
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

    public ArrayList<DuendeCombateDO> cargarDuendes(int idHada) {

        String query = "SELECT * FROM DuendeCombate WHERE HadaMadrina_id = ?";

        ArrayList<DuendeCombateDO> duendes =  new ArrayList<>();

        try (PreparedStatement stmt = con.prepareStatement(query)) {

            stmt.setInt(1, idHada);

            try (ResultSet rs = stmt.executeQuery()) {

                while (rs.next()) {

                    DuendeCombateDO duende = new DuendeCombateDO();
                    duende.setId(rs.getInt("id"));
                    duende.setNombre(rs.getString("nombre"));
                    duende.setApodoGuerra(rs.getString("apodoGuerra"));
                    duende.setModelo(rs.getString("modelo"));
                    duende.setAgilidad(rs.getInt("agilidad"));
                    duende.setNivelSarcasmo(rs.getInt("nivelSarcasmo"));
                    duende.setHorasSombra(rs.getInt("horasSombra"));
                    duende.setTiempoBrilloCegador(rs.getInt("tiempoBrilloCegador"));
                    duende.setHadaMadrina_id(rs.getInt("HadaMadrina_id"));
                    duende.setCaracolGigante_id(rs.getInt("CaracolGigante_id"));
                    duendes.add(duende);
                    
                }

            }
            
        } catch (SQLException e) {
            System.out.println("ERROR\n");
            e.printStackTrace();
        }

        return duendes;

    }

    public double calcularPolvoPurpurinaTotal() {

        String query = "SELECT * FROM HadaMadrina WHERE nivelPasivoAgresividad > 3";

        double polvoPurpurinaTotal = 0;

        try (PreparedStatement stmt = con.prepareStatement(query)) {

            try (ResultSet rs = stmt.executeQuery()) {

                while (rs.next()) {

                    polvoPurpurinaTotal += rs.getDouble("polvoPurpurina");
                    
                }

            }
            
        } catch (SQLException e) {
            System.out.println("ERROR\n");
            e.printStackTrace();
        }

        return polvoPurpurinaTotal;

    }

    public HadaMadrinaDO obtenerHadaMasVeterana(){

        String query = "SELECT * FROM HadaMadrina ORDER BY edad DESC LIMIT 1";

        HadaMadrinaDO hada = new HadaMadrinaDO();

        try (PreparedStatement stmt = con.prepareStatement(query)) {

            try (ResultSet rs = stmt.executeQuery()) {

                while (rs.next()) {

                    hada.setId(rs.getInt("id"));
                    hada.setNombre(rs.getString("nombre"));
                    hada.setApodoGuerra(rs.getString("apodoGuerra"));
                    hada.setEdad(rs.getInt("edad"));
                    hada.setEnvergaduraAlas(rs.getString("envergaduraAlas"));
                    hada.setNivelPasivoAgresividad(rs.getInt("nivelPasivoAgresividad"));
                    hada.setPolvoPurpurina(rs.getDouble("polvoPurpurina"));
                    
                }

            }
            
        } catch (SQLException e) {
            System.out.println("ERROR\n");
            e.printStackTrace();
        }

        return hada;

    }

    public ArrayList<HadaMadrinaDO> cargarHadasConAlasPequeñas(double envergaduraMaxima){

        String query = "SELECT * FROM HadaMadrina WHERE envergaduraAlas < ?";

        ArrayList<HadaMadrinaDO> hadasValidas = new ArrayList<>();

        try (PreparedStatement stmt = con.prepareStatement(query)) {

            stmt.setDouble(1, envergaduraMaxima);

            try (ResultSet rs = stmt.executeQuery()) {

                while (rs.next()) {

                    HadaMadrinaDO hada = new HadaMadrinaDO();
                    hada.setId(rs.getInt("id"));
                    hada.setNombre(rs.getString("nombre"));
                    hada.setApodoGuerra(rs.getString("apodoGuerra"));
                    hada.setEdad(rs.getInt("edad"));
                    hada.setEnvergaduraAlas(rs.getString("envergaduraAlas"));
                    hada.setNivelPasivoAgresividad(rs.getInt("nivelPasivoAgresividad"));
                    hada.setPolvoPurpurina(rs.getDouble("polvoPurpurina"));
                    hadasValidas.add(hada);
                    
                }

            }
            
        } catch (SQLException e) {
            System.out.println("ERROR\n");
            e.printStackTrace();
        }

        return hadasValidas;

    }


}
