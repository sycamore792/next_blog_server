package com.sycamore.nextblog.app.user.executor;

import com.sycamore.nextblog.client.user.dto.resp.UserLoginByAccountCO;
import com.sycamore.nextblog.client.user.dto.req.UserLoginByAccountCmd;
import com.sycamore.nextblog.components.cola.dto.SingleResponse;
import com.sycamore.nextblog.components.cola.exception.BizException;
import com.sycamore.nextblog.user.entity.User;
import com.sycamore.nextblog.user.entity.UserLoginToken;
import com.sycamore.nextblog.user.gateway.UserGateway;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author: Sycamore
 * @date: 2024/7/9 17:54
 * @version: 1.0
 * @description: TODO
 */

@Component
@RequiredArgsConstructor
@Slf4j
public class UserLoginByAccountExe {
    private final UserGateway userGateway;

    public SingleResponse<UserLoginByAccountCO> execute(UserLoginByAccountCmd cmd) {
        String account = cmd.getAccount();
        String password = cmd.getPassword();

        // 查找用户
        List<User> users = userGateway.listUserByAccount(account);
        if (Objects.isNull(users) || users.isEmpty()) {
            throw new BizException("用户不存在或密码错误");
        }
        //校验
        ArrayList<User> targetUsers = new ArrayList<>();
        users.forEach(user -> {
            if (user.passwordIsRight(password)) {
                targetUsers.add(user);
            }
        });
        if (targetUsers.isEmpty()) {
            throw new BizException("密码错误");
        }
        if (targetUsers.size() > 1) {
            // 系统漏洞 发布事件
            throw new BizException("系统繁忙，请联系管理员");
        }
        User user = targetUsers.get(0);
        // 注册用户在线状态
        UserLoginToken userLoginToken = new UserLoginToken(user.getId());
        userLoginToken.refreshToken();

        userGateway.registerUserOnlineToken(user.getId(), userLoginToken.getToken());
        UserLoginByAccountCO co = new UserLoginByAccountCO();
        co.setToken(userLoginToken.getToken());
        co.setUsername(user.getUsername());
        co.setId(user.getId());

        return SingleResponse.of(co);
    }
}
