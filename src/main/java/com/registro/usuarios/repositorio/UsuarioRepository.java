package com.registro.usuarios.repositorio;



import org.springframework.data.jpa.repository.JpaRepository;


import com.registro.usuarios.modelo.Usuario;




public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

}
