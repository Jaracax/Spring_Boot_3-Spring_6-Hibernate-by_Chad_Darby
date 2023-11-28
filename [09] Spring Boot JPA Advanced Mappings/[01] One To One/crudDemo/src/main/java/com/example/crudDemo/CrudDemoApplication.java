package com.example.crudDemo;

import com.example.crudDemo.dao.AppDAO;
import com.example.crudDemo.entity.Instructor;
import com.example.crudDemo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CrudDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudDemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO){
		return runner -> {
//			createInstructor(appDAO);

//			findInstructor(appDAO);

			deleteInstructor(appDAO);

		};
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
//		// create the instructor
//		Instructor instructor = new Instructor("Chad","Darby","something");
//
//		// create instructorDetail
//
//		InstructorDetail instructorDetail = new InstructorDetail("youtube","hobby");

		// create the instructor
		Instructor instructor = new Instructor("Jose","Dominguez","something@");

		// create instructorDetail

		InstructorDetail instructorDetail = new InstructorDetail("github","music");

		// Associate the objects
		instructor.setInstructorDetail(instructorDetail);

		// save the instructor

		System.out.println("Saving " + instructor);
		appDAO.save(instructor);
	}

}
