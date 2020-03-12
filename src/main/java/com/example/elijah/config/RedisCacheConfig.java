package com.example.elijah.config;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.boot.autoconfigure.cache.CacheProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

@Configuration
@EnableConfigurationProperties({CustomCacheProperties.class, CacheProperties.class})
public class RedisCacheConfig {

  private static final ObjectMapper MAPPER = Jackson2ObjectMapperBuilder.json().build();

  public static final String CACHE_KEY_PATTERN
      = "#root.targetClass.name"
      + " + '::'"
      + " + #root.methodName"
      + " + '::'"
      + " + T(String).join(':::', T(com.example.elijah.config.RedisCacheConfig).serializeArgs(#root.args))";

  public static Collection<String> serializeArgs(Object[] args) {
    if (ArrayUtils.isEmpty(args)) {
      return Collections.emptyList();
    }

    return Stream.of(args).map(value -> {
      try {
        return MAPPER.writeValueAsString(value);
      } catch (JsonProcessingException e) {
        throw new RedisCacheException(e);
      }
    }).collect(Collectors.toList());
  }

  @Bean
  RedisCacheConfiguration defaultCacheConfig(CacheProperties cacheProperties) {
    return RedisCacheConfiguration.defaultCacheConfig()
        .prefixKeysWith(cacheProperties.getRedis().getKeyPrefix());
  }

  @Bean
  RedisCacheManager redisCacheManager(
      RedisConnectionFactory factory,
      CacheProperties cacheProperties,
      CustomCacheProperties customCacheProperties) {

    Map<String, RedisCacheConfiguration> configMap = new HashMap<>();
    customCacheProperties.getTtl().forEach((cacheName, ttl) ->
        configMap.put(cacheName, defaultCacheConfig(cacheProperties).entryTtl(ttl)));

    return RedisCacheManager.builder(factory)
        .cacheDefaults(defaultCacheConfig(cacheProperties)
            .entryTtl(cacheProperties.getRedis().getTimeToLive()))
        .withInitialCacheConfigurations(configMap)
        .build();
  }
}
