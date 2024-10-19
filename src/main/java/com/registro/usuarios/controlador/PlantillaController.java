package com.registro.usuarios.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PlantillaController {

    @GetMapping("/plantilla")
    public String mostrarPlantilla() {
        return "layout/plantilla"; 
    }
    
    
}
