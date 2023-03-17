package com.sagem.emt.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sagem.emt.dao.entity.Category;
import com.sagem.emt.dao.repository.CategoryRepository;

@Service
public class CategoryService implements com.sagem.emt.service.CategoryService	 {
    @Autowired
    private CategoryRepository categorieRepository;

    @Override
    public List<Category> getAll() {
	return categorieRepository.findAll();
    }

    @Override
    public Category save(Category c) {
	return categorieRepository.save(c);
    }

    @Override
    public void deleteAll() {
	categorieRepository.deleteAll();
    }

    @Override
    public void delete(Long id) {
	categorieRepository.deleteById(id);
    }

}
