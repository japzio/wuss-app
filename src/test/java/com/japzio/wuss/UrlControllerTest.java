package com.japzio.wuss;

import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.containers.wait.strategy.Wait;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;


import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@Testcontainers
class UrlControllerTest {

    @Container
    static GenericContainer<?> redis =
                new GenericContainer<>(DockerImageName.parse("redis:5.0.3-alpine"))
                        .withExposedPorts(6379)
                        .waitingFor(Wait.forHealthcheck());

    @DynamicPropertySource
    static void redisProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.redis.host", redis::getHost);
        registry.add("spring.redis.port", redis::getFirstMappedPort);
    }

    @BeforeAll
    public static void setup(){
        redis.start();
    }

    @Test
    public void defaultTest() {
        assertTrue(true);
    }


}

