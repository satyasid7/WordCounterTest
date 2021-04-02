package com.ssid.word.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class TranslateServiceImpl implements TranslatorService {
    private Map<String, String> WORD_BANK = new HashMap<>();

    {
        WORD_BANK.put("flower", "flower");
        WORD_BANK.put("flor", "flower");
        WORD_BANK.put("blume", "flower");
        WORD_BANK.put("fleur", "flower");
        WORD_BANK.put("tree", "tree");
        WORD_BANK.put("boom", "tree");
        WORD_BANK.put("arbre", "tree");
        WORD_BANK.put("baum", "tree");
    }

    @Override
    public String translate(String word) {
        return WORD_BANK.get(word);
    }
}
