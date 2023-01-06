package com.example.courses.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@Builder
public class Course {
    @Id
    private Long id;

    private String name;

    private String description;

    private String duration;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "instructor_id", referencedColumnName = "id", nullable = false)
    private Instructor instructor;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable (name = "enrolled_in",
            joinColumns = {@JoinColumn (name = "course_id")},
            inverseJoinColumns = {@JoinColumn (name = "student_id")})
    private Set<Student> enrolledStudents = new HashSet<>();

}
