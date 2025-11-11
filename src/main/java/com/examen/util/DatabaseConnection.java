package com.examen.util;

import java.sql.*;

public class DatabaseConnection 
{
    private static final String sqlUrl = "jdbc:sqlite:src/main/resources/dispositivos.db";

    public static Connection getConection() throws SQLException
    {
        return DriverManager.getConnection(sqlUrl);
    }

    public static void inicialization()
    {
        String sql =    "CREATE TABLE IF NOT EXISTS dispositivos (" + 
                        "id INTEGER PRIMARY KEY AUTOINCREMENT, " + 
                        "nombre TEXT NOT NULL, " + 
                        "categoria TEXT, " + 
                        "precio REAL, " + 
                        "stock INTEGER);";
        try (Connection c = getConection(); 
        Statement st = c.createStatement())
        {
            st.execute(sql);
            System.out.println("Database creation was succesful");
            c.close();
        }
        catch (SQLException e)
        {
            System.err.println("Database creation failure: " + e.getMessage());
        }
    }
}
