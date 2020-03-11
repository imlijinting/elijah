package com.example.elijah.echo;

import java.util.List;

public interface EchoService {

  List<String> execute(String word, String... otherWords);
}
