package com.registro.usuarios.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import com.registro.usuarios.modelo.Insumo;

public interface InsumoRepositorio extends JpaRepository<Insumo, Integer> {
	
}
