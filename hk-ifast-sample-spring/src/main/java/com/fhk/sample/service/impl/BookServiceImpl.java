package com.fhk.sample.service.impl;


import org.springframework.stereotype.Service;

/**
 * @author lingzan
 */
@Service("bookService")
public class BookServiceImpl extends ServiceImpl<BookDao, BookEntity> implements BookService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<BookEntity> page = this.page(
                new Query<BookEntity>().getPage(params),
                new QueryWrapper<BookEntity>()
        );

        return new PageUtils(page);
    }

}