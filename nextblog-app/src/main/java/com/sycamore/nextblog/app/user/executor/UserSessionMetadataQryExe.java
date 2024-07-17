package com.sycamore.nextblog.app.user.executor;

import com.sycamore.nextblog.client.user.dto.resp.UserSessionMetadataQueryCO;
import com.sycamore.nextblog.user.entity.UserSession;
import com.sycamore.nextblog.user.gateway.UserGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author: Sycamore
 * @date: 2024/7/16 18:27
 * @version: 1.0
 * @description: TODO
 */
@Component
@RequiredArgsConstructor
public class UserSessionMetadataQryExe {
    private final UserGateway userGateway;


    public UserSessionMetadataQueryCO execute(String token) {
        UserSession userSession = userGateway.queryUserSessionMetadata(token);
        if (userSession == null || !userSession.isValid()) {
            return null;
        }
        return new UserSessionMetadataQueryCO(userSession.getUserId(), userSession.getUserName());

    }
}
