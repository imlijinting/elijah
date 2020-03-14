package com.example.elijah.school;

import com.example.elijah.HasIdentity;
import java.io.Serializable;
import java.time.LocalDate;
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
public class Student implements Serializable, HasIdentity {

  private static final long serialVersionUID = 4320156439776235149L;

  private String id;

  private String name;

  private LocalDate birthday;
}
