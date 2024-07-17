package com.sycamore.nextblog.user.gateway;

import com.sycamore.nextblog.client.user.dto.resp.UserSessionMetadataQueryCO;
import com.sycamore.nextblog.user.entity.User;
import com.sycamore.nextblog.user.entity.UserSession;

import java.util.List;

/**
 * @author: Sycamore
 * @date: 2024/7/9 17:58
 * @version: 1.0
 * @description: TODO
 */
public interface UserGateway {
    List<User> listUserByAccount(String username);

    void registerUserOnlineToken(String id , String token);

    UserSession queryUserSessionMetadata(String token);
}
