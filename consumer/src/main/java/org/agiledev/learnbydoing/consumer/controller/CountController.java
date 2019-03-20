package org.agiledev.learnbydoing.consumer.controller;

import static org.agiledev.learnbydoing.consumer.channels.TestSink.WORD_COUNTS_1;

import com.google.common.collect.Maps;
import java.util.Map;
import lombok.AllArgsConstructor;
import org.apache.kafka.streams.state.QueryableStoreTypes;
import org.apache.kafka.streams.state.ReadOnlyKeyValueStore;
import org.springframework.cloud.stream.binder.kafka.streams.InteractiveQueryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class CountController {
  private final InteractiveQueryService queryService;
  private final Map<String, Long> map = Maps.newConcurrentMap();

  @GetMapping("/counts")
  public Map<String, Long> getWordCounts() {
    final ReadOnlyKeyValueStore<Object, Object> store = queryService.getQueryableStore(WORD_COUNTS_1, QueryableStoreTypes.keyValueStore());

    store.all().forEachRemaining(record -> map.put((String)record.key, (Long)record.value));

    return map;

  }
}
