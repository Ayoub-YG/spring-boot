package com.esi.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class formation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idFormation;

    @Column(nullable = false)
    private String nomFormation;


    @ToString.Exclude
    @JsonIgnore
    @OneToMany(mappedBy = "formation", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<student> listStudent;

}
