package com.fhk.sample.service.impl;

import com.fhk.sample.domain.dao.AuthorRepository;
import com.fhk.sample.domain.entity.Author;
import com.fhk.sample.domain.vo.PageVO;
import com.fhk.sample.service.AuthorService;
import com.fhk.sample.util.BizAssert;
import com.fhk.sample.util.PageUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;


/**
 * @author lingzan
 */
@Service
public class AuthorServiceImpl implements AuthorService {

    @Resource
    private AuthorRepository authorRepository;

    @Override
    public PageVO<Author> queryPage(Integer pageNum, Integer pageSize, Author criteria) {
        Pageable pageable = new PageRequest(pageNum, pageSize);
        Specification<Author> specification = (root, cq, cb) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (StringUtils.isNotBlank(criteria.getName())) {
                predicates.add(cb.equal(root.get("name"), criteria.getName()));
            }
            return cb.and(predicates.toArray(new Predicate[0]));
        };
        Page<Author> page = authorRepository.findAll(specification, pageable);
        return PageUtil.convert(pageNum,pageSize,page);
    }

    @Override
    public Author queryById(Integer id) {
        return authorRepository.findOne(id);
    }

    @Override
    public Author add(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public Author update(Author author) {
        Author authorOfExist = this.queryById(author.getId());
        BizAssert.isNotNull(authorOfExist, "作者信息不存在");
        return authorRepository.save(author);
    }

    @Override
    public void deleteById(Integer id) {
        Author authorOfExist = this.queryById(id);
        BizAssert.isNotNull(authorOfExist, "作者信息不存在");
        authorRepository.delete(id);
    }

    @Override
    public List<Author> listAll() {
        return authorRepository.findAll();
    }
}