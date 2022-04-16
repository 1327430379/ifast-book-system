package com.fhk.sample.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;

import java.util.Map;

/**
 * 分类
 *
 * @author lingzan
 * 
 * @date 2022-04-16 09:52:44
 */
public interface CategoryService {

    PageUtils queryPage(Map<String, Object> params);
}

