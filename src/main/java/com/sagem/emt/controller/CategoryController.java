package com.sagem.emt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sagem.emt.dao.entity.Category;
import com.sagem.emt.service.CategoryService;

@RestController
@RequestMapping("category")
public class CategoryController {
    @Autowired
    private CategoryService categorieService;

    @GetMapping
    public List<Category> getAll() {
	return categorieService.getAll();
    }

    @PostMapping
    public Category save(@RequestBody Category category) {
	return categorieService.save(category);
    }

    @DeleteMapping("clear")
    public void deleteAll() {
	categorieService.deleteAll();
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Long id) {
	categorieService.delete(id);
    }
}
