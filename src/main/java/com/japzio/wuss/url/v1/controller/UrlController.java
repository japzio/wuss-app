package com.japzio.wuss.url.v1.controller;

import com.japzio.wuss.url.v1.model.UrlRequest;
import com.japzio.wuss.url.v1.model.UrlRespose;

import org.apache.commons.lang3.RandomStringUtils;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/urls")
public class UrlController {

    @GetMapping(value = "/{urlId}")
    public UrlRespose getShortenUrlById(@PathVariable("urlId") String urlId) {

        return new UrlRespose(urlId, new StringBuilder()
                .append("https://japzio.com")
                .append("/")
                .append(urlId)
                .toString(),
                "https://coreos.com/blog/the-prometheus-operator.html"
        );

    }

    @PostMapping(value = "/shorten")
    public UrlRespose shortenUrl(@RequestBody UrlRequest urlRequest) {

        String id = RandomStringUtils.randomAlphanumeric(8);

        return new UrlRespose(
                id,
                new StringBuilder()
                        .append("https://japzio.com")
                        .append("/")
                        .append(id).toString(),
                urlRequest.getUrl()
        );

    }


}
