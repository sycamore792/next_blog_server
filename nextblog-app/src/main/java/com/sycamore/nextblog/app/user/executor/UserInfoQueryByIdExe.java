package com.sycamore.nextblog.app.user.executor;

import com.sycamore.nextblog.client.user.dto.req.UserLoginByAccountCmd;
import com.sycamore.nextblog.client.user.dto.resp.UserInfoQueryByIdCO;
import com.sycamore.nextblog.client.user.dto.resp.UserLoginByAccountCO;
import com.sycamore.nextblog.components.cola.dto.SingleResponse;
import com.sycamore.nextblog.components.cola.exception.BizException;
import com.sycamore.nextblog.infrastructure.user.mapper.UserBaseMapper;
import com.sycamore.nextblog.infrastructure.user.mapper.dataobject.UserBaseDO;
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
public class UserInfoQueryByIdExe {
    private final UserBaseMapper userBaseMapper;

    public SingleResponse<UserInfoQueryByIdCO> execute(String id) {
        UserBaseDO userBaseDO = userBaseMapper.selectById(id);
        if (Objects.isNull(userBaseDO)){
            throw new BizException("用户信息不存在！");
        }
        return SingleResponse.of(new UserInfoQueryByIdCO(userBaseDO.getId().toString(),userBaseDO.getUsername()));
    }
}
