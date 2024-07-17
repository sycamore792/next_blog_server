package com.sycamore.nextblog.infrastructure.user.mapper.dataobject;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author: Sycamore
 * @date: 2024/7/9 12:16
 * @version: 1.0
 * @description: TODO
 */

@Data
@TableName("user_base")
public class UserBaseDO {
    @TableId(type = IdType.AUTO)
    private Long id;
    private String username;
    private String password;
    private String passwordSalt;
    private String email;
    private String phone;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createAt;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date lastLoginAt;
    private Integer unavailableFlag;
}
