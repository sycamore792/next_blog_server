package com.sycamore.nextblog.client.user.api;


import com.sycamore.nextblog.client.user.dto.resp.UserLoginByAccountCO;
import com.sycamore.nextblog.client.user.dto.req.UserLoginByAccountCmd;
import com.sycamore.nextblog.components.cola.dto.SingleResponse;
import org.springframework.validation.annotation.Validated;

/**
 *
 * @author 桑运昌
 */
public interface IUserLoginService {
    SingleResponse<UserLoginByAccountCO> userLoginByAccount( UserLoginByAccountCmd cmd);
}
