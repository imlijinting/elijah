package com.example.elijah.school;

import com.example.elijah.data.entity.Student;
import java.util.List;

public interface QueryService {

  List<Student> findStudents(Integer page, Integer size);
}
