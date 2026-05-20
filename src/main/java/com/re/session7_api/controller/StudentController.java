package com.re.session7_api.controller;

import com.re.session7_api.model.dto.ApiDataResponse;
import com.re.session7_api.model.entity.Student;
import com.re.session7_api.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/students")
public class StudentController {
    private final StudentService studentService;

    @GetMapping(produces = {"application/json", "application/xml"})
    public ResponseEntity<ApiDataResponse<List<Student>>> getAllStudents() {
        return new ResponseEntity<>(new ApiDataResponse<>(
                true,
                "Lấy danh sách thành công",
                studentService.getAllStudents(),
                HttpStatus.OK
        ),HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<ApiDataResponse<Student>> getStudentById(@PathVariable Long id){

        Student student = studentService.getStudentById(id);


        if (student == null){
            return new ResponseEntity<>(new ApiDataResponse<>(
                    true,
                    "Không thấy sinh viên",
                    null,
                    HttpStatus.NOT_FOUND
            ),HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(new ApiDataResponse<>(
                true,
                "Lấy sinh viên theo ID thành công",
                student,
                HttpStatus.OK
        ),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ApiDataResponse<Student>> saveStudent(@RequestBody Student student){
        return new ResponseEntity<>(new ApiDataResponse<>(
                true,
                "Thêm sinh viên thành công",
                student,
                HttpStatus.CREATED
        ),HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiDataResponse<Boolean>> deleteStudent(@PathVariable Long id){

        Student student = studentService.getStudentById(id);

        if (student == null){
            return new ResponseEntity<>(new ApiDataResponse<>(
                    true,
                    "không thấy sinh viên cần xóa",
                    null,
                    HttpStatus.NOT_FOUND
            ),HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(new ApiDataResponse<>(
                true,
                "Lấy sinh viên theo ID thành công",
                studentService.deleteStudent(id),
                HttpStatus.NO_CONTENT
        ),HttpStatus.NO_CONTENT);
    }


    @PutMapping("/{id}")
    public ResponseEntity<ApiDataResponse<Student>> updateStudent(@PathVariable Long id){

        Student student = studentService.getStudentById(id);

        if (student == null){
            return new ResponseEntity<>(new ApiDataResponse<>(
                    true,
                    "không thấy sinh viên cần sửa",
                    null,
                    HttpStatus.NOT_FOUND
            ),HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(new ApiDataResponse<>(
                true,
                "Cập nhật thông tin sinh viên thành công",
                studentService.updateStudent(student),
                HttpStatus.OK
        ),HttpStatus.OK);
    }


    @PatchMapping("/{id}")
    public ResponseEntity<ApiDataResponse<Student>> updateStudentGpa(@PathVariable Long id,@PathVariable Double gpa){

        Student student = studentService.getStudentById(id);

        if (student == null){
            return new ResponseEntity<>(new ApiDataResponse<>(
                    true,
                    "không thấy sinh viên cần sửa",
                    null,
                    HttpStatus.NOT_FOUND
            ),HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(new ApiDataResponse<>(
                true,
                "Cập nhật thông tin sinh viên thành công",
                studentService.updateStudentsByGPA(student.getId(), gpa),
                HttpStatus.OK
        ),HttpStatus.OK);
    }


}

























