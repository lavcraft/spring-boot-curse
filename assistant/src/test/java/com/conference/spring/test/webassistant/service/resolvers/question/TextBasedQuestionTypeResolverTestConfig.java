package com.conference.spring.test.webassistant.service.resolvers.question;

import com.conference.spring.test.webassistant.service.resolvers.CommonConfig;
import com.conference.spring.test.webassistant.service.resolvers.words.WordsFrequencyResolver;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import java.util.List;

@TestConfiguration
public class TextBasedQuestionTypeResolverTestConfig {

    @Bean
    public TextBasedQuestionTypeResolver textBasedQuestionTypeResolver(List<WordsFrequencyResolver> resolvers) {
        return new TextBasedQuestionTypeResolver(resolvers);
    }

}
