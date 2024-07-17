package com.sycamore.nextblog.user.entity;

import lombok.Data;

import java.util.UUID;

/**
 * @author: Sycamore
 * @date: 2024/7/15 16:10
 * @version: 1.0
 * @description: TODO
 */

@Data
public class UserLoginToken {

    private String id;
    private String token;

    public UserLoginToken(String id) {
        this.id = id;
    }

    public void refreshToken() {
        this.token = UUID.randomUUID() + "-" + id + "-" + System.currentTimeMillis();
    }
}
