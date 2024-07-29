package com.sycamore.nextblog.infrastructure.blog.dataobject;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

/**
 * @author: Sycamore
 * @date: 2024/7/17 11:58
 * @version: 1.0
 * @description: TODO
 */

@Data
public class BlogPageQueryDO {
    private Long id;
    private String title;
    private Long publisherId;
    private String publisherName;
//    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
//    private LocalDateTime createAt;
//
//    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
//    private LocalDateTime updateAt;
    private String contentPreview;

//    /**
//     * 上次修改时间
//     */
//    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
//    private LocalDateTime lastUpdateAt;
    /**
     * 发布时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime publishAt;
}
