package com.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.demo.exception.SpringException;
import com.demo.model.Student;
import com.demo.validator.StudentValidator;

@Controller
public class StudentController {
    
    @InitBinder
    public void initBinder(DataBinder binder) {
        binder.setValidator(new StudentValidator());
    }
    
    @RequestMapping(value = "/student", method = RequestMethod.GET)
    public ModelAndView student() {
        return new ModelAndView("student", "command", new Student());
    }
    
    @RequestMapping(value = "/addStudent", method = RequestMethod.POST)
    @ExceptionHandler({SpringException.class})
    public String addStudent(@ModelAttribute @Validated Student student, BindingResult result, ModelMap modelMap) {
        if (result.hasErrors()) {
            return "error";
        }
        
        modelMap.put("id", student.getId());
        modelMap.put("name", student.getName());
        
        if (student.getAge() < 0) {
            throw new RuntimeException("Given age less than 0");
        }
        
        if (student.getAge() < 10) {
            throw new SpringException("Given age(" + student.getAge() + ") is too low");
        } else {
            modelMap.put("age", student.getAge());
        }
        
        return "result";
    }
}
