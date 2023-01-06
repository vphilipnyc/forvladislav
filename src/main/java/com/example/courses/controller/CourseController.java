package com.example.courses.controller;

import com.example.courses.model.Course;
import com.example.courses.model.Instructor;
import com.example.courses.model.Student;
import com.example.courses.service.CourseAdminService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Controller
@RequestMapping("/")
public class CourseController {

    private final CourseAdminService courseAdminService;

    public CourseController(CourseAdminService courseAdminService) {
        this.courseAdminService = courseAdminService;
    }

    @GetMapping("/{courseId}")
    public String findCourse(@PathVariable Long courseId, Model model) {

        Optional<Course> optional = courseAdminService.findCourseById(courseId);
        optional.ifPresent(course -> model.addAttribute("courses", course));
        return "courses";
    }

    @GetMapping("/")
    public String findAllCourses(Model model) {

        addTestCourses();

        List<Course> all = courseAdminService.findAllCourses();
        model.addAttribute("courses", all);
        return "courses";
    }

    /*
     * In reality, you could create logic to have an admin add courses.  We are just adding some dummy data here.
     */
    public void addTestCourses() {

        Student maria = Student.builder()
                .id(1L)
                .name("Maria Fernandez")
                .build();

        Student raj = Student.builder()
                .id(2L)
                .name("Raj Singh")
                .build();

        Student john = Student.builder()
                .id(3L)
                .name("John O'Brien")
                .build();

        courseAdminService.addStudents(Set.of(maria, raj, john));

        Instructor vlad = Instructor.builder()
                .id(1L)
                .firstName("Vlad")
                .lastName("Peskov")
                .build();

        courseAdminService.addInstructor(vlad);

        Course cookingCourse = Course.builder()
                .id(1L)
                .name("How to Create an International Meal")
                .instructor(vlad)
                .enrolledStudents(Set.of(maria, raj))
                .build();

        courseAdminService.addCourse(cookingCourse);

        Course drinkingCourse = Course.builder()
                .id(2L)
                .name("Mixology 101")
                .instructor(vlad)
                .enrolledStudents(Set.of(raj, john))
                .build();

        courseAdminService.addCourse(drinkingCourse);
    }

}