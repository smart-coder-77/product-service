package com.smart.product.controller;

import com.smart.product.entity.Product;
import com.smart.product.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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

    @PostMapping("/save")
    public String saveProduct(@RequestBody Product product){
        log.info("Inside save product");
        return productService.saveProduct(product)?"Product saved successfully":"Product not saved";
    }

    @GetMapping(value = "/all")

    public List<Product> getListOfProducts(){
        log.debug("get all products");
        return productService.getAllProduct();
    }

    @GetMapping("/")
    public Product getProductsByID(@RequestParam Long id){
        log.debug("get products by ID");
        return productService.getProductById(id);
    }

    @GetMapping("/name/")
    public Product getProductByName(@RequestParam String name){
        log.debug("get products by Name");
        return productService.getProductByName(name);
    }

    @DeleteMapping("/")
    public String deleteProductById(@RequestParam Long id){
        log.debug("delete products by Id");
        return productService.deleteProductById(id)?"Product removed successfully":"Product not removed";
    }
}
