package com.Api.product;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductPOJO, Integer> {
    ProductPOJO findByAlias(String alias);
}