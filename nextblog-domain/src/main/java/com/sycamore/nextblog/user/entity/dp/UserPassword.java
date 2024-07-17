package com.sycamore.nextblog.user.entity.dp;

import com.sycamore.nextblog.user.toolkits.Md5Util;
import jakarta.validation.ValidationException;
import lombok.Getter;

/**
 * @author: Sycamore
 * @date: 2024/7/15 15:43
 * @version: 1.0
 * @description: TODO
 */
@Getter
public class UserPassword{
    private final String password ;

    public UserPassword(String password,String salt) {
        if (password == null|| password.isEmpty()) {
            throw new ValidationException("password 不能为空");
        }
        if (salt == null|| salt.isEmpty()) {
            throw new ValidationException("salt 不能为空");
        }
        if (!isValid(password) || !isValid(salt)) {
            throw new ValidationException("格式错误");
        }
        this.password = Md5Util.toMd5(password + salt);
    }
    public static UserPassword of(String password,String salt) {

        return new UserPassword(password, salt);
    }



    public static boolean isValid(String password) {
        return password.length() == 32 ;
    }
}
