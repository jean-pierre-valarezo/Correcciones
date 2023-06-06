/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ec.edu.ups.correccionpruebapoo.dao;

import ec.edu.ups.correccionpruebapoo.modelo.CarritoCompra;
import java.util.Date;
import java.util.List;

/**
 *
 * @author jeanp
 */
public interface CarritoCompraDAO {
    void agregarCarritoCompra(CarritoCompra carritoCompra);
    void eliminarCarritoCompra(Date fecha);
    void actualizarCarritoCompra(CarritoCompra carritoCompra);
    CarritoCompra obtenerCarritoCompra(Date fecha);
    List<CarritoCompra> obtenerTodosLosCarritosCompra();
}
