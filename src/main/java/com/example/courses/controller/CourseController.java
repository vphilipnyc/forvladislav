package com.example.courses.controller;

import com.example.courses.model.Course;
import com.example.courses.service.CourseService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/{courseId}")
    public String findCourse(@PathVariable Long courseId, Model model) {

        Optional<Course> optional = courseService.findById(courseId);
        optional.ifPresent(course -> model.addAttribute("courses", course));
        return "courses";
    }

    @GetMapping("/")
    public String findAllCourses(Model model) {

        List<Course> all = courseService.findAll();
        model.addAttribute("courses", all);
        return "courses";
    }

}