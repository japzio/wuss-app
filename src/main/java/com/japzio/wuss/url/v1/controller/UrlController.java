package com.japzio.wuss.url.v1.controller;

import com.japzio.wuss.url.v1.dto.UrlDto;
import com.japzio.wuss.url.v1.model.UrlRequest;
import com.japzio.wuss.url.v1.model.UrlRespose;

import com.japzio.wuss.url.v1.service.UrlCacheService;
import org.apache.commons.lang3.RandomStringUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/urls")
public class UrlController {

    @Autowired
    private UrlCacheService urlCacheService;

    @GetMapping(value = "/{urlId}")
    public UrlRespose getShortenUrlById(@PathVariable("urlId") String urlId) {

        return new UrlRespose(
                urlId,
                "https://coreos.com/blog/the-prometheus-operator.html"
        );

    }

    @PostMapping(value = "/shorten")
    public UrlRespose shortenUrl(@RequestBody UrlRequest urlRequest) {

        String id = RandomStringUtils.randomAlphanumeric(8);


        urlCacheService.addUrl(
                    UrlDto.builder()
                        .id(id)
                        .origUrl(urlRequest.getUrl())
                        .ttl(3600)
                        .build()
        );

        return new UrlRespose(
                id,
                urlRequest.getUrl()
        );

    }

}
