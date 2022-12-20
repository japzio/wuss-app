package com.japzio.wuss.url.v1.service;

import com.japzio.wuss.url.v1.dto.UrlDto;

public interface UrlCacheService {

    public void addUrl(UrlDto urlDto);
    public UrlDto getUrl(String id);

}
