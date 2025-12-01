package com.taltech.ecomm.operaciones;
import com.taltech.ecomm.modelos.Producto;

//Clase creada como DTO para manejar JSON con varios parametros

public class manejadorJson {
    private Integer idJson;
    private Producto productoJson;

    public Integer getIdJson() {
        return idJson;
    }

    public void setIdJson(Integer idJson) {
        this.idJson = idJson;
    }

    public Producto getProductoJson() {
        return productoJson;
    }

    public void setProductoJson(Producto productoJson) {
        this.productoJson = productoJson;
    }
}
