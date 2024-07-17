package com.sycamore.nextblog.user.entity.dp;
import jakarta.validation.ValidationException;
import lombok.Getter;


/**
 * @author 桑运昌
 */
@Getter
public class UserPhone {
    private final String phoneNumber;
    public UserPhone(String phoneNumber) {
        if (phoneNumber == null) {
            throw new ValidationException("phoneNumber不能为空");
        }
        if (!isValid(phoneNumber)) {
            throw new ValidationException("phoneNumber格式错误");
        }
        this.phoneNumber = phoneNumber;
    }
    public static UserPhone of(String phoneNumber) {
        return new UserPhone(phoneNumber);
    }

    public static boolean isValid(String number) {
        String pattern = "^1[3-9]\\d{9}$";
        return number.matches(pattern);
    }
}