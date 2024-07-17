package com.sycamore.nextblog.infrastructure;

import com.sycamore.nextblog.user.entity.UserSession;


/**
 * 用户上下文
 * @author 桑运昌
 */
public class UserContext {


    private static final ThreadLocal<UserSession> USER_HOLDER = new ThreadLocal<>();

    public static void setUser(String userId, String userName) {
        USER_HOLDER.set(new UserSession(userId, userName));
    }

    public static UserSession getUser() {
        return USER_HOLDER.get();
    }

    public static void clear() {
        USER_HOLDER.remove();
    }

    public static void main(String[] args) {
        UserContext.setUser("1", "sang");
        System.out.println(UserContext.getUser().getUserId());
        UserContext.clear();
        System.out.println(UserContext.getUser());
    }
}