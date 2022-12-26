package com.japzio.wuss.url.v1.controller;

import com.japzio.wuss.exception.EmptyFieldException;
import com.japzio.wuss.url.v1.domain.Url;
import com.japzio.wuss.url.v1.model.UrlRequest;
import com.japzio.wuss.url.v1.model.UrlRespose;

import com.japzio.wuss.url.v1.service.UrlCacheService;
import org.apache.commons.lang3.RandomStringUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/urls")
public class UrlController {

    private UrlCacheService urlCacheService;

    public UrlController(@Autowired UrlCacheService urlCacheService) {
        this.urlCacheService = urlCacheService;
    }

    @GetMapping(value = "/{urlId}")
    public UrlRespose getShortenUrlById(@PathVariable("urlId") String urlId) {

        Url url = urlCacheService.getUrl(urlId);
        return UrlRespose.builder()
                .origUrl(url.getOrigUrl())
                .id(url.getId())
                .build();
    }

    @PostMapping(value = "/shorten", consumes = "application/json")
    public UrlRespose shortenUrl(@RequestBody UrlRequest urlRequest) throws EmptyFieldException {

        String id = RandomStringUtils.randomAlphanumeric(8);

        urlCacheService.addUrl(
                    Url.builder()
                        .withId(id)
                        .withOrigUrl(urlRequest.getUrl())
                        .withTtl(3600)
                        .build()
        );

        return new UrlRespose(
                id,
                urlRequest.getUrl()
        );
    }
}
