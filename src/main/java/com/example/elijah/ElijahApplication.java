package com.example.elijah;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class ElijahApplication {

  public static void main(String[] args) {
    SpringApplication.run(ElijahApplication.class, args);
  }

}
