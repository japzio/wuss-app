package com.japzio.wuss.url.v1.service;

import com.japzio.wuss.repository.UrlCacheRepository;
import com.japzio.wuss.url.v1.dto.UrlDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UrlCacheServiceRedis implements UrlCacheService{

    @Autowired
    private UrlCacheRepository urlCacheRepository;

    @Override
    public void addUrl(UrlDto urlDto) {
        this.urlCacheRepository.save(urlDto);
    }


}
