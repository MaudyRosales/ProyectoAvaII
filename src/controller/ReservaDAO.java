
package controller;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import bd.connectionDB;
import model.Reserva;

/**
 *
 * @author maudy
 */
public class ReservaDAO implements DBOperationsR {
    
    @Override
    public List<Object> getAll(){
        List<Object> lista = new ArrayList<>();
        String sql = "SELECT * FROM reservas";
        try (Connection con = connectionDB.getConnection()){
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                lista.add(new Reserva(
                        rs.getInt("id_reserva"),
                        rs.getInt("id_huesped"),
                        rs.getInt("id_habitacion"),
                        rs.getDate("fecha_entrada"),
                        rs.getDate("fecha_salida"),
                        rs.getString("estado")
                ));
            }           
        }catch(SQLException e){
            System.err.println("Error al listar reservas: " + e.getMessage());
        }     
        return lista;
    }
    
    @Override
    public Object getById(int id_reserva) {
        Reserva reserva = new Reserva();
        String sql = "SELECT * FROM reservas Where id_reserva = ?";
        try (Connection con = connectionDB.getConnection()){
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, id_reserva);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){                
                reserva.setId_reserva(rs.getInt("id_reserva"));
                reserva.setId_huesped(rs.getInt("id_huesped"));
                reserva.setId_habitacion(rs.getInt("id_habitacion"));
                reserva.setFecha_entrada(rs.getDate("fecha_entrada"));
                reserva.setFecha_salida(rs.getDate("fecha_salida"));
                reserva.setEstado(rs.getString("estado"));
            }           
            
        }catch(SQLException e){
            System.err.println("Error al listar reservas: " + e.getMessage());
        }     
        return reserva;
    }
    @Override
    public boolean insert(Object object){               
        Reserva reserva = (Reserva) object;
        String sql = "INSERT INTO reservas (id_huesped, id_habitacion, fecha_entrada, fecha_salida, estado) VALUES (?, ?, ?, ?, ?)" ;
        try (Connection con = connectionDB.getConnection()){
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, reserva.getId_huesped());
            pst.setInt(2, reserva.getId_habitacion());
            pst.setDate(3, (Date) reserva.getFecha_entrada());
            pst.setDate(4, (Date) reserva.getFecha_salida());
            pst.setString(5, reserva.getEstado());
            
            return pst.executeUpdate() > 0;
        }catch(SQLException e){
            System.err.println("Error al insertar reserva: " + e.getMessage());
            return false;
        }     
    }
    @Override
    public boolean update(Object object){ 
        Reserva reserva = (Reserva) object;
        String sql = "UPDATE reservas SET id_huesped=?, id_habitacion=?, fecha_entrada=?, fecha_salida=?, estado=? WHERE id_reserva=?" ;
        try (Connection con = connectionDB.getConnection()){
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt( 1,reserva.getId_huesped());
            pst.setInt( 2,reserva.getId_habitacion());
            pst.setDate(3, (Date) reserva.getFecha_entrada());
            pst.setDate(4, (Date) reserva.getFecha_salida());
            pst.setString(5, reserva.getEstado());
            pst.setInt(6, reserva.getId_reserva());
            
            return pst.executeUpdate() > 0;
        }catch(SQLException e){
            System.err.println("Error al actualizar reserva: " + e.getMessage());
            return false;
        }     
    }
    @Override
    public boolean delete(int id_reserva){
        String sql = "DELETE FROM reservas WHERE id_reserva=?";
        try (Connection con = connectionDB.getConnection()){
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, id_reserva);            
            return pst.executeUpdate() > 0;
        }catch(SQLException e){
            System.err.println("Error al eliminar reserva: " + e.getMessage());
            return false;
        }     
    }
    
}
