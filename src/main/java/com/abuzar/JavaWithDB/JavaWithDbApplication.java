package com.abuzar.JavaWithDB;

import com.abuzar.JavaWithDB.controller.StudentController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JavaWithDbApplication {

	public static void main(String[] args) throws Exception {
		StudentController controller = new StudentController();
		controller.start();
	}

}
