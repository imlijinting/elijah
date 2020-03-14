package com.example.elijah.school;

import java.util.List;

public interface QueryService {

  List<Student> findStudents(Integer page, Integer size);
}
