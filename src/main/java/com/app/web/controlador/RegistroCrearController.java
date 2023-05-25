package com.app.web.controlador;

import com.app.web.entidad.Empleado;
import com.app.web.servicio.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/registro")
public class RegistroCrearController {

    @Autowired
    private EmpleadoService usuarioServicio;

    @ModelAttribute("empleado")
    public Empleado retornarNuevoUsuarioRegistroDTO() {
        return new Empleado();
    }

    @GetMapping
    public String mostrarFormularioDeRegistro() {
        return "registro";
    }

    @PostMapping
    public String registrarCuentaDeUsuario(@ModelAttribute("empleado") Empleado registroDTO) {
        usuarioServicio.guardarEmpleado(registroDTO);
        return "redirect:/registro?exito";
    }


}
