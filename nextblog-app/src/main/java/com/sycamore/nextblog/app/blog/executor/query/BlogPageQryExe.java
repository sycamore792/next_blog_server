package com.sycamore.nextblog.app.blog.executor.query;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sycamore.nextblog.client.blog.dto.resp.BlogPageCO;
import com.sycamore.nextblog.client.blog.dto.req.BlogPageQry;
import com.sycamore.nextblog.components.cola.dto.PageResponse;
import com.sycamore.nextblog.infrastructure.blog.convertor.BlogBaseConvertor;
import com.sycamore.nextblog.infrastructure.blog.mapper.BlogBaseMapper;
import com.sycamore.nextblog.infrastructure.blog.dataobject.BlogBaseDO;
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
public class BlogPageQryExe {

    private final BlogBaseMapper mapper;
    private final BlogBaseConvertor convertor;

    public PageResponse<BlogPageCO> execute(BlogPageQry qry) {
        QueryWrapper<BlogBaseDO> wrapper = new QueryWrapper<>();
        IPage<BlogBaseDO> iPage = new Page<>(qry.getPageIndex(), qry.getPageSize(), qry.isNeedTotalCount());
        IPage<BlogBaseDO> pageResult = mapper.selectPage(iPage, wrapper);

        List<BlogPageCO> pageList = convertor.toPageList(pageResult.getRecords());

        return PageResponse.of(pageList, (int) pageResult.getTotal(), qry.getPageSize(), qry.getPageIndex());
    }
}
