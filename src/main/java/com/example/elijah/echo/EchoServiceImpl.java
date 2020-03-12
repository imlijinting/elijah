package com.example.elijah.echo;

import static com.example.elijah.config.RedisCacheConfig.CACHE_KEY_PATTERN;

import com.example.elijah.data.entity.Student;
import java.util.ArrayList;
import java.util.Collection;
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

    log.info("2 Echo Service Layer : {}, {}", word, otherWords);

    List<String> list = new ArrayList<>();
    list.add(word);
    Collections.addAll(list, otherWords);
    return list;
  }

  @Override
  @Cacheable(cacheNames = "student", key = CACHE_KEY_PATTERN)
  public List<Student> execute(Collection<Student> students) {
    log.info("4 Students Service Layer : {}", students);
    return new ArrayList<>(students);
  }
}
