package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import control.InsertarDatosTabla;
import java.util.List;
import view.MailListReader;

public class Kata5P1 {

    public static void main(String[] args) {
        String fileName = "email.txt";
        List<String> mails = MailListReader.read(fileName);
        InsertarDatosTabla idt = new InsertarDatosTabla();
        idt.insert(mails);
        connect(); 
    }
    
    private static void connect() {
        Connection conn = null;
        try {
            String url = "jdbc:sqlite:KATA5.db";
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