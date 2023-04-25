package com.tianjiaxu.repository.impl;

import com.tianjiaxu.entity.Student;
import com.tianjiaxu.repository.StudentRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class StudentRepositoryImpl implements StudentRepository {

    private static Map<Long,Student> studentMap;

    static {
        studentMap = new HashMap<>();
        studentMap.put(1L,new Student(1L,"zhangsan",23));
        studentMap.put(2L,new Student(2L,"lisi",24));
        studentMap.put(3L,new Student(3L,"wangwu",25));
    }
    @Override
    public Collection<Student> findAll() {
        return studentMap.values();
    }

    @Override
    public Student findById(long id) {
        return studentMap.get(id);
    }

    @Override
    public void saveOrUpdate(Student student) {
        studentMap.put(student.getId(),student);
    }

    @Override
    public void deleteById(long id) {
        studentMap.remove(id);
    }
}
