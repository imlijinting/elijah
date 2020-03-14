package com.example.elijah.school;

import static com.example.elijah.config.RedisCacheConfig.CACHE_KEY_PATTERN;

import com.example.elijah.data.dao.StudentDao;
import com.example.elijah.data.entity.StudentEntity;
import com.example.elijah.data.id.IdSupplier;
import java.util.List;
import java.util.stream.Collectors;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class SchoolServiceImpl implements QueryService, StudentService {

  @Setter(onMethod_ = @Autowired)
  private StudentDao studentDao;

  @Setter(onMethod_ = @Autowired)
  private IdSupplier idSupplier;

  @Override
  @Cacheable(cacheNames = "student", key = CACHE_KEY_PATTERN)
  public List<Student> findStudents(Integer page, Integer size) {
    return studentDao.findAll(PageRequest.of(page, size)).getContent()
        .stream()
        .map(StudentEntity::getStudent)
        .collect(Collectors.toList());
  }

  @Override
  public Student addStudent(Student student) {
    student.setId(idSupplier.get());
    return studentDao.save(new StudentEntity(student)).getStudent();
  }
}
