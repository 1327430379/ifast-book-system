package com.fhk.sample.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fhk.sample.domain.dao.ChequeRepository;
import com.fhk.sample.domain.entity.Cheque;
import com.fhk.sample.service.ChequeService;
import org.springframework.stereotype.Service;


@Service("chequeService")
public class ChequeServiceImpl extends ServiceImpl<ChequeRepository, Cheque> implements ChequeService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<Cheque> page = this.page(
                new Query<Cheque>().getPage(params),
                new QueryWrapper<Cheque>()
        );

        return new PageUtils(page);
    }

}