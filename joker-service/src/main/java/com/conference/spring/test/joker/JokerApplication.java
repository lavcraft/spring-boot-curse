package com.conference.spring.test.joker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author tolkv
 * @version 19/03/2017
 */

@EnableScheduling
@EnableFeignClients
@SpringBootApplication
@EnableConfigurationProperties(JokerProperties.class)
public class JokerApplication {
  public static void main(String[] args) {
    SpringApplication.run(JokerApplication.class, args);
  }
}
