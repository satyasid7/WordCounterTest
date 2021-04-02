package com.ssid.word;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@EnableConfigurationProperties
@PropertySources({@PropertySource(value = "classpath:application.yml")})
@SpringBootApplication
public class WordCounterApplication {
    public static void main(String[] args) {
        SpringApplication.run(WordCounterApplication.class, args);
    }
}
