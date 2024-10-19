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


import com.registro.usuarios.modelo.Producto;
import com.registro.usuarios.servicio.ProductoService;

@Controller
@RequestMapping("/views/producto")
public class ProductoController {

    @Autowired
    ProductoService productoService;

    @GetMapping("/")
    public String verIndex(Model model) {
        List<Producto> listaProductos = productoService.getProductos();
        model.addAttribute("listaProductos", listaProductos);
        return "/views/producto/producto";
    }
    
    @GetMapping("/Producto")
    public String ver(Model model) {
        List<Producto> listaProductos = productoService.getProductos();
        model.addAttribute("listaProductos", listaProductos);
        return "/views/producto/plantilla";
    }

    @GetMapping("/new")
    public String MostrarPaginaNuevoProducto(Model model) {
        Producto producto = new Producto();
        model.addAttribute("producto", producto);
        return "/views/producto/nuevo_producto";
    }

    @PostMapping("/save")
    public String saveProducto(@Valid @ModelAttribute("producto") Producto producto, Errors errors, Model model,
            RedirectAttributes attribute) {
        if (errors.hasErrors()) {
            return "/views/producto/nuevo_producto";
        }
        productoService.nuevoProducto(producto);
        attribute.addFlashAttribute("success", "Producto guardado con éxito");
        return "redirect:/views/producto/";
    }

    @GetMapping("/listar/{id_producto}")
    public String listarId(@PathVariable int id_producto, Model model) {
        model.addAttribute("producto", productoService.buscarProducto(id_producto));
        return "/views/producto/editar_producto";
    }

    @RequestMapping("/delete/{id_producto}")
    public String deleteProducto(@PathVariable(name = "id_producto") int id_producto, RedirectAttributes attribute) {
        try {
            productoService.borrarProducto(id_producto);
            System.out.println("Producto eliminado correctamente!");
            attribute.addFlashAttribute("info", "Producto eliminado correctamente!");
        } catch (Exception e) {
            System.out.println("No se pudo eliminar el producto!");
            attribute.addFlashAttribute("error", "No se pudo eliminar el producto!");
        }
        return "redirect:/views/producto/";
    }
}