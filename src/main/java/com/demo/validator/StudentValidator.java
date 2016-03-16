package com.demo.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.demo.model.Student;

public class StudentValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Student.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Student student = (Student) target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "", "Name is empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "age", "", "Age is empty");
        final int MIN_NAME_LENGTH = 3;
        if (student.getName().length() < MIN_NAME_LENGTH) {
            errors.rejectValue("name", "", "Name length is less than " + MIN_NAME_LENGTH);
        }
    }

}
