package com.example.elijah;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;

import com.example.elijah.data.entity.Student;
import com.example.elijah.data.id.IdSupplier;
import com.example.elijah.school.StudentService;
import java.time.LocalDate;
import java.util.stream.IntStream;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;

@Slf4j
@EnableCaching
@SpringBootApplication
public class ElijahApplication {

  public static void main(String[] args) {
    SpringApplication.run(ElijahApplication.class, args);
  }

  @Bean
  CommandLineRunner initialize(IdSupplier idSupplier, StudentService studentService) {
    return args ->
        IntStream.range(0, 1000).parallel()
            .forEach(
                i -> studentService.addStudent(
                    new Student(idSupplier.get(), randomAlphabetic(10, 50), LocalDate.now())));
  }
}
