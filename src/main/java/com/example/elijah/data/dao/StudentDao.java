package com.example.elijah.data.dao;

import com.example.elijah.data.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentDao extends JpaRepository<StudentEntity, String> {

}
