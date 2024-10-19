package com.registro.usuarios.servicio;

import java.util.List;

import com.registro.usuarios.modelo.Empleado;









public interface IEmpleadoServicio {
	
	//Definir los encabezados de los métodos a implementar
	//Mostrar todos los datos
	public List<Empleado> listar();
	
	//Buscra producto por id
	public Empleado listarId(int id_empleado);
	
	//Crear un producto
	public void save(Empleado p);
	
	//Eliminar por Id
	public void delete(int id_empleado);
	

}
