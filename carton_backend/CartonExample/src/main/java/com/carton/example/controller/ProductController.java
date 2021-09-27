package com.carton.example.controller;

import com.carton.example.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping("/getbulkprices")
    public ResponseEntity<?> getBulkPrices(@RequestParam("productid") int productId) {
        return service.getPriceMapforProduct(productId);
    }

    @GetMapping("/getprice")
    public ResponseEntity<?> getPrice(@RequestParam("productid") int productId, @RequestParam("cartons") int cartons, @RequestParam("units") int units) {
        return service.getPriceForProduct(productId, cartons, units);
    }


    @GetMapping("/getallproducts")
    public ResponseEntity<?> getAllProducts() {
        return ResponseEntity.ok(service.getAllProducts());
    }

}
