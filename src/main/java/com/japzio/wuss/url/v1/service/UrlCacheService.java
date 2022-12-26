package com.japzio.wuss.url.v1.service;

import com.japzio.wuss.url.v1.domain.Url;

public interface UrlCacheService {

    public void addUrl(Url url);
    public Url getUrl(String id);
    public void updateUrl(String id, Url url);
}
