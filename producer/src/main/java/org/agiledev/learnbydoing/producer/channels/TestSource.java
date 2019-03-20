package org.agiledev.learnbydoing.producer.channels;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface TestSource {
  String OUTPUT = "output1";

  @Output(TestSource.OUTPUT)
  MessageChannel output();
}
