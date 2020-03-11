package com.example.elijah.config;

import java.time.Duration;
import java.util.Map;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ToString
@ConfigurationProperties(prefix = "spring.cache.redis.custom")
public class CustomCacheProperties {

  private Map<String, Duration> ttl;
}
