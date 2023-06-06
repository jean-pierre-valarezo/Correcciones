/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.correccionpruebapoo.vista;

import ec.edu.ups.correccionpruebapoo.controlador.ControladorCarritoCompra;
import ec.edu.ups.correccionpruebapoo.modelo.CarritoCompra;
import ec.edu.ups.correccionpruebapoo.modelo.Cliente;
import ec.edu.ups.correccionpruebapoo.modelo.Producto;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author jeanp
 */
public class VistaCarritoCompra {
    private ControladorCarritoCompra controladorCarritoCompra;

    public VistaCarritoCompra(ControladorCarritoCompra controladorCarritoCompra) {
        this.controladorCarritoCompra = controladorCarritoCompra;
    }
    
    public void ejecutar(){
        Scanner scanner = new Scanner(System.in);

        int opcion;
        do{
            mostrarMenu();
            opcion = scanner.nextInt();
            
            switch (opcion){
                case 11:
                    agregarCarritoCompra(scanner);
                    break;
                case 12:
                    eliminarCarritoCompra(scanner);
                    break;
                case 13:
                    actualizarCarritoCompra(scanner);
                    break;
                case 14:
                    obtenerCarritoCompra(scanner);
                    break;
                case 15:
                    obtenerTodosLosCarritosCompra();
                    break;
                case 0:
                    System.out.println("¡Bye!");
                    break;
                default:
                    System.out.println("Opción incorrecta. Ingrese nuevamente.");
            }
        }while (opcion != 0);
    }
public void agregarCarritoCompra(Scanner scanner) {
        System.out.println("Ingrese la fecha y hora del carrito de compras (formato: dd/MM/yyyy HH:mm:ss):");
        String fechaString = scanner.next();
        System.out.println("Ingrese el subtotal a pagar:");
        double subtotal = scanner.nextDouble();
        System.out.println("Ingrese el IVA a pagar:");
        double iva = scanner.nextDouble();
        System.out.println("Ingrese el total a pagar:");
        double total = scanner.nextDouble();
        System.out.println("Ingrese la cédula del cliente que realiza la compra:");
        String cedulaCliente = scanner.next();
        System.out.println("Ingrese el código del producto a comprar (0 para finalizar):");

        List<Producto> productos = new ArrayList<>();

        String codigoProducto;
        while (!(codigoProducto = scanner.next()).equals("0")) {
            Producto producto = controladorCarritoCompra.obtenerProducto(codigoProducto);
            if (producto != null) {
                productos.add(producto);
                System.out.println("El producto se agrego al carrito. Ingrese el código del siguiente producto (0 para finalizar):");
            } else {
                System.out.println("El producto no se encontro. Ingrese el código del producto válido (0 para finalizar):");
            }
        }

        Cliente cliente = controladorCarritoCompra.obtenerCliente(cedulaCliente);

        if (cliente != null) {
            Date fecha;
            try {
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                fecha = dateFormat.parse(fechaString);
            } catch (ParseException e) {
                System.out.println("Fecha y hora ingresadas esta en un formato incorrecto. El Carrito de compras no se ha agregado.");
                return;
            }

            CarritoCompra carritoCompra = new CarritoCompra(fecha, subtotal, iva, total, cliente, productos);
            controladorCarritoCompra.agregarCarritoCompra(carritoCompra);
            System.out.println("El Carrito de compras se ha agregado correctamente.");
        } else {
            System.out.println("El Cliente no se ha encontrado. El Carrito de compras no se agrego.");
        }
    }

    public void eliminarCarritoCompra(Scanner scanner) {
        System.out.println("Ingrese la fecha y hora del carrito de compras a eliminar (formato: dd/MM/yyyy HH:mm:ss):");
        String fechaString = scanner.next();

        Date fecha;
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            fecha = dateFormat.parse(fechaString);
        } catch (ParseException e) {
            System.out.println("La Fecha y la hora se ingreso en un formato incorrecto. El Carrito de compras no se ha eliminado.");
            return;
        }

        controladorCarritoCompra.eliminarCarritoCompra(fecha);
        System.out.println("El Carrito de compras se elimino correctamente.");
    }

    public void actualizarCarritoCompra(Scanner scanner) {
        System.out.println("Ingrese la fecha y hora del carrito de compras a actualizar (formato: dd/MM/yyyy HH:mm:ss):");
        String fechaString = scanner.next();
        CarritoCompra carritoCompra = controladorCarritoCompra.obtenerCarritoCompra(parseFecha(fechaString));

        if (carritoCompra != null) {
            System.out.println("Ingrese el nuevo subtotal a pagar:");
            double subtotal = scanner.nextDouble();
            System.out.println("Ingrese el nuevo IVA a pagar:");
            double iva = scanner.nextDouble();
            System.out.println("Ingrese el nuevo total a pagar:");
            double total = scanner.nextDouble();

            carritoCompra.setSubtotal(subtotal);
            carritoCompra.setIva(iva);
            carritoCompra.setTotal(total);

            controladorCarritoCompra.actualizarCarritoCompra(carritoCompra);
            System.out.println("El Carrito de compras se ha actualizado correctamente.");
        } else {
            System.out.println("El Carrito de compras no se ha encontrado.");
        }
    }

    public void obtenerCarritoCompra(Scanner scanner) {
        System.out.println("Ingrese la fecha y la hora del carrito de compras a obtener (formato: dd/MM/yyyy HH:mm:ss):");
        String fechaString = scanner.next();

        CarritoCompra carritoCompra = controladorCarritoCompra.obtenerCarritoCompra(parseFecha(fechaString));

        if (carritoCompra != null) {
            System.out.println("Carrito de compras encontrado:");
            System.out.println("Fecha y hora: " + carritoCompra.getFecha());
            System.out.println("Subtotal: " + carritoCompra.getSubtotal());
            System.out.println("IVA: " + carritoCompra.getIva());
            System.out.println("Total: " + carritoCompra.getTotal());
            System.out.println("Cliente: " + carritoCompra.getCliente().getCedula());
            System.out.println("Productos:");

            for (Producto producto : carritoCompra.getProductos()) {
                System.out.println("- Código: " + producto.getCodigo());
                System.out.println("  Nombre: " + producto.getNombre());
                System.out.println("  Descripción: " + producto.getDescripcion());
                System.out.println("  Precio: " + producto.getPrecio());
            }
        } else {
            System.out.println("Carrito de compras no encontrado.");
        }
    }

    public void obtenerTodosLosCarritosCompra() {
        List<CarritoCompra> todosLosCarritosCompra = controladorCarritoCompra.obtenerTodosLosCarritosCompra();

        if (!todosLosCarritosCompra.isEmpty()) {
            System.out.println("Todos los carritos de compras:");

            for (CarritoCompra carritoCompra : todosLosCarritosCompra) {
                System.out.println("Fecha y hora: " + carritoCompra.getFecha());
                System.out.println("Subtotal: " + carritoCompra.getSubtotal());
                System.out.println("IVA: " + carritoCompra.getIva());
                System.out.println("Total: " + carritoCompra.getTotal());
                System.out.println("Cliente: " + carritoCompra.getCliente().getCedula());
                System.out.println("Productos:");

                for (Producto producto : carritoCompra.getProductos()) {
                    System.out.println("- Código: " + producto.getCodigo());
                    System.out.println("  Nombre: " + producto.getNombre());
                    System.out.println("  Descripción: " + producto.getDescripcion());
                    System.out.println("  Precio: " + producto.getPrecio());
                }

                System.out.println("------------------------------");
            }
        } else {
            System.out.println("No hay carritos de compras registrados.");
        }
    }
    private Date parseFecha(String fechaString) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            return dateFormat.parse(fechaString);
        } catch (ParseException e) {
            return null;
        }
    }
    private void mostrarMenu(){
        System.out.println("11. Agregar un carrito de compras");
        System.out.println("12. Eliminar el carrito de compras");
        System.out.println("13. Actualizar el carrito de compras");
        System.out.println("14. Obtener el carrito de compras");
        System.out.println("15. Obtener todos los carritos de compras");
        System.out.println("0. Salir");
        System.out.println("Ingrese el número de la opción que guste:");
    }
}
