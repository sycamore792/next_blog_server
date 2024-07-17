package com.sycamore.nextblog.app.user;


import com.sycamore.nextblog.app.user.executor.UserInfoQueryByIdExe;
import com.sycamore.nextblog.app.user.executor.UserSessionExpireExe;
import com.sycamore.nextblog.app.user.executor.UserSessionMetadataQryExe;
import com.sycamore.nextblog.client.user.api.IUserBaseService;
import com.sycamore.nextblog.client.user.dto.resp.UserInfoQueryByIdCO;
import com.sycamore.nextblog.client.user.dto.resp.UserLoginByAccountCO;
import com.sycamore.nextblog.client.user.dto.resp.UserSessionMetadataQueryCO;
import com.sycamore.nextblog.components.cola.dto.SingleResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 *
 * @author 桑运昌
 */
@Service
@RequiredArgsConstructor
public class UserBaseServiceImpl implements IUserBaseService {

    private final UserInfoQueryByIdExe userInfoQueryByIdExe;
    private final UserSessionMetadataQryExe userSessionMetadataQryExe;
    private final UserSessionExpireExe userSessionExpireExe;

    @Override
    public SingleResponse<UserInfoQueryByIdCO> getUserInfoById(String userId) {
        return userInfoQueryByIdExe.execute(userId);
    }

    @Override
    public UserSessionMetadataQueryCO queryUserSessionMetadata(String token) {
        return userSessionMetadataQryExe.execute(token);
    }

    @Override
    public void expireUserSessionMetadata(String token) {
        userSessionExpireExe.execute(token);
    }
}
