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

public class DuendeCombateDAO extends CrudModel {
    
    private Connection con;
    private String table;
    private List<String> columns;

    public DuendeCombateDAO(){
        this.con = Db.conectar();
        this.table = "DuendeCombate";
        this.columns = Arrays.asList("nombre", "apodoGuerra", "modelo", "agilidad", "nivelSarcasmo", "horasSombra", "tiempoBrilloCegador");
    }

    /**
     * 
     * Hace una query para seleccionar los registros de la tabla DuendeCombate segun un campo y un valor
     * Despues deveuenve una lista de mapas, que representa los registros de la tabla y contiene los valores de las columnas.
     * 
     */
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
        } catch (SQLException e) {
            System.out.println("ERROR\n");
            e.printStackTrace();
        }

        return lista;

    }

    /**    
     * 
     * Busca registros en la tabla DuendeCombate según un campo, un comparador y un texto.
     * 
     */
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


}
