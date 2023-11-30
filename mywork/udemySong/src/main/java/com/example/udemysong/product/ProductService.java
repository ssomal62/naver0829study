package com.example.udemysong.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ProductService {


    private ProductRepository productRepository;

    @Autowired
    ProductService (ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public Product findProduct(int idx){
        return productRepository.findProduct(idx);
    }

    public void saveProduct(Product product){
        productRepository.save(product);
    }
}
