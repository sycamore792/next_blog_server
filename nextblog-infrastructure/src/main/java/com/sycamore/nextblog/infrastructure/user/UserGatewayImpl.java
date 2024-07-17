package com.sycamore.nextblog.infrastructure.user;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.sycamore.nextblog.infrastructure.CacheUtil;
import com.sycamore.nextblog.infrastructure.user.mapper.UserBaseMapper;
import com.sycamore.nextblog.infrastructure.user.mapper.dataobject.UserBaseDO;
import com.sycamore.nextblog.user.entity.User;
import com.sycamore.nextblog.user.entity.UserAccountStatus;
import com.sycamore.nextblog.user.entity.UserSession;
import com.sycamore.nextblog.user.entity.dp.UserEmail;
import com.sycamore.nextblog.user.entity.dp.UserPhone;
import com.sycamore.nextblog.user.gateway.UserGateway;
import lombok.RequiredArgsConstructor;
import net.sf.jsqlparser.statement.select.KSQLWindow;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: Sycamore
 * @date: 2024/7/9 17:58
 * @version: 1.0
 * @description: TODO
 */
@RequiredArgsConstructor
@Service
public class UserGatewayImpl implements UserGateway {
    private final UserBaseMapper userMapper;
    private final StringRedisTemplate redisTemplate;
    private final CacheUtil cacheUtil;

    @Override
    public List<User> listUserByAccount(String account) {
        // 判断手机号还是邮箱  todo 规则耦合
        LambdaQueryWrapper<UserBaseDO> queryWrapper = Wrappers.lambdaQuery(UserBaseDO.class);
        if (account.matches("^1[3-9]\\d{9}$")) {
            queryWrapper.eq(UserBaseDO::getPhone, account);
        } else if (account.matches("^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$")) {
            queryWrapper.eq(UserBaseDO::getEmail, account);
        } else {
            // 账号格式错误
            return new ArrayList<>();
        }

        List<UserBaseDO> userBaseDOList = userMapper.selectList(queryWrapper.eq(UserBaseDO::getUnavailableFlag, UserAccountStatus.AVAILABLE.getCode()));
        return userBaseDOList.stream().map(userBaseDO -> {
            return new User(
                    userBaseDO.getId().toString(),
                    userBaseDO.getUsername(),
                    UserPhone.of(userBaseDO.getPhone()),
                    UserEmail.of(userBaseDO.getEmail()),
                    userBaseDO.getPassword(),
                    userBaseDO.getPasswordSalt(),
                    UserAccountStatus.getByCode(userBaseDO.getUnavailableFlag())
            );
        }).collect(Collectors.toList());
    }

    @Override
    public void registerUserOnlineToken(String id, String token) {

        String tokenKey = cacheUtil.getCacheKey("user:loginToken:" + id);
        String userIdKey = cacheUtil.getCacheKey("user:loginToken:" + token);

        redisTemplate.opsForValue().set(tokenKey, token);
        redisTemplate.expire(tokenKey, java.time.Duration.ofDays(7));
        redisTemplate.opsForValue().set(userIdKey, id);
        redisTemplate.expire(userIdKey, java.time.Duration.ofDays(7));
    }

    @Override
    public UserSession queryUserSessionMetadata(String token) {
        return new UserSession(redisTemplate.opsForValue().get(cacheUtil.getCacheKey("user:loginToken:" + token)),"");
    }
}
