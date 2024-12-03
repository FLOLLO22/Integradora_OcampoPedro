package com.utez.supermercado.modules.product;

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
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Transactional(rollbackFor = {SQLException.class, Exception.class})
    public ResponseEntity<?> save(Product product) {
        Map<String, Object> body = new HashMap<>();
        Product saved = null;
        try {
            saved = productRepository.save(product);
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
