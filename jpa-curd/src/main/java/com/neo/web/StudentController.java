package com.neo.web;

import com.neo.entity.Student;
import com.neo.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;


@RequestMapping("/student")
@Controller
public class StudentController {


    @Resource
    StudentService studentService;


    @RequestMapping("/")
    public String index() {
        return "redirect:/student/list";
    }

    @RequestMapping("/list")
    public String list(Model model) {
        // 根据id排序
        List<Student> students = studentService.getStudentList();
        model.addAttribute("students", students);
        return "student/list";
    }

    @RequestMapping("/toAdd")
    public String toAdd(){
        return "student/studentAdd";
    }

    @RequestMapping("/add")
    public String add(Student student){
        studentService.save(student);
        return "redirect:/student/list";
    }

    @RequestMapping("/toEdit")
    public String toEdit(Model model, long id){
        Student student = studentService.findStudentById(id);
        model.addAttribute("student",student);
        return "student/studentEdit";
    }

    // 召唤师 等一下我想问你 你后悔吗?
    @RequestMapping("/edit")
    public String edit(Student student){
        studentService.edit(student);
        return "redirect:/student/list";
    }

    @RequestMapping("/delete")
    public String delete(long id){
        studentService.delete(id);
        return "redirect:/student/list";
    }

    @RequestMapping("/findStudentByName")
    public String findStudentByName(Model model, String name){

        //
        if ("".equals(name)){
            return "redirect:/student/list";
        }
        Student student = studentService.findStudentByName(name);
        model.addAttribute("students", student);
        return "student/list";
    }
}

