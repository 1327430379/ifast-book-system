package com.fhk.sample.service;

import com.fhk.sample.domain.entity.Book;
import com.fhk.sample.domain.entity.User;

public interface PaymentService {

    void pay(User user, Book book);
}
