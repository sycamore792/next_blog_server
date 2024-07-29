package com.sycamore.nextblog.infrastructure.blog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sycamore.nextblog.client.blog.dto.resp.BlogPageCO;
import com.sycamore.nextblog.infrastructure.blog.dataobject.BlogBaseDO;
import com.sycamore.nextblog.infrastructure.blog.dataobject.BlogPageQueryDO;
import org.apache.ibatis.annotations.Select;

/**
 * @author: Sycamore
 * @date: 2024/7/9 12:15
 * @version: 1.0
 * @description: TODO
 */

public interface BlogBaseMapper extends BaseMapper<BlogBaseDO> {


    @Select("""
SELECT
    b.id,
    b.title,
    b.publish_at,
    u.username AS publisher_name,
    LEFT(c.content, 200) AS content_preview
FROM
    blog_base b
JOIN
    blog_content c ON b.id = c.id
JOIN
    user_base u ON b.publisher_id = u.id
WHERE
    b.del_flag = 0 AND
    c.del_flag = 0 AND
    u.del_flag = 0
order by b.publish_at DESC
""")
    Page<BlogPageQueryDO> queryPage(Page<BlogPageQueryDO> page);
}
