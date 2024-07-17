package com.sycamore.nextblog.components.cola.catchlog;

import java.util.Objects;

/**
 * @author 桑运昌
 */
public class ResponseHandlerFactory {

    public static ResponseHandlerI get(){
        ResponseHandlerI bean = ApplicationContextHelper.getBean(ResponseHandlerI.class);
        if(Objects.nonNull(bean)){
            return bean;
        }
        return new DefaultResponseHandler();
    }
}