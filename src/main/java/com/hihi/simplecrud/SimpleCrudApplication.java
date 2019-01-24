package com.hihi.simplecrud;

import com.hihi.simplecrud.dao.StudentDao;
import com.hihi.simplecrud.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SimpleCrudApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SimpleCrudApplication.class, args);
    }

    @Autowired
    StudentDao studentDao;

    @Override
    public void run(String... args) throws Exception {
        for(int i = 0;i<100;i++){
        Student student1 = new Student();
        student1.setName("aaa");
        student1.setPhone("8765432");
        studentDao.save(student1);
        Student student2 = new Student();
        student2.setName("bbb");
        student2.setPhone("3251134");
        studentDao.save(student2);
        Student student3 = new Student();
        student3.setName("ccc");
        student3.setPhone("4625135");
        studentDao.save(student3);
        Student student4 = new Student();
        student4.setName("ddd");
        student4.setPhone("4362562");
        studentDao.save(student4);
        Student student5 = new Student();
        student5.setName("eee");
        student5.setPhone("6474536");
        studentDao.save(student5);}
    }
}

