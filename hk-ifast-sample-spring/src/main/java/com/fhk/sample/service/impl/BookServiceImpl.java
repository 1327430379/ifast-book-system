package com.fhk.sample.service.impl;


import com.fhk.sample.domain.dao.BookRepository;
import com.fhk.sample.domain.dao.UserRepository;
import com.fhk.sample.domain.entity.Book;
import com.fhk.sample.domain.entity.User;
import com.fhk.sample.domain.vo.PageVO;
import com.fhk.sample.service.BookService;
import com.fhk.sample.util.BizAssert;
import com.fhk.sample.util.PageUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author lingzan
 */
@Service
public class BookServiceImpl implements BookService {

    @Resource
    private BookRepository bookRepository;

    @Override
    public PageVO<Book> queryPage(int pageNum, int pageSize, Book criteria) {
        Sort sortBy = Sort.by(Sort.Order.desc("updatedDate"));
        Pageable pageable = PageRequest.of(pageNum, pageSize, sortBy);
        Specification<Book> specification = getSpecification(criteria);
        Page<Book> page = bookRepository.findAll(specification, pageable);
        return PageUtil.convert(page);
    }

    @Override
    public Book queryById(Integer id) {
        return bookRepository.findById(id).orElse(null);
    }

    @Override
    public Book save(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book update(Book book) {
        Book bookOfExist = queryById(book.getId());
        BizAssert.isNotNull(bookOfExist, "书籍不存在");
        return bookRepository.save(book);
    }

    @Override
    public void deleteById(Integer id) {
        Book bookOfExist = queryById(id);
        BizAssert.isNotNull(bookOfExist, "书籍不存在");
        bookRepository.deleteById(id);
    }

    private Specification<Book> getSpecification(Book criteria) {
        return (root, cq, cb) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (StringUtils.isNotBlank(criteria.getSubject())) {
                predicates.add(cb.equal(root.get("subject"), criteria.getSubject()));
            }
            if (StringUtils.isNotBlank(criteria.getAuthor())) {
                predicates.add(cb.equal(root.get("author"), criteria.getAuthor()));
            }
            if (StringUtils.isNotBlank(criteria.getCategory())) {
                predicates.add(cb.equal(root.get("category"), criteria.getCategory()));
            }
            if (StringUtils.isNotBlank(criteria.getPublisher())) {
                predicates.add(cb.equal(root.get("publisher"), criteria.getPublisher()));
            }
            if (StringUtils.isNotBlank(criteria.getContentType())) {
                predicates.add(cb.equal(root.get("contentType"), criteria.getContentType()));
            }
            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }
}