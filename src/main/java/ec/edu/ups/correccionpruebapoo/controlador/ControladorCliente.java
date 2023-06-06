/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.correccionpruebapoo.controlador;

import ec.edu.ups.correccionpruebapoo.dao.ClienteDAO;
import ec.edu.ups.correccionpruebapoo.modelo.Cliente;
import java.util.List;

/**
 *
 * @author jeanp
 */
public class ControladorCliente {
    private ClienteDAO clienteDAO;

    public ControladorCliente(ClienteDAO clienteDAO) {
        this.clienteDAO = clienteDAO;
    }
    public void agregarCliente(Cliente cliente) {
        clienteDAO.agregarCliente(cliente);
    }

    public void eliminarCliente(String cedula) {
        clienteDAO.eliminarCliente(cedula);
    }

    public void actualizarCliente(Cliente cliente) {
        clienteDAO.actualizarCliente(cliente);
    }

    public Cliente obtenerCliente(String cedula) {
        return clienteDAO.obtenerCliente(cedula);
    }

    public List<Cliente> obtenerTodosLosClientes() {
        return clienteDAO.obtenerTodosLosClientes();
    }   
}
