
package bd;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import java.sql.Connection;
import java.sql.SQLException;
import bd.connectionDB;


/**
 *
 * @author maudy
 */
public class connectionDB {
    
    private static final String URL = "jdbc:mysql://localhost:3306/hotel_bd";
    private static final String USUARIO = "hotel_app";
    private static final String PASSWORD = "MauN1234567890+";
    
    private static HikariDataSource dataSource;
    
    static{
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(URL);
        config.setUsername(USUARIO);
        config.setPassword(PASSWORD);
        config.setMaximumPoolSize(10); //Máximo de conexiones simultáneas
        config.setMinimumIdle(5); //Mínimo de conexiones en espera
        config.setIdleTimeout(3000); //Tiempo máximo inactivo antes de cerrar la conexión
        config.setMaxLifetime(200000);//Tiempo máximo de vida de una conexión
        config.setConnectionTimeout(10000); //Timeout para obtener conexión 
        
        dataSource = new HikariDataSource(config);                
    }
    
    public static Connection getConnection() throws SQLException{
        return dataSource.getConnection();
    }
    
    public static void closePool(){
        if(dataSource != null){
            dataSource.close();
        }
    }   
}
