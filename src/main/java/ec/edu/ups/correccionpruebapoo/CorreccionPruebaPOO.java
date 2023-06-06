/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package ec.edu.ups.correccionpruebapoo;

import ec.edu.ups.correccionpruebapoo.controlador.ControladorCarritoCompra;
import ec.edu.ups.correccionpruebapoo.controlador.ControladorCliente;
import ec.edu.ups.correccionpruebapoo.controlador.ControladorProducto;
import ec.edu.ups.correccionpruebapoo.dao.CarritoCompraDAOImpl;
import ec.edu.ups.correccionpruebapoo.dao.ClienteDAOImpl;
import ec.edu.ups.correccionpruebapoo.dao.ProductoDAOImpl;
import ec.edu.ups.correccionpruebapoo.vista.VistaCarritoCompra;
import ec.edu.ups.correccionpruebapoo.vista.VistaCliente;
import ec.edu.ups.correccionpruebapoo.vista.VistaProducto;
import java.util.Scanner;



/**
 *
 * @author jeanp
 */
public class CorreccionPruebaPOO {
    private static VistaCliente vistaCliente;
    private static VistaProducto vistaProducto;
    private static VistaCarritoCompra vistaCarritoCompra;
    
    public static void main(String[] args) {
        ControladorCliente controladorCliente = new ControladorCliente (new ClienteDAOImpl());
        ControladorProducto controladorProducto = new ControladorProducto(new ProductoDAOImpl());
        ControladorCarritoCompra controladorCarritoCompra = new ControladorCarritoCompra (new CarritoCompraDAOImpl());
        
        vistaCliente = new VistaCliente(controladorCliente);
        vistaProducto = new VistaProducto(controladorProducto);
        vistaCarritoCompra = new VistaCarritoCompra(controladorCarritoCompra);
        
         Scanner scanner = new Scanner(System.in);
         
         int opcion;
         do {
            mostrarMenu();
            opcion = obtenerOpcion(scanner);
            ejecutarOpcion(opcion, scanner);
        }while (opcion != 0);
         
        scanner.close();
    }
    private static void mostrarMenu() {
        System.out.println("----- MENU -----");
        System.out.println("1. Agregar un cliente");
        System.out.println("2. Eliminar el cliente");
        System.out.println("3. Actualizar el cliente");
        System.out.println("4. Obtener un cliente");
        System.out.println("5. Obtener todos los clientes");
        System.out.println("6. Agregar un producto");
        System.out.println("7. Eliminar el producto");
        System.out.println("8. Actualizar el producto");
        System.out.println("9. Obtener un producto");
        System.out.println("10. Obtener todos los productos");
        System.out.println("11. Agregar un carrito de compra");
        System.out.println("12. Eliminar el carrito de compra");
        System.out.println("13. Actualizar el carrito de compra");
        System.out.println("14. Obtener un carrito de compra");
        System.out.println("15. Obtener todos los carritos de compra");
        System.out.println("0. Salir del programa");
        System.out.println("----------------");
    }
    private static int obtenerOpcion(Scanner scanner){
        System.out.print("Ingrese una opción: ");
        return scanner.nextInt();
    }
    private static void ejecutarOpcion(int opcion, Scanner scanner){
        switch (opcion){
            case 1:
                vistaCliente.agregarCliente(scanner);
                break;
            case 2:
                vistaCliente.eliminarCliente(scanner);
                break;
            case 3:
                vistaCliente.actualizarCliente(scanner);
                break;
            case 4:
                vistaCliente.obtenerCliente(scanner);
                break;
            case 5:
                vistaCliente.obtenerTodosLosClientes();
                break;
            case 6:
                vistaProducto.agregarProducto(scanner);
                break;
            case 7:
                vistaProducto.eliminarProducto(scanner);
                break;
            case 8:
                vistaProducto.actualizarProducto(scanner);
                break;
            case 9:
                vistaProducto.obtenerProducto(scanner);
                break;
            case 10:
                vistaProducto.obtenerTodosLosProductos();
                break;
            case 11:
                vistaCarritoCompra.agregarCarritoCompra(scanner);
                break;
            case 12:
                vistaCarritoCompra.eliminarCarritoCompra(scanner);
                break;
            case 13:
                vistaCarritoCompra.actualizarCarritoCompra(scanner);
                break;
            case 14:
                vistaCarritoCompra.obtenerCarritoCompra(scanner);
                break;
            case 15:
                vistaCarritoCompra.obtenerTodosLosCarritosCompra();
                break;
            case 0:
                System.out.println("Cerrando el programa...");
                break;
            default:
                System.out.println("Opción incorrecta. Ingrese nuevamente.");
                break;
        }
    } 
}
