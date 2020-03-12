package com.example.elijah.config;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.assertj.core.api.Assertions.assertThat;

import com.example.elijah.data.entity.Student;
import java.time.LocalDate;
import org.junit.Test;


public class RedisCacheConfigTest {

  @Test
  public void serializeArgs() {

    Student student = new Student(randomAlphabetic(5), LocalDate.now());
    String school = randomAlphabetic(10);

    assertThat(RedisCacheConfig.serializeArgs(new Object[]{school, student}))
        .isNotEmpty()
        .hasSize(2);
  }
}
