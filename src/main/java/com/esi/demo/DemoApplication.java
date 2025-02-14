package com.esi.demo;

import com.esi.demo.entities.Grade;
import com.esi.demo.entities.formation;
import com.esi.demo.entities.student;
import com.esi.demo.entities.teacher;
import com.esi.demo.repositories.formationInterface;
import com.esi.demo.repositories.studentInterface;
import com.esi.demo.repositories.teacherInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@SpringBootApplication
@RestController
@CrossOrigin(origins = "http://127.0.0.1:8086")

public class DemoApplication implements CommandLineRunner {
    @Autowired
    private studentInterface studentRepo;

    @Autowired
    private teacherInterface teacherRepo;

    @Autowired
    private formationInterface formationRepo;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

       // formation format = new formation();
       // format.setNomFormation("AI");
       // formationRepo.save(format);  // ✅ Save it before using it


       // student student1 = new student(null, "djalil", new Date(2000 - 1900, 11, 3), format, null); // Correct Date
       // studentRepo.save(student1);  // ✅ Save student separately


       // teacher teacher1 = new teacher(null, "mohamed", Grade.MAA, Arrays.asList(student1));
       // student1.setTeachers(Arrays.asList(teacher1));
      //  teacherRepo.save(teacher1);  // ✅ Save teacher separately


       // studentRepo.save(student1);
    }
}
