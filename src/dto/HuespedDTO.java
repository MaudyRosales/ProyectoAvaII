
package dto;

import java.util.Date;

/**
 *
 * @author maudy
 */
public class HuespedDTO {
    private int id_huesped;
    private String nombre;
    private String email;
    private int telefono;
    private Date fecha_registro;

    public HuespedDTO(int id_huesped, String nombre, String email, int telefono, Date fecha_registro) {
        this.id_huesped = id_huesped;
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
        this.fecha_registro = fecha_registro;
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
}
