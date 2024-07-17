package com.sycamore.nextblog.client.user.dto.resp;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author 桑运昌
 */
@Data
@AllArgsConstructor
public class UserInfoQueryByIdCO {
    @Schema(title = "id")
    private String id;
    @Schema(title = "账号")
    private String username;

}