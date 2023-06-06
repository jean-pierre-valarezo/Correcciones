/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.correccionpruebapoo.controlador;

import ec.edu.ups.correccionpruebapoo.dao.CarritoCompraDAO;
import ec.edu.ups.correccionpruebapoo.modelo.CarritoCompra;
import ec.edu.ups.correccionpruebapoo.modelo.Cliente;
import ec.edu.ups.correccionpruebapoo.modelo.Producto;
import java.util.Date;
import java.util.List;

/**
 *
 * @author jeanp
 */
public class ControladorCarritoCompra {
    private CarritoCompraDAO carritoDAO;

    public ControladorCarritoCompra(CarritoCompraDAO carritoDAO) {
        this.carritoDAO = carritoDAO;
    }
    public void agregarCarritoCompra(CarritoCompra carritoCompra) {
        carritoDAO.agregarCarritoCompra(carritoCompra);
    }

    public void eliminarCarritoCompra(Date fecha) {
        carritoDAO.eliminarCarritoCompra(fecha);
    }

    public void actualizarCarritoCompra(CarritoCompra carritoCompra) {
        carritoDAO.actualizarCarritoCompra(carritoCompra);
    }

    public CarritoCompra obtenerCarritoCompra(Date fecha) {
        return carritoDAO.obtenerCarritoCompra(fecha);
    }

    public List<CarritoCompra> obtenerTodosLosCarritosCompra() {
        return carritoDAO.obtenerTodosLosCarritosCompra();
    } 

    public Producto obtenerProducto(String codigoProducto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Cliente obtenerCliente(String cedulaCliente) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
