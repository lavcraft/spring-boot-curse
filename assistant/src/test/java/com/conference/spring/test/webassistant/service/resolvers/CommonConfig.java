package com.conference.spring.test.webassistant.service.resolvers;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
@ComponentScan("com.conference.spring.test.common")
public class CommonConfig {

    @PostConstruct
    public void init() {
        System.out.println("== load common config");
    }
}
