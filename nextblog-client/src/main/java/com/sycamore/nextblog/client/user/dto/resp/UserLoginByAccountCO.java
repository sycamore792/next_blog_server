package com.sycamore.nextblog.client.user.dto.resp;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author 桑运昌
 */
@Data
public class UserLoginByAccountCO {
    @Schema(title = "id")
    private String id;
    @Schema(title = "账号")
    private String username;
    @Schema(title = "token")
    private String token;
}