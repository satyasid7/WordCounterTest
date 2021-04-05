package com.ssid.word.controller;

import com.ssid.word.service.WordCounterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class WordCounterController {

    @Autowired
    WordCounterService wordCounterService;

    @PostMapping("/add")
    public ResponseEntity<Integer> add(@RequestParam String word) {
        return new ResponseEntity(wordCounterService.add(word), HttpStatus.OK);
    }

    @GetMapping("/wordCount")
    public Integer wordCount(@RequestParam String word) {
        return wordCounterService.wordCount(word);
    }

}
