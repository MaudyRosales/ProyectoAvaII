
package model;

import java.util.Date;
import java.util.Objects;
/**
 *
 * @author maudy
 */
public class Huesped {
    private int id_huesped;
    private String nombre;
    private String email;
    private int telefono;
    private Date fecha_registro;
    
    public Huesped() {
    }
    
    public Huesped(int id_huesped, String nombre, String email, int telefono, Date fecha_registro) {
        this.id_huesped = id_huesped;
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
        this.fecha_registro = fecha_registro;
    }   

    public void setId(int id_huesped) {
        this.id_huesped = id_huesped;
    }
    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public Date getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(Date fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

    public int getId_huesped() {
        return id_huesped;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Huesped other = (Huesped) obj;
        
        if (this.id_huesped != other.id_huesped) {
            return false;
        }
        if (this.email != other.email) {
            return false;
        }
        if(this.telefono != other.telefono){
            return false;
        }
        if(this.fecha_registro != other.fecha_registro){
            return false;
        }
        
        return Objects.equals(this.nombre, other.nombre);
    }
    
}
