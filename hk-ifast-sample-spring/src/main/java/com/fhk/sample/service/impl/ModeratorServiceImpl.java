package com.fhk.sample.service.impl;

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