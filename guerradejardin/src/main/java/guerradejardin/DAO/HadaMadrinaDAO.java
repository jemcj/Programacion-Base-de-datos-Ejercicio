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

    


}
