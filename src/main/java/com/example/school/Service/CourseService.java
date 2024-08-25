package com.example.school.Service;

import com.example.school.Api.ApiException;
import com.example.school.Model.Course;
import com.example.school.Model.Teacher;
import com.example.school.Repository.CourseRepository;
import com.example.school.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;
    private final TeacherRepository teacherRepository;

    public List<Course> findAll() {
        return courseRepository.findAll();
    }

    public void addCourse(Course course) {
        courseRepository.save(course);
    }

    public void updateCourse(Integer id ,Course course) {
        Course c = courseRepository.findCourseById(id);
        if(c == null) {
            throw new ApiException("Course not found");
        }
        c.setName(course.getName());
        courseRepository.save(c);
    }

    public void deleteCourse(Integer id) {
        Course c = courseRepository.findCourseById(id);
        if(c == null) {
            throw new ApiException("Course not found");
        }
        courseRepository.delete(c);
    }

    public void assignCourseToTeacher(Integer courseId, Integer teacherId) {
        Course c = courseRepository.findCourseById(courseId);
        if(c == null) {
            throw new ApiException("Course not found");
        }
        Teacher t = teacherRepository.findTeacherByid(teacherId);
        if(t == null) {
            throw new ApiException("Teacher not found");
        }
        c.setTeacher(t);
        courseRepository.save(c);
    }

    public String getTeacherNameByCourseId(Integer courseId) {
        Course course = courseRepository.findCourseById(courseId);
        if (course == null) {
            throw new ApiException("Course not found");
        }
        Teacher teacher = course.getTeacher();
        if (teacher == null) {
            throw new ApiException("No teacher assigned to this course");
        }
        return teacher.getName();
    }

}
