package com.conference.spring.test.webassistant.service.resolvers.words;

import com.conference.spring.test.common.utils.WordsComposer;
import com.conference.spring.test.webassistant.domain.QuestionType;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import static com.conference.spring.test.webassistant.domain.QuestionType.JOKER;
import static lombok.AccessLevel.PACKAGE;

/**
 * Created by Evegeny on 28/03/2017.
 */
@Component
public class JokerWordsFrequencyResolver extends AbstractWordsFrequencyResolver {
  @Getter
  @Setter(PACKAGE)
  @Value("${tokens.joker}")
  private String answers;

  public JokerWordsFrequencyResolver(WordsComposer wordsComposer) {
    super(wordsComposer);
  }

  @Override
  public QuestionType getQuestionType() {
    return JOKER;
  }
}
