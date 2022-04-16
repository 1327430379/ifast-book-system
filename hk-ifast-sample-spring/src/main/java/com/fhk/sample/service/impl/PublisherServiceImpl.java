package com.fhk.sample.service.impl;



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