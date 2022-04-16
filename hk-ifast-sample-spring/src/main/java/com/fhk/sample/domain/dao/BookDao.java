package io.renren.modules.generator.dao;

import io.renren.modules.generator.entity.BookEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2022-04-16 09:52:44
 */
@Mapper
public interface BookDao extends BaseMapper<BookEntity> {
	
}
