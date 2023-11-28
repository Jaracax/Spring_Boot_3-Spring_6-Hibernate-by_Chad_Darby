package com.example.crudDemo;

import com.example.crudDemo.dao.AppDAO;
import com.example.crudDemo.entity.*;
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
	public CommandLineRunner commandLineRunner(AppDAO appDAO){
		return runner -> {

//			createCourseAndStudents(appDAO);

//			findCourseAndStudents(appDAO);

//			findStudentAndCourses(appDAO);

//			addMoreCoursesForStudent(appDAO);

//			deleteCourse(appDAO);

//			deleteStudent(appDAO);
		};
	}

	private void deleteStudent(AppDAO appDAO) {
		int id = 1;

		appDAO.deleteStudentById(id);

	}

	private void addMoreCoursesForStudent(AppDAO appDAO) {

		int id = 2;

		Student student = appDAO.findStudentAndStudentsByStudentId(id);

		Course course1 = new Course("JUnit 5");
		Course course2 = new Course("Mockito");

		student.addCourse(course1);
		student.addCourse(course2);

		appDAO.update(student);
	}

	private void findStudentAndCourses(AppDAO appDAO) {

		int id = 1;

		Student student = appDAO.findStudentAndStudentsByStudentId(id);

		System.out.println(student);
	}

	private void findCourseAndStudents(AppDAO appDAO) {

		int id = 10;

		Course course = appDAO.findCourseAndStudentsByCourseId(id);

		System.out.println(course);
	}

	private void createCourseAndStudents(AppDAO appDAO) {

		// Create a course
		Course course = new Course("Java Masterclass");

		// Create the students
		Student student1 = new Student("Jose", "Dominguez","jadominguez");
		Student student2 = new Student("Daniel", "Chirinos","bachour");

		// add students to the course
		course.addStudent(student1);
		course.addStudent(student2);

		// save the course and associated the objects
		appDAO.saveCourse(course);
	}

	private void deleteCourseAndReviews(AppDAO appDAO) {

		int theId = 10;

		appDAO.deleteCourseById(theId);
	}

	private void retrieveCourseAndReviews(AppDAO appDAO) {

		// get the course reviews

		int theId = 10;
		Course course = appDAO.findCourseAndReviewsByCourseId(theId);

		// print the course
		System.out.println(course);

		// print the associate reviews
		System.out.println(course.getReviews());
	}

	private void createCourseAndReviews(AppDAO appDAO) {

		// create a course

		Course course = new Course("SOLID Principles");

		// add some reviews
		course.addReview(new Review("Good course"));
		course.addReview(new Review("Could have been better"));
		course.addReview(new Review("Idk"));

		// save the course
		appDAO.saveCourse(course);
	}

	private void deleteCourse(AppDAO appDAO) {

		int theId = 10;
		appDAO.deleteCourseById(theId);
	}

	private void updateCourse(AppDAO appDAO) {

		int theId = 10;

		Course course = appDAO.findCourseById(theId);

		course.setTitle("Java Masterclass");

		appDAO.update(course);
	}

	private void updateInstructor(AppDAO appDAO) {

		int theId = 2;

		Instructor instructor = appDAO.findInstructorById(theId);

		instructor.setLastName("TEST");

		appDAO.update(instructor);
	}

	private void findInstructorWithCoursesJoinFetch(AppDAO appDAO) {

		int theId = 2;

		Instructor instructor = appDAO.findInstructorByIdJoinFetch(theId);

		System.out.println(instructor);
		System.out.println(instructor.getCourses());
	}

	private void findCoursesForInstructor(AppDAO appDAO) {

		int theId = 2;
		// find instructor
		System.out.println("Finding instructor id: " + theId);

		Instructor tempInstructor = appDAO.findInstructorById(theId);

		System.out.println("tempInstructor: " + tempInstructor);


		// find courses for instructor
		System.out.println("Finding courses for instructor id: " + theId);
		List<Course> courses = appDAO.findCoursesByInstructorId(theId);

		// associate the objects
		tempInstructor.setCourses(courses);

		System.out.println("the associated courses: " + tempInstructor.getCourses());

		System.out.println("Done!");
	}

	private void findInstructorWithCourses(AppDAO appDAO) {

			int id = 2;
		System.out.println("Finding instructor with id " + id);

		Instructor instructor = appDAO.findInstructorById(id);

		System.out.println(instructor);
		System.out.println("Courses " + instructor.getCourses());
	}

	private void createInstructorWithCourses(AppDAO appDAO) {

		// create the instructor
		Instructor tempInstructor =
				new Instructor("Susan", "Public", "susan.public@luv2code.com");

		// create the instructor detail
		InstructorDetail tempInstructorDetail =
				new InstructorDetail(
						"http://www.youtube.com",
						"Video Games");

		// associate the objects
		tempInstructor.setInstructorDetail(tempInstructorDetail);

		// create some courses
		Course tempCourse1 = new Course("Air Guitar - The Ultimate Guide");
		Course tempCourse2 = new Course("The Pinball Masterclass");

		// add courses to instructor
		tempInstructor.add(tempCourse1);
		tempInstructor.add(tempCourse2);

		// save the instructor
		//
		// NOTE: this will ALSO save the courses
		// because of CascadeType.PERSIST
		//
		System.out.println("Saving instructor: " + tempInstructor);
		System.out.println("The courses: " + tempInstructor.getCourses());
		appDAO.save(tempInstructor);

		System.out.println("Done!");
	}

	private void deleteInstructorDetail(AppDAO appDAO) {
		System.out.println("Deleting instructorDetail id: " + 4);
		appDAO.deleteInstructorDetailById(4);
		System.out.println("Done");
	}

	private void findInstructorDetail(AppDAO appDAO) {

		System.out.println("Finding instructorDetaik by id: " + 1);

		InstructorDetail instructorDetail = appDAO.findInstructorDetailById(3);

		System.out.println("instructorDetail " + instructorDetail);

		System.out.println("Instructor " + instructorDetail.getInstructor());
	}

	private void deleteInstructor(AppDAO appDAO) {

		System.out.println("Deleting instructor id: " + 2);
		appDAO.deleteInstructorById(2);
		System.out.println("Done");
	}

	private void findInstructor(AppDAO appDAO) {
		System.out.println("Finding instructor by id: " + 3);
		Instructor instructor = appDAO.findInstructorById(3);
		System.out.println("instructor " + instructor);
		System.out.println("instructor details " + instructor.getInstructorDetail());
	}

	private void createInstructor(AppDAO appDAO) {
		/*
		// create the instructor
		Instructor tempInstructor =
				new Instructor("Chad", "Darby", "darby@luv2code.com");

		// create the instructor detail
		InstructorDetail tempInstructorDetail =
				new InstructorDetail(
						"http://www.luv2code.com/youtube",
						"Luv 2 code!!!");
		*/

		// create the instructor
		Instructor tempInstructor =
				new Instructor("Madhu", "Patel", "madhu@luv2code.com");

		// create the instructor detail
		InstructorDetail tempInstructorDetail =
				new InstructorDetail(
						"http://www.luv2code.com/youtube",
						"Guitar");

		// associate the objects
		tempInstructor.setInstructorDetail(tempInstructorDetail);

		// save the instructor
		//
		// NOTE: this will ALSO save the details object
		// because of CascadeType.ALL
		//
		System.out.println("Saving instructor: " + tempInstructor);
		appDAO.save(tempInstructor);

		System.out.println("Done!");
	}

}
