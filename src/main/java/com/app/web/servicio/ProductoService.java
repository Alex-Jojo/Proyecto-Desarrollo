package com.app.web.servicio;

import com.app.web.entidad.Producto;

import java.util.List;

public interface ProductoService {
    public List<Producto> listar();
    public Producto guardarProducto(Producto producto);
    public Producto obtenerId(Long id);
    public Producto actualizarProducto(Producto producto);
    public void eliminarProducto(Long id);
}
