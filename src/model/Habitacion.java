
package model;

import java.util.Date;
import java.util.Objects;
/**
 *
 * @author maudy
 */
public class Habitacion {
    private int id_habitacion;
    private String tipo;
    private Double precio;
    private int capacidad;
    private String estado;
    
    public Habitacion() {
    }
    
    public Habitacion(int id_habitacion, String tipo, Double precio, int capacidad, String estado) {
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
        final Habitacion other = (Habitacion) obj;
        
        if (this.id_habitacion != other.id_habitacion) {
            return false;
        }
        if (this.tipo != other.tipo) {
            return false;
        }
        if(this.precio != other.precio){
            return false;
        }
        if(this.estado != other.estado){
            return false;
        }
        
        return Objects.equals(this.tipo, other.tipo);
    }
    
}
