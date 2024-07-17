package com.sycamore.nextblog.client.blog.dto.resp;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author 桑运昌
 */
@Data
public class BlogPageCO {
    @Schema(title = "id")
    private String id;
    @Schema(title = "标题")
    private String title;
}