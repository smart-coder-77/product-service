package com.smart.product.repository;

import com.smart.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Choudhury Subham on 31-05-2022
 */
@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

    public Product findByProductName(String pName);
}
