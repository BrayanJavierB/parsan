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


import com.registro.usuarios.modelo.Insumo;
import com.registro.usuarios.servicio.InsumoService;

@Controller
@RequestMapping("/views/insumos")
public class InsumoController {

    @Autowired
    private InsumoService insumoService;

    @GetMapping("/")
    public String verIndex(Model model) {
        List<Insumo> listaInsumos = insumoService.listar();
        model.addAttribute("listaInsumos", listaInsumos);
        return "/views/insumos/insumo";
    }
    
    @GetMapping("/Insumo")
    public String ver(Model model) {
        List<Insumo> listaInsumos = insumoService.listar();
        model.addAttribute("listaInsumos", listaInsumos);
        return "/views/insumos/plantilla";
    }


    @GetMapping("/new")
    public String mostrarPaginaNuevoInsumo(Model model) {
        Insumo insumo = new Insumo();
        model.addAttribute("insumo", insumo);
        return "/views/insumos/nuevo_insumo";
    }

    @PostMapping("/save")
    public String saveInsumo(@Valid @ModelAttribute("insumo") Insumo insumo, Errors errors, Model model,
                             RedirectAttributes attribute) {
        if (errors.hasErrors()) {
            return "/views/insumos/nuevo_insumo";
        }
        insumoService.save(insumo);
        attribute.addFlashAttribute("success", "Insumo guardado con éxito");
        return "redirect:/views/insumos/";
    }

    @GetMapping("/listar/{idInsumo}")
    public String listarId(@PathVariable int idInsumo, Model model) {
        model.addAttribute("insumo", insumoService.listarId(idInsumo));
        return "/views/insumos/editar_insumo";
    }

    @RequestMapping("/delete/{idInsumo}")
    public String deleteInsumo(@PathVariable(name = "idInsumo") int idInsumo, RedirectAttributes attribute) {
        try {
            insumoService.delete(idInsumo);
            attribute.addFlashAttribute("info", "Insumo eliminado correctamente!");
        } catch (Exception e) {
            attribute.addFlashAttribute("error", "No se pudo eliminar el insumo!");
        }
        return "redirect:/views/insumos/";
    }
}