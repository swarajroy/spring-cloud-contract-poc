package org.agiledev.learnbydoing.producer.config;

import java.util.Random;
import org.agiledev.learnbydoing.producer.channels.TestSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.core.MessageSource;
import org.springframework.messaging.support.GenericMessage;

@Configuration
public class ProducerConfig {
  private String[] randomWords = new String[]{"foo", "bar", "foobar", "baz", "fox"};
  private Random random = new Random();

  @Bean
  @InboundChannelAdapter(channel = TestSource.OUTPUT, poller = @Poller(fixedDelay = "1000"))
  public MessageSource<String> sendTestData() {
    return () -> {
      int idx = random.nextInt(5);
      return new GenericMessage<>(randomWords[idx]);
    };
  }

}
