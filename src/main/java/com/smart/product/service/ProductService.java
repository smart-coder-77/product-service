package com.smart.product.service;

import com.smart.product.entity.Product;

import java.util.List;

/**
 * @author Choudhury Subham on 31-05-2022
 */
public interface ProductService {

     List<Product> getAllProduct();
     Boolean saveProduct(Product product);
     Product getProductById(Long pId);
     Product getProductByName(String pName);
     Boolean deleteProductById(Long pId);

}
