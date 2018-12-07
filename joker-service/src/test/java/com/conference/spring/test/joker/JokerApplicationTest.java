package com.conference.spring.test.joker;

import org.hamcrest.MatcherAssert;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.notNullValue;

/**
 * @author tolkv
 * @version 19/03/2017
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class JokerApplicationTest {
  @Autowired
  private ApplicationContext context;

  @Autowired
  private JokerProperties jokerProperties;

  @Test
  public void test() {
    Assert.assertNotNull(jokerProperties);
    MatcherAssert.assertThat(context, notNullValue());
  }
}
