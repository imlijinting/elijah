package com.example.elijah.web;

import com.example.elijah.data.entity.Student;
import com.example.elijah.school.QueryService;
import com.example.elijah.school.StudentService;
import java.util.List;
import javax.validation.Valid;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/student")
public class StudentController {

  @Setter(onMethod_ = @Autowired)
  private QueryService queryService;

  @Setter(onMethod_ = @Autowired)
  private StudentService studentService;

  @GetMapping
  public List<Student> listAll(@RequestParam Integer page, @RequestParam Integer size) {
    return queryService.findStudents(page, size);
  }

  @PostMapping
  public Student addOne(@Valid @RequestBody Student student) {
    return studentService.addStudent(student);
  }
}
