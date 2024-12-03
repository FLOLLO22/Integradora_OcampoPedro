package com.utez.supermercado.modules.carrito_producto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Carrito_ProductoRepository extends JpaRepository<Carrito_Producto, Long>{

    List<Carrito_Producto> findAll();
    Carrito_Producto save(Carrito_Producto cp);


}
