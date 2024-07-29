package com.sycamore.nextblog.app.blog.executor.query;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sycamore.nextblog.client.blog.dto.resp.BlogPageCO;
import com.sycamore.nextblog.client.blog.dto.req.BlogPageQry;
import com.sycamore.nextblog.components.cola.dto.PageResponse;
import com.sycamore.nextblog.infrastructure.blog.convertor.BlogPageDOConvertor;
import com.sycamore.nextblog.infrastructure.blog.dataobject.BlogPageQueryDO;
import com.sycamore.nextblog.infrastructure.blog.mapper.BlogBaseMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author: Sycamore
 * @date: 2024/7/8 13:07
 * @version: 1.0
 * @description: TODO
 */

@Component
@RequiredArgsConstructor
public class BlogRecommendPageQryExe {

    private final BlogBaseMapper mapper;
    private final BlogPageDOConvertor convertor;

    public PageResponse<BlogPageCO> execute(BlogPageQry qry) {
        Page<BlogPageQueryDO> pageResult = mapper.queryPage(new Page<>(qry.getPageIndex(), qry.getPageSize()));
        List<BlogPageCO> pageList = convertor.toPageList(pageResult.getRecords());
        return PageResponse.of(pageList, (int) pageResult.getTotal(), qry.getPageSize(), qry.getPageIndex());
    }
}
