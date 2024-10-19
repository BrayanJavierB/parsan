package com.registro.usuarios.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.registro.usuarios.servicio.UsuarioServicio;

@Controller
public class RegistroControlador {

	@Autowired
	private UsuarioServicio servicio;
	
	@GetMapping("/login")
	public String iniciarSesion() {
		return "login";
	}
	
	@GetMapping("/")
	public String verPaginaDeInicio(Model modelo) {
		modelo.addAttribute("usuarios", servicio.listarUsuarios());
		return "index";
	}
	
	@GetMapping("/templates/usuario")
	public String verPaginaDeUsuario(Model modelo) {
		modelo.addAttribute("usuarios", servicio.listarUsuarios());
		return "usuario";
	}
	
	@GetMapping("/templates/nuevouser")
	public String verPaginaDeNuevoUsuario(Model modelo) {
		modelo.addAttribute("usuarios", servicio.listarUsuarios());
		return "nuevouser";
	}
	
	@GetMapping("/templates/registro")
	public String mostrarFormularioDeRegistro() {
		return "registro";
	}
}
