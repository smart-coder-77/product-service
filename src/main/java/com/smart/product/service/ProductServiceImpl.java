package com.smart.product.service;

import com.smart.product.dto.ProductDto;
import com.smart.product.entity.Product;
import com.smart.product.exception.ProductIdNotFoundException;
import com.smart.product.exception.ProductNotFoundException;
import com.smart.product.exception.ProductNotSavedException;
import com.smart.product.mapper.ProductMapper;
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

    @Autowired
    private ProductMapper productMapper;

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
    public Boolean saveProduct(ProductDto productDto) {
       if (productDto.getPName()!=null){
            productRepository.save(productMapper.dtoToEntity(productDto));
            return true;
        }else {
            throw new ProductNotSavedException("Product Not Saved");
        }
    }

    @Override
    public ProductDto getProductById(Long pId) {
        return productMapper.entityToDto(productRepository.findById(pId).orElseThrow(()->new ProductIdNotFoundException("Product"+pId+"NotFound Exception")));
    }

    @Override
    public ProductDto getProductByName(String pName) {
        ProductDto productDto= productMapper.entityToDto(productRepository.findBypName(pName));
        if (productDto.getPName()!=null){
            return productDto;
        }else {
            throw new ProductIdNotFoundException("Product"+pName+"Not Found Exception");
        }
    }

    @Override
    public Boolean deleteProductById(Long pId) {
        productRepository.deleteById(pId);
        return true;
    }
}
