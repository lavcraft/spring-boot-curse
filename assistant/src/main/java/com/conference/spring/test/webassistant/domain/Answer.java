package com.conference.spring.test.webassistant.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author tolkv
 * @version 23/02/2017
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Answer {
  private long id;
  private String operatorId;
  private String answer;
  private String answerDate;

  private Long questionId;
}
