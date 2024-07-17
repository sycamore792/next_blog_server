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
@TableName("blog_base")
public class BlogBaseDO {
    @TableId(type = IdType.AUTO)
    private Long id;
    private String title;
    private Long publisherId;

    @TableField(fill = FieldFill.INSERT)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createAt;

    @TableField(fill = FieldFill.UPDATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateAt;

    /**
     * 发布时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime publishAt;

    @TableLogic(delval = "1",value = "0")
    @TableField(fill = FieldFill.INSERT)
    private Integer delFlag;
}
