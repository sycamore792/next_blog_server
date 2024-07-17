package com.sycamore.nextblog.client.user.api;


import com.sycamore.nextblog.client.user.dto.req.UserLoginByAccountCmd;
import com.sycamore.nextblog.client.user.dto.resp.UserInfoQueryByIdCO;
import com.sycamore.nextblog.client.user.dto.resp.UserLoginByAccountCO;
import com.sycamore.nextblog.client.user.dto.resp.UserSessionMetadataQueryCO;
import com.sycamore.nextblog.components.cola.dto.SingleResponse;

/**
 *
 * @author 桑运昌
 */
public interface IUserBaseService {
    SingleResponse<UserInfoQueryByIdCO> getUserInfoById(String userId);

    UserSessionMetadataQueryCO queryUserSessionMetadata(String token);
    void expireUserSessionMetadata(String token);
}
