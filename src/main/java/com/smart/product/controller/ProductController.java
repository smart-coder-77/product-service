package com.smart.product.controller;

import com.smart.product.dto.ProductDto;
import com.smart.product.entity.Product;
import com.smart.product.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
/**
 * @author Choudhury Subham on 31-05-2022
 */
@RestController
@RequestMapping("/product")
@Slf4j
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/")
    public ResponseEntity<String> saveProduct(@RequestBody ProductDto productDto){
        log.info("Inside save product");
        return new ResponseEntity<String>(productService.saveProduct(productDto)?"Product saved successfully":"Product not saved", HttpStatus.CREATED);
    }

    @GetMapping("/")

    public ResponseEntity<List<Product>> getListOfProducts(){
        log.debug("get all products");
        return new ResponseEntity<>(productService.getAllProduct(),HttpStatus.FOUND);
    }

    @GetMapping("/id")
    public ResponseEntity<ProductDto> getProductsByID(@RequestParam Long id){
        log.debug("get products by ID");
        return new ResponseEntity<ProductDto>(productService.getProductById(id),HttpStatus.OK);
    }

    @GetMapping("/name")
    public ResponseEntity<ProductDto> getProductByName(@RequestParam String name){
        log.debug("get products by Name");
        return new ResponseEntity<>(productService.getProductByName(name),HttpStatus.OK);
    }

    @DeleteMapping("/")
    public ResponseEntity<String> deleteProductById(@RequestParam Long id){
        log.debug("delete products by Id");
        return new ResponseEntity<>(productService.deleteProductById(id)?"Product removed successfully":"Product not removed",HttpStatus.OK);
    }
}
