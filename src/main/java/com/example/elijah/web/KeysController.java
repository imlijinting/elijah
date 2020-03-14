package com.example.elijah.web;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/keys")
public class KeysController {

  @Setter(onMethod_ = @Autowired)
  private StringRedisTemplate redisTemplate;

  @Setter(onMethod_ = @Autowired)
  private CacheManager cacheManager;

  @GetMapping
  public Set<String> queryAllKeys() {
    return redisTemplate.keys("*");
  }

  @PostMapping
  public List<String> clearCaches(@RequestBody List<String> cacheNames) {
    cacheNames.forEach(name ->
        Optional.ofNullable(cacheManager.getCache(name))
            .ifPresent(Cache::clear));
    return cacheNames;
  }
}
