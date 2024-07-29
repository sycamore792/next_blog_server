package com.sycamore.nextblog.app.user;


import com.sycamore.nextblog.app.user.executor.UserLoginSmsExe;
import com.sycamore.nextblog.client.user.api.IUserLoginService;
import com.sycamore.nextblog.client.user.dto.resp.UserLoginByAccountCO;
import com.sycamore.nextblog.client.user.dto.req.UserLoginByAccountCmd;
import com.sycamore.nextblog.app.user.executor.UserLoginByAccountExe;
import com.sycamore.nextblog.components.cola.dto.SingleResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


/**
 *
 * @author 桑运昌
 */
@Service
@RequiredArgsConstructor
public class UserLoginServiceImpl implements IUserLoginService {
    private final UserLoginByAccountExe userLoginByAccountExe;
    private final UserLoginSmsExe userLoginSmsExe;


    @Override
    public SingleResponse<UserLoginByAccountCO> userLoginByAccount(UserLoginByAccountCmd cmd) {
        return userLoginByAccountExe.execute(cmd);
    }

    @Override
    public SingleResponse trySendSms(String phoneNum) {
        return userLoginSmsExe.execute(phoneNum);
    }
}
