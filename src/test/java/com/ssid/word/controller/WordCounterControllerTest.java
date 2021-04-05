package com.ssid.word.controller;

import com.ssid.word.service.WordCounterService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(value = WordCounterController.class)
public class WordCounterControllerTest {

    @Autowired
    MockMvc mockMvc;
    @MockBean
    WordCounterService wordCounterService;

    @Test
    public void add() throws Exception {
        this.mockMvc.perform(post("/api/add")
                .param("word", "flower"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("0")));
    }

    @Test
    public void wordCount() throws Exception {
        Mockito.when(wordCounterService.wordCount("flower")).thenReturn(5);
        this.mockMvc.perform(get("/api/wordCount")
                .param("word", "flower"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("5")));

    }
}