package com.fhk.sample.service;

import com.fhk.sample.domain.entity.Book;
import com.fhk.sample.domain.vo.PageVO;

import java.util.List;


/**
 * @author lingzan
 * @date 2022-04-16 09:52:44
 */
public interface BookService {

    PageVO<Book> queryPage(int pageNum, int pageSize, Book criteria);

    List<Book> list();

    Book queryById(Integer id);

    Book add(Book book);

    Book update(Book book);

    void deleteById(Integer id);

    void buy(Integer id, String paymentMode);

}

