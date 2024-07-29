package com.sycamore.nextblog.blog.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.util.StringUtils;

import java.util.Date;

/**
 * @author: Sycamore
 * @date: 2024/7/17 10:45
 * @version: 1.0
 * @description: TODO
 */
@Data
@AllArgsConstructor
public class Blog {
    private String id;
    private String title;
    private String content;
    private String publisherId;
    private Date publishAt;
    public Blog(String title, String content, String publisherId) {
        this.title = title;
        this.content = content;
        this.publisherId = publisherId;
    }

    public boolean isPublishValid() {
        return title.length()<50 && StringUtils.hasText(content)&& StringUtils.hasText(publisherId);
    }
}
