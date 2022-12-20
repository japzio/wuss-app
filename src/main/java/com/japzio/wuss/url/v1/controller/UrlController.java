package com.japzio.wuss.url.v1.controller;

import com.japzio.wuss.exception.EmptyFieldException;
import com.japzio.wuss.url.v1.dto.UrlDto;
import com.japzio.wuss.url.v1.model.UrlRequest;
import com.japzio.wuss.url.v1.model.UrlRespose;

import com.japzio.wuss.url.v1.service.UrlCacheService;
import org.apache.commons.lang3.RandomStringUtils;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/url")
public class UrlController {

    private UrlCacheService urlCacheService;

    public UrlController(@Autowired UrlCacheService urlCacheService) {
        this.urlCacheService = urlCacheService;
    }

    @GetMapping(value = "/{urlId}")
    public UrlRespose getShortenUrlById(@PathVariable("urlId") String urlId) {

        return new UrlRespose(
                urlId,
                "https://coreos.com/blog/the-prometheus-operator.html"
        );

    }

    @PostMapping(value = "/shorten", consumes = "application/json")
    public UrlRespose shortenUrl(@RequestBody UrlRequest urlRequest) throws EmptyFieldException {

        String id = RandomStringUtils.randomAlphanumeric(8);

        if(StringUtils.isBlank(urlRequest.getUrl())){
            throw new EmptyFieldException();
        }

        urlCacheService.addUrl(
                    UrlDto.builder()
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
