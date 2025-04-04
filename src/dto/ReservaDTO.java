
package dto;
import java.util.Date;
/**
 *
 * @author maudy
 */
public class ReservaDTO {
    private int id_reserva;
    private int id_huesped;
    private int id_habitacion;
    private Date fecha_entrada;
    private Date fecha_salida;
    private String estado;

    public ReservaDTO(int id_reserva, int id_huesped, int id_habitacion, Date fecha_entrada, Date fecha_salida, String estado) {
        this.id_reserva = id_reserva;
        this.id_huesped = id_huesped;
        this.id_habitacion = id_habitacion;
        this.fecha_entrada = fecha_entrada;
        this.fecha_salida = fecha_salida;
        this.estado = estado;
    }

    public int getId_reserva() {
        return id_reserva;
    }

    public void setId_reserva(int id_reserva) {
        this.id_reserva = id_reserva;
    }

    public int getId_huesped() {
        return id_huesped;
    }

    public void setId_huesped(int id_huesped) {
        this.id_huesped = id_huesped;
    }

    public int getId_habitacion() {
        return id_habitacion;
    }

    public void setId_habitacion(int id_habitacion) {
        this.id_habitacion = id_habitacion;
    }

    public Date getFecha_entrada() {
        return fecha_entrada;
    }

    public void setFecha_entrada(Date fecha_entrada) {
        this.fecha_entrada = fecha_entrada;
    }

    public Date getFecha_salida() {
        return fecha_salida;
    }

    public void setFecha_salida(Date fecha_salida) {
        this.fecha_salida = fecha_salida;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    
}
