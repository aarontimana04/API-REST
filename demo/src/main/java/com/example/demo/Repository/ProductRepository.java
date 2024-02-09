package com.example.demo.Repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.Entities.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long>{

    List<Product> findProductByPriceBetween(BigDecimal minPrice, BigDecimal maxPrice);
    
}
