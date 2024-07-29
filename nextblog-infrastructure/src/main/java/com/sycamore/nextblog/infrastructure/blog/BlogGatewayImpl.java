package com.sycamore.nextblog.infrastructure.blog;

import com.sycamore.nextblog.blog.entity.Blog;
import com.sycamore.nextblog.blog.gateway.BlogGateway;
import com.sycamore.nextblog.components.cola.exception.BizException;
import com.sycamore.nextblog.infrastructure.blog.dataobject.BlogBaseDO;
import com.sycamore.nextblog.infrastructure.blog.dataobject.BlogContentDO;
import com.sycamore.nextblog.infrastructure.blog.mapper.BlogBaseMapper;
import com.sycamore.nextblog.infrastructure.blog.mapper.BlogContentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

/**
 * @author: Sycamore
 * @date: 2024/7/17 10:57
 * @version: 1.0
 * @description: TODO
 */
@RequiredArgsConstructor
@Service
public class BlogGatewayImpl implements BlogGateway {
    private final BlogBaseMapper blogBaseMapper;
    private final BlogContentMapper blogContentMapper;


    @Override
    @Transactional
    public void publish(Blog blog) {
        BlogBaseDO blogBaseDO = new BlogBaseDO();
        blogBaseDO.setTitle(blog.getTitle());
        blogBaseDO.setPublisherId(Long.valueOf(blog.getPublisherId()));
        blogBaseDO.setPublishAt(LocalDateTime.now());

        if (blogBaseMapper.insert(blogBaseDO) == 1) {
            BlogContentDO blogContentDO = new BlogContentDO();
            blogContentDO.setId(blogBaseDO.getId());
            blogContentDO.setContent(blog.getContent());
            blogContentDO.setLastUpdateAt(blogBaseDO.getPublishAt());
            if (blogContentMapper.insertOrUpdate(blogContentDO)) {
                return;
            }
        }
        throw new BizException("发布博客失败");

    }
}
