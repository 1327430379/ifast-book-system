package io.renren.modules.generator.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.generator.dao.ModeratorDao;
import io.renren.modules.generator.entity.ModeratorEntity;
import io.renren.modules.generator.service.ModeratorService;


@Service("moderatorService")
public class ModeratorServiceImpl extends ServiceImpl<ModeratorDao, ModeratorEntity> implements ModeratorService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<ModeratorEntity> page = this.page(
                new Query<ModeratorEntity>().getPage(params),
                new QueryWrapper<ModeratorEntity>()
        );

        return new PageUtils(page);
    }

}