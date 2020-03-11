package com.example.elijah;

import static com.example.elijah.config.RedisCacheConfig.CACHE_KEY_PATTERN;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class EchoServiceImpl implements EchoService {

  @Override
  @Cacheable(cacheNames = "echo", key = CACHE_KEY_PATTERN)
  public List<String> execute(String word, String... otherWords) {

    log.info("2 Service Layer {}, {}", word, otherWords);

    List<String> list = new ArrayList<>();
    list.add(word);
    Collections.addAll(list, otherWords);
    return list;
  }
}
