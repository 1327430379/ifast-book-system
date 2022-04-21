package com.fhk.sample.util;

import com.fhk.sample.domain.vo.PageVO;
import org.springframework.data.domain.Page;

/**
 * @Author: 凌瓒
 * @Date: 2022/04/17/9:44 上午
 */
public class PageUtil {

    public static <T> PageVO<T> convert(Integer pageNum,Integer pageSize,Page<T> page) {
        PageVO<T> pageVO = new PageVO<>();
        pageVO.setCurrentPage(pageNum);
        pageVO.setPageSize(pageSize);
        pageVO.setPageCount(page.getTotalPages());
        pageVO.setTotal(page.getTotalElements());
        pageVO.setData(page.getContent());
        return pageVO;
    }
}
