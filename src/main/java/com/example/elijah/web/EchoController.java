package com.example.elijah.web;

import com.example.elijah.data.entity.Student;
import com.example.elijah.echo.EchoService;
import java.util.Collection;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/echo")
public class EchoController {

  private EchoService echoService;

  public EchoController(EchoService echoService) {
    this.echoService = echoService;
  }

  @GetMapping
  public List<String> echo(@RequestParam String word1, @RequestParam String word2) {
    log.info("1 Echo Web Layer {}, {}", word1, word2);
    return echoService.execute(word1, word2);
  }

  @PostMapping
  public List<Student> echo(@RequestBody Collection<Student> students) {
    log.info("3 Student Web Layer {}", students);
    return echoService.execute(students);
  }
}
