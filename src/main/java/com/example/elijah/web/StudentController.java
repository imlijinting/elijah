package com.example.elijah.web;

import com.example.elijah.school.QueryService;
import com.example.elijah.school.Student;
import com.example.elijah.school.StudentService;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
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
  public List<StudentDto> listAll(@RequestParam Integer page, @RequestParam Integer size) {
    return queryService.findStudents(page, size)
        .stream()
        .map(StudentDto::new)
        .collect(Collectors.toList());
  }

  @PostMapping
  public StudentDto addOne(@Valid @RequestBody StudentDto student) {
    return new StudentDto(studentService.addStudent(student.getStudent()));
  }
}

@JsonIgnoreProperties({"student"})
@JsonPropertyOrder({"id", "name", "birthday"})
class StudentDto {

  private Student student;

  public StudentDto() {
    this.student = new Student();
  }

  public StudentDto(Student student) {
    this.student = student;
  }

  public Student getStudent() {
    return student;
  }

  public String getId() {
    return student.getId();
  }

  public String getName() {
    return student.getName();
  }

  public LocalDate getBirthday() {
    return student.getBirthday();
  }

  public void setId(String id) {
    student.setId(id);
  }

  public void setName(String name) {
    student.setName(name);
  }

  public void setBirthday(LocalDate birthday) {
    student.setBirthday(birthday);
  }
}
