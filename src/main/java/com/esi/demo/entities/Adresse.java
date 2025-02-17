package com.esi.demo.entities;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Adresse {
    private String rue;
    private int number;
    private String postalCode;
    private String ville;
}
