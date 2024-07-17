package com.sycamore.nextblog.user.entity;

import com.sycamore.nextblog.user.entity.dp.UserEmail;
import com.sycamore.nextblog.user.entity.dp.UserPassword;
import com.sycamore.nextblog.user.entity.dp.UserPhone;
import com.sycamore.nextblog.user.toolkits.Md5Util;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.util.StringUtils;

/**
 * @author: Sycamore
 * @date: 2024/7/15 9:57
 * @version: 1.0
 * @description: TODO
 */
@Data
@AllArgsConstructor
public class User {
    private String id;
    private String username;
    private UserPhone userPhone;
    private UserEmail userEmail;
    private String password;
    private String passwordSalt;
//    private UserPassword userPassword;
    private UserAccountStatus userAccountStatus;


    /**
     * 密码是否正确
     * @param passwordChecked (md5)
     * @return
     */
    public boolean passwordIsRight(String passwordChecked) {
        if (!isPasswordValid()){
            return false;
        }
        if (!StringUtils.hasText(passwordChecked) || passwordChecked.length()!=32){
            return false;
        }
        return this.password.equals(Md5Util.toMd5(passwordChecked+ this.passwordSalt));
    }

    public boolean isPasswordValid() {
        if (!StringUtils.hasText(this.password) || !StringUtils.hasText(this.passwordSalt)){
            return false;
        }
        return this.password.length()  == 32 && this.passwordSalt.length() == 32;
    }
}
