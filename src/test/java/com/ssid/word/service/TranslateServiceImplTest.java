package com.ssid.word.service;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class TranslateServiceImplTest {
    TranslatorService translatorService;

    @BeforeEach
    public void setUp() {
        translatorService = new TranslateServiceImpl();
    }

    @Test
    public void translateTest() {
        assertEquals("flower", translatorService.translate("flower"));
        assertEquals("flower", translatorService.translate("flor"));
        assertEquals("flower", translatorService.translate("blume"));
        assertEquals("flower", translatorService.translate("fleur"));
        assertEquals("tree", translatorService.translate("tree"));
        assertEquals("tree", translatorService.translate("boom"));
        assertEquals("tree", translatorService.translate("arbre"));
        assertEquals("tree", translatorService.translate("baum"));
        assertNull(translatorService.translate("blahblah"));
        assertNull(translatorService.translate(null));
    }
}