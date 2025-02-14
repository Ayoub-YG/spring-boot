package com.esi.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.esi.demo.entities.student;
import com.esi.demo.repositories.studentInterface;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class studentservice {

    @Autowired
    studentInterface studentrepository;

    public studentservice(studentInterface studentrepository) {
        this.studentrepository = studentrepository;
    }

    public List<student> getStudent() {
        return studentrepository.findAll();  // ✅ Correct return type
    }
    public student getStudentID(@PathVariable("id") Long id) {
        return studentrepository.findById(id).get();
    }
}
