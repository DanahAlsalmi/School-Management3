package com.example.school.Service;

import com.example.school.Api.ApiException;
import com.example.school.Model.Teacher;
import com.example.school.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherService {
    private final TeacherRepository teacherRepository;

    //get
    public List<Teacher> getAllTeacher() {
        return teacherRepository.findAll();
    }
    //add
    public void addTeacher(Teacher teacher) {
        teacherRepository.save(teacher);
    }
    //update
    public void updateTeacher(Integer id, Teacher teacher) {
        Teacher t = teacherRepository.findTeacherByid(id);
        if (t == null) {
            throw new ApiException("Teacher Not Found");
        }
        t.setName(teacher.getName());
        t.setAge(teacher.getAge());
        t.setEmail(teacher.getEmail());
        t.setSalary(teacher.getSalary());
        teacherRepository.save(t);
    }
    //Delete
    public void deleteTeacher(Integer id) {
        Teacher teacher = teacherRepository.findTeacherByid(id);
        if (teacher == null) {
            throw new ApiException("Teacher Not Found");
        }
        teacherRepository.delete(teacher);
    }

    public Teacher getTeacherById(Integer teacherId) {
        Teacher teacher = teacherRepository.findTeacherByid(teacherId);
        if (teacher == null) {
            throw new ApiException("Teacher not found");
        }
        return teacher;
    }
}