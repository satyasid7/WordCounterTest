package com.ssid.word.controller;

import com.ssid.word.service.WordCounterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api")
public class WordCounterController {

    @Autowired
    WordCounterService wordCounterService;

    @GetMapping("/add")
    public Integer add(@RequestParam String word) {
        return wordCounterService.add(word);
    }

    @GetMapping("/wordCount")
    public Integer wordCount(@RequestParam String word) {
        return wordCounterService.wordCount(word);
    }

}
