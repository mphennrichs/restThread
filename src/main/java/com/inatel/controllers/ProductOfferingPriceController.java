package com.inatel.controllers;

import com.inatel.domain.ProductOfferingPrice;
import com.inatel.services.ProductOfferingPriceService;
import com.sun.xml.internal.ws.transport.http.WSHTTPConnection;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("pop")
@Api(value="ProductOfferingPrice")
public class ProductOfferingPriceController {

    @Autowired
    ProductOfferingPriceService popService;

    @GetMapping(produces = "application/json")
    @ApiOperation(value = "Retrieve a list of all ProductOfferingPrice",response = Iterable.class)
    public List<ProductOfferingPrice> getAll(){

        return popService.getAllProductOfferingPrice();
    }

    @GetMapping(path = "/search", produces = "application/json")
    @ApiOperation(value = "Retrieve ProductOfferingPrice by id",response = ProductOfferingPrice.class)
    public ProductOfferingPrice getProductOfferingPrice(@RequestParam Long id){

        return popService.getProductOfferingPrice(id);
    }

    @GetMapping(path = "/delete", produces = "application/json")
    @ApiOperation(value = "Delete ProductOfferingPrice by id",response = ProductOfferingPrice.class)
    public ProductOfferingPrice deleteProductOfferingPrice(@RequestParam Long id){

        return popService.deleteProductOfferingPrice(id);
    }

    @PostMapping(path = "/add", consumes = "application/json")
    @ApiOperation(value = "Add a ProductOfferingPrice and return the same object if the operation succeeds",
            response = ProductOfferingPrice.class)
    public ResponseEntity addProductOfferingPrice(@RequestBody ProductOfferingPrice pop){
        try{

            popService.addProductOfferingPrice(pop);

        } catch (Exception ex) {
            return ResponseEntity.status(WSHTTPConnection.INTERNAL_ERR).body(ex.getMessage());
        }

        return ResponseEntity.ok(pop);
    }

    @PutMapping(path = "/update", consumes = "application/json")
    @ApiOperation(value = "Update ProductOfferingPrice data and return the same ProductOfferingPrice if the operation succeeds",
            response = ProductOfferingPrice.class)
    public ResponseEntity updateProductOfferingPrice(@RequestBody ProductOfferingPrice pop){
        try{

            popService.addProductOfferingPrice(pop);

        } catch (Exception ex) {
            return ResponseEntity.status(WSHTTPConnection.INTERNAL_ERR).body(ex.getMessage());
        }

        return ResponseEntity.ok(pop);
    }
}
