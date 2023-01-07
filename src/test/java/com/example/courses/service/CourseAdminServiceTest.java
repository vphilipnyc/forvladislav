package com.example.courses.service;

import com.example.courses.model.Course;
import com.example.courses.model.Instructor;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CourseAdminServiceTest {

    @Test
    public void testAddCourse() {
        List<Course> list = new ArrayList<>();
        Instructor instructor = new Instructor(1L, "Jane","Doe");
        Course c = Course.builder()
                .name("Intro to Computer Science")
                .instructor(instructor)
                .build();
        list.add(c);
        assertEquals(1, list.size());
        assertEquals(c, list.get(0));
    }
}