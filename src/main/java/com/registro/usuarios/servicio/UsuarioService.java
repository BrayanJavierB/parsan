package com.registro.usuarios.servicio;


import java.util.List;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.registro.usuarios.modelo.Usuario;
import com.registro.usuarios.repositorio.UsuarioRepository;








@Service
@Transactional
public class UsuarioService implements UsuarioServiceImpl {
	//Instanciar un objeto repositorio
	@Autowired
	private UsuarioRepository repo;
	@Override
	public List<Usuario> listar() {
		return repo.findAll();
	}

	@Override
	public Usuario listarId(Long id) {
		return repo.findById(id).get();
	}

	@Override
	public void save(Usuario p) {
		repo.save(p);
	}
	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
	}

	
}
