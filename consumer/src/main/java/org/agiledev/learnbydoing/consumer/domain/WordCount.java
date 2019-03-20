package org.agiledev.learnbydoing.consumer.domain;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WordCount {
  private String word;

  private long count;

  private Date start;

  private Date end;
}
