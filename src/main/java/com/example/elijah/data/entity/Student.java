package com.example.elijah.data.entity;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "student")
public class Student implements Serializable, HasIdentity {

  private static final long serialVersionUID = 8760101455867283080L;

  @Id
  @Column(name = "studentid", updatable = false)
  private String id;

  @NotNull
  @Column(name = "studentname")
  private String name;

  @NotNull
  @Column(name = "birthday")
  private LocalDate birthday;
}
