package com.sycamore.nextblog.client.blog.dto.req;

import com.sycamore.nextblog.components.cola.dto.Command;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @author: Sycamore
 * @date: 2024/7/16 16:33
 * @version: 1.0
 * @description: TODO
 */


@Data
@EqualsAndHashCode(callSuper = true)
public class BlogCreateCmd extends Command {

    private String publisherId;
    private String title;
    private String content;
    private List<String> tags;

}
