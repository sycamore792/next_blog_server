package com.sycamore.nextblog.client.blog.api;


import com.sycamore.nextblog.client.blog.dto.req.BlogCreateCmd;
import com.sycamore.nextblog.client.blog.dto.resp.BlogDetailCO;
import com.sycamore.nextblog.client.blog.dto.resp.BlogPageCO;
import com.sycamore.nextblog.client.blog.dto.req.BlogPageQry;
import com.sycamore.nextblog.components.cola.dto.PageResponse;
import com.sycamore.nextblog.components.cola.dto.SingleResponse;

/**
 *
 * @author 桑运昌
 */
public interface IBlogService {
    PageResponse<BlogPageCO> listByParam(BlogPageQry param);

    SingleResponse<BlogDetailCO> queryBlogDetailById(String blogId);

    SingleResponse createBlog(BlogCreateCmd createCmd);
}
