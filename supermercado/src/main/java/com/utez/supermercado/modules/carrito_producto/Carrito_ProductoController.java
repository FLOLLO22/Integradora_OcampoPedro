package com.utez.supermercado.modules.carrito_producto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/carrito_producto")
public class Carrito_ProductoController {
    @Autowired
    private Carrito_ProductoService carrito_productoService;

    @PostMapping("")
    public ResponseEntity<?> save(@RequestBody Carrito_Producto cp) {
        return carrito_productoService.save(cp);
    }
}
