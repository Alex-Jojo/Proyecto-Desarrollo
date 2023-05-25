package com.app.web.controlador;


import com.app.web.entidad.Empleado;
import com.app.web.servicio.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
//@RequestMapping("/empleados/nuevo")
public class EmpleadoController {
    @Autowired
    private EmpleadoService inEmpleado;

    @GetMapping("/empleados")
    public String listar(Model model) {
        //List<Empleado> empleados = inEmpleado.listar();
        model.addAttribute("empleado",inEmpleado.listar());
        return "empleado";
    }

    @GetMapping("/empleados/nuevo")
    public String mostrarFormRegistroEmpleado(Model modelo){
        Empleado empleado = new Empleado();
        modelo.addAttribute("empleado", empleado);
        return "crearempleado";
    }

    @PostMapping("/empleados")
    public String guardarEmpleado(@ModelAttribute("empleado") Empleado empleado){
        inEmpleado.guardarEmpleado(empleado);
        return "redirect:/empleados";
    }


    @GetMapping("/empleados/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable Long id, Model modelo){
        modelo.addAttribute("empleado", inEmpleado.obtenerId(id));
        return "editarempleado";
    }

    @PostMapping("/empleados/{id}")
    public String actualizarListaEmpleado(@PathVariable Long id, @ModelAttribute("empleado") Empleado empleado){
        Empleado empleado1 = inEmpleado.obtenerId(id);
        empleado1.setId(id);
        empleado1.setNombre(empleado.getNombre());
        empleado1.setEmail(empleado.getEmail());
        empleado1.setPassword(empleado.getPassword());
        //empleado1.setRol(empleado.getRol());

        inEmpleado.actualizarEmpleado(empleado1);
        return "redirect:/empleados";
    }



    @GetMapping("/empleados/{id}")
    public String eliminarEmpleado(@PathVariable Long id){
        inEmpleado.eliminarEmpleado(id);
        return "redirect:/empleados";
    }
}
