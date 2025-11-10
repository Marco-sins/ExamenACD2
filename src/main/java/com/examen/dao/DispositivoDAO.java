package com.examen.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.examen.model.Dispositivo;
import com.examen.util.DatabaseConnection;

public class DispositivoDAO 
{
    public void insertarDispositivo(Dispositivo d) throws SQLException
    {
        String sql = "INSERT INTO dispositivos(nombre, categoria, precio, stock) VALUES (?, ?, ?, ?)";
        try (Connection c = DatabaseConnection.getConection(); PreparedStatement ps = c.prepareStatement(sql))
        {
            ps.setString(1, d.getNombre());
            ps.setString(2, d.getCategoria());
            ps.setDouble(3, d.getPrecio());
            ps.setInt(4, d.getStock());
            ps.executeUpdate();
        }
    }

    public void actualizarDispositivo(Dispositivo d) throws SQLException
    {
        String sql = "UPDATE dispositivos SET nombre = ?, categoria = ?, precio = ?, stock = ? WHERE id = ?";
        try (Connection c = DatabaseConnection.getConection(); PreparedStatement ps = c.prepareStatement(sql))
        {
            ps.setString(1, d.getNombre());
            ps.setString(2, d.getCategoria());
            ps.setDouble(3, d.getPrecio());
            ps.setInt(4, d.getStock());
            ps.setInt(5, d.getId());
            ps.executeUpdate();
        }
    }

    public void eliminarDispositivo(Dispositivo d) throws SQLException
    {
        String sql = "DELETE FROM dispositivos WHERE id = ?";
        try (Connection c = DatabaseConnection.getConection(); PreparedStatement ps = c.prepareStatement(sql))
        {
            ps.setInt(1, d.getId());
            ps.executeUpdate();
        }
    }

    public List<Dispositivo> listarDispositivos() throws SQLException
    {
        List<Dispositivo> list = new ArrayList<>();
        String sql = "SELECT * FROM dispositivos";
        try (Connection c = DatabaseConnection.getConection(); 
            PreparedStatement ps = c.prepareStatement(sql);
            ResultSet r = ps.executeQuery())
        {
            while (r.next())
            {
                Dispositivo d = new Dispositivo(
                    r.getInt("id"),
                    r.getString("nombre"),
                    r.getString("categoria"),
                    r.getDouble("precio"),
                    r.getInt("stock")
                );
                list.add(d);
            }
        }
        return list;
    }

    public Dispositivo buscarPorCategoriayRangoPrecio(String categoria, double precioMinimo, double precioMaximo) throws SQLException
    {
        String sql = String.format("SELECT * FROM dispositivos d WHERE d.categoria = \"%s\" AND d.precio BETWEEN %f AND %f", 
                categoria,
                precioMinimo,
                precioMaximo);
        Dispositivo d;
        try (Connection c = DatabaseConnection.getConection();
            PreparedStatement ps = c.prepareStatement(sql);
            ResultSet r = ps.executeQuery())
        {
            if (!r.next())
                return null;
            d = new Dispositivo(
                r.getInt(1),
                r.getString(2),
                r.getString(3),
                r.getDouble(4),
                r.getInt(5)
            );
        }
        return d;
    }
}
