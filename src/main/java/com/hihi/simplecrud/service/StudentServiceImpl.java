package com.hihi.simplecrud.service;

import com.hihi.simplecrud.dao.StudentDao;
import com.hihi.simplecrud.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements IStudentService {

    @Autowired
    StudentDao studentDao;

    @Override
    public List<Student> findAll() {
        return studentDao.findAll();
    }

    @Override
    public void save(Student student) {
        studentDao.save(student);
    }

    @Override
    public void deleteById(Long id) {
        studentDao.deleteById(id);
    }

    @Override
    public Student findStudentById(Long id) {
        return studentDao.findStudentById(id);
    }

    @Override
    public Page<Student> findStudentPages(Integer page, Integer size) {
        Pageable pageable = new PageRequest(page, size, Sort.Direction.ASC, "id");
        return studentDao.findAll(pageable);
    }
}
