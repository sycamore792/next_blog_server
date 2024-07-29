package com.sycamore.nextblog.app.blog.executor;

import com.sycamore.nextblog.blog.entity.Blog;
import com.sycamore.nextblog.blog.gateway.BlogGateway;
import com.sycamore.nextblog.client.blog.dto.req.BlogCreateCmd;
import com.sycamore.nextblog.components.cola.dto.SingleResponse;
import com.sycamore.nextblog.components.cola.exception.BizException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author: Sycamore
 * @date: 2024/7/16 17:30
 * @version: 1.0
 * @description: TODO
 */
@Component
@RequiredArgsConstructor
public class BlogPublishCmdExe {

    private final BlogGateway blogGateway;
    public SingleResponse execute(BlogCreateCmd cmd) {
        Blog blog = new Blog(cmd.getTitle(), cmd.getContent(), cmd.getPublisherId());
        if (!blog.isPublishValid()){
            throw new BizException("博客发布信息不合法");
        }
        blogGateway.publish(blog);
        return  SingleResponse.buildSuccess();
    }
}
