/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.correccionpruebapoo.dao;

import ec.edu.ups.correccionpruebapoo.modelo.Cliente;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author jeanp
 */
public class ClienteDAOImpl implements ClienteDAO {
    private List<Cliente> clientes;
    
    public ClienteDAOImpl() {
        clientes = new ArrayList<>();
    }
    
    @Override
    public void agregarCliente(Cliente cliente) {
        clientes.add(cliente);
    }
    
    @Override
    public void eliminarCliente(String cedula) {
        clientes.removeIf(c -> c.getCedula().equals(cedula));
    }
    
    @Override
    public void actualizarCliente(Cliente cliente) {
        for (int i = 0; i < clientes.size(); i++) {
            Cliente c = clientes.get(i);
            if (c.getCedula().equals(cliente.getCedula())) {
                clientes.set(i, cliente);
                break;
            }
        }
    }
    
    @Override
    public Cliente obtenerCliente(String cedula) {
        for (Cliente cliente : clientes) {
            if (cliente.getCedula().equals(cedula)) {
                return cliente;
            }
        }
        return null;
    }
    
    @Override
    public List<Cliente> obtenerTodosLosClientes() {
        return clientes;
    }
}
