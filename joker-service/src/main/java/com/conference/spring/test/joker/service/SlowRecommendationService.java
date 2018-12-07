package com.conference.spring.test.joker.service;

import com.conference.spring.test.common.utils.AnswerComposer;
import com.conference.spring.test.joker.JokerProperties;
import com.conference.spring.test.joker.client.Answer;
import com.conference.spring.test.joker.client.AssistantClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicLong;

import static com.conference.spring.test.common.utils.IconConstants.JOKER_ICON;

/**
 * @author tolkv
 * @version 19/03/2017
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class SlowRecommendationService {
  private final AssistantClient         assistantClient;
  private final JokerProperties         jokerProperties;
  private final AnswerComposer          answerComposer;
  private       BlockingQueue<Question> questionsQueue = new ArrayBlockingQueue<>(10);
  private       AtomicLong              atomicLong = new AtomicLong();

  @Scheduled(cron = "*/2 * * * * ?")
  public void scheduler() {
    try {
      Question poll = questionsQueue.poll();

      if (poll != null) {
        log.info("Question: {}", poll.getBody());
        log.info("Joker thinking...");
        log.info("Joker answering... {}");

        String answerText = answerComposer.giveAnswerText(jokerProperties.getAnswers(), poll.getBody());

        Answer answer = Answer.builder()
            .id(String.valueOf(atomicLong.incrementAndGet()))
            .questionId(poll.getId())
            .operatorId(JOKER_ICON)
            .answer(answerText)
            .build();

        assistantClient.answer(answer);
      } else {
        log.info("Joker waiting...");
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  // TODO сделать веселый список ответов Егора
  private String generateAnswer() {
    return " – yes";
  }

  public void addQuestion(Question question) {
    log.info("Add question to joker queue and wait...");
    questionsQueue.add(question);
  }
}
