package com.app.web.servicio;

import com.app.web.entidad.Empleado;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface EmpleadoService extends UserDetailsService {
    public List<Empleado> listar();

    public Empleado guardarEmpleado(Empleado empleado);
    public Empleado obtenerId(Long id);
    public Empleado actualizarEmpleado(Empleado empleado);
    public void eliminarEmpleado(Long id);
}
