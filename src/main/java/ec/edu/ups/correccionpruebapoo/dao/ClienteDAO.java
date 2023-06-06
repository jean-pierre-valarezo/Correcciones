/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ec.edu.ups.correccionpruebapoo.dao;

import ec.edu.ups.correccionpruebapoo.modelo.Cliente;
import java.util.List;

/**
 *
 * @author jeanp
 */
public interface ClienteDAO {
    void agregarCliente(Cliente cliente);
    void eliminarCliente(String cedula);
    void actualizarCliente(Cliente cliente);
    Cliente obtenerCliente(String cedula);
    List<Cliente> obtenerTodosLosClientes();
}
