package com.app.web.servicio;

import com.app.web.entidad.Producto;
import com.app.web.repositorio.EmpleadoRepository;
import com.app.web.repositorio.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServiceImpl implements ProductoService{
    @Autowired
    private ProductoRepository data;


    @Override
    public List<Producto> listar() {
        return data.findAll();
    }

    @Override
    public Producto guardarProducto(Producto producto) {
        return data.save(producto);
    }

    @Override
    public Producto obtenerId(Long id) {
        return data.findById(id).get();
    }

    @Override
    public Producto actualizarProducto(Producto producto) {
        return data.save(producto);
    }

    @Override
    public void eliminarProducto(Long id) {
        data.deleteById(id);
    }
}
