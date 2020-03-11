package com.example.elijah;

import java.util.List;

public interface EchoService {

  List<String> execute(String word, String... otherWords);
}
