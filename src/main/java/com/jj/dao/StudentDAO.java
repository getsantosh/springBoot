package com.jj.dao;

import com.jj.entity.Student;
import com.jj.util.Gender;
import com.sun.tools.javac.jvm.Gen;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class StudentDAO {

    private static Map<Integer, Student> students;

    static {
        students = new HashMap<Integer, Student>() {
            {
                put(1, new Student(1, "Ford", "Commerce", Gender.MALE));
                put(2, new Student(2, "Henry", "Computers", Gender.MALE));
                put(3, new Student(3, "James", "Electronics", Gender.MALE));
                put(4, new Student(4, "Sachin", "Commerce", Gender.MALE));
                put(5, new Student(5, "Michael", "Arts", Gender.FEMALE));
                put(6, new Student(6, "Tiya", "Music", Gender.FEMALE));
                put(7, new Student(7, "Lily", "Arts", Gender.FEMALE));
            }
        };
    }

    public Collection<Student> getAllStudents(){
        return this.students.values();
    }

    public Student getStudent(int id) {

        return this.students.get(id);
    }

    public void updateStudent(Student student){
        students.replace(student.getId(), student);
    }

    public void deleteStudent(int id) {
        students.remove(id);
    }

    public void addStudent(Student student) {
        students.put(student.getId(), student);
    }

    public Collection<Student> getStudentsByGender(String gender) {
        return getAllStudents().stream()
                .filter(s -> s.getGender().equals(gender))
                .collect(Collectors.toList());
    }
}
