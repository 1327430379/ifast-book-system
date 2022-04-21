package com.fhk.sample.service.impl;


import com.fhk.sample.domain.dao.PublisherRepository;
import com.fhk.sample.domain.entity.Publisher;
import com.fhk.sample.domain.vo.PageVO;
import com.fhk.sample.service.PublisherService;
import com.fhk.sample.util.BizAssert;
import com.fhk.sample.util.PageUtil;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author lingzan
 */
@Service
public class PublisherServiceImpl implements PublisherService {

    @Resource
    private PublisherRepository publisherRepository;

    @Override
    public PageVO<Publisher> queryByPage(Integer pageNum, Integer pageSize, Publisher criteria) {
        Pageable pageable = new PageRequest(pageNum, pageSize);
        Specification<Publisher> specification = null;
        Page<Publisher> page = publisherRepository.findAll(specification, pageable);
        return PageUtil.convert(pageNum,pageSize,page);
    }

    @Override
    public Publisher queryById(Integer id) {
        return publisherRepository.findOne(id);
    }

    @Override
    public List<Publisher> listAll() {
        return publisherRepository.findAll();
    }

    @Override
    public Publisher add(Publisher publisher) {
        return publisherRepository.save(publisher);
    }

    @Override
    public Publisher update(Publisher publisher) {
        Publisher publisherOfExist = queryById(publisher.getId());
        BizAssert.isNotNull(publisherOfExist, "出版社不存在");
        return publisherRepository.save(publisher);
    }

    @Override
    public void deleteById(Integer id) {
        Publisher publisherOfExist = queryById(id);
        BizAssert.isNotNull(publisherOfExist, "出版社不存在");
        publisherRepository.delete(id);
    }
}