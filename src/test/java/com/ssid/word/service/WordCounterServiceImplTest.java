package com.ssid.word.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class WordCounterServiceImplTest {
    WordCounterService wordCounterService;
    TranslatorService translatorService;

    @Before
    public void setUp() {
        translatorService = new TranslateServiceImpl();
        wordCounterService = new WordCounterServiceImpl(translatorService);
    }

    @Test
    public void add() {
        Assertions.assertEquals(null, wordCounterService.add("flower"));
        Assertions.assertEquals(1, wordCounterService.add("flower"));
        Assertions.assertEquals(2, wordCounterService.add("flor"));
        Assertions.assertEquals(null, wordCounterService.add("blahblah"));
    }

    @Test
    public void wordCount() {
        Assertions.assertEquals(3, wordCounterService.wordCount("flower"));
    }
}