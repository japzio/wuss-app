package com.japzio.wuss.config;


import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.redisson.spring.data.connection.RedissonConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.data.redis.core.RedisTemplate;

import java.io.IOException;

@Slf4j
@Configuration
public class SpringDataConfigRedis {

    @Value("classpath:/redisson.yaml")
    private Resource configFile;

    @Bean
    public RedissonConnectionFactory connectionFactory(RedissonClient redisson) {
        return new RedissonConnectionFactory(redisson);
    }

    @Bean(destroyMethod = "shutdown")
    public RedissonClient redisson() throws IOException {

        Config config = Config.fromYAML(configFile.getInputStream());
        return Redisson.create(config);
    }

    @Bean
    public RedisTemplate<String, Object> redisTemplate() {
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        try {
            template.setConnectionFactory(connectionFactory(this.redisson()));
        } catch(IOException e) {
            log.error("Connection factory error - " + e.getMessage());
        }
        return template;
    }
}
