package com.sycamore.nextblog.app.blog.executor.query;

import com.sycamore.nextblog.client.blog.dto.resp.BlogDetailCO;
import com.sycamore.nextblog.infrastructure.blog.convertor.BlogBaseConvertor;
import com.sycamore.nextblog.infrastructure.blog.dataobject.BlogContentDO;
import com.sycamore.nextblog.infrastructure.blog.mapper.BlogBaseMapper;
import com.sycamore.nextblog.infrastructure.blog.dataobject.BlogBaseDO;
import com.sycamore.nextblog.infrastructure.blog.mapper.BlogContentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author: Sycamore
 * @date: 2024/7/8 13:07
 * @version: 1.0
 * @description: TODO
 */

@Component
@RequiredArgsConstructor
public class BlogDetailQryExe {

    private final BlogBaseMapper mapper;
    private final BlogContentMapper contentMapper;
    private final BlogBaseConvertor convertor;

    public BlogDetailCO execute(String id) {
        BlogBaseDO dataObject = mapper.selectById(id);
        BlogDetailCO co = convertor.toDetailCO(dataObject);
        if (dataObject != null) {
            BlogContentDO blogContentDO = contentMapper.selectById(dataObject.getId());
            co.setContent(blogContentDO.getContent());
        }
        return co;
    }
}
