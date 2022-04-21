package com.fhk.sample.service.impl;


import com.fhk.sample.common.module.SessionManager;
import com.fhk.sample.domain.dao.BookRepository;
import com.fhk.sample.domain.entity.Book;
import com.fhk.sample.domain.entity.User;
import com.fhk.sample.domain.vo.PageVO;
import com.fhk.sample.service.BookService;
import com.fhk.sample.service.PaymentService;
import com.fhk.sample.service.ShelfService;
import com.fhk.sample.util.BizAssert;
import com.fhk.sample.util.PageUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author lingzan
 */
@Service
public class BookServiceImpl implements BookService {

    @Resource
    private BookRepository bookRepository;
    @Resource
    private ShelfService shelfService;
    @Resource
    private ApplicationContext applicationContext;

    @Override
    public PageVO<Book> queryPage(int pageNum, int pageSize, Book criteria) {
        Pageable pageable = new PageRequest(pageNum, pageSize);
        Specification<Book> specification = getSpecification(criteria);
        Page<Book> page = bookRepository.findAll(specification, pageable);
        return PageUtil.convert(pageNum,pageSize,page);
    }

    @Override
    public List<Book> list() {
        return bookRepository.findAll();
    }

    @Override
    public Book queryById(Integer id) {
        return bookRepository.findOne(id);
    }

    @Override
    public Book add(Book book) {
        Date date = new Date();
        book.setCreatedDate(date);
        book.setUpdatedDate(date);
        book.setStock(1);

        return bookRepository.save(book);
    }

    @Override
    public Book update(Book book) {
        Book bookOfExist = queryById(book.getId());
        BizAssert.isNotNull(bookOfExist, "书籍不存在");
        book.setUpdatedDate(new Date());
        return bookRepository.save(book);
    }

    @Override
    public void deleteById(Integer id) {
        Book bookOfExist = queryById(id);
        BizAssert.isNotNull(bookOfExist, "书籍不存在");
        bookRepository.delete(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void buy(Integer id,String paymentMode) {
        Book bookOfExist = queryById(id);
        BizAssert.isNotNull(bookOfExist, "书籍不存在");
        BizAssert.isTrue(bookOfExist.getStock()>0,"庫存不足");

        synchronized (this) {
            //扣减库存
            bookRepository.deductStock(id);
            //支付
            User user = SessionManager.getCurrentUserSession();

            PaymentService paymentService = getPaymentService(paymentMode);
            paymentService.pay(user,bookOfExist);
            //添加到书架
            shelfService.addToBookShelf(bookOfExist,user.getId());
        }
    }

    private PaymentService getPaymentService(String paymentMode) {
        String beanName = paymentMode + "PaymentService";
        return applicationContext.getBean(beanName,PaymentService.class);
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