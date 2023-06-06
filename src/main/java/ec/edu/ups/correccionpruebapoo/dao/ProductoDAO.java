/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ec.edu.ups.correccionpruebapoo.dao;

import ec.edu.ups.correccionpruebapoo.modelo.Producto;
import java.util.List;

/**
 *
 * @author jeanp
 */
public interface ProductoDAO {
    void agregarProducto(Producto producto);
    void eliminarProducto(String codigo);
    void actualizarProducto(Producto producto);
    Producto obtenerProducto(String codigo);
    List<Producto> obtenerTodosLosProductos();
}
