package com.app.web.controlador;

import com.app.web.entidad.Producto;
import com.app.web.servicio.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ProductoController {
    @Autowired
    private ProductoService repository;

    @GetMapping("/productos")
    public String listar(Model modelo){
        List<Producto> productos = repository.listar();
        modelo.addAttribute("producto", productos);
        return "producto";
    }
    @GetMapping("/productos/nuevo")
    public String mostrarFormRegistroProducto(Model modelo){
        Producto producto = new Producto();
        modelo.addAttribute("producto", producto);
        return "crearproducto";
    }

    @PostMapping("/productos")
    public String guardarProducto(@ModelAttribute("producto") Producto producto){
        repository.guardarProducto(producto);
        return "redirect:/productos";
    }

    @GetMapping("/productos/editar/{id}")
    public String mostrarFormuEditar(@PathVariable Long id, Model modelo){
        modelo.addAttribute("producto", repository.obtenerId(id));
        return "editarproducto";
    }

    @PostMapping("/productos/{id}")
    public String actualizarProducto(@PathVariable Long id, @ModelAttribute("producto") Producto producto){
        Producto producto1 = repository.obtenerId(id);
        producto1.setId(id);
        producto1.setNombre(producto.getNombre());
        producto1.setPrecio((producto.getPrecio()));
        repository.actualizarProducto(producto1);
        return "redirect:/productos";
    }

    @GetMapping("/productos/{id}")
    public String eliminarProducto(@PathVariable Long id){
        repository.eliminarProducto(id);
        return "redirect:/productos";
    }


}
