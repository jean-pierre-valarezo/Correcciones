/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.correccionpruebapoo.vista;

import ec.edu.ups.correccionpruebapoo.controlador.ControladorCliente;
import ec.edu.ups.correccionpruebapoo.modelo.Cliente;
import java.util.List;
import java.util.Scanner;


/**
 *
 * @author jeanp
 */
public class VistaCliente {
    private ControladorCliente controladorCliente;

    public VistaCliente(ControladorCliente controladorCliente) {
        this.controladorCliente = controladorCliente;
    }
    public void ejecutar(){
        Scanner scanner = new Scanner(System.in);

        int opcion;
        do{
            mostrarMenu();
            opcion = scanner.nextInt();
            
            switch (opcion){
                case 1:
                    agregarCliente(scanner);
                    break;
                case 2:
                    eliminarCliente(scanner);
                    break;
                case 3:
                    actualizarCliente(scanner);
                    break;
                case 4:
                    obtenerCliente(scanner);
                    break;
                case 5:
                    obtenerTodosLosClientes();
                    break;
                case 0:
                    System.out.println("¡Bye!");
                    break;
                default:
                    System.out.println("Opción inválida. Ingrese nuevamente.");
            }
        }while (opcion != 0);
    }
    public void agregarCliente(Scanner scanner) {
    System.out.println("Ingrese la cédula del cliente:");
    String cedula = scanner.next();
    System.out.println("Ingrese un solo nombre del cliente:");
    String nombres = scanner.next();
    System.out.println("Ingrese un solo apellido del cliente:");
    String apellidos = scanner.next();
    System.out.println("Ingrese la dirección del cliente:");
    String direccion = scanner.next();
    System.out.println("Ingrese el teléfono del cliente:");
    String telefono = scanner.next();

    Cliente cliente = new Cliente(cedula, nombres, apellidos, direccion, telefono);
    controladorCliente.agregarCliente(cliente);
    System.out.println("Cliente agregado correctamente.");
}

    public void eliminarCliente(Scanner scanner) {
    System.out.println("Ingrese la cédula del cliente a eliminar:");
    String cedula = scanner.next();
    controladorCliente.eliminarCliente(cedula);
    System.out.println("El Cliente se elimino correctamente.");
}

    public void actualizarCliente(Scanner scanner) {
    System.out.println("Ingrese la cédula del cliente a actualizar:");
    String cedula = scanner.next();
    Cliente cliente = controladorCliente.obtenerCliente(cedula);

    if (cliente != null) {
        System.out.println("Ingrese los nuevos nombres del cliente:");
        String nuevosNombres = scanner.next();
        System.out.println("Ingrese los nuevos apellidos del cliente:");
        String nuevosApellidos = scanner.next();
        System.out.println("Ingrese la nueva dirección del cliente:");
        String nuevaDireccion = scanner.next();
        System.out.println("Ingrese el nuevo teléfono del cliente:");
        String nuevoTelefono = scanner.next();

        cliente.setNombres(nuevosNombres);
        cliente.setApellidos(nuevosApellidos);
        cliente.setDireccion(nuevaDireccion);
        cliente.setTelefono(nuevoTelefono);

        controladorCliente.actualizarCliente(cliente);
        System.out.println("El cliente se actualizo correctamente.");
    } else {
        System.out.println("Cliente no encontrado.");
    }
}

    public void obtenerCliente(Scanner scanner) {
    System.out.println("Ingrese la cédula del cliente a obtener:");
    String cedula = scanner.next();
    Cliente cliente = controladorCliente.obtenerCliente(cedula);

    if (cliente != null) {
        System.out.println("Cliente encontrado:");
        System.out.println("Cédula: " + cliente.getCedula());
        System.out.println("Nombres: " + cliente.getNombres());
        System.out.println("Apellidos: " + cliente.getApellidos());
        System.out.println("Dirección: " + cliente.getDireccion());
        System.out.println("Teléfono: " + cliente.getTelefono());
    } else {
        System.out.println("Cliente no encontrado.");
    }
}

    public void obtenerTodosLosClientes() {
    List<Cliente> todosLosClientes = controladorCliente.obtenerTodosLosClientes();

    if (!todosLosClientes.isEmpty()) {
        System.out.println("Todos los clientes:");

        for (Cliente cliente : todosLosClientes) {
            System.out.println("Cédula: " + cliente.getCedula());
            System.out.println("Nombres: " + cliente.getNombres());
            System.out.println("Apellidos: " + cliente.getApellidos());
            System.out.println("Dirección: " + cliente.getDireccion());
            System.out.println("Teléfono: " + cliente.getTelefono());
            System.out.println("------------------------------");
        }
    } else {
        System.out.println("No hay clientes registrados.");
    }
} 
    private void mostrarMenu() {
        System.out.println("==== Menú ====");
        System.out.println("1. Agregar un cliente");
        System.out.println("2. Eliminar el cliente");
        System.out.println("3. Actualizar el cliente");
        System.out.println("4. Obtener el cliente");
        System.out.println("5. Obtener todos los clientes");
        System.out.println("0. Salir");
        System.out.println("Ingrese el número de la opción que guste:");
    }
}
