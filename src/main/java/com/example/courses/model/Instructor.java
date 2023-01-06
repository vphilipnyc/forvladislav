package com.example.courses.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@ToString
@Builder
public class Instructor {

    @Id
    private Long id;

    private String firstName;

    private String lastName;
}
