package com.fhk.sample.service.impl;


import com.fhk.sample.domain.dao.CategoryRepository;
import com.fhk.sample.domain.entity.Category;
import com.fhk.sample.service.CategoryService;
import com.fhk.sample.util.BizAssert;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


/**
 * @author lingzan
 */
@Service("categoryService")
public class CategoryServiceImpl  implements CategoryService {


    @Resource
    private CategoryRepository categoryRepository;

    @Override
    public Category add(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category update(Category category) {
        Category categoryOfExist = queryById(category.getId());
        BizAssert.isNotNull(categoryOfExist,"分类信息不存在");
        return categoryRepository.save(category);
    }

    @Override
    public Category queryById(Integer id) {
        return categoryRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Integer id) {
        Category category = queryById(id);
        BizAssert.isNotNull(category,"分类信息不存在");
        categoryRepository.deleteById(id);
    }

    @Override
    public List<Category> list(String name) {
        return categoryRepository.findAll();
    }
}