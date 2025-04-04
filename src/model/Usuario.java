
package model;


public class Usuario {
    
   private int id_usuario;
   private String usuario_nombre;
   private String usuario_clave;
   private int usuario_estado;

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getUsuario_nombre() {
        return usuario_nombre;
    }

    public void setUsuario_nombre(String usuario_nombre) {
        this.usuario_nombre = usuario_nombre;
    }

    public String getUsuario_clave() {
        return usuario_clave;
    }

    public void setUsuario_clave(String usuario_clave) {
        this.usuario_clave = usuario_clave;
    }

    public int getUsuario_estado() {
        return usuario_estado;
    }

    public void setUsuario_estado(int usuario_estado) {
        this.usuario_estado = usuario_estado;
    }
   
   
    
}
