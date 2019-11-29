package com.japzio.wuss.shortener.v1.controller;

import com.japzio.wuss.shortener.v1.model.GetUrlRespose;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/url")
public class ShortenerController {

    @GetMapping
    public String shortenUrl() {

        return "https://bit.ly/surprise";

    }

    @GetMapping(value = "/{urlId}")
    public GetUrlRespose getShortenUrlById(@PathVariable("urlId") String urlId) {

        return new GetUrlRespose(urlId, this.shortenUrl());

    }

}
