package com.japzio.wuss.shortener.v1.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GetUrlRespose {

    private String id;
    private String fullUrl;

}
