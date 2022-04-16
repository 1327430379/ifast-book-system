package io.renren.modules.generator.dao;

import io.renren.modules.generator.entity.ModeratorEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 版主
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2022-04-16 09:52:44
 */
@Mapper
public interface ModeratorDao extends BaseMapper<ModeratorEntity> {
	
}
