package guerradejardin.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class CrudModel {
    
    protected Connection con;
    protected String table;
    protected List<String> columns;

    public int count(){
        String query = "SELECT COUNT(*) FROM " + table;
        int re = -1;

        try (PreparedStatement stmt = this.con.prepareStatement(query)){
            try (ResultSet rs = stmt.executeQuery()){
                if (rs.next()) {
                    re = rs.getInt(1);
                } else {
                    re = 0; 
                }
            }
            
        }
        catch(SQLException e){
            System.out.println("Error");

        }

        return re;
    }

    public List<Map<String, Object>> findAll(){
        String query = "SELECT * FROM " + table;
        List<Map<String, Object>> mapa = new ArrayList<>();

        try (Statement stmt = con.createStatement()){
            try(ResultSet rs = stmt.executeQuery(query)){
                while(rs.next()){
                    Map<String,Object> fila = new HashMap<>();
                    for (String col : columns) {
                        fila.put(col, rs.getObject(col));
                    }
                    mapa.add(fila);
                }
            }
        } catch(SQLException e){
            System.out.println("Error");
        }
        return mapa;
    }

    public Map<String, Object> findByID(Object id){
        String query = "SELECT * FROM " + table + "WHERE id = ?";
        Map<String, Object> res = new HashMap<>();

        try(PreparedStatement stmt = this.con.prepareStatement(query)){
            stmt.setObject(1, id);
            try(ResultSet rs = stmt.executeQuery()){
                if(rs.next()){
                    for (String col : columns) {
                        res.put(col, rs.getObject(col));
                    }
                } 
                return res;
            }
        } catch (SQLException e) {
            System.out.println("Error");
            return null;
        }
    }

    public List<Map<String, Object>> findAll(int page, int size){
        
        String query = "SELECT * FROM " + table + " OFFSET " + ((page - 1) * size) + " LIMIT " + size;
        List<Map<String, Object>> mapa = new ArrayList<>();

        try (Statement stmt = con.createStatement()){
            try(ResultSet rs = stmt.executeQuery(query)){
                while(rs.next()){
                    Map<String,Object> fila = new HashMap<>();
                    for (String col : columns) {
                        fila.put(col, rs.getObject(col));
                    }
                    mapa.add(fila);
                }
            }
        } catch(SQLException e){
            System.out.println("Error");
        }
        return mapa;
    }

    public boolean delete(Object id){
        String query = "DELETE FROM " + table + "WHERE id = ?";
        int filasAfectadas = 0;

        try(PreparedStatement stmt = this.con.prepareStatement(query)){
            stmt.setObject(1, id);
            filasAfectadas = stmt.executeUpdate();
        } catch (SQLException e){
            System.out.println("Error");
        }

        return (filasAfectadas != 0);
    }

    public boolean update(Object id, Map<String, Object> data){
        String query = "UPDATE " + table + "SET ";
        int filasAfectadas = 0;

        boolean coma = false;
        List<String> coluval = new ArrayList<>();
        for(int i=0; i<columns.size(); i++){
            if(!data.containsKey(columns.get(i))){
                continue;
            }
            if(coma == false){
                coma = true;
            } else {
                query += " , ";
            }

            query += " " + columns.get(i) + " = ? ";
            coluval.add(columns.get(i));
        }

        query += " WHERE id = ?";

        try(PreparedStatement stmt = this.con.prepareStatement(query)){
            for(int i = 1; i <=columns.size(); i++){
                stmt.setObject(i, data.get(coluval.get(i-1)));
            }
            stmt.setObject(coluval.size()+1, id);
            filasAfectadas = stmt.executeUpdate();
        } catch (SQLException e){
            System.out.println("Error");
        }

        return (filasAfectadas != 0);
    }

    public int insert(Map<String, Object> data){
        String query = "INSERT INTO " + table + "(";
        List<String> coluad = new ArrayList<>();

        try{
            boolean coma = false;
            for(int i=0; i<columns.size(); i++){
            if(!data.containsKey(columns.get(i))){
                continue;
            }
            if(coma == false){
                coma = true;
            } else {
                query += " , ";
            }

            query += " " + columns.get(i);
            coluad.add(columns.get(i));
            }
            if(coluad.isEmpty()){
                System.out.println("Error, no hay información o no es válida");
            }

            query += ") VALUES (";
            for(int i=0; i < coluad.size(); i++){
                if(i != 0){
                    query += ", ";
                }                
                query += "?";
            }
            query += ");";

        } catch (Exception e){
            System.out.println("Error");
        }

        int id = 0;

        try (PreparedStatement stmt = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)){
            for (int i = 1; i <= coluad.size(); i++){
                stmt.setObject(i, data.get(coluad.get(i-1)));
            }

            stmt.executeUpdate();

            try(ResultSet rs = stmt.getGeneratedKeys()){
                if (rs.next()){
                    id = rs.getInt(1);
                }
            }
        } catch (SQLException e){
            System.out.println("Error");
        }
        
        return id;
    }

    public abstract List<Map<String, Object>> filtrar (String campo, Object valor);
    public abstract List<Map<String, Object>> buscar (String campo, String comparador, String texto);
    

}
