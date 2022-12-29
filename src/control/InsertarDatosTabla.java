package control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class InsertarDatosTabla {
    public Connection connect() {
        String url = "jdbc:sqlite:KATA5.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public void insert(List<String> mails) {
        String sql = "INSERT INTO EMAIL(Mail) VALUES(?)";
        Connection conn = this.connect();
        if (conn == null) {
            System.out.println("Error al conectar a la base de datos");
            return;
        }
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            mails.forEach((i) -> {
                try {
                    pstmt.setString(1, i);
                    pstmt.executeUpdate();
                } catch (SQLException ex) {
                    Logger.getLogger(InsertarDatosTabla.class.getName()).log(Level.SEVERE, "Error al insertar el mail " + i + " en la base de datos", ex);
                }
            });
        } catch (SQLException e) {
            Logger.getLogger(InsertarDatosTabla.class.getName()).log(Level.SEVERE, "Error al conectarse a la base de datos", e);
        }
    }
}
