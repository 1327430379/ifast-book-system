package com.fhk.sample.service;


import java.util.Map;

/**
 * 用户已购买书籍表
 *
 * @author lingzan
 * 
 * @date 2022-04-16 09:52:44
 */
public interface ShelfService  {

    PageUtils queryPage(Map<String, Object> params);
}

