
package dto;

import java.util.Date;

/**
 *
 * @author maudy
 */
public class HabitacionDTO {
     private int id_habitacion;
    private String tipo;
    private Double precio;
    private int capacidad;
    private String estado;
    

    public HabitacionDTO(int id_habitacion, String tipo, Double precio, int capacidad, String estado) {
        this.id_habitacion = id_habitacion;
        this.tipo = tipo;
        this.precio = precio;
        this.capacidad = capacidad;
        this.estado = estado;
    }

    public int getId_habitacion() {
        return id_habitacion;
    }

    public void setId_habitacion(int id_habitacion) {
        this.id_habitacion = id_habitacion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

   
}
