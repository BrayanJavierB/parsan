package com.registro.usuarios.servicio;

import java.util.List;

import com.registro.usuarios.modelo.Producto;

public interface IProductoService {

    List<Producto> getProductos();

    Producto nuevoProducto(Producto producto);

    Producto buscarProducto(Integer id);

    void borrarProducto(Integer id);
}
