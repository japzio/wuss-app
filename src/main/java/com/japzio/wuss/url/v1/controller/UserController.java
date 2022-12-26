package com.japzio.wuss.url.v1.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/users")
public class UserController {

    @GetMapping(value = "/{id}")
    public String getUserById(@PathVariable("id") String id) {
        return "USER : " + id;
    }

    @GetMapping()
    public String getAllUsers() {
        return "All USERs!";
    }
}
