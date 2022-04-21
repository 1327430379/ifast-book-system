package com.fhk.sample.domain.vo;

import lombok.*;

import java.util.List;

/**
 * @Author: 凌瓒
 * @Date: 2022/04/17/9:28 上午
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageVO<T> {

    private int currentPage;

    private int pageSize;

    private int pageCount;

    private long total;

    private List<T> data;

    public int getPageCount() {
        if (pageCount > 0) {
            return pageCount;
        }
        return pageSize <= 0 ? 1 : (int) Math.ceil(((double) total / (double) pageSize));
    }

    public int getFirstResult() {
        return currentPage <= 0 ? 0 : (this.currentPage - 1) * this.pageSize;
    }


}
