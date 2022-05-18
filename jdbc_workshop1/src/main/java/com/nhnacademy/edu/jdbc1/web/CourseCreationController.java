package com.nhnacademy.edu.jdbc1.web;

import com.nhnacademy.edu.jdbc1.service.course.CourseCreationService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CourseCreationController {
    private final CourseCreationService courseCreationService;

    public CourseCreationController(CourseCreationService courseCreationService) {
        this.courseCreationService = courseCreationService;
    }

    @GetMapping("/")
    public String root() {
        return "index";
    }
}
