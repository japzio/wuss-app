package com.japzio.wuss.url.v1.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UrlRespose {

    private String id;
    private String url;
    private String fullUrl;

}
