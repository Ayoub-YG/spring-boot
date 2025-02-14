package com.esi.demo.entities.projection;

import com.esi.demo.entities.student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "pri",types = {student.class})
public interface studentProjection {

    @Value("#{target.firstName}")
    String getName();
    @Value("#{target.formation.nomFormation}")
    public String getFormation();

}
