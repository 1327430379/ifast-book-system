package io.renren.modules.generator.dao;

import io.renren.modules.generator.entity.ShelfEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户已购买书籍表
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2022-04-16 09:52:44
 */
@Mapper
public interface ShelfDao extends BaseMapper<ShelfEntity> {
	
}
