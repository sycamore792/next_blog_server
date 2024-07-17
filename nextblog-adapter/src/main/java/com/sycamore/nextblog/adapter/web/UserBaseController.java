package com.sycamore.nextblog.adapter.web;

import com.sycamore.nextblog.adapter.filter.user.Authenticated;
import com.sycamore.nextblog.client.user.api.IUserBaseService;
import com.sycamore.nextblog.client.user.dto.resp.UserInfoQueryByIdCO;
import com.sycamore.nextblog.client.user.dto.resp.UserLoginByAccountCO;
import com.sycamore.nextblog.components.cola.catchlog.CatchAndLog;
import com.sycamore.nextblog.components.cola.dto.SingleResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Sycamore
 * @date: 2024/7/9 16:29
 * @version: 1.0
 * @description: TODO
 */
@RestController
@RequiredArgsConstructor
@Tag(name = "用户基础模块")
@CatchAndLog
public class UserBaseController {
    private final IUserBaseService userBaseService;
    @GetMapping("v1/user_info_service/user_info/{userId}")
    @Operation(summary = "获取用户基本信息")
    public SingleResponse<UserInfoQueryByIdCO> getUserInfo (@PathVariable("userId") String userId) {
        return userBaseService.getUserInfoById(userId);
    }
}
