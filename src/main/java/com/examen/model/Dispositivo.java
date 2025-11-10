package com.examen.model;

public class Dispositivo 
{
    private final int id;
    private final String nombre;
    private final String categoria;
    private final Double precio;
    private final int stock; 

    public Dispositivo() 
    {
        this.id = 0;
        this.nombre = "Default";
        this.categoria = "Default";
        this.precio = 0.0;
        this.stock = 0;
    }

    public Dispositivo(int id, String nombre, String categoria, Double precio, int stock)
    {
        this.id = id;
        this.nombre = nombre;
        this.categoria = categoria;
        this.precio = precio;
        this.stock = stock;
    }

    public Dispositivo(String nombre, String categoria, Double precio, int stock)
    {
        this.id = 0;
        this.nombre = nombre;
        this.categoria = categoria;
        this.precio = precio;
        this.stock = stock;
    }

    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public String getCategoria() { return categoria; }
    public Double getPrecio() { return precio; }
    public int getStock() { return stock; }

    @Override
    public String toString()
    {
        return String.format("Id: %d,\nNombre: %s,\nCategoria: %s,\nPrecio: %f,\nStock: %d", 
                this.id,
                this.nombre,
                this.categoria,
                this.precio,
                this.stock);
    }
}
