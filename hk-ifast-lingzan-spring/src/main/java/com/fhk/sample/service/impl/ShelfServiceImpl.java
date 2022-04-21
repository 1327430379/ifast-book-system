package com.fhk.sample.service.impl;


import com.fhk.sample.common.module.SessionManager;
import com.fhk.sample.domain.dao.ShelfRepository;
import com.fhk.sample.domain.entity.Book;
import com.fhk.sample.domain.entity.Shelf;
import com.fhk.sample.domain.entity.User;
import com.fhk.sample.domain.vo.PageVO;
import com.fhk.sample.service.ShelfService;
import com.fhk.sample.service.UserService;
import com.fhk.sample.util.BizAssert;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class ShelfServiceImpl implements ShelfService {

    @Resource
    private ShelfRepository shelfRepository;
    @Resource
    private UserService userService;

    @Override
    public PageVO<Shelf> queryPage(Map<String, Object> params) {
        return null;
    }

    @Override
    public List<Shelf> list() {
        User user = SessionManager.getCurrentUserSession();
        return shelfRepository.findAllByUserId(user.getId());
    }

    @Override
    public Shelf queryById(Integer id) {
        return shelfRepository.findOne(id);
    }

    @Override
    public Shelf addToBookShelf(Book book,Integer userId) {
        Shelf shelf = Shelf.builder()
                .book(book)
                .numberOfAccess(0)
                .userId(userId)
                .build();
        return shelfRepository.save(shelf);
    }

    @Override
    public Shelf saveReadRecord(Integer shelfId) {
        Shelf shelf = shelfRepository.findOne(shelfId);
        BizAssert.isNotNull(shelf,"书架不存在");
        shelf.setNumberOfAccess(shelf.getNumberOfAccess()+1);
        shelf.setLastAccessDate(new Date());
        shelfRepository.save(shelf);
        userService.incrRetries(shelf.getUserId());
        return shelf;
    }
}