package com.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demo.model.Student;

@Controller
@RequestMapping("/hello")
public class HelloController {

    @RequestMapping(method = RequestMethod.GET)
    public String printHello(ModelMap model) {
        model.addAttribute("message", "Hello Spring MVC framework!");
        return "hello";
    }
    
    @RequestMapping(value = "/sub", method = RequestMethod.GET)
    @ResponseBody
    public String printSubHello() {
        return "hello from sub";
    }
    
    @RequestMapping(value = "/params", method = RequestMethod.GET)
    @ResponseBody
    public String printParams(String name, int age) {
        return "Params: name=" + name + ", age=" + age;
    }
    
    @RequestMapping(value = "/student", method = RequestMethod.GET)
    @ResponseBody
    public String printStudent(Student student) {
        return "Student: id=" + student.getId() + ", name="
                + student.getName() + ", age=" + student.getAge();
    }
}
