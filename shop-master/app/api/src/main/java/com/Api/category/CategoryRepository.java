package com.Api.category;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryPOJO, Integer> {
    CategoryPOJO findByAlias(String alias);
}