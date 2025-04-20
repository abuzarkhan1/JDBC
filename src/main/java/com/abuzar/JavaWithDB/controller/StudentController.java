package com.abuzar.JavaWithDB.controller;

import com.abuzar.JavaWithDB.entities.Student;
import com.abuzar.JavaWithDB.service.StudentService;

import java.util.List;
import java.util.Scanner;

public class StudentController {

    Scanner scanner = new Scanner(System.in);

    StudentService service = new StudentService();

    public void start() throws Exception {

        while (true){

            System.out.println("\n1. Add Student\n2. View All\n3. Search by ID\n4. Update\n5. Delete\n6. Exit");
            int choice = scanner.nextInt();

            switch (choice){
                case 1:
                    scanner.nextLine();
                    System.out.println("Name: ");
                    String name = scanner.nextLine();
                    System.out.println("Age: ");
                    int age = scanner.nextInt();
                    service.createStudent(name, age);
                    System.out.println("Student added successfully");
                    break;

                case  2:
                    List<Student> students = service.getAllStudents();
                    students.forEach(s -> System.out.println(s.getId() + " | " + s.getName() + " | " + s.getAge()));
                    break;

                case 3:
                    System.out.println("Enter ID: ");
                    int id = scanner.nextInt();
                    Student s = service.getStudentById(id);
                    if (s != null) {
                        System.out.println(s.getId() + " | " + s.getName() + " | " + s.getAge());
                    } else {
                        System.out.println("Not found.");
                    }
                    break;

                case 4:

                    System.out.println("Enter ID: ");
                    int id2 = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Name: ");
                    String name1 = scanner.nextLine();
                    System.out.println("Age: ");
                    int age1 = scanner.nextInt();
                    service.updateStudent(id2, name1, age1);
                    System.out.println("Updated successfully");
                    break;

                case 5:
                    System.out.println("Enter ID: ");
                    int id1 = scanner.nextInt();
                    service.deleteStudent(id1);
                    System.out.println("Deleted successfully");
                    break;


                case 6:
                    System.exit(0);
            }

        }
    }

}
