package io.renren.modules.generator.dao;

import io.renren.modules.generator.entity.ChequeEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 支票
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2022-04-16 09:52:44
 */
@Mapper
public interface ChequeDao extends BaseMapper<ChequeEntity> {
	
}
