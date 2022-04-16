package io.renren.modules.generator.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.generator.dao.ShelfDao;
import io.renren.modules.generator.entity.ShelfEntity;
import io.renren.modules.generator.service.ShelfService;


@Service("shelfService")
public class ShelfServiceImpl extends ServiceImpl<ShelfDao, ShelfEntity> implements ShelfService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<ShelfEntity> page = this.page(
                new Query<ShelfEntity>().getPage(params),
                new QueryWrapper<ShelfEntity>()
        );

        return new PageUtils(page);
    }

}