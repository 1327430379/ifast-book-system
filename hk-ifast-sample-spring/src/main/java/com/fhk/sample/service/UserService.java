package io.renren.modules.generator.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.generator.entity.UserEntity;

import java.util.Map;


public interface UserService {

    PageUtils queryPage(Map<String, Object> params);
}

