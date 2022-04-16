package com.fhk.sample.service;

import java.util.Map;

/**
 * 
 *
 * @author lingzan
 * 
 * @date 2022-04-16 09:52:44
 */
public interface BookService  {

    PageUtils queryPage(Map<String, Object> params);
}

