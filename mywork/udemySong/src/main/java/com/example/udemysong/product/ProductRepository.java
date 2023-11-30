package com.example.udemysong.product;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
//기존 dao
@Repository
public class ProductRepository {

    private final Map<Integer, Product> db = new HashMap<>();
    private int id = 1;

    public Product findProduct(int idx){
        return db.get(idx);
    }

    public void save(Product product){
        System.out.println(product.getName());
       db.put(id++, product);
    }
}
