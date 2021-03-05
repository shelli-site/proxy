package site.shelli.serverchan.proxy.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import site.shelli.serverchan.proxy.entity.GotifyBody;

/**
 * @author shen_xi
 * @create 2021/03/05 12:01
 */
@Slf4j
@RestController
@RequestMapping("/proxy/gotify")
public class Server2GotifyController {
    @Autowired
    RestTemplate restTemplate;

    @PostMapping("serverchan")
    public String proxyServer2Gotify(@RequestParam("token") String token,
                                     @RequestParam("title") String title,
                                     @RequestParam("desp") String desp,
                                     @RequestParam("proxyUrl") String proxyUrl) {
        GotifyBody gotifyBody = GotifyBody.builder().title(title)
                .message(desp).priority(10)
                .extras(new GotifyBody.Extra("text/markdown", null, null)).build();
        String url = proxyUrl + "?token=" + token;
        String s = restTemplate.postForObject(url, gotifyBody, String.class);
        log.info("\n===> 请求 {} \n返回{}", url, s);
        return "OK";
    }
}
