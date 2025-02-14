package com.esi.demo.repositories;

import com.esi.demo.entities.teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface teacherInterface extends JpaRepository<teacher,Long> {
}
