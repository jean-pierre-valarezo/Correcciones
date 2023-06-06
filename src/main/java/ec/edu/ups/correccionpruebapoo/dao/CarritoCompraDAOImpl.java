/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.correccionpruebapoo.dao;

import ec.edu.ups.correccionpruebapoo.modelo.CarritoCompra;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author jeanp
 */
public class CarritoCompraDAOImpl implements CarritoCompraDAO {
    private List<CarritoCompra> carritos;
    
    public CarritoCompraDAOImpl() {
        carritos = new ArrayList<>();
    }
    
    @Override
    public void agregarCarritoCompra(CarritoCompra carritoCompra) {
        carritos.add(carritoCompra);
    }
    
    @Override
    public void eliminarCarritoCompra(Date fecha) {
        carritos.removeIf(c -> c.getFecha().equals(fecha));
    }
    
    @Override
    public void actualizarCarritoCompra(CarritoCompra carritoCompra) {
        for (int i = 0; i < carritos.size(); i++) {
            CarritoCompra c = carritos.get(i);
            if (c.getFecha().equals(carritoCompra.getFecha())) {
                carritos.set(i, carritoCompra);
                break;
            }
        }
    }
    
    @Override
    public CarritoCompra obtenerCarritoCompra(Date fecha) {
        for (CarritoCompra carrito : carritos) {
            if (carrito.getFecha().equals(fecha)) {
                return carrito;
            }
        }
        return null;
    }
    
    @Override
    public List<CarritoCompra> obtenerTodosLosCarritosCompra() {
        return carritos;
    }
}