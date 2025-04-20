package com.abuzar.JavaWithDB.repository;

import com.abuzar.JavaWithDB.config.DBconnection;
import com.abuzar.JavaWithDB.entities.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudentRepository {

    public void save(Student student) throws Exception {

        Connection conn = DBconnection.getConnection();
        String sql = "INSERT INTO students (name, age) VALUES (?, ?)";
        PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        stmt.setString(1, student.getName());
        stmt.setInt(2, student.getAge());
        stmt.executeUpdate();
        ResultSet generatedKeys = stmt.getGeneratedKeys();
        if (generatedKeys.next()) {
            int generatedId = generatedKeys.getInt(1);
            System.out.println("Student inserted with ID: " + generatedId);
            student.setId(generatedId);
        }

        generatedKeys.close();
        stmt.close();
        conn.close();
    }

    public List<Student> findAll() throws Exception {

        Connection conn = DBconnection.getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM students");

        List<Student> students = new ArrayList<>();
        while (rs.next()){
            Student s = new Student(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getInt("age")
            );
            students.add(s);

        }

        rs.close();
        stmt.close();
        conn.close();
        return students;
    }

    // now create method  to find student by id

    public Student findById(int id) throws Exception {

        Connection conn = DBconnection.getConnection();
        String sql = "SELECT * FROM students WHERE id = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            Student s = new Student(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getInt("age")
            );
            rs.close();
            stmt.close();
            conn.close();
            return s;
        } else {
            rs.close();
            stmt.close();
            conn.close();
            return null;
        }
    }


    public void update(Student student) throws Exception {

        Connection conn = DBconnection.getConnection();
        String sql = "UPDATE students SET name = ?, age = ? WHERE id = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, student.getName());
        stmt.setInt(2, student.getAge());
        stmt.setInt(3, student.getId());
        stmt.executeUpdate();
        stmt.close();
        conn.close();
    }


    public void delete(int id) throws Exception {

        Connection conn = DBconnection.getConnection();
        String sql = "DELETE FROM students WHERE id = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, id);
        stmt.executeUpdate();
        stmt.close();
        conn.close();
    }





}
