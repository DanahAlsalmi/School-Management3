package com.example.school.Service;

import com.example.school.Api.ApiException;
import com.example.school.Model.Course;
import com.example.school.Model.Student;
import com.example.school.Repository.CourseRepository;
import com.example.school.Repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    public List<Student> getStudent() {
        return studentRepository.findAll();
    }

    public void addStudent(Student student) {
        studentRepository.save(student);
    }

    public void updateStudent(Integer id,Student student) {
        Student s = studentRepository.findStudentById(id);
        if(s==null){
            throw new ApiException("Student not found");
        }
        s.setName(student.getName());
        s.setAge(student.getAge());
        s.setMajor(student.getMajor());
        studentRepository.save(s);
    }

    public void deleteStudent(Integer id) {
        Student s = studentRepository.findStudentById(id);
        if(s==null){
            throw new ApiException("Student not found");
        }
        studentRepository.delete(s);
    }

    public void assignStudentAndCourse(Integer studentId, Integer courseId) {
        Student s = studentRepository.findStudentById(studentId);
        Course c = courseRepository.findCourseById(courseId);

        if(s==null || c==null){
            throw new ApiException("Student Or Course not found , cannot assign Student");
        }
        s.getCourses().add(c);
        c.getStudents().add(s);
        courseRepository.save(c);
        studentRepository.save(s);
    }

    public Student updateStudentMajor(Integer id, String major) {
        Student student = studentRepository.findStudentById(id);
        if (student == null) {
            throw new ApiException("Student not found for this id: " + id);
        }
        
        for (Course c : student.getCourses()) {
            c.getStudents().remove(student);
        }
        student.getCourses().clear();
        student.setMajor(major);
        return studentRepository.save(student);
    }


    public Set<Student> getStudentsByCourseId(Integer courseId) {
        Course c = courseRepository.findCourseById(courseId);
        if (c == null) {
            throw new ApiException("Course not found for this id: " + courseId);
        }
        return c.getStudents();

    }
}
