package com.fhk.sample.service.impl;


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