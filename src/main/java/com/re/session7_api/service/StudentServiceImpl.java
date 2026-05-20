package com.re.session7_api.service;

import com.re.session7_api.model.entity.Student;
import com.re.session7_api.repository.StudentRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService{
    private final StudentRepository studentRepository;


    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public boolean deleteStudent(Long id) {
        studentRepository.deleteById(id);
        return true;
    }

    @Override
    public Student updateStudent(Student student) {
        studentRepository.save(student);
        return null;
    }

    @Override
    public Student updateStudentsByGPA(Long id, Double gpa) {
        Student student = studentRepository.findById(id).orElse(null);

        if (student != null){
            student.setGpa(gpa);
            return studentRepository.save(student);
        }

        return null;
    }
}
