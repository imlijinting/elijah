package com.example.elijah.web;

import java.util.Set;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/keys")
public class KeysController {

  private StringRedisTemplate redisTemplate;

  public KeysController(StringRedisTemplate redisTemplate) {
    this.redisTemplate = redisTemplate;
  }

  @GetMapping
  public Set<String> queryAllKeys() {
    return redisTemplate.keys("*");
  }
}
