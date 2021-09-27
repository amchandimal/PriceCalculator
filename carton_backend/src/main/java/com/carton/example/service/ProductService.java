package com.carton.example.service;

import com.carton.example.dto.*;
import com.carton.example.model.Product;
import com.carton.example.repositary.ProductRepositary;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductRepositary repositary;

    public ProductService(ProductRepositary repositary) {
        this.repositary = repositary;
    }

    public ResponseEntity<?> getPriceMapforProduct(int productId) {

        Product product = repositary.findById(productId).orElse(null);
        if (product == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        List<PricingResponseBaseModel> responseList = new ArrayList<>();
        for (int i = 1; i <= 50; i++) {
            PricingModel model = new PricingModel(0, i);
            double cost = optimize(model, product);
            responseList.add(new PricingResponseBulkModel(i, model.cartons, model.units, cost));
        }
        return ResponseEntity.ok(responseList);
    }

    public ResponseEntity<?> getPriceForProduct(int productId, int cartons, int units) {

        if (cartons < 0 || units < 0) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Product product = repositary.findById(productId).orElse(null);
        if (product == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        PricingResponeDto responeDto = new PricingResponeDto();
        responeDto.setProductId(productId);
        responeDto.setName(product.getName());

        PricingModel pricingModel = new PricingModel(cartons, units);
        responeDto.setPrice(optimize(pricingModel, product));
        responeDto.setCartons(pricingModel.cartons);
        responeDto.setUnits(pricingModel.units);

        return ResponseEntity.ok(responeDto);
    }

    public List<ProductDto> getAllProducts() {
        return repositary.findAll().stream().map(product -> new ProductDto(product)).collect(Collectors.toList());
    }

    //Logics

    public double optimize(PricingModel pricingModel, Product product) {
        //Getting No of Cartons in Units
        pricingModel.cartons += pricingModel.units / product.getCartonSize();
        //Getting setting of Units
        pricingModel.units %= product.getCartonSize();
        return getPrice(pricingModel.cartons, pricingModel.units, product);
    }


    public double getPrice(int cartons, int units, Product product) {
        double total = 0;

        //Adding the Unit Price Extra
        total += units * (product.getCartonPrice() / product.getCartonSize()) * (1 + product.getHandlingPercentage());

        //Adding Carton Price
        if (cartons >= product.getDisountQty()) {
            total += cartons * product.getCartonPrice() * (1 - product.getDiscountRate());
        } else {
            total += cartons * product.getCartonPrice();
        }

        return total;
    }


}
