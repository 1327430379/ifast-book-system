package com.fhk.sample.domain.dto;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
public class BookDTO {

    /**
     *id
     */
    private Integer id;

    /**
     * 学科
     */
    @NotBlank(message = "subject required")
    private String subject;

    /**
     * 描述
     */
    @NotBlank(message = "description required")
    private String description;


    /**
     * ISBN
     */
    private String isbn;

    /**
     * 内容存放路径
     */
    private String path;

    /**
     * 内容类型:pdf,txt
     */
    @NotBlank(message = "contentType required")
    private String contentType;

    /**
     * 作者
     */
    @NotBlank(message = "author required")
    private String author;
    /**
     * 分类
     */
    @NotBlank(message = "category required")
    private String category;
    /**
     * 出版社
     */
    @NotBlank(message = "publisher required")
    private String publisher;

    /**
     * 文件大小
     */
    @NotNull(message = "size required")
    private Double size;

    /**
     * 价格
     */
    @NotNull(message = "price required")
    private BigDecimal price;

}
