package com.utez.supermercado.modules.product;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.utez.supermercado.modules.carrito_producto.Carrito_Producto;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "product")
public class Product {

    // ATRIBUTOS DE LA TABLA

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false)
    private int id;
    @Column(name = "name",nullable = false)
    private String name;
    @Column(name = "precio",nullable = false)
    private double precio;

    // RELACIONES

    @OneToMany(mappedBy = "product")
    @JsonIgnore
    private List<Carrito_Producto> carrito_productos;

    // CONSTRUCTORES

    public Product() {}

    public Product(int id, String name, double precio, List<Carrito_Producto> carrito_productos) {
        this.id = id;
        this.name = name;
        this.precio = precio;
        this.carrito_productos = carrito_productos;
    }

    //GETTERS AND SETTERS

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public List<Carrito_Producto> getCarrito_productos() {
        return carrito_productos;
    }

    public void setCarrito_productos(List<Carrito_Producto> carrito_productos) {
        this.carrito_productos = carrito_productos;
    }
}
