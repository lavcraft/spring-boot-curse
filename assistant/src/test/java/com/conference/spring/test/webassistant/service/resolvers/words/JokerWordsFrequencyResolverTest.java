package com.conference.spring.test.webassistant.service.resolvers.words;

import com.conference.spring.test.webassistant.domain.Question;
import com.conference.spring.test.webassistant.service.resolvers.CommonConfig;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@ContextHierarchy({
        @ContextConfiguration(classes = CommonConfig.class),
        @ContextConfiguration(classes = JokerWordsFrequencyResolverTestConfiguration.class)
})
@ActiveProfiles("joker_vs_jbaruch")
class JokerWordsFrequencyResolverTest {

    @Autowired JokerWordsFrequencyResolver jokerWordsFrequencyResolver;

    @Test
    void should_work() {
        jokerWordsFrequencyResolver.setAnswers("улыбка");
        int улыбок = jokerWordsFrequencyResolver.match(Question.builder().body("улыбка").build());

        assertEquals(1, улыбок);
    }
}
