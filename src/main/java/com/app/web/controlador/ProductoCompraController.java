package com.app.web.controlador;


import com.app.web.entidad.Producto;
import com.app.web.servicio.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


@Controller
public class ProductoCompraController {
    @Autowired
    private ProductoService repository;

    @GetMapping("/productocompra")
    public String listar(Model modelo) {
        List<Producto> productos = repository.listar();
        modelo.addAttribute("producto", productos);
        return "productocompra";
    }
}
