package com.aggregation.redis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootVersion;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RedisApplication {

    /**
     * @Desc redis锁 自动续期
     */
    public static void main(String[] args) {
        SpringApplication.run(RedisApplication.class, args);
    }

}
