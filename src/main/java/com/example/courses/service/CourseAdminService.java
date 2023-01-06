package com.example.courses.service;

import com.example.courses.model.Course;
import com.example.courses.model.Instructor;
import com.example.courses.model.Student;
import com.example.courses.repository.CourseRepository;
import com.example.courses.repository.InstructorRepository;
import com.example.courses.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class CourseAdminService {

    private final CourseRepository courseRepository;
    private final InstructorRepository instructorRepository;
    private final StudentRepository studentRepository;

    public CourseAdminService(CourseRepository courseRepository, InstructorRepository instructorRepository, StudentRepository studentRepository) {
        this.courseRepository = courseRepository;
        this.instructorRepository = instructorRepository;
        this.studentRepository = studentRepository;
    }

    public Optional<Course> findCourseById(Long id) {
        return courseRepository.findById(id);
    }

    public List<Course> findAllCourses() {
        return courseRepository.findAll();
    }

    public void addCourse(Course course) {
        courseRepository.save(course);
    }

    public void addStudents(Set<Student> students) {
        studentRepository.saveAll(students);
    }

    public void addInstructor(Instructor instructor) {
        instructorRepository.save(instructor);
    }

}

