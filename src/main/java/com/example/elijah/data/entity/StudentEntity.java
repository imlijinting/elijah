package com.example.elijah.data.entity;


import com.example.elijah.school.Student;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "student")
public class StudentEntity {

  private Student student;

  public StudentEntity() {
    this.student = new Student();
  }

  public StudentEntity(Student student) {
    setStudent(student);
  }

  @Transient
  public Student getStudent() {
    return student;
  }

  @Id
  @Column(name = "studentid", updatable = false)
  public String getId() {
    return student.getId();
  }

  @Column(name = "studentname")
  public String getName() {
    return student.getName();
  }

  @Column(name = "birthday")
  public LocalDate getBirthday() {
    return student.getBirthday();
  }


  private void setStudent(Student student) {
    this.student = student;
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
