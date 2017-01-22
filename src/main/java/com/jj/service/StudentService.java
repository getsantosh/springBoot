package com.jj.service;


import com.jj.dao.StudentDAO;
import com.jj.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Map;

@Service
public class StudentService {

    @Autowired
    StudentDAO studentDAO;

    public Collection<Student> getAllStudents() {
        return studentDAO.getAllStudents();
    }

    public Student getStudent(int id) {
        return studentDAO.getStudent(id);
    }

    public void  updateStudent(Student student) {
        studentDAO.updateStudent(student);
    }

    public void deleteStudent(int id) {
        studentDAO.deleteStudent(id);
    }

    public void addStudent(Student student){
        studentDAO.addStudent(student);
    }

    public Collection<Student> getStudentsByGender(String gender) {
        return studentDAO.getStudentsByGender(gender);
    }
}
