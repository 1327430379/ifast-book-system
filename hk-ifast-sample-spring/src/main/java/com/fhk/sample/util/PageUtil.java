package com.fhk.sample.util;

import com.fhk.sample.domain.vo.PageVO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @Author: 凌瓒
 * @Date: 2022/04/17/9:44 上午
 */
public class PageUtil {

    public static <T> PageVO<T> convert(Page<T> page) {
        Pageable pageable = page.getPageable();
        PageVO<T> pageVO = new PageVO<>();
        pageVO.setCurrentPage(pageable.getPageNumber());
        pageVO.setPageSize(pageable.getPageSize());
        pageVO.setPageCount(page.getTotalPages());
        pageVO.setTotal(page.getTotalElements());
        pageVO.setData(page.getContent());
        return pageVO;
    }
}
