
package controller;
import java.util.ArrayList;
import java.util.List;
import model.Huesped;
import java.sql.*;
import bd.connectionDB;

/**
 *
 * @author maudy
 */
public class HuespedDAO implements DBOperations {
    
    @Override
    public List<Object> getAll(){
        List<Object> lista = new ArrayList<>();
        String sql = "SELECT * FROM huespedes";
        try (Connection con = connectionDB.getConnection()){
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                lista.add(new Huesped(
                        rs.getInt("id_huesped"),
                        rs.getString("nombre"),
                        rs.getString("email"),
                        rs.getInt("telefono"),
                        rs.getDate("fecha_registro")
                ));
            }           
        }catch(SQLException e){
            System.err.println("Error al listar huespedes: " + e.getMessage());
        }     
        return lista;
    }
    
   @Override
    public Object getById(int id_huesped) {
        Huesped huesped = new Huesped();
        String sql = "SELECT * FROM huespedes Where id_huesped = ?";
        try (Connection con = connectionDB.getConnection()){
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, id_huesped);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){                
                huesped.setId(rs.getInt("id_huesped"));
                huesped.setNombre(rs.getString("nombre"));
                huesped.setEmail(rs.getString("email"));
                huesped.setTelefono(rs.getInt("telefono"));  
                huesped.setFecha_registro(rs.getDate("fecha_registro"));
            }           
            
        }catch(SQLException e){
            System.err.println("Error al listar huespedes: " + e.getMessage());
        }     
        return huesped;
    }
    
    @Override
    public boolean insert(Object object){               
        Huesped huesped = (Huesped) object;
        String sql = "INSERT INTO huespedes (nombre, email, telefono, fecha_registro) VALUES (?, ?, ?, ?)" ;
        try (Connection con = connectionDB.getConnection()){
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, huesped.getNombre());
            pst.setString(2, huesped.getEmail());
            pst.setInt(3, huesped.getTelefono());
            pst.setDate(4, (Date) huesped.getFecha_registro());
            
            return pst.executeUpdate() > 0;
        }catch(SQLException e){
            System.err.println("Error al insertar huesped: " + e.getMessage());
            return false;
        }     
    }
    
    @Override
    public boolean update(Object object){ 
        Huesped huesped = (Huesped) object;
        String sql = "UPDATE huespedes SET nombre=?, email=?, telefono=?, fecha_registro=? WHERE id_huesped=?" ;
        try (Connection con = connectionDB.getConnection()){
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, huesped.getNombre());
            pst.setString(2, huesped.getEmail());
            pst.setInt(3, huesped.getTelefono());
            pst.setDate(4, (Date) huesped.getFecha_registro());
            pst.setInt(5, huesped.getId_huesped());
            
            return pst.executeUpdate() > 0;
        }catch(SQLException e){
            System.err.println("Error al actualizar huesped: " + e.getMessage());
            return false;
        }     
    }
    
    @Override
    public boolean delete(int id_huesped){
        String sql = "DELETE FROM huespedes WHERE id_huesped=?";
        try (Connection con = connectionDB.getConnection()){
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, id_huesped);            
            return pst.executeUpdate() > 0;
        }catch(SQLException e){
            System.err.println("Error al eliminar huesped: " + e.getMessage());
            return false;
        }     
    }
    
}
