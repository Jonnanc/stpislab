package com.Api.product;

import com.Api.category.CategoryControllerNotFoundException;
import com.Api.category.CategoryPOJO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    // Get All Notes
    @GetMapping("/products")
    public List<ProductPOJO> getAllNotes() {
        return productRepository.findAll();
    }

    @GetMapping("/products/{alias}")
    public ProductPOJO getNoteById(@PathVariable(value = "alias") String alias) throws ProductNotFoundException {
        return productRepository.findById(productRepository.findByAlias(alias).getId()).orElseThrow(() -> new ProductNotFoundException(alias));
    }


    @DeleteMapping("/products/{id}")
    public Boolean deleteBook(@PathVariable(value = "id") Integer productId) throws ProductNotFoundException {
        ProductPOJO product = productRepository.findById(productId)
                .orElseThrow(() -> new ProductNotFoundException(productId));

        productRepository.delete(product);
        return true;
    }

    @PostMapping("/products")
    public ProductPOJO createNote(@RequestBody ProductPOJO product) {
        return productRepository.save(product);
    }

    @PutMapping("/products/{id}")
    public ProductPOJO updateNote(@PathVariable(value = "id") Integer productId,
                                   @RequestBody ProductPOJO newProduct) throws ProductNotFoundException {

        ProductPOJO oldProduct = productRepository.findById(productId)
                .orElseThrow(() -> new ProductNotFoundException(productId));
        System.out.println(oldProduct);
        oldProduct.setBrand_id(newProduct.getBrand_id() == 0 ? newProduct.getBrand_id() : oldProduct.getBrand_id());
        oldProduct.setTitle(oldProduct.getTitle());
        oldProduct.setAlias(oldProduct.getAlias());
        oldProduct.setContent(newProduct.getContent() == null ? newProduct.getContent() : oldProduct.getContent());
        oldProduct.setPrice(newProduct.getPrice() != 0.0 ? newProduct.getPrice() : oldProduct.getPrice());
        oldProduct.setOld_price(newProduct.getOld_price() == 0.0 ? newProduct.getOld_price() : oldProduct.getOld_price());
        oldProduct.setStatus(true);
        oldProduct.setKeywords(newProduct.getKeywords() == null? newProduct.getKeywords() : oldProduct.getKeywords());
        oldProduct.setDescription(newProduct.getDescription() == null? newProduct.getDescription() : oldProduct.getDescription());
        oldProduct.setImg(oldProduct.getImg());
        oldProduct.setHits(oldProduct.isHits());

        return productRepository.save(oldProduct);
    }
}