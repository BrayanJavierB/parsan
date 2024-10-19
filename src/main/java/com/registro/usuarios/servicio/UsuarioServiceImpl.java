package com.registro.usuarios.servicio;

import java.util.List;

import com.registro.usuarios.modelo.Usuario;











public interface UsuarioServiceImpl {
	
	//Definir los encabezados de los métodos a implementar
	//Mostrar todos los datos
	public List<Usuario> listar();
	
	//Buscra producto por id
	public Usuario listarId(Long id);
	
	//Crear un producto
	public void save(Usuario p);
	
	//Eliminar por Id
	public void delete(Long id);
	

}
