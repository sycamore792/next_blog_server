package com.sycamore.nextblog.client.blog.dto.req;

import com.sycamore.nextblog.components.cola.dto.PageQuery;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author 桑运昌
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class BlogPageQry extends PageQuery {
    private String userId;

}