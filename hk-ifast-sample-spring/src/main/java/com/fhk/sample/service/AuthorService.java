package io.renren.modules.generator.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.generator.entity.AuthorEntity;

import java.util.Map;

/**
 * 作者表
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2022-04-16 09:52:44
 */
public interface AuthorService{

    PageUtils queryPage(Map<String, Object> params);
}

