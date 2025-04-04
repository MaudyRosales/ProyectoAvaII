
package controller;

import java.util.ArrayList;
import java.util.List;
import model.Usuario;
import java.sql.*;
import bd.connectionDB;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;





public class LoginDAO implements DBOperations {

    @Override
    public List<Object> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public Object getById(int id_usuario) {
        Usuario usuario = new Usuario();
        String sql = "SELECT * FROM usuarios WHERE id_usuario = ?";
        try (Connection con = connectionDB.getConnection()) {
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setInt(1, id_usuario);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) { 
            usuario.setId_usuario(rs.getInt("id_usuario"));  
            usuario.setUsuario_nombre(rs.getString("usuario_nombre")); 
            usuario.setUsuario_clave(rs.getString("usuario_clave")); 
            usuario.setUsuario_estado(rs.getInt("usuario_estado"));
        }
        }catch(SQLException e) {
            System.err.println("Error al obtener el usuario: " + e.getMessage());
        }
        return usuario;

        }

    @Override
    public boolean insert(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public boolean update(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public boolean delete(int id_huesped) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    
   
    public Usuario getByUsernameAndPassword(String usuario_nombre, String usuario_clave) {
       Usuario usuario = null;
        String sql = "SELECT * FROM usuarios WHERE usuario_nombre = ?";
        
        try (Connection con = connectionDB.getConnection()) {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, usuario_nombre);  // Establecer el nombre de usuario
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String storedPasswordHash = rs.getString("usuario_clave");

                String hashedInputPassword = hashPassword(usuario_clave);
                if (storedPasswordHash.equals(hashedInputPassword)) {
                    usuario = new Usuario();
                    usuario.setId_usuario(rs.getInt("id_usuario"));
                    usuario.setUsuario_nombre(rs.getString("usuario_nombre"));
                    usuario.setUsuario_clave(rs.getString("usuario_clave"));
                    usuario.setUsuario_estado(rs.getInt("usuario_estado"));
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener el usuario: " + e.getMessage());
        }

        return usuario;  
    }
    
    private String hashPassword(String password) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] encodedHash = digest.digest(password.getBytes());
            StringBuilder hexString = new StringBuilder();
            for (byte b : encodedHash) {
                hexString.append(String.format("%02x", b));
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            System.err.println("Error al generar el hash SHA-256: " + e.getMessage());
            return null;
        }
    }
    
    public void updatePasswordToSHA256(int id_usuario) {
        String sqlSelect = "SELECT usuario_clave FROM usuarios WHERE id_usuario = ?";
        String sqlUpdate = "UPDATE usuarios SET usuario_clave = ? WHERE id_usuario = ?";
        
        try (Connection con = connectionDB.getConnection()) {
            // Obtener la contraseña en texto plano del usuario
            PreparedStatement stmtSelect = con.prepareStatement(sqlSelect);
            stmtSelect.setInt(1, id_usuario);  // Establecer el ID del usuario a actualizar
            ResultSet rs = stmtSelect.executeQuery();
            
            if (rs.next()) {
                String plainPassword = rs.getString("usuario_clave");  // Contraseña en texto plano
                
                // Generar el hash SHA-256 de la contraseña
                String hashedPassword = hashPassword(plainPassword);
                
                // Si el hash es válido, actualizar la contraseña en la base de datos
                if (hashedPassword != null) {
                    PreparedStatement stmtUpdate = con.prepareStatement(sqlUpdate);
                    stmtUpdate.setString(1, hashedPassword);  // El hash de la nueva contraseña
                    stmtUpdate.setInt(2, id_usuario);  // ID del usuario cuya contraseña se va a actualizar
                    int rowsUpdated = stmtUpdate.executeUpdate();

                    if (rowsUpdated > 0) {
                        System.out.println("La contraseña del usuario con ID " + id_usuario + " se actualizó correctamente.");
                    } else {
                        System.out.println("No se encontró el usuario con ese ID.");
                    }
                } else {
                    System.out.println("Error al generar el hash de la contraseña.");
                }
            } else {
                System.out.println("No se encontró un usuario con ese ID.");
            }
        } catch (SQLException e) {
            System.err.println("Error al actualizar la contraseña: " + e.getMessage());
        }
    }
}
