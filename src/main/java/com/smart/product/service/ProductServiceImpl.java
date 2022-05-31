package com.smart.product.service;

import com.smart.product.entity.Product;
import com.smart.product.exception.ProductIdNotFoundException;
import com.smart.product.exception.ProductNotFoundException;
import com.smart.product.exception.ProductNotSavedException;
import com.smart.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Choudhury Subham on 31-05-2022
 */

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getAllProduct() {
        List<Product> products = productRepository.findAll();
        if (products.size()>0){
            return products;
        }else {
            throw new ProductNotFoundException("Product Not Found");
        }
    }

    @Override
    public Boolean saveProduct(Product product) {
       if (product.getPName()!=null){
            productRepository.save(product);
            return true;
        }else {
            throw new ProductNotSavedException("Product Not Saved");
        }
    }

    @Override
    public Product getProductById(Long pId) {
        return productRepository.findById(pId).orElseThrow(()->new ProductIdNotFoundException("Product"+pId+"NotFound Exception"));
    }

    @Override
    public Product getProductByName(String pName) {
        Product product= productRepository.findBypName(pName);
        if (product.getPid()!=null){
            return product;
        }else {
            throw new ProductIdNotFoundException("Product"+pName+"Not Found Exception");
        }
    }

    @Override
    public Boolean deleteProductById(Long pId) {
        Product product = getProductById(pId);
        productRepository.delete(product);
        return true;
    }
}
