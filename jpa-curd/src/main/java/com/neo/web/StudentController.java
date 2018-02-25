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
        return "redirect:/list";
    }

    @RequestMapping("/list")
    public String list(Model model) {
        List<Student> students = studentService.getStudentList();
        model.addAttribute("students", students);
        int[] arr = {1, 2, 3, 4, 5};
        int len = arr.length;
        for (int i = 0; i < len; i++){
            System.out.println(arr[i]);
        }
        return "student/list";
    }
}
