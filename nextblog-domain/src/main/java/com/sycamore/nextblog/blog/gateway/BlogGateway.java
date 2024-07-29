package com.sycamore.nextblog.blog.gateway;

import com.sycamore.nextblog.blog.entity.Blog;

/**
 * @author: Sycamore
 * @date: 2024/7/17 10:55
 * @version: 1.0
 * @description: TODO
 */

public interface BlogGateway {

    void publish(Blog blog);
}
