package com.example.crudDemo;

import com.example.crudDemo.DAO.StudentDAO;
import com.example.crudDemo.Entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CrudDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudDemoApplication.class, args);
	}


	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			// createStudent(studentDAO);

			 createMultipleStudents(studentDAO);

			// readStudent(studentDAO);

			// queryForStudents(studentDAO);

			// queryStudentsByLastName(studentDAO);

			// updateStudent(studentDAO);

			// deleteStudent(studentDAO);

			// deleteAllStudents(studentDAO);
		};
	}

	private void deleteAllStudents(StudentDAO studentDAO) {
		System.out.println("Deleting all students");
		int numRowsDeleted = studentDAO.deleteAll();
		System.out.println("Number of students deleted: " + numRowsDeleted);
	}

	private void deleteStudent(StudentDAO studentDAO) {
		int studentId = 4;
		System.out.println("Getting student with id: " + studentId);
		studentDAO.delete(studentId);
	}

	private void updateStudent(StudentDAO studentDAO) {

		// Retrieve student based on the ID (primary key)
		int studentId = 4;
		System.out.println("Getting student with id: " + studentId);
		Student student = studentDAO.findById(studentId);

		// Change first name to "Scooby"
		System.out.println("Updating student");
		student.setFirstName("Brandon");

		// Update the student
		studentDAO.update(student);

		// Display the student
		System.out.println(student);
	}

	private void queryStudentsByLastName(StudentDAO studentDAO) {

		// Get a list of students
		List<Student> theStudents = studentDAO.findByLastName("Dominguez");

		// Display list of students
		for (Student student : theStudents){
			System.out.println(student);
		}
	}

	private void queryForStudents(StudentDAO studentDAO) {

		// Get a list of students
		List<Student> theStudents = studentDAO.findAll();

		// Display the list of students
		for (Student student : theStudents){
			System.out.println(student);
		}
	}

	private void readStudent(StudentDAO studentDAO) {

		// Create a student object
		Student tempStudent = new Student("Cloud","Strife","FFVII@capcom");

		// Save the student
		studentDAO.save(tempStudent);

		// Display id of the saved student
		int studentId = tempStudent.getId();

		// Retrieve a student based on the id: primary key
		Student student = studentDAO.findById(studentId);

		// Display student
		System.out.println(student);
	}

	private void createMultipleStudents(StudentDAO studentDAO) {

		// Create multiple students
		System.out.println("Creating 3 student objects");
		Student student1 = new Student("Jose","Dominguez","email1");
		Student student2 = new Student("Brandon","Chacon","email2");
		Student student3 = new Student("Daniel","Chirinos","email3");

		// Save the student objects
		System.out.println("New students being saved");
		studentDAO.save(student1);
		studentDAO.save(student2);
		studentDAO.save(student3);
		System.out.println(student1);
		System.out.println(student2);
		System.out.println(student3);
	}

	private void createStudent(StudentDAO studentDAO) {

		// Create the student object

		System.out.println("Creating new student object");
		Student student = new Student("Jose","Dominguez","email");

		// Save the student object
		System.out.println("New student being saved");
		studentDAO.save(student);

		// Display the id of the saved student
		System.out.println("New student id = " + student.getId());
		System.out.println(student);
	}

}
