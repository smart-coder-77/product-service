package com.smart.product.service;

import com.smart.product.dto.ProductDto;
import com.smart.product.entity.Product;

import java.util.List;

/**
 * @author Choudhury Subham on 31-05-2022
 */
public interface ProductService {

     List<Product> getAllProduct();
     Boolean saveProduct(ProductDto productDto);
     ProductDto getProductById(Long pId);
     ProductDto getProductByName(String pName);
     Boolean deleteProductById(Long pId);

}
