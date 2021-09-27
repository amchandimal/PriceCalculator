package com.carton.example.service;

import com.carton.example.CartonexampleApplication;
import com.carton.example.dto.PricingModel;
import com.carton.example.model.Product;
import com.carton.example.repositary.ProductRepositary;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CartonexampleApplication.class)

class ProductServiceTest {

    @InjectMocks
    ProductService service;

    public Product getProduct(){
        Product testProduct = new Product();
        testProduct.setName("testProduct");
        testProduct.setCartonPrice(100);
        testProduct.setCartonSize(10);
        testProduct.setDiscountRate(0.1);
        testProduct.setDisountQty(5);
        testProduct.setHandlingPercentage(0.3);
        testProduct.setId(1);
        return testProduct;
    }

    @Test
    void checkPriceWithCartonsOnly() {
        Product testProduct = getProduct();
        int cartons = 2;
        int units = 0;
        PricingModel pricingModel = new PricingModel(cartons,units);
        assertEquals( 200,service.optimize(pricingModel,testProduct));
    }

    @Test
    void checkPriceWithUnitOnlyUnderCartonSize() {
        Product testProduct = getProduct();
        int cartons = 0;
        int units = 7;
        PricingModel pricingModel = new PricingModel(cartons,units);
        assertEquals( 91,service.optimize(pricingModel,testProduct));
    }

    @Test
    void checkPriceWithUnitOnlyOverCartonSize() {
        Product testProduct = getProduct();
        int cartons = 0;
        int units = 11;
        PricingModel pricingModel = new PricingModel(cartons,units);
        assertEquals( 113,service.optimize(pricingModel,testProduct));
        assertEquals(1,pricingModel.cartons);
        assertEquals(1,pricingModel.units);
    }

    @Test
    void checkPriceWithCartonsAndUnits() {
        Product testProduct = getProduct();
        int cartons = 1;
        int units = 11;
        PricingModel pricingModel = new PricingModel(cartons,units);
        assertEquals( 213,service.optimize(pricingModel,testProduct));
        assertEquals(2,pricingModel.cartons);
        assertEquals(1,pricingModel.units);
    }

    @Test
    void checkPriceWithDiscounts() {
        Product testProduct = getProduct();
        int cartons = 10;
        int units = 0;
        PricingModel pricingModel = new PricingModel(cartons,units);
        assertEquals( 900,service.optimize(pricingModel,testProduct));
    }

}