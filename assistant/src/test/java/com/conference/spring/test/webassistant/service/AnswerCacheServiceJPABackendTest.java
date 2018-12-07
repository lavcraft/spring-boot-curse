package com.conference.spring.test.webassistant.service;

import com.conference.spring.test.webassistant.domain.Answer;
import com.conference.spring.test.webassistant.domain.Question;
import com.conference.spring.test.webassistant.persistence.AnswersRepository;
import com.conference.spring.test.webassistant.persistence.QuestionRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@SpringJUnitConfig
@SpringBootTest
class AnswerCacheServiceJPABackendTest {
    @MockBean  QuestionRepository           questionRepository;
    @MockBean  AnswersRepository            answersRepository;
    @Autowired AnswerCacheServiceJPABackend answerCacheServiceJPABackend;

    @Test
    void should_work() {
        when(questionRepository.findFirstByText(anyString()))
                .thenThrow(new RuntimeException());

        Answer answer = answerCacheServiceJPABackend.find(Question.builder().build());

        assertNull(answer);

    }
}
