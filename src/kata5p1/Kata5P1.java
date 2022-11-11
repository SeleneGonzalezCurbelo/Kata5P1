package kata5p1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import static kata5p1.CrearTabla.createNewTable;

public class Kata5P1 {

    public static void main(String[] args) {
        createNewTable();
        
        /*InsertarDatosTabla idt = new InsertarDatosTabla();
        idt.insert(1, "Alberto", "García", "DIS");
        idt.insert(2, "María", "Montes", "DUI");
        idt.insert(3, "Luisa", "Cabello", "DMA");
        */
        connect(); 
        
        SelectApp app = new SelectApp();
        app.selectAll();
    }
    
    private static void connect() {
        Connection conn = null;
        try {
            // parámetros de la BD
            String url = "jdbc:sqlite:KATA5.db";
            // creamos una conexión a la BD
            conn = DriverManager.getConnection(url);
            System.out.println("Connexión a SQLite establecida");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}
