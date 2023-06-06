/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.correccionpruebapoo.vista;

import ec.edu.ups.correccionpruebapoo.controlador.ControladorProducto;
import ec.edu.ups.correccionpruebapoo.modelo.Producto;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author jeanp
 */
public class VistaProducto {
    private ControladorProducto controladorProducto;

    public VistaProducto(ControladorProducto controladorProducto) {
        this.controladorProducto = controladorProducto;
    }
    public void ejecutar(){
        Scanner scanner = new Scanner(System.in);
        
        int opcion;
        do{
            mostrarMenu();
            opcion = scanner.nextInt();
            
            switch (opcion){
                case 6:
                    agregarProducto(scanner);
                    break;
                case 7:
                    eliminarProducto(scanner);
                    break;
                case 8:
                    actualizarProducto(scanner);
                    break;
                case 9:
                    obtenerProducto(scanner);
                    break;
                case 10:
                    obtenerTodosLosProductos();
                    break;
                case 0:
                    System.out.println("¡Bye!");
                    break;
                default:
                    System.out.println("Opción incorrecta. Ingrese nuevamente.");
            }
        }while (opcion != 0);
    }
    public void agregarProducto(Scanner scanner) {
        System.out.println("Ingrese el código del producto:");
        String codigo = scanner.next();
        System.out.println("Ingrese el nombre del producto:");
        String nombre = scanner.next();
        System.out.println("Ingrese la descripción del producto:");
        String descripcion = scanner.next();
        System.out.println("Ingrese el precio del producto:");
        double precio = scanner.nextDouble();

        Producto producto = new Producto(codigo, nombre, descripcion, precio);
        controladorProducto.agregarProducto(producto);
        System.out.println("El Producto se agrego correctamente.");
    }

    public void eliminarProducto(Scanner scanner) {
        System.out.println("Ingrese el código del producto a eliminar:");
        String codigo = scanner.next();

        controladorProducto.eliminarProducto(codigo);
        System.out.println("Producto eliminado correctamente.");
    }

    public void actualizarProducto(Scanner scanner) {
        System.out.println("Ingrese el código del producto a actualizar:");
        String codigo = scanner.next();
        Producto producto = controladorProducto.obtenerProducto(codigo);

        if (producto != null) {
            System.out.println("Ingrese el nuevo nombre del producto:");
            String nombre = scanner.next();
            System.out.println("Ingrese la nueva descripción del producto:");
            String descripcion = scanner.next();
            System.out.println("Ingrese el nuevo precio del producto:");
            double precio = scanner.nextDouble();

            producto.setNombre(nombre);
            producto.setDescripcion(descripcion);
            producto.setPrecio(precio);

            controladorProducto.actualizarProducto(producto);
            System.out.println("El Producto se ha actualizado correctamente.");
        } else {
            System.out.println("El Producto no se ha encontrado.");
        }
    }

    public void obtenerProducto(Scanner scanner) {
        System.out.println("Ingrese el código del producto a obtener:");
        String codigo = scanner.next();

        Producto producto = controladorProducto.obtenerProducto(codigo);

        if (producto != null) {
            System.out.println("Producto encontrado:");
            System.out.println("Código: " + producto.getCodigo());
            System.out.println("Nombre: " + producto.getNombre());
            System.out.println("Descripción: " + producto.getDescripcion());
            System.out.println("Precio: " + producto.getPrecio());
        } else {
            System.out.println("Producto no encontrado.");
        }
    }

    public void obtenerTodosLosProductos() {
        List<Producto> todosLosProductos = controladorProducto.obtenerTodosLosProductos();

        if (!todosLosProductos.isEmpty()) {
            System.out.println("Todos los productos:");
            for (Producto producto : todosLosProductos) {
                System.out.println("Código: " + producto.getCodigo());
                System.out.println("Nombre: " + producto.getNombre());
                System.out.println("Descripción: " + producto.getDescripcion());
                System.out.println("Precio: " + producto.getPrecio());
                System.out.println("------------------------------");
            }
        } else {
            System.out.println("No hay productos registrados.");
        }
    } 
    private void mostrarMenu(){
        System.out.println("==== Menú ====");
        System.out.println("6. Agregar un producto");
        System.out.println("7. Eliminar el producto");
        System.out.println("8. Actualizar el producto");
        System.out.println("9. Obtener el producto");
        System.out.println("10. Obtener todos los productos");
        System.out.println("0. Salir");
        System.out.println("Ingrese el número de la opción que guste:");
    }
}
