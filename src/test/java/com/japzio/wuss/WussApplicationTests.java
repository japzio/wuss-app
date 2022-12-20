package com.japzio.wuss;

import com.japzio.wuss.url.v1.dto.UrlDto;
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
class WussApplicationTests {

	@Test
	void contextLoads() {
	}

}
