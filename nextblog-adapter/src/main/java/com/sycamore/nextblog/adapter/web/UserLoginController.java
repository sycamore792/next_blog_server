package com.sycamore.nextblog.adapter.web;

import com.sycamore.nextblog.client.user.api.IUserLoginService;
import com.sycamore.nextblog.client.user.dto.resp.UserLoginByAccountCO;
import com.sycamore.nextblog.client.user.dto.req.UserLoginByAccountCmd;
import com.sycamore.nextblog.components.cola.catchlog.CatchAndLog;
import com.sycamore.nextblog.components.cola.dto.SingleResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Sycamore
 * @date: 2024/7/9 16:29
 * @version: 1.0
 * @description: TODO
 */
@RestController
@RequiredArgsConstructor
@Tag(name = "用户登录模块")
@CatchAndLog
public class UserLoginController {
    private final IUserLoginService userLoginService;
    @PostMapping("v1/user_login_service/login_by_account")
    @Operation(summary = "账号密码登陆")
    public SingleResponse<UserLoginByAccountCO> userLoginByAccount (@Validated @RequestBody UserLoginByAccountCmd cmd) {
        return userLoginService.userLoginByAccount(cmd);
    }
}
