package com.example.elijah.config;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;


public class RedisCacheConfigTest {

  @Test
  public void serializeArgs() {

    String school = randomAlphabetic(10);

    assertThat(RedisCacheConfig.serializeArgs(new Object[]{school, school}))
        .isNotEmpty()
        .hasSize(2);
  }
}
