package com.sycamore.nextblog.infrastructure.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;

import java.time.LocalDateTime;

/**
 * 元数据处理器
 */
public class DefaultMetaObjectHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {

        //字段为空，可以进行填充
        setFieldValByName("createAt", LocalDateTime.now(), metaObject);
        //字段为空，可以进行填充
        setFieldValByName("updateAt", LocalDateTime.now(), metaObject);
        setFieldValByName("delFlag", 0, metaObject);
    }



    @Override
    public void updateFill(MetaObject metaObject) {
        //更新数据时，直接更新字段
        setFieldValByName("updateAt", LocalDateTime.now(), metaObject);

    }
}