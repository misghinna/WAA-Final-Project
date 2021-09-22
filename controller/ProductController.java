package miu.main.controller;

import miu.main.domain.Product;
import miu.main.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductService productService;


    // Get a list of all the products
    @GetMapping
    public List<Product> getAll() {
        return productService.getAll();
    }

    // get any product of specific id
    @GetMapping("/{id}")
    public Optional<Product> getProductById(@PathVariable("id") long id){
        return productService.getProductByID(id);
    }

    //Save a product
    @PostMapping( "application/json")
    public Product addProductInfo(@RequestBody Product product){
        productService.addProduct(product);
        return product;
    }

    //Delete a product
    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable("id") long id){
        productService.deleteProduct(id);
    }

    // get List of product posted by a seller
    @RequestMapping("/id/seller/{id}")
    public List<Product> getProductsBySeller(@PathVariable("id") long id){
        return productService.getProductsBySellerId(id);
    }

    // get List of products of the same category
    @RequestMapping("/id/category/{id}")
    public List<Product> getProductByCategoryId(@PathVariable("id") long id){
        return productService.getProductsByCategoryId(id);
    }

}
