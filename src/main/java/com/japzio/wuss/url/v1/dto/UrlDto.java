package com.japzio.wuss.url.v1.dto;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.redis.core.RedisHash;

@RedisHash("shortUrl")
@Data
@Builder
public class UrlDto {

    private String id;
    private String origUrl;
    private int ttl;

}
