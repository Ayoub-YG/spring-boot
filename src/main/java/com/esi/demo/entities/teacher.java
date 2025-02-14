package com.esi.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.esi.demo.entities.Grade;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data

public class teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTeacher;
    @Column(nullable = false)
    private String firstName;
    @Enumerated(EnumType.STRING)
    private Grade grade;
    @ToString.Exclude
    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "teacherstudent", // Name of the join table
            joinColumns = @JoinColumn(name = "idTeacher"),
            inverseJoinColumns = @JoinColumn(name = "idStudent")
    )
    private List<student> students;
}
