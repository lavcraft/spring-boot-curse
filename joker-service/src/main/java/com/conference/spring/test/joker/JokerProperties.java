package com.conference.spring.test.joker;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

/**
 * @author tolkv
 * @version 26/03/2017
 */
@Data
@NoArgsConstructor
@ConfigurationProperties(prefix = "joker")
public class JokerProperties {
  List<String> answers;
}
