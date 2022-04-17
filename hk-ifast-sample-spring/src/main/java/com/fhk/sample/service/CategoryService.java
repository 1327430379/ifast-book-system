package com.fhk.sample.service;

import com.fhk.sample.domain.entity.Category;
import com.fhk.sample.domain.vo.PageVO;

import java.util.List;
import java.util.Map;

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

