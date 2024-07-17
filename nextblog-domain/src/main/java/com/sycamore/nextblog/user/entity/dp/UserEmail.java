package com.sycamore.nextblog.user.entity.dp;
import jakarta.validation.ValidationException;
import lombok.Getter;


/**
 * @author 桑运昌
 */
@Getter
public class UserEmail {
    private final String email ;

    public UserEmail(String email) {
        if (email == null|| email.isEmpty()) {
            throw new ValidationException("email 不能为空");
        }
        if (!isValid(email)) {
            throw new ValidationException("email 格式错误");
        }
        this.email = email;
    }
    public static UserEmail of(String email) {
        return new UserEmail(email);
    }

    public static boolean isValid(String number) {
        String pattern = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        return number.matches(pattern);
    }
}