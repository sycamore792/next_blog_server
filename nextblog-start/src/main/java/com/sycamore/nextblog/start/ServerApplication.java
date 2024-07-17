package com.sycamore.nextblog.start;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * <p>
 *    main application
 * </p>
 *
 * @author 桑运昌
 */
@SpringBootApplication(scanBasePackages = {"com.sycamore.nextblog"})
@MapperScan("com.sycamore.nextblog.infrastructure.*.mapper")
@EnableConfigurationProperties
public class ServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServerApplication.class, args);
    }
}
