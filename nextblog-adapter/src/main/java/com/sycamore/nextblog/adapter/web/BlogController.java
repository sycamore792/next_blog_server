package com.sycamore.nextblog.adapter.web;

import com.sycamore.nextblog.adapter.filter.user.Authenticated;
import com.sycamore.nextblog.client.blog.api.IBlogService;
import com.sycamore.nextblog.client.blog.dto.req.BlogCreateCmd;
import com.sycamore.nextblog.client.blog.dto.resp.BlogDetailCO;
import com.sycamore.nextblog.client.blog.dto.resp.BlogPageCO;
import com.sycamore.nextblog.client.blog.dto.req.BlogPageQry;
import com.sycamore.nextblog.components.cola.catchlog.CatchAndLog;
import com.sycamore.nextblog.components.cola.dto.PageResponse;
import com.sycamore.nextblog.components.cola.dto.SingleResponse;
import com.sycamore.nextblog.infrastructure.UserContext;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Sycamore
 * @date: 2024/7/5 12:49
 * @version: 1.0
 * @description: TODO
 */
@RestController
@RequiredArgsConstructor
@Tag(name = "博客基础模块")
@CatchAndLog
public class BlogController {

    private final IBlogService blogService;

    @GetMapping("v1/blog_service/list_by_param")
    @Operation(summary = "获取博客列表")
    @Authenticated
    public PageResponse listByParam (@Validated @ParameterObject BlogPageQry param) {
        return blogService.listByParam(param);
    }

    @GetMapping("v1/blog_service/blog_detail/{blogId}")
    @Operation(summary = "获取博客详情")
    public SingleResponse blogDetail (@PathVariable("blogId") String blogId) {
        return blogService.queryBlogDetailById(blogId);
    }


    @PostMapping("v1/blog_service/publish_blog")
    @Operation(summary = "发布博客")
    @Authenticated
    public SingleResponse createBlog(BlogCreateCmd createCmd) {
        return blogService.createBlog(createCmd);
    }




}
