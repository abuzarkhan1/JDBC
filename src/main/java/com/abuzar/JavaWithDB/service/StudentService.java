package com.abuzar.JavaWithDB.service;

import com.abuzar.JavaWithDB.entities.Student;
import com.abuzar.JavaWithDB.repository.StudentRepository;

import java.util.List;

public class StudentService {

    StudentRepository repo = new StudentRepository();

    public void createStudent(String name , int age) throws Exception {
        Student student = new Student();

        student.setName(name);
        student.setAge(age);
        repo.save(student);
    }

    public List<Student> getAllStudents() throws Exception {
        return repo.findAll();
    }

    public Student getStudentById(int id) throws Exception {
        return repo.findById(id);
    }

    public void updateStudent(int id, String name, int age) throws Exception {
        Student student = new Student();
        student.setId(id);
        student.setName(name);
        student.setAge(age);
        repo.update(student);
    }

    public void deleteStudent(int id) throws Exception {
        repo.delete(id);
    }
}
