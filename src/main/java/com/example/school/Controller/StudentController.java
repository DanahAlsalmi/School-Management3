package com.example.school.Controller;

import com.example.school.Model.Student;
import com.example.school.Service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/student")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @GetMapping("/get")
    public ResponseEntity getStudent() {
        return ResponseEntity.status(200).body(studentService.getStudent());
    }

    @PostMapping("/add")
    public ResponseEntity addStudent(@Valid @RequestBody Student student) {
        studentService.addStudent(student);
        return ResponseEntity.status(200).body("Student added successfully");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateStudent(@PathVariable Integer id, @Valid @RequestBody Student student) {
        studentService.updateStudent(id, student);
        return ResponseEntity.status(200).body("Student updated successfully");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteStudent(@PathVariable Integer id) {
        studentService.deleteStudent(id);

        return ResponseEntity.status(200).body("Student deleted successfully");
    }

    @PutMapping("/assign/{studentId}/{courseId}")
    public ResponseEntity assignStudentAndCourse(@PathVariable Integer studentId,@PathVariable Integer courseId) {
        studentService.assignStudentAndCourse(studentId, courseId);
        return ResponseEntity.status(200).body("student assigned successfully");
    }

    @PutMapping("/major/{id}/update/{major}")
    public ResponseEntity updateStudentMajor(@PathVariable Integer id,@PathVariable String major) {
        studentService.updateStudentMajor(id, major);
        return ResponseEntity.status(200).body("student major updated successfully");
    }

    @GetMapping("/course/{courseId}/students")
    public ResponseEntity getStudentsByCourseId(@PathVariable Integer courseId) {
        return ResponseEntity.status(200).body(studentService.getStudentsByCourseId(courseId));
    }
}
