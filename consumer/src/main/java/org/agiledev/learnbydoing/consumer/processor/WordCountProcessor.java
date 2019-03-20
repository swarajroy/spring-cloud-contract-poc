package org.agiledev.learnbydoing.consumer.processor;

import java.util.Arrays;
import org.agiledev.learnbydoing.consumer.channels.TestSink;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.KTable;
import org.apache.kafka.streams.kstream.Materialized;
import org.apache.kafka.streams.kstream.Serialized;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

@Component
public class WordCountProcessor {

  @StreamListener
  public void process(@Input(TestSink.INPUT) KStream<Object, String> input) {

    KTable<String, Long> count =
        input.flatMapValues(value -> Arrays.asList(value.toLowerCase().split("\\W+"))).map((key, value) -> new KeyValue<>(value, value)).groupByKey(Serialized.with(Serdes.String(), Serdes.String()))
            .count(Materialized.as(TestSink.WORD_COUNTS_1));
  }
}
