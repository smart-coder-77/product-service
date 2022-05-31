package com.smart.product.controller;

import com.smart.product.entity.Product;
import com.smart.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Choudhury Subham on 31-05-2022
 */

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/save")
    public String saveProduct(@RequestBody Product product){
        return productService.saveProduct(product)?"Product saved successfully":"Product not saved";
    }
    
    @GetMapping("/all")
    public List<Product> getListOfProducts(){
        return productService.getAllProduct();
    }

    @GetMapping("/")
    public Product getProductByID(@RequestParam Long id){
        return productService.getProductById(id);
    }

    @GetMapping("/name/")
    public Product getProductByName(@RequestParam String name){
        return productService.getProductByName(name);
    }

    @DeleteMapping("/")
    public String getProductByName(@RequestParam Long id){
        return productService.deleteProductById(id)?"Product removed successfully":"Product not removed";
    }
}
