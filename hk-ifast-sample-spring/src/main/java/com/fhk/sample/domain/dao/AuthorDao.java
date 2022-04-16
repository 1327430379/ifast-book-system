package io.renren.modules.generator.dao;

import io.renren.modules.generator.entity.AuthorEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 作者表
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2022-04-16 09:52:44
 */
@Mapper
public interface AuthorDao extends BaseMapper<AuthorEntity> {
	
}
