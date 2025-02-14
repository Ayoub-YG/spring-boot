package com.esi.demo.repositories;

import com.esi.demo.entities.student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.Optional;

@RepositoryRestResource
public interface studentInterface extends JpaRepository<student, Long> {

    // Search students whose first name starts with a given prefix
  //  List<student> findByFirstNameStartingWith(String name);

    // Fix: Correct @Query syntax and parameterized query
   // @Query("SELECT e FROM student e WHERE e.idStudent = :idStudent")
   // Optional<student> findByIdStudent(@Param("idStudent") Long idStudent);
}
