package com.registro.usuarios.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.registro.usuarios.modelo.Empleado;




public interface EmpleadoRepositorio extends JpaRepository<Empleado, Integer>{

}
