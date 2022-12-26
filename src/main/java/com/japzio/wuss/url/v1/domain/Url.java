package com.japzio.wuss.url.v1.domain;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.redis.core.RedisHash;

@RedisHash("shortUrl")
@Data
@Builder(setterPrefix = "with")
public class Url {

    private String id;
    private String origUrl;
    private int ttl;

}
