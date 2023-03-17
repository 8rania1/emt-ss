package com.sagem.emt.service;

import java.util.List;

import com.sagem.emt.dao.entity.Category;

public interface CategoryService {

    public Category save(Category c);

    public List<Category> getAll();

    public void deleteAll();

    public void delete(Long id);
}
