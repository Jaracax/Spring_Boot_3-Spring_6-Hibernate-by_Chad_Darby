package com.example.AOP_Demo;

import com.example.AOP_Demo.dao.AccountDAO;
import com.example.AOP_Demo.dao.MembershipDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AopDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopDemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO accountDAO, MembershipDAO membershipDAO){

		return runner -> {

			demoTheBeforeAdvice(accountDAO, membershipDAO);
			//demoTheBeforeAdvice(accountDAO, membershipDAO);

		};
	}

	private void demoTheBeforeAdvice(AccountDAO accountDAO, MembershipDAO membershipDAO) {

		// call the business method
		Account account = new Account();
		accountDAO.addAccount(account, true);
		accountDAO.doWork();
		membershipDAO.addSillyNumber();
		membershipDAO.goToSleep();
	}
}
