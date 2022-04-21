package com.fhk.sample.service;


import com.fhk.sample.domain.entity.Book;
import com.fhk.sample.domain.entity.Shelf;
import com.fhk.sample.domain.vo.PageVO;

import java.util.List;
import java.util.Map;

/**
 * 用户已购买书籍表
 *
 * @author lingzan
 * 
 * @date 2022-04-16 09:52:44
 */
public interface ShelfService  {

    PageVO<Shelf> queryPage(Map<String, Object> params);

    List<Shelf> list();

    Shelf queryById(Integer id);

    Shelf addToBookShelf(Book book, Integer userId);

    Shelf saveReadRecord(Integer shelfId);
}

