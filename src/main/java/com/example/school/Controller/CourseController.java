package com.example.school.Controller;

import com.example.school.Model.Course;
import com.example.school.Service.CourseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/course")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;


    @GetMapping("/get")
    public ResponseEntity getAllCourse() {
        return ResponseEntity.status(200).body(courseService.findAll());
    }

    @PostMapping("/add")
    public ResponseEntity addCourse(@Valid @RequestBody Course course) {
        courseService.addCourse(course);
        return ResponseEntity.status(200).body("Course added successfully");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateCourse(@Valid @RequestBody Course course, @PathVariable Integer id) {
        courseService.updateCourse(id, course);
        return ResponseEntity.status(200).body("Course updated successfully");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteCourse(@PathVariable Integer id) {
        courseService.deleteCourse(id);
        return ResponseEntity.status(200).body("Course deleted successfully");
    }

    @PutMapping("/assign/{courseId}/{teacherId}")
    public ResponseEntity assignMerchantToProduct(@PathVariable Integer courseId,@PathVariable Integer teacherId) {
        courseService.assignCourseToTeacher(courseId, teacherId);
        return ResponseEntity.status(200).body("Course assigned successfully");
    }

    @GetMapping("/teacher-name/{courseId}")
    public ResponseEntity getTeacherNameByCourseId(@PathVariable Integer courseId) {
        String teacherName = courseService.getTeacherNameByCourseId(courseId);
        return ResponseEntity.status(200).body(teacherName);
    }
}
