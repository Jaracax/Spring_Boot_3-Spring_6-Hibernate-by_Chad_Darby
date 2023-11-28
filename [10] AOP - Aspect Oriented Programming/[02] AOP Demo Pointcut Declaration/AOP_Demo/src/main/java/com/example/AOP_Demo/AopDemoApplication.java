package com.example.AOP_Demo;

import com.example.AOP_Demo.dao.AccountDAO;
import com.example.AOP_Demo.dao.MembershipDAO;
import com.example.AOP_Demo.service.TrafficFortune;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class AopDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopDemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO accountDAO, MembershipDAO membershipDAO, TrafficFortune trafficFortune){

		return runner -> {

//			demoTheBeforeAdvice(accountDAO, membershipDAO);
//			demoTheBeforeAdvice(accountDAO, membershipDAO);
//			demoTheAfterReturningAdvice(accountDAO);
//			demoTheAfterThrowingAdvice(accountDAO);
//			demoTheAfterAdvice(accountDAO);
			demoTheAroundAdvice(trafficFortune);
		};
	}

	private void demoTheAroundAdvice(TrafficFortune trafficFortune) {
		System.out.println("\nMain Program: demoTheAroundAdvice");
		System.out.println("Calling getFortune()");
		String data = trafficFortune.getFortune();
		System.out.println("\nMy fortune is: " + data);
		System.out.println("Finished");
	}

	private void demoTheAfterAdvice(AccountDAO accountDAO) {
		// call the method to find the accounts
		List<Account> accounts = accountDAO.findAccounts();

		try {
			// add a boolean flag to simulate exception
			boolean tripWare = true;
			accounts = accountDAO.findAccounts(tripWare);
		} catch (Exception exception){
			System.out.println("\n\n Main programn: caught exception" + exception);
		}
		// Display the accounts
		System.out.println("\n\n Main programn: demoTheAfterThrowingAdvice");
		System.out.println("-----");
		System.out.println(accounts);
		System.out.println("\n");
	}

	private void demoTheAfterThrowingAdvice(AccountDAO accountDAO) {
		// call the method to find the accounts
		List<Account> accounts = accountDAO.findAccounts();

		try {
			// add a boolean flag to simulate exception
			boolean tripWare = true;
			accounts = accountDAO.findAccounts(!tripWare);
		} catch (Exception exception){
			System.out.println("\n\n Main programn: caught exception" + exception);
		}
		// Display the accounts
		System.out.println("\n\n Main programn: demoTheAfterThrowingAdvice");
		System.out.println("-----");
		System.out.println(accounts);
		System.out.println("\n");


	}

	private void demoTheAfterReturningAdvice(AccountDAO accountDAO) {

		// call the method to find the accounts
		List<Account> accounts = accountDAO.findAccounts();

		// Display the accounts
		System.out.println("\n\n Main programn: demoTheAfterReturningAdvice");
		System.out.println("-----");
		System.out.println(accounts);
		System.out.println("\n");
	}

	private void demoTheBeforeAdvice(AccountDAO accountDAO, MembershipDAO membershipDAO) {

		// call the business method
		Account account = new Account();
		account.setName("Jose");
		account.setLevel("High");
		accountDAO.addAccount(account, true);
		accountDAO.doWork();

		// call the accountdao getter/setter methods
		accountDAO.setName("Jose");
		accountDAO.setServiceCode("1010");

		String name = accountDAO.getName();
		String code = accountDAO.getServiceCode();

		// call the membership methods
		membershipDAO.addSillyNumber();
		membershipDAO.goToSleep();
	}
}
