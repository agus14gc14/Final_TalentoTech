package com.taltech.ecomm;
import com.taltech.ecomm.modelos.Producto;
import com.taltech.ecomm.operaciones.manejadorJson;
import com.taltech.ecomm.services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")

public class ProductoController {
    private final ProductoService productoService;
    @Autowired
    public ProductoController(ProductoService productoService){
        this.productoService = productoService;
    }


    public String saludoSpring(){
        return "Hola desde Spring";
    }

    @GetMapping("/serviceTest")
    public String probandoService(){
        return productoService.getPruebaService();
    }

    @GetMapping("/listado")
    public List <Producto> listado(){
        return productoService.listarProductos();
    }

    @PostMapping ("/crear")
    public Producto crearProducto(@RequestBody Producto producto){
        return productoService.guardarProducto(producto);
    }

    @GetMapping ("/busqueda")
    public Producto buscarPorId(@RequestBody int id){
        return productoService.obtenerPorId(id);
    }

    @DeleteMapping("/eliminar")
    public void eliminar(@RequestBody int id){
        productoService.eliminarProducto(id);
    }

    @PostMapping ("/actualizarProducto")
    public Producto actualizar(@RequestBody manejadorJson manejador){
        Integer id = manejador.getIdJson();
        Producto obtenido = manejador.getProductoJson();
        return productoService.actualizarProducto(id, obtenido);
    }

}
