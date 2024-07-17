package com.sycamore.nextblog.infrastructure.blog.dataobject;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

/**
 * @author: Sycamore
 * @date: 2024/7/9 12:16
 * @version: 1.0
 * @description: TODO
 */

@Data
@TableName("blog_content")
public class BlogContentDO {
    @TableId(type = IdType.AUTO)
    private Long id;
    private String content;

    /**
     * 上次修改时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime lastUpdateAt;

    @TableLogic(delval = "1",value = "0")
    @TableField(fill = FieldFill.INSERT)
    private Integer delFlag;
}
