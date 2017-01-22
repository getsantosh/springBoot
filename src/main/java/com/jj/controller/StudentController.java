package com.jj.controller;

import com.jj.entity.Student;
import com.jj.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    /*
    *   http://localhost:8080/student
    * */
    @RequestMapping
    public Collection<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    /*
    *   http://localhost:8080/student/1
    * */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Student getStudent(@PathVariable("id") int id) {
        return studentService.getStudent(id);
    }

    /*
   * http://localhost:8080/student/add
   * {
   * "id": 2,
   * "name": "Henery F",
   * "branch": "MCA"
   * }
   * */
    @RequestMapping(value = "/update", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateStudent(@RequestBody Student student) {
        studentService.updateStudent(student);
    }

    // req url - http://localhost:8080/student/delete?id=6
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public void deleteStudent(@RequestParam int id){
        studentService.deleteStudent(id);
    }

    /*
    * http://localhost:8080/student/add
    * {
    * "id": 5,
    * "name": "ABC",
    * "branch": "XYZ"
    * }
    * */

    @RequestMapping(value = "/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addStudent(@RequestBody Student student){
        studentService.addStudent(student);
    }

    @RequestMapping(value = "/getStudentsByGender", method = RequestMethod.GET)
    public Collection<Student> getStudentsByGender(@RequestParam String gender) {
        return studentService.getStudentsByGender(gender);
    }

}
