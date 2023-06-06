/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.correccionpruebapoo.controlador;

import ec.edu.ups.correccionpruebapoo.dao.ProductoDAO;
import ec.edu.ups.correccionpruebapoo.modelo.Producto;
import java.util.List;

/**
 *
 * @author jeanp
 */
public class ControladorProducto {
    private ProductoDAO productoDAO;

    public ControladorProducto(ProductoDAO productoDAO) {
        this.productoDAO = productoDAO;
    }
    public void agregarProducto(Producto producto) {
        productoDAO.agregarProducto(producto);
    }

    public void eliminarProducto(String codigo) {
        productoDAO.eliminarProducto(codigo);
    }

    public void actualizarProducto(Producto producto) {
        productoDAO.actualizarProducto(producto);
    }

    public Producto obtenerProducto(String codigo) {
        return productoDAO.obtenerProducto(codigo);
    }

    public List<Producto> obtenerTodosLosProductos() {
        return productoDAO.obtenerTodosLosProductos();
    }  
}
