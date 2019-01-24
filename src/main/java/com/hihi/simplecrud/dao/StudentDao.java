package com.hihi.simplecrud.dao;

import com.hihi.simplecrud.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentDao extends JpaRepository<Student,Long>, JpaSpecificationExecutor<Student> {
    Student findStudentById(Long id);
    List<Student> findAll();
}
