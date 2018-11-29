package com.conference.spring.test.jbaruch;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author tolkv
 * @version 25/03/2017
 */
@AllArgsConstructor
@Getter
public enum QuestionType {
  YEGOR256(false), JBARUCH(true), OTHER(true);

  private final boolean cacheable;
}
