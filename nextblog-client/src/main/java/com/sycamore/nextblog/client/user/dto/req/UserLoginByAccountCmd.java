package com.sycamore.nextblog.client.user.dto.req;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

/**
 * @author 桑运昌
 */
@Data
@Valid
public class UserLoginByAccountCmd {
    @Schema(title = "账号")
    @NotBlank(message = "账号不能为空")
    private String account;
    @Schema(title = "密码")
    @NotBlank(message = "密码不能为空")
    private String password;
}