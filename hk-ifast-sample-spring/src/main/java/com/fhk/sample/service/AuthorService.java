package com.fhk.sample.service;
import com.fhk.sample.domain.entity.Author;
import com.fhk.sample.domain.vo.PageVO;

/**
 * 作者表
 *
 * @author lingzan
 * @date 2022-04-16 09:52:44
 */
public interface AuthorService {

    PageVO<Author> queryPage(Integer pageNum, Integer pageSize, Author criteria);

    Author queryById(Integer id);

    Author add(Author author);

    Author update(Author author);

    void deleteById(Integer id);
}

