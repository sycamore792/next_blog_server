package com.sycamore.nextblog.app.blog.executor;

import com.sycamore.nextblog.client.blog.dto.req.BlogCreateCmd;
import com.sycamore.nextblog.components.cola.dto.SingleResponse;
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
    public SingleResponse execute(BlogCreateCmd cmd) {

        return null;
    }
}
