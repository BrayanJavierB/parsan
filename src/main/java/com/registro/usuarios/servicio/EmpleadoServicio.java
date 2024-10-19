package com.registro.usuarios.servicio;


import java.util.List;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.registro.usuarios.modelo.Empleado;
import com.registro.usuarios.repositorio.EmpleadoRepositorio;






@Service
@Transactional
public class EmpleadoServicio implements IEmpleadoServicio {
	//Instanciar un objeto repositorio
	@Autowired
	private EmpleadoRepositorio repo;
	@Override
	public List<Empleado> listar() {
		return repo.findAll();
	}

	@Override
	public Empleado listarId(int id_empleado) {
		return repo.findById(id_empleado).get();
	}

	@Override
	public void save(Empleado p) {
		repo.save(p);
	}
	@Override
	public void delete(int id_empleado) {
		// TODO Auto-generated method stub
		repo.deleteById(id_empleado);
	}

	
}
