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

//			deleteInstructor(appDAO);

//			findInstructorDetail(appDAO);

			deleteInstructorDetail(appDAO);

		};
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
		// create the instructor
		Instructor instructor = new Instructor("Chad","Darby","something",
				new InstructorDetail("Jaracax","Music and video games"));

		// save the instructor
		System.out.println("Saving " + instructor);
		appDAO.save(instructor);
	}

}
