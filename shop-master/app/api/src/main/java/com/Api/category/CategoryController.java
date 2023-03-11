package com.Api.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class CategoryController {

    @Autowired
    CategoryRepository categoryRepository;

    // Get All Notes
    @GetMapping("/category")
    public List<CategoryPOJO> getAllNotes() {
        return categoryRepository.findAll();
    }

    @GetMapping("/category/{alias}")
    public CategoryPOJO getNoteById(@PathVariable(value = "alias") String alias) throws CategoryControllerNotFoundException {
        return categoryRepository.findById(categoryRepository.findByAlias(alias).getId()).orElseThrow(() -> new CategoryControllerNotFoundException(alias));
    }

    @DeleteMapping("/category/{id}")
    public Boolean deleteBook(@PathVariable(value = "id") Integer productId) throws CategoryControllerNotFoundException {
        CategoryPOJO product = categoryRepository.findById(productId)
                .orElseThrow(() -> new CategoryControllerNotFoundException(productId));

        categoryRepository.delete(product);
        return true;
    }

    @PostMapping("/category")
    public CategoryPOJO createNote(@RequestBody CategoryPOJO product) {
        return categoryRepository.save(product);
    }

    @PutMapping("/category/{id}")
    public CategoryPOJO updateNote(@PathVariable(value = "id") Integer categoryId,
                                     @RequestBody CategoryPOJO newCategory) throws CategoryControllerNotFoundException {

        CategoryPOJO oldCategory = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new CategoryControllerNotFoundException(categoryId));

        oldCategory.setAlias(newCategory.getAlias() == null ? oldCategory.getAlias() : newCategory.getAlias());
        oldCategory.setDescription(newCategory.getDescription() == null? oldCategory.getDescription() : newCategory.getDescription());
        oldCategory.setKeywords(newCategory.getKeywords() == null? oldCategory.getKeywords() : newCategory.getKeywords());
        oldCategory.setTitle(newCategory.getTitle() == null? oldCategory.getTitle() : newCategory.getTitle());
        oldCategory.setParent_id(newCategory.getParent_id() == 0 ? oldCategory.getParent_id() : newCategory.getParent_id());

        CategoryPOJO updatedCategory = categoryRepository.save(oldCategory);

        return updatedCategory;
    }
}