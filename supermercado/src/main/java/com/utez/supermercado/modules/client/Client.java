package com.utez.supermercado.modules.client;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.utez.supermercado.modules.carrito_producto.Carrito_Producto;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "client")
public class Client {

    // ATRIBUTOS DE LA TABLA

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false)
    private int id;
    @Column(name = "name",nullable = false)
    private String name;

    // RELACIONES

    @OneToMany(mappedBy = "client")
    @JsonIgnore
    private List<Carrito_Producto> carrito_productos;


    // CONSTRUCTORES

    public Client() {}

    public Client(int id, String name, List<Carrito_Producto> carrito_productos) {
        this.id = id;
        this.name = name;
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

    public List<Carrito_Producto> getCarrito_productos() {
        return carrito_productos;
    }

    public void setCarrito_productos(List<Carrito_Producto> carrito_productos) {
        this.carrito_productos = carrito_productos;
    }
}
