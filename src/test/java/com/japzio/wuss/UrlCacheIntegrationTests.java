package com.japzio.wuss;

import com.japzio.wuss.url.v1.domain.Url;
import com.japzio.wuss.url.v1.service.UrlCacheService;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

import static org.junit.Assert.assertEquals;

@SpringBootTest
@Testcontainers
public class UrlCacheIntegrationTests {
    UrlCacheService urlCacheService;

    public UrlCacheIntegrationTests(@Autowired UrlCacheService urlCacheService) {
        this.urlCacheService = urlCacheService;
    }

    @Container
    private static GenericContainer<?> redis =
            new GenericContainer<>(DockerImageName.parse("redis:7.0.7"))
                    .withExposedPorts(6379);
    
    @DynamicPropertySource
    static void redisProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.redis.host", redis::getHost);
        registry.add("spring.redis.port", redis::getFirstMappedPort);
    }

    @BeforeClass
    public static void setup(){
        redis.start();
    }


    @Test
    void givenUrlCreated_thenProductExistsAndHasSameProperties() {
        Url url = Url.builder()
                .withId("adfasdfsdf")
                .withOrigUrl("https://www.github.com/japzio")
                .withTtl(60)
                .build();
        urlCacheService.addUrl(url);
        Url urlFromCache = urlCacheService.getUrl("adfasdfsdf");
        assertEquals(url.getId(), urlFromCache.getId());
        assertEquals(url.getOrigUrl(), urlFromCache.getOrigUrl());
        assertEquals(url.getTtl(), urlFromCache.getTtl());
    }
}
