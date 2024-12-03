package com.utez.supermercado.modules.carrito_producto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class Carrito_ProductoService {
    @Autowired
    private Carrito_ProductoRepository carrito_productoRepository;

    @Transactional(rollbackFor = {SQLException.class, Exception.class})
    public ResponseEntity<?> save(Carrito_Producto carrito_producto) {
        Map<String, Object> body = new HashMap<>();
        Carrito_Producto saved = null;
        try {
            saved = carrito_productoRepository.save(carrito_producto);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

        body.put("message", saved == null ? "No se registró la información" : "Operación exitosa");
        body.put("status", saved == null ? "BAD_REQUEST" : "OK");
        body.put("code", saved == null ? 400 : 200);
        body.put("data", saved == null ? null : saved.getId());
        return new ResponseEntity<>(body, saved == null ? HttpStatus.BAD_REQUEST : HttpStatus.OK);
    }
}
