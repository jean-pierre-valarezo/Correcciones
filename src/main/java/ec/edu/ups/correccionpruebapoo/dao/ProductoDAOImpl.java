/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.correccionpruebapoo.dao;

import ec.edu.ups.correccionpruebapoo.modelo.Producto;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jeanp
 */
public class ProductoDAOImpl implements ProductoDAO{
       private List<Producto> productos;
    
    public ProductoDAOImpl() {
        productos = new ArrayList<>();
    }
    
    @Override
    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }
    
    @Override
    public void eliminarProducto(String codigo) {
        productos.removeIf(p -> p.getCodigo().equals(codigo));
    }
    
    @Override
    public void actualizarProducto(Producto producto) {
        for (int i = 0; i < productos.size(); i++) {
            Producto p = productos.get(i);
            if (p.getCodigo().equals(producto.getCodigo())) {
                productos.set(i, producto);
                break;
            }
        }
    }
    
    @Override
    public Producto obtenerProducto(String codigo) {
        for (Producto producto : productos) {
            if (producto.getCodigo().equals(codigo)) {
                return producto;
            }
        }
        return null;
    }
    
    @Override
    public List<Producto> obtenerTodosLosProductos() {
        return productos;
    }
}
