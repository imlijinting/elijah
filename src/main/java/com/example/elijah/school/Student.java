package com.example.elijah.school;

import com.example.elijah.HasIdentity;
import java.io.Serializable;
import java.time.LocalDate;
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
public class Student implements Serializable, HasIdentity {

  private static final long serialVersionUID = 8760101455867283080L;

  private String id;

  @NotNull

  private String name;

  @NotNull
  private LocalDate birthday;
}
