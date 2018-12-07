package com.conference.spring.test.webassistant.service.resolvers.question;

import com.conference.spring.test.webassistant.domain.Question;
import com.conference.spring.test.webassistant.domain.QuestionType;
import com.conference.spring.test.webassistant.service.resolvers.ResolversAbstractCommonConfiguration;
import com.conference.spring.test.webassistant.service.resolvers.WordsCommonConfiguration;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static com.conference.spring.test.webassistant.domain.QuestionType.JBARUCH;
import static com.conference.spring.test.webassistant.domain.QuestionType.JOKER;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * @author tolkv
 * @version 30/03/2017
 */
@ExtendWith(SpringExtension.class)
@ContextHierarchy(value = {
    @ContextConfiguration(classes = WordsCommonConfiguration.class),
    @ContextConfiguration(classes = TextBasedQuestionTypeResolverTestConfiguration.class),
})
public class TextBasedQuestionTypeResolverTest extends ResolversAbstractCommonConfiguration {
  @Autowired
  TextBasedQuestionTypeResolver textBasedQuestionTypeResolver;
  @Value("${tokens.jbaruch}")
  String                        jbaruchTokens;
  @Value("${tokens.joker}")
  String                        jokerTokens;

  @Test
  public void should_sth() throws Exception {
    QuestionType jbaruchType = textBasedQuestionTypeResolver.resolveType(Question.builder()
        .body("groovy in object is sexy?")
        .build());

    QuestionType jokerType = textBasedQuestionTypeResolver.resolveType(Question.builder()
        .body("Smile, because it confuses people")
        .build());

    assertThat(jbaruchType, equalTo(JBARUCH));
    assertThat(jokerType, equalTo(JOKER));
  }

}
