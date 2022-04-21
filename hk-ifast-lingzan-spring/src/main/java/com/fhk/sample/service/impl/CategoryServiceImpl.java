package com.fhk.sample.service.impl;


import com.fhk.sample.domain.dao.CategoryRepository;
import com.fhk.sample.domain.entity.Category;
import com.fhk.sample.service.CategoryService;
import com.fhk.sample.util.BizAssert;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


/**
 * @author lingzan
 */
@Service("categoryService")
public class CategoryServiceImpl implements CategoryService {


    @Resource
    private CategoryRepository categoryRepository;

    @Override
    public Category add(Category category) {
        Category byName = categoryRepository.findByName(category.getName());
        BizAssert.isNull(byName, "分类名称已存在");
        return categoryRepository.save(category);
    }

    @Override
    public Category update(Category category) {
        Category categoryOfExist = queryById(category.getId());
        BizAssert.isNotNull(categoryOfExist, "分类信息不存在");
        if (!category.getName().equals(categoryOfExist.getName())) {
            Category byName = categoryRepository.findByName(category.getName());
            Optional.ofNullable(byName).map(x -> {
                BizAssert.isTrue(category.getId().equals(byName.getId()), "分类名称已存在");
                return x;
            });
        }

        return categoryRepository.save(category);
    }

    @Override
    public Category queryById(Integer id) {
        return categoryRepository.findOne(id);
    }


    @Override
    public void deleteById(Integer id) {
        Category category = queryById(id);
        BizAssert.isNotNull(category, "分类信息不存在");
        categoryRepository.delete(id);
    }

    @Override
    public List<Category> list(String name) {
        Specification<Category> specification = (root, cq, cb) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (StringUtils.isNotBlank(name)) {
                predicates.add(cb.like(root.get("name"), name));
            }
            return cb.and(predicates.toArray(new Predicate[0]));

        };
        return categoryRepository.findAll(specification);
    }
}