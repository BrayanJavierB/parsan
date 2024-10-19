package com.registro.usuarios.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.registro.usuarios.modelo.Producto;

public interface ProductoRepositorio extends JpaRepository<Producto, Integer> {

}