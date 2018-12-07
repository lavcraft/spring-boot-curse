package com.conference.spring.test.webassistant.service.resolvers.words;

import com.conference.spring.test.common.GarbageProperties;
import com.conference.spring.test.common.utils.WordsComposer;
import com.conference.spring.test.webassistant.domain.Question;
import com.conference.spring.test.webassistant.service.resolvers.WordsCommonConfiguration;
import com.conference.spring.test.webassistant.service.resolvers.ResolversAbstractCommonConfiguration;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * @author tolkv
 * @version 29/03/2017
 */
@ExtendWith(SpringExtension.class)
@ContextHierarchy({
    @ContextConfiguration(classes = WordsCommonConfiguration.class),
    @ContextConfiguration(classes = WordsFrequencyResolverTestConfiguration.class),
})
public class JokerWordsFrequencyResolverTest extends ResolversAbstractCommonConfiguration {
  @Autowired
  JokerWordsFrequencyResolver jokerWordsFrequencyResolver;

//  @Test
  public void first_test() throws Exception {
    JokerWordsFrequencyResolver jokerWordsFrequencyResolver =
        new JokerWordsFrequencyResolver(
            new WordsComposer(
                new GarbageProperties()));
    jokerWordsFrequencyResolver.setAnswers("i am object and object within me");

    int match = jokerWordsFrequencyResolver.match(Question.builder()
        .body("object in me")
        .build());

    assertThat(match, equalTo(1));
  }

  @Test
  public void improved_test() throws Exception {
    jokerWordsFrequencyResolver.setAnswers("i am object and object within me");
    int match = jokerWordsFrequencyResolver.match(Question.builder()
        .body("object in me")
        .build());

    assertThat(match, equalTo(1));

  }

}
