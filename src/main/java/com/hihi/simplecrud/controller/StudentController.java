package com.hihi.simplecrud.controller;

import com.hihi.simplecrud.entity.Student;
import com.hihi.simplecrud.service.IStudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;


@Controller
public class StudentController {

    @Autowired
    IStudentService studentService;

    //all students
    @GetMapping("/students")
    public String list(Model model){
        model.addAttribute("students",studentService.findAll());
        return "/student/list";
    }

    //to add page
    @GetMapping("/student")
    public String toAddPage(){
        return "/student/add";
    }

    //add
    @PostMapping("/student")
    public String add(Student student){
        studentService.save(student);
        return "redirect:/students";
    }

    //to edit page
    @GetMapping("/student/{id}")
    public String toEditPage(Model model, @PathVariable("id") Long id){
        model.addAttribute("student",studentService.findStudentById(id));
        return "/student/add";
    }

    //edit
    @PutMapping("/student")
    public String edit(Student student){
        studentService.save(student);
        return "redirect:/students";
    }

    //delete
    @DeleteMapping("/student/{id}")
    public String delete(@PathVariable("id") Long id){
        studentService.deleteById(id);
        return "redirect:/students";
    }


    @RequestMapping("/studentPage")
    public String findBookNoQuery(ModelMap modelMap, @RequestParam(value = "page", defaultValue = "0") Integer page,
                                  @RequestParam(value = "size", defaultValue = "10") Integer size){
        Page<Student> datas = studentService.findStudentPages(page, size);
        modelMap.addAttribute("students", datas);
        return "index1";
    }
}
