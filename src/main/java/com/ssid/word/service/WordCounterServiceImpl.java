package com.ssid.word.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class WordCounterServiceImpl implements WordCounterService {
    private static Map<String, Integer> wordCounterMap = new HashMap<>();
    @Autowired
    private final TranslatorService translatorService;

    @Override
    public Integer add(String word) {
        String transWord = translatorService.translate(word);
        if (wordCounterMap.containsKey(transWord)) {
            return wordCounterMap.put(transWord, wordCounterMap.get(transWord) + 1);
        } else {
            return wordCounterMap.put(transWord, 1);
        }
    }

    @Override
    public int wordCount(String word) {
        return wordCounterMap.get(translatorService.translate(word));
    }


}
