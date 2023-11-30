package com.example.udemysong.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
public class ProductController {

    //사용자가 요청을 던지면 그걸 받아서
    // 요청에 맞는 메소드를 실행 시킵니다.
    //그에 맞는 로직을 수행할 수 있도록 서비스에게 시킬거에요.

    @Autowired
    private ProductService productService;

    //상품 조회 메서드
    @RequestMapping(value = "/products/{id}", method = RequestMethod.GET)
    public Product findProduct(@PathVariable("id") int idx){

        return productService.findProduct(idx);
    }

    //상품 등록
    @RequestMapping(value = "/products", method = RequestMethod.POST)
    public void saveProduct(@RequestBody Product product){
        productService.saveProduct(product);
    }

}
