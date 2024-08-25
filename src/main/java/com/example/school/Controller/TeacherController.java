package com.example.school.Controller;

import com.example.school.Model.Teacher;
import com.example.school.Service.TeacherService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/v1/teacher")
@RestController //json
@RequiredArgsConstructor
public class TeacherController {
    private final TeacherService teacherService;

    @GetMapping("/get")
    public ResponseEntity getTeachers() {
        return ResponseEntity.status(200).body(teacherService.getAllTeacher());
    }

    @PostMapping("/add")
    public ResponseEntity addTeacher(@Valid @RequestBody Teacher teacher) {
        teacherService.addTeacher(teacher);
        return ResponseEntity.status(200).body("Teacher added successfully");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateTeacher(@PathVariable Integer id, @Valid @RequestBody Teacher teacher) {
        teacherService.updateTeacher(id, teacher);
        return ResponseEntity.status(200).body("Teacher updated successfully");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteTeacher(@PathVariable Integer id) {
        teacherService.deleteTeacher(id);
        return ResponseEntity.status(200).body("Teacher deleted successfully");
    }

    @GetMapping("/{teacherId}")
    public ResponseEntity getTeacherDetails(@PathVariable Integer teacherId) {
        Teacher teacher = teacherService.getTeacherById(teacherId);
        return ResponseEntity.status(200).body(teacher);
    }

}