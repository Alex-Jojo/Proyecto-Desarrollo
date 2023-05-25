package com.app.web.controlador;


import com.app.web.servicio.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class RegistroController {

    @Autowired
    private EmpleadoService servicio;

    @GetMapping("/login")
    public String login(){
        return "login";
    }



    @GetMapping("/login/")
    public String verPaginaDeInicio(Model modelo) {
        modelo.addAttribute("empleado", servicio.listar());
        return "index";
    }


}
