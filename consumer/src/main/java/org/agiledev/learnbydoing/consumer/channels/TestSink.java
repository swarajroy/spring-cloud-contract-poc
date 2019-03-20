package org.agiledev.learnbydoing.consumer.channels;

import org.apache.kafka.streams.kstream.KStream;
import org.springframework.cloud.stream.annotation.Input;

public interface TestSink {
  String INPUT = "input1";
  String WORD_COUNTS_1 = "WordCounts-1";

  @Input(INPUT)
  KStream<?, String> input1();
}
