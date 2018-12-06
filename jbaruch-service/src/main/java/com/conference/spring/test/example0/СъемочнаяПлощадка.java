package com.conference.spring.test.example0;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class СъемочнаяПлощадка {

    @Bean
    public CommandLineRunner commandLineRunner() {
        return (args) -> {

        };
    }

    public static void main(String[] args) {
        SpringApplication.run(СъемочнаяПлощадка.class);

        Киношка съёмка = new Киношка().снимать();

        съёмка.герой.бить();
        съёмка.злодей.страдать();
        съёмка.злодей.бить();
        съёмка.герой.страдать();
        съёмка.герой.страдать();
    }
}
