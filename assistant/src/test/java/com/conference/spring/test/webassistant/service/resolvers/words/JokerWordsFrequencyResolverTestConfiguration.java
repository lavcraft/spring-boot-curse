package com.conference.spring.test.webassistant.service.resolvers.words;

import com.conference.spring.test.common.utils.WordsComposer;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

@TestConfiguration
public class JokerWordsFrequencyResolverTestConfiguration {

    @Bean
    public JokerWordsFrequencyResolver jokerWordsFrequencyResolver(WordsComposer wordsComposer) {
        return new JokerWordsFrequencyResolver(wordsComposer);
    }
}
