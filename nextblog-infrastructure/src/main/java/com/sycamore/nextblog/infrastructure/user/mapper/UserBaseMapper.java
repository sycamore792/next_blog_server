package com.sycamore.nextblog.infrastructure.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sycamore.nextblog.infrastructure.user.mapper.dataobject.UserBaseDO;

import java.util.List;

/**
 * @author: Sycamore
 * @date: 2024/7/9 12:15
 * @version: 1.0
 * @description: TODO
 */

public interface UserBaseMapper extends BaseMapper<UserBaseDO> {

    List<UserBaseDO> listUserByPhone(String account);
    List<UserBaseDO> listUserByEmail(String account);
}
