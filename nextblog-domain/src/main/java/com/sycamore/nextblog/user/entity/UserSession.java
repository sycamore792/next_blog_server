package com.sycamore.nextblog.user.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.util.StringUtils;

/**
 * @author 桑运昌
 */
@Data
@AllArgsConstructor
public class UserSession {
    private String userId;
    private String userName;


    public boolean isValid() {
        return this.userId != null && this.userName != null;
    }
}
