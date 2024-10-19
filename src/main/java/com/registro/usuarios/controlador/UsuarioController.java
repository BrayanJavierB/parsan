package com.registro.usuarios.controlador;



import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.registro.usuarios.modelo.Usuario;
import com.registro.usuarios.servicio.UsuarioService;






@Controller
@RequestMapping("/views/usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioService servicio;
	
	
	@RequestMapping("/")
	public String verIndex(Model model) {
		List<Usuario> listaUsuarios = servicio.listar();
		model.addAttribute("listaUsarios",listaUsuarios);
		return "/views/usuarios/usuario" ;
	}
	
	@GetMapping("/new")
	public String mostrarPaginaNuevoUsuario(Model model) {
		Usuario usuario = new Usuario();
		
		model.addAttribute("usuario", usuario);
		return "/views/usuarios/nuevo_user";
	}

	@PostMapping("/save")
	public String saveUsuario(@Valid @ModelAttribute("usuario") Usuario usuario, Errors errors, Model model,
	                           RedirectAttributes attribute) {
	    if (errors.hasErrors()) {
	        // Reagregar lista de datos necesarios en caso de error (ejemplo, lista de cargos, etc.)
	        // model.addAttribute("listaCargos", servicio.listarCargos()); // Ejemplo si tienes lista de cargos

	        return "/views/usuarios/nuevo_user"; // Asegúrate de que este es el nombre correcto de la vista
	    }
	    servicio.save(usuario);
	    attribute.addFlashAttribute("success", "Empleado guardado con éxito");
	    return "redirect:/templates/usuario";
	}
	
	
	@PostMapping("/update")
    public String updateUsuario(@Valid @ModelAttribute("usuario") Usuario usuario, Errors errors, Model model,
                                RedirectAttributes attribute) {
        if (errors.hasErrors()) {
            return "/views/usuarios/editar_user";
        }
        servicio.save(usuario);
        attribute.addFlashAttribute("success", "Empleado actualizado con éxito");
        return "redirect:/templates/usuario";
    }
	
	
	@GetMapping("/listar/{id}")
	public String listarId(@PathVariable Long id, Model model) {
		model.addAttribute("usuario", servicio.listarId(id));
		
		return "/views/usuarios/editar_user";
	}
	
	@RequestMapping("/delete/{id}")
	public String deleteEmpleado(@PathVariable(name = "id") Long id, RedirectAttributes attribute) {
		try {
		servicio.delete(id);
		 attribute.addFlashAttribute("info", "Usuario eliminado correctamente!");
		} catch (Exception e) {
            attribute.addFlashAttribute("error", "No se pudo eliminar el Usuario!");
        }
		return "redirect:/templates/usuario";
	}	
}