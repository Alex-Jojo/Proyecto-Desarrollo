package com.app.web.servicio;

import com.app.web.entidad.Empleado;
import com.app.web.entidad.Rol;
import com.app.web.repositorio.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmpleadoServiceImpl implements EmpleadoService{
    @Autowired
    private EmpleadoRepository data;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;


    @Override
    public List<Empleado> listar() {
        return data.findAll();
    }

    @Override
    public Empleado guardarEmpleado(Empleado empleado) {
        Empleado empleado1 = new Empleado(empleado.getNombre(),
        empleado.getEmail(),passwordEncoder.encode(empleado.getPassword()),Arrays.asList(new Rol("Role_User")));
        //Empleado empleado1 = new Empleado(empleado.getNombre(),
          //      empleado.getEmail(),empleado.getPassword(),Arrays.asList(new Rol("Role_User")));

        return data.save(empleado1);
    }

    @Override
    public Empleado obtenerId(Long id) {
        return data.findById(id).get();
    }

    @Override
    public Empleado actualizarEmpleado(Empleado empleado) {
        return data.save(empleado);
    }

    @Override
    public void eliminarEmpleado(Long id) {
        data.deleteById(id);

    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Empleado usuario = data.findByEmail(username);
        if(usuario == null) {
            throw new UsernameNotFoundException("Usuario o password inválidos");
        }
        return new User(usuario.getEmail(),usuario.getPassword(), mapearAutoridadesRoles(usuario.getRoles()));
    }

    private Collection<? extends GrantedAuthority> mapearAutoridadesRoles(Collection<Rol> roles){
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getNombre())).collect(Collectors.toList());//roles.stream().map(role -> new SimpleGrantedAuthority(role.getNombre())).collect(Collectors.toList());
    }
}
