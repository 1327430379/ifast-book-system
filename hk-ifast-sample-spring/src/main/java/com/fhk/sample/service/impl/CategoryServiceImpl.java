package com.fhk.sample.service.impl;


import com.fhk.sample.domain.dao.CategoryDao;
import com.fhk.sample.domain.entity.Category;
import com.fhk.sample.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.Map;


/**
 * @author lingzan
 */
@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryDao, Category> implements CategoryService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<Category> page = this.page(
                new Query<Category>().getPage(params),
                new QueryWrapper<Category>()
        );

        return new PageUtils(page);
    }


}