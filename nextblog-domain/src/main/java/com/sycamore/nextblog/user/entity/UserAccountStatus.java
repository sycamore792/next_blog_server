package com.sycamore.nextblog.user.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;

/** 用户账号状态枚举
 * @author 桑运昌
 */

@AllArgsConstructor
@Getter

public enum UserAccountStatus {
    AVAILABLE(0, "可用"),
    UNAVAILABLE(1, "不可用");

    private final int code;
    private final String desc;


    public static UserAccountStatus getByCode(Integer unavailableFlag) {
        return UserAccountStatus.values()[unavailableFlag];
    }
}
