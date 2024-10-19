package com.registro.usuarios.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import com.registro.usuarios.modelo.Factura;

public interface FacturaRepositorio extends JpaRepository<Factura, Integer> {
}