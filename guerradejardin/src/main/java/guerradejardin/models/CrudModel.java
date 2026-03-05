package guerradejardin.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class CrudModel {
    
    protected Connection con;
    protected String table;
    protected List<String> columns;

    public int count(){
        String query = "SELECT COUNT(*) FROM " + table;

        try (PreparedStatement stmt = this.con.prepareStatement(query)){
            try (ResultSet rs = stmt.executeQuery()){
                if (rs.next()) {
                    rs.getInt(1);
                } else {
                    // Si no hay 
                }
            }
            
        }
        catch(SQLException e){
            //ERROR
        }

        
    }

}
