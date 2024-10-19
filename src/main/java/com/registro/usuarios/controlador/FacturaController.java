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

import com.registro.usuarios.modelo.Factura;
import com.registro.usuarios.servicio.FacturaService;
import com.registro.usuarios.servicio.InsumoService;

@Controller
@RequestMapping("/views/facturas")
public class FacturaController {

    @Autowired
    private FacturaService facturaService;

    @Autowired
    private InsumoService insumoService;  // Inyección de InsumoService

    @GetMapping("/")
    public String verIndex(Model model) {
        List<Factura> listaFacturas = facturaService.listar();
     // Calcular el total de cada factura
        for (Factura factura : listaFacturas) {
            Float total = factura.getPrecio() * factura.getCantidad();
            factura.setTotal(total);
        }
        model.addAttribute("listaFacturas", listaFacturas);
        return "/views/facturas/factura";
    }
    
    @GetMapping("/factura")
    public String ver(Model model) {
        List<Factura> listaFacturas = facturaService.listar();
     // Calcular el total de cada factura
        for (Factura factura : listaFacturas) {
            Float total = factura.getPrecio() * factura.getCantidad();
            factura.setTotal(total);
        }
        model.addAttribute("listaFacturas", listaFacturas);
        return "/views/facturas/plantilla";
    }

    @GetMapping("/new")
    public String mostrarPaginaNuevaFactura(Model model) {
        Factura factura = new Factura();
        
        model.addAttribute("listaInsumos", insumoService.listar());  // Uso de insumoService
        model.addAttribute("factura", factura);
        return "/views/facturas/nueva_factura";
    }

    @PostMapping("/save")
    public String saveFactura(@Valid @ModelAttribute("factura") Factura factura, Errors errors, Model model,
                              RedirectAttributes attribute) {
        if (errors.hasErrors()) {
            model.addAttribute("listaInsumos", insumoService.listar());  // Reagregar lista de insumos en caso de error
            return "/views/facturas/nueva_factura";
        }
        facturaService.save(factura);
        attribute.addFlashAttribute("success", "Factura guardada con éxito");
        return "redirect:/views/facturas/";
    }

    @GetMapping("/listar/{idFactura}")
    public String listarId(@PathVariable int idFactura, Model model) {
        model.addAttribute("factura", facturaService.listarId(idFactura));
        return "/views/facturas/editar_factura";
    }

    @RequestMapping("/delete/{idFactura}")
    public String deleteFactura(@PathVariable(name = "idFactura") int idFactura, RedirectAttributes attribute) {
        try {
            facturaService.delete(idFactura);
            attribute.addFlashAttribute("info", "Factura eliminada correctamente!");
        } catch (Exception e) {
            attribute.addFlashAttribute("error", "No se pudo eliminar la factura!");
        }
        return "redirect:/views/facturas/";
    }
}
