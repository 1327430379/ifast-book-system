package com.fhk.sample.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;

import com.fhk.sample.domain.dao.AuthorDao;
import com.fhk.sample.domain.entity.Author;
import com.fhk.sample.service.AuthorService;


/**
 * @author lingzan
 */
@Service("authorService")
public class AuthorServiceImpl extends ServiceImpl<AuthorDao, Author> implements AuthorService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        return null;
    }

}