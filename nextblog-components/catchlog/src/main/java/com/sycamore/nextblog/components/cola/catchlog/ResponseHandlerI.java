package com.sycamore.nextblog.components.cola.catchlog;

/**
 * @author 桑运昌
 */
public interface ResponseHandlerI {
    public Object handle(Class returnType, String errCode, String errMsg);
}