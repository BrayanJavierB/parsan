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

import com.registro.usuarios.modelo.Empleado;
import com.registro.usuarios.servicio.EmpleadoServicio;




@Controller
@RequestMapping("/views/empleados")
public class EmpleadoController {

	@Autowired
	private EmpleadoServicio servicio;
	
	
	@RequestMapping("/")
	public String verIndex(Model model) {
		List<Empleado> listaEmpleados = servicio.listar();
		model.addAttribute("listaEmpleados",listaEmpleados);
		return "/views/empleados/empleado" ;
	}
	
	@GetMapping("/Empleado")
	public String ver(Model model) {
		List<Empleado> listaEmpleados = servicio.listar();
		model.addAttribute("listaEmpleados",listaEmpleados);
		return "/views/empleados/plantilla" ;
	}
	
	@GetMapping("/new")
	public String mostrarPaginaNuevoEmpleado(Model model) {
		Empleado empleado = new Empleado();
		
		model.addAttribute("empleado", empleado);
		return "/views/empleados/nuevo_empleado";
	}

	@PostMapping("/save")
	public String saveEmpleado(@Valid @ModelAttribute("empleado") Empleado empleado, Errors errors, Model model,
	                           RedirectAttributes attribute) {
	    if (errors.hasErrors()) {
	        // Reagregar lista de datos necesarios en caso de error (ejemplo, lista de cargos, etc.)
	        // model.addAttribute("listaCargos", servicio.listarCargos()); // Ejemplo si tienes lista de cargos

	        return "/views/empleados/nuevo_empleado"; // Asegúrate de que este es el nombre correcto de la vista
	    }
	    servicio.save(empleado);
	    attribute.addFlashAttribute("success", "Empleado guardado con éxito");
	    return "redirect:/views/empleados/";
	}

	
	@GetMapping("/listar/{id_empleado}")
	public String listarId(@PathVariable int id_empleado, Model model) {
		model.addAttribute("empleado", servicio.listarId(id_empleado));
		
		return "/views/empleados/editar_empleado";
	}
	
	@RequestMapping("/delete/{id_empleado}")
	public String deleteEmpleado(@PathVariable(name = "id_empleado") int id_empleado) {
		servicio.delete(id_empleado);
		return "redirect:/views/empleados/";
	}		
}