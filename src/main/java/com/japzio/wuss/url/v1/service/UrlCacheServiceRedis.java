package com.japzio.wuss.url.v1.service;

import com.japzio.wuss.exception.UrlNotFoundException;
import com.japzio.wuss.repository.UrlCacheRepository;
import com.japzio.wuss.url.v1.domain.Url;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class UrlCacheServiceRedis implements UrlCacheService{

    @Autowired
    private UrlCacheRepository urlCacheRepository;

    @Override
    public void addUrl(Url url) {
        this.urlCacheRepository.save(url);
    }

    @Override
    public Url getUrl(String id) {
        UUID uuidFormat;
        try {
            uuidFormat = UUID.fromString(id);
        } catch (IllegalArgumentException e) {
            log.error("action=getUrl, error={}", e.getMessage());
        }
        return urlCacheRepository.findById(id)
               .orElseThrow(() -> new NullPointerException(id + " not found!"));
    }

    @Override
    public void updateUrl(String id, Url url) {
        if(!urlCacheRepository.existsById(id)){
            log.warn("action=updatedUrl, warn=unableToFindRecordToBeUpdated, urlId={}", id);
            return;
        }
        try {
            Url urlFromDb = urlCacheRepository.findById(id)
                    .orElseThrow(() -> new UrlNotFoundException(id + " not found!"));
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        urlCacheRepository.save(url);
    }
}
