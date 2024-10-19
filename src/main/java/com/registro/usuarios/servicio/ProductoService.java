package com.registro.usuarios.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.registro.usuarios.modelo.Producto;
import com.registro.usuarios.repositorio.ProductoRepositorio;

@Service
@Transactional
public class ProductoService implements IProductoService {

    @Autowired
    ProductoRepositorio productoRepositorio;

    @Override
    public List<Producto> getProductos() {
        return productoRepositorio.findAll();
    }

    @Override
    public Producto nuevoProducto(Producto producto) {
        return productoRepositorio.save(producto);
    }

    @Override
    public Producto buscarProducto(Integer id) {
        return productoRepositorio.findById(id).orElse(null);
    }

    @Override
    public void borrarProducto(Integer id) {
        productoRepositorio.deleteById(id);
    }

}
