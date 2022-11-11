/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
        try (Connection conn = this.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
                mails.forEach((i) -> {
                    try {
                        pstmt.setString(1, i);
                        pstmt.executeUpdate();
                    } catch (SQLException ex) {
                        Logger.getLogger(InsertarDatosTabla.class.getName()).log(Level.SEVERE, null, ex);
                    }
                });
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
