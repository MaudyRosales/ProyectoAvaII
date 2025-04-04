
package controller;
import java.util.ArrayList;
import java.util.List;
import model.Habitacion;
import java.sql.*;
import bd.connectionDB;

/**
 *
 * @author maudy
 */
public class HabitacionDAO implements DBOperations {
    
    @Override
    public List<Object> getAll(){
        List<Object> lista = new ArrayList<>();
        String sql = "SELECT * FROM habitaciones";  // Consulta de todas las habitaciones
        try (Connection con = connectionDB.getConnection()) {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                lista.add(new Habitacion(
                        rs.getInt("id_habitacion"),
                        rs.getString("tipo"),
                        rs.getDouble("precio"),  // Usando BigDecimal para el precio
                        rs.getInt("capacidad"),
                        rs.getString("estado")
                ));
            }
        } catch (SQLException e) {
            System.err.println("Error al listar habitaciones: " + e.getMessage());
        }
        return lista;
    }
    
   @Override
    public Object getById(int id_habitacion) {
         Habitacion habitacion = null;
        String sql = "SELECT * FROM habitaciones WHERE id_habitacion = ?";
        try (Connection con = connectionDB.getConnection()) {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, id_habitacion);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                habitacion = new Habitacion(
                        rs.getInt("id_habitacion"),
                        rs.getString("tipo"),
                        rs.getDouble("precio"),
                        rs.getInt("capacidad"),
                        rs.getString("estado")
                );
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener habitación: " + e.getMessage());
        }
        return habitacion;
    }
    
    @Override
    public boolean insert(Object object){               
        Habitacion habitacion = (Habitacion) object;
        String sql = "INSERT INTO habitaciones (tipo, precio, capacidad, estado) VALUES (?, ?, ?, ?)";
        try (Connection con = connectionDB.getConnection()) {
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, habitacion.getTipo());
            pst.setDouble(2, habitacion.getPrecio()); 
            pst.setInt(3, habitacion.getCapacidad());
            pst.setString(4, habitacion.getEstado());

            return pst.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error al insertar habitación: " + e.getMessage());
            return false;
        }    
    }
    
    @Override
    public boolean update(Object object){ 
         Habitacion habitacion = (Habitacion) object;
        String sql = "UPDATE habitaciones SET tipo = ?, precio = ?, capacidad = ?, estado = ? WHERE id_habitacion = ?";
        try (Connection con = connectionDB.getConnection()) {
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, habitacion.getTipo());
            pst.setDouble(2, habitacion.getPrecio());  
            pst.setInt(3, habitacion.getCapacidad());
            pst.setString(4, habitacion.getEstado());
            pst.setInt(5, habitacion.getId_habitacion());

            return pst.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error al actualizar habitación: " + e.getMessage());
            return false;
        }
    }
    
    @Override
    public boolean delete(int id_habitacion){
       String sql = "DELETE FROM habitaciones WHERE id_habitacion = ?";
        try (Connection con = connectionDB.getConnection()) {
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, id_habitacion);

            return pst.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error al eliminar habitación: " + e.getMessage());
            return false;
        }
    }
    
}
