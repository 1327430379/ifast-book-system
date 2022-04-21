package com.fhk.sample.service;

import com.fhk.sample.domain.entity.Category;

import java.util.List;

/**
 * 分类
 *
 * @author lingzan
 * 
 * @date 2022-04-16 09:52:44
 */
public interface CategoryService {

    Category add(Category category);

    Category update(Category category);

    Category queryById(Integer id);

    void deleteById(Integer id);

    List<Category> list(String name);

}

