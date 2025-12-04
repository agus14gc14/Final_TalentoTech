package com.taltech.ecomm.modelos;
import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonProperty; // 1. Importante importar esto

@Entity
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JsonProperty("title")
    private String nombre;

    @JsonProperty("description")
    private String descripcion;

    @JsonProperty("price")
    private double precio;

    @JsonProperty("image")
    private String imagenUrl;


    public Producto(){ //Vacio para instanciacion de hibernate

    }

    public Integer getId() {
        return id;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Producto(String nombre, String descripcion, double precio, String imagenUrl){
        setNombre(nombre);
        setDescripcion(descripcion);
        setPrecio(precio);
        setImagenUrl(imagenUrl);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public String getImagenUrl() {
        return imagenUrl;
    }
    public void setImagenUrl(String imagenUrl) {
        this.imagenUrl = imagenUrl;
    }

}

