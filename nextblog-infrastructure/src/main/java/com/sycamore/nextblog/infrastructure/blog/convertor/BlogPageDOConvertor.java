package com.sycamore.nextblog.infrastructure.blog.convertor;

import com.sycamore.nextblog.client.blog.dto.resp.BlogDetailCO;
import com.sycamore.nextblog.client.blog.dto.resp.BlogPageCO;
import com.sycamore.nextblog.infrastructure.blog.dataobject.BlogBaseDO;
import com.sycamore.nextblog.infrastructure.blog.dataobject.BlogPageQueryDO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

/**
 * @author: Sycamore
 * @date: 2024/7/9 12:29
 * @version: 1.0
 * @description: TODO
 */

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface BlogPageDOConvertor {

    List<BlogPageCO> toPageList(List<BlogPageQueryDO> dataObjects);
}
