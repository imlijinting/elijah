package com.example.elijah.web;

import com.example.elijah.EchoService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
  public List<String> echo(String word1, String word2) {
    log.info("1 Web Layer {}, {}", word1, word2);
    return echoService.execute(word1, word2);
  }
}
