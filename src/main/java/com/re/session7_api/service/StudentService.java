package com.re.session7_api.service;

import com.re.session7_api.model.entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudents();
    Student getStudentById(Long id);
    Student saveStudent(Student student);
    boolean deleteStudent(Long id);
    Student updateStudent(Student student);
    Student updateStudentsByGPA(Long id,Double gpa);
}
