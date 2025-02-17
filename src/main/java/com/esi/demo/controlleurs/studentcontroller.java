package com.esi.demo.controlleurs;

import com.esi.demo.entities.formation;
import com.esi.demo.entities.student;
import com.esi.demo.entities.teacher;
import com.esi.demo.repositories.formationInterface;
import com.esi.demo.repositories.studentInterface;
import com.esi.demo.repositories.teacherInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import com.esi.demo.services.studentservice;

@RestController
@RequestMapping(path = "/api")
public class studentcontroller {

    @Autowired
    studentInterface studentrepository;
    @Autowired
    formationInterface formationrepo;
    @Autowired
    teacherInterface teacherrepo;


    //   public studentcontroller(studentservice studentservice) {
  //      this.studentservice = studentservice;
   // }

    @GetMapping(path = "/student")
    public List<student> getStudent() {
        return studentrepository.findAll();  // ✅ Correct return type
    }

    @GetMapping(path = "/teachers")
    public List<teacher> getTeachers() {
        return teacherrepo.findAll();
    }

    @GetMapping(path = "/formations")
    public List<formation> getFormations() {
        return formationrepo.findAll();
    }

    @GetMapping(path = "/student/{id}")
    public student getStudentID(@PathVariable("id") Long id) {
        student std = studentrepository.findById(id).get();
        if (std != null) {
            return studentrepository.findById(id).get();
        }
        return null;
    }

    @PostMapping("studentt")
    public student addStudent(@RequestBody student student, @RequestParam("idF") int idF) {
        student.setFormation(formationrepo.findById(idF).get());
        return studentrepository.save(student);
    }

    @DeleteMapping(path="deletestd/{id}")
    public void deleteStudent(@PathVariable("id") Long id) {
        boolean exsistent = studentrepository.existsById(id);
        if (exsistent) {
            teacherrepo.deleteById(id);
            studentrepository.deleteById(id);
        }else {
            throw new IllegalStateException("student with id " + id + " not found");
        }
    }

    @DeleteMapping(path="deletefrm/{id}")
    public void deleteStudentFrm(@PathVariable("id") int id) {
        formationrepo.deleteById(id);
    }

    @PutMapping(path = "updatestd/{id}")
    public student updateStudent(@PathVariable("id") Long id, @RequestParam(required = false) String firstName) {
          student student = studentrepository.findById(id).orElseThrow(() ->
                  new IllegalStateException("student with id " + id + " not found"));
          if (firstName != null && !firstName.isEmpty() && !firstName.equals(student.getFirstName())) {
              student.setFirstName(firstName);
          }

          return studentrepository.save(student);
    }
}
