package rnd.product.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rnd.product.model.Product;

@RestController
public class ProductController {

    @RequestMapping("/product/{productId}")
    public Product getProduct(@PathVariable int productId){
        return new Product(productId, "productName", 8);
    }
}
