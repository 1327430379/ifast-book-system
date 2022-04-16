package io.renren.modules.generator.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.generator.dao.PublisherDao;
import io.renren.modules.generator.entity.PublisherEntity;
import io.renren.modules.generator.service.PublisherService;


@Service("publisherService")
public class PublisherServiceImpl extends ServiceImpl<PublisherDao, PublisherEntity> implements PublisherService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<PublisherEntity> page = this.page(
                new Query<PublisherEntity>().getPage(params),
                new QueryWrapper<PublisherEntity>()
        );

        return new PageUtils(page);
    }

}