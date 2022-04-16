package com.fhk.sample.service.impl;

@Service("contractService")
public class ContractServiceImpl extends ServiceImpl<ContractDao, ContractEntity> implements ContractService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<ContractEntity> page = this.page(
                new Query<ContractEntity>().getPage(params),
                new QueryWrapper<ContractEntity>()
        );

        return new PageUtils(page);
    }

}