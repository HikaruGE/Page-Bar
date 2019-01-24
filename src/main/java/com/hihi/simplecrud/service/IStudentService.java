package com.hihi.simplecrud.service;

import com.hihi.simplecrud.entity.Student;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IStudentService {
    List<Student> findAll(); //R
    void save(Student student); //C,U
    void deleteById(Long id); //D
    Student findStudentById(Long id); //R

    Page<Student> findStudentPages(Integer page,Integer size);
}
