package com.example.elijah.echo;

import com.example.elijah.data.entity.Student;
import java.util.Collection;
import java.util.List;

public interface EchoService {

  List<String> execute(String word, String... otherWords);

  List<Student> execute(Collection<Student> students);
}
