package com.sycamore.nextblog.client.blog.dto.resp;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

/**
 * @author 桑运昌
 */
@Data
public class BlogPageCO {
    @Schema(title = "id")
    private String id;
    @Schema(title = "标题")
    private String title;
    @Schema(title = "发布时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime publishAt;
    @Schema(title = "发布人名称")
    private String publisherName;
    @Schema(title = "发布人ID")
    private String publisherId;
    @Schema(title = "内容预览")
    private String contentPreview;
}