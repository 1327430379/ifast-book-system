package io.renren.modules.generator.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.generator.entity.ShelfEntity;

import java.util.Map;

/**
 * 用户已购买书籍表
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2022-04-16 09:52:44
 */
public interface ShelfService  {

    PageUtils queryPage(Map<String, Object> params);
}

