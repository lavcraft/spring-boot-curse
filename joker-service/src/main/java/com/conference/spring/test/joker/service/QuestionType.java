package com.conference.spring.test.joker.service;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @author tolkv
 * @version 25/03/2017
 */
@RequiredArgsConstructor
@Getter
public enum QuestionType {
  JOKER(false), JBARUCH(true), OTHER(true);

  private final boolean cacheable;
}
