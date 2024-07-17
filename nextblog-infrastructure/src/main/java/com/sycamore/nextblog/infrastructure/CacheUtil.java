package com.sycamore.nextblog.infrastructure;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author: Sycamore
 * @date: 2024/7/15 15:58
 * @version: 1.0
 * @description: TODO
 */

@Configuration
@ConfigurationProperties(prefix = "cache")
public class CacheUtil {
    private String prefix = "nextblog";


    public String getCacheKey(String key) {
        return prefix+":"+key;
    }
}
