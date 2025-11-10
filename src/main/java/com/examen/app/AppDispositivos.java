package com.examen.app;

import java.sql.SQLException;
import java.util.Scanner;
import com.examen.dao.DispositivoDAO;
import com.examen.model.Dispositivo;

public class AppDispositivos 
{
    public final static Scanner scan = new Scanner(System.in);
    public final static DispositivoDAO dao = new DispositivoDAO();

    private static void addDispositivo()
    {
        System.out.println("Nombre: ");
        String nombre = scan.next();
        System.out.println("Categoria: ");
        String categoria = scan.next();
        System.out.println("Precio: ");
        Double precio = scan.nextDouble();
        System.out.println("Stock: ");
        int stock = scan.nextInt();

        Dispositivo d = new Dispositivo(nombre, categoria, precio, stock);
        try
        {
            dao.insertarDispositivo(d);
        }
        catch (SQLException e)
        {
            System.err.println(e);
        }
    }

    private static void listarDispositivos()
    {
        try
        {
            System.out.println((dao.listarDispositivos()).toString());
        }
        catch (SQLException e)
        {
            System.err.println(e);
        }
    }

    private static void buscarCategoria()
    {
        System.out.println("Escribe la categoria: ");
        String categoria = scan.next();
        System.out.println("Introduce el precio minimo: ");
        Double minimo = scan.nextDouble();
        System.out.println("Introduce el precio maximo: ");
        Double maximo = scan.nextDouble();
        try
        {
            System.out.println((dao.buscarPorCategoriayRangoPrecio(categoria, minimo, maximo)).toString());
        }
        catch (SQLException e)
        {
            System.err.println(e);
        }
    }

    private static void actualizarPrecio()
    {
        System.out.println("Nombre: ");
        String nombre = scan.next();
        System.out.println("Categoria: ");
        String categoria = scan.next();
        System.out.println("Precio: ");
        Double precio = scan.nextDouble();
        System.out.println("Stock: ");
        int stock = scan.nextInt();
    }

    private static void eliminarDispositivo()
    {

    }

    public static void appDisposivos()
    {        
        while (true)
        {
            System.out.println("1. Añadir Dispositivo");
            System.out.println("2. Listar Dispositivo");
            System.out.println("3. Buscar por Categoria");
            System.out.println("4. Actualizar precio/stock");
            System.out.println("5. Eliminar Dispositivo");
            System.out.println("6. Salir");
            int input = scan.nextInt();
            switch (input) {
                case 1:
                    addDispositivo();
                    break;
                case 2:
                    listarDispositivos();
                    break;
                case 3:
                    buscarCategoria();
                    break;
                case 4:
                    actualizarPrecio();
                    break;
                case 5:
                    eliminarDispositivo();
                    break;
                case 6:
                    return ;
                default:
                System.out.println("Bad option");
                    break;
            }
        }
    }

    public static void main(String[] av)
    {
        System.out.println("Welcome to Manager \"Dispositivos\"");

        appDisposivos();

        System.out.println("Bye, have a good day <3");
        scan.close();
    }
}
