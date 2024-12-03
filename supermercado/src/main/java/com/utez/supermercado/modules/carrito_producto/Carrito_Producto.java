package com.utez.supermercado.modules.carrito_producto;

import com.utez.supermercado.modules.client.Client;
import com.utez.supermercado.modules.product.Product;
import jakarta.persistence.*;

@Entity
@Table(name = "carrito_producto")
public class Carrito_Producto {

    // ATRIBUTOS DE LA TABLA
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false)
    private int id;
    @Column(name = "cantidad",nullable = false)
    private int cantidad;

    // RELACIONES

    @ManyToOne
    @JoinColumn(name = "id_client",nullable = false)
    private Client client;
    @ManyToOne
    @JoinColumn(name = "id_product",nullable = false)
    private Product product;

    // CONSTRUCTORES

    public Carrito_Producto() {}

    public Carrito_Producto(int id, int cantidad, Client client, Product product) {
        this.id = id;
        this.cantidad = cantidad;
        this.client = client;
        this.product = product;
    }

    //GETTERS AND SETTERS


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
