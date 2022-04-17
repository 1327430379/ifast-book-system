package com.fhk.sample.service;


import com.fhk.sample.domain.entity.Publisher;
import com.fhk.sample.domain.vo.PageVO;

import java.util.Map;

/**
 * 出版社
 *
 * @author lingzan
 * @date 2022-04-16 09:52:44
 */
public interface PublisherService {

    PageVO<Publisher> queryByPage(Integer pageNum, Integer pageSize, Publisher criteria);
    Publisher queryById(Integer id);
    Publisher add(Publisher publisher);
    Publisher update(Publisher publisher);
    void deleteById(Integer id);
}

