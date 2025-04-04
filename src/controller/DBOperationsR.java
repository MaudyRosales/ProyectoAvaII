
package controller;

import java.util.List;

/**
 *
 * @author maudy
 */
public interface DBOperationsR {
    public List<Object> getAll();
    public Object getById(int id_reserva);
    public boolean insert(Object object);
    public boolean update(Object object);
    public boolean delete(int id_reserva);
}
