package com.esi.demo.repositories;

import com.esi.demo.entities.formation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface formationInterface extends JpaRepository<formation, Integer> {
}
