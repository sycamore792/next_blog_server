package com.sycamore.nextblog.client.blog.dto.resp;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Date;

/**
 * @author 桑运昌
 */
@Data
public class BlogDetailCO {
    @Schema(title = "id")
    private String id;
    @Schema(title = "标题")
    private String title;

    @Schema(title = "内容")
    private String content;

    @Schema(title = "发布时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date publishAt;

    @Schema(title = "作者名称")
    private String authorName;

    @Schema(title = "作者头像")
    private String authorAvatar;
}