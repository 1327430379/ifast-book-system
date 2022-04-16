package io.renren.modules.generator.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.generator.dao.ChequeDao;
import io.renren.modules.generator.entity.ChequeEntity;
import io.renren.modules.generator.service.ChequeService;


@Service("chequeService")
public class ChequeServiceImpl extends ServiceImpl<ChequeDao, ChequeEntity> implements ChequeService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<ChequeEntity> page = this.page(
                new Query<ChequeEntity>().getPage(params),
                new QueryWrapper<ChequeEntity>()
        );

        return new PageUtils(page);
    }

}