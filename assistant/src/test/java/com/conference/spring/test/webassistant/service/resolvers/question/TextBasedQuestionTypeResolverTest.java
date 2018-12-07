package com.conference.spring.test.webassistant.service.resolvers.question;

import com.conference.spring.test.webassistant.domain.Question;
import com.conference.spring.test.webassistant.domain.QuestionType;
import com.conference.spring.test.webassistant.service.resolvers.CommonConfig;
import com.conference.spring.test.webassistant.service.resolvers.words.JokerWordsFrequencyResolverTestConfiguration;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@ActiveProfiles("joker_vs_jbaruch")
class TextBasedQuestionTypeResolverTest {
    @Autowired TextBasedQuestionTypeResolver textBasedQuestionTypeResolver;

    @Test
    void should_work() {
        QuestionType jbaruch = textBasedQuestionTypeResolver.resolveType(Question.builder().body("омск").build());
        QuestionType joker   = textBasedQuestionTypeResolver.resolveType(Question.builder().body("confuses").build());

        assertAll(
                () -> assertEquals(QuestionType.JOKER, joker),
                () -> assertEquals(QuestionType.JBARUCH, jbaruch)
        );

    }
}
