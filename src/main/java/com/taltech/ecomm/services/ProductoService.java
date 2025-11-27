package com.taltech.ecomm.services;
import com.taltech.ecomm.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.taltech.ecomm.modelos.Producto;

import java.util.List;

@Service
public class ProductoService {
    private final ProductoRepository repo;

    @Autowired
    public ProductoService(ProductoRepository repo) {
        this.repo = repo;
    }

    private String pruebaService = "Probando Service";


    public List<Producto> listarProductos(){
        return repo.findAll();
    }

    public Producto obtenerPorId(int id){
        return repo.findById(id).orElse(null);
    }

    public boolean eliminarProducto(int id){
        if (repo.existsById(id)){
            repo.deleteById(id);
            return true;
        }
        return false;
    }

    public Producto guardarProducto(Producto producto){
        return repo.save(producto);
    }

    public Producto actualizarProducto(int id, Producto datos){
        Producto p = obtenerPorId(id);
        if (p != null){
            p.setNombre(datos.getNombre());
        }
        return null;
    }

    public String getPruebaService() {
        return pruebaService;
    }
}
