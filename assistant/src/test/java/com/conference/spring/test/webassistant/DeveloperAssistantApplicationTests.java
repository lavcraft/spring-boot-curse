package com.conference.spring.test.webassistant;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringRunner;

@SpringJUnitConfig
@SpringBootTest
public class DeveloperAssistantApplicationTests {
  @Autowired
  ApplicationContext applicationContext;

  @Test
  public void contextLoads() {
    Assert.assertNotNull(applicationContext);
  }

}
