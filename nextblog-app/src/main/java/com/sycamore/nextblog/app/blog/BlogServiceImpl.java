package com.sycamore.nextblog.app.blog;

import com.sycamore.nextblog.app.blog.executor.BlogPublishCmdExe;
import com.sycamore.nextblog.app.blog.executor.query.BlogDetailQryExe;
import com.sycamore.nextblog.client.blog.api.IBlogService;
import com.sycamore.nextblog.client.blog.dto.req.BlogCreateCmd;
import com.sycamore.nextblog.client.blog.dto.resp.BlogDetailCO;
import com.sycamore.nextblog.client.blog.dto.resp.BlogPageCO;
import com.sycamore.nextblog.client.blog.dto.req.BlogPageQry;
import com.sycamore.nextblog.app.blog.executor.query.BlogRecommendPageQryExe;
import com.sycamore.nextblog.components.cola.dto.PageResponse;
import com.sycamore.nextblog.components.cola.dto.SingleResponse;
import com.sycamore.nextblog.infrastructure.UserContext;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * @author: Sycamore
 * @date: 2024/7/8 12:39
 * @version: 1.0
 * @description: TODO
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class BlogServiceImpl implements IBlogService {
    private final BlogRecommendPageQryExe blogRecommendPageQryExe;
    private final BlogDetailQryExe blogDetailQryExe;
    private final BlogPublishCmdExe blogPublishCmdExe;
    @Override
    public PageResponse<BlogPageCO> listRecommend(BlogPageQry param) {
        return blogRecommendPageQryExe.execute(param);
    }

    @Override
    public SingleResponse queryBlogDetailById(String blogId) {
        BlogDetailCO co = blogDetailQryExe.execute(blogId);
        if (Objects.isNull(co)) {
            return SingleResponse.buildFailure("blog_id_not_exist", "博客id不存在");
        }
        co.setAuthorAvatar("https://krseoul.imgtbl.com/i/2024/07/11/668fb17bc647f.jpg");
        return SingleResponse.of(co);
    }

    @Override
    public SingleResponse createBlog(BlogCreateCmd createCmd) {
        createCmd.setPublisherId(UserContext.getUser().getUserId());
        return blogPublishCmdExe.execute(createCmd);
    }
}
